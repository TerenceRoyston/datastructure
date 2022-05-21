package interviewguide;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author XuBowen
 * @date 2022/4/3 22:45
 */
public class IG4_CatAndDogQueue {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        CatAndDogQueue petQueue = new CatAndDogQueue();
        petQueue.add(new Dog(1));
        petQueue.add(new Cat(2));
        petQueue.add(new Dog(3));
        petQueue.add(new Cat(4));
        petQueue.add(new Dog(5));

        // petQueue.pollDog();
        // System.out.println(petQueue.isDogEmpty());
        // System.out.println(petQueue.isCatEmpty());
        // petQueue.pollCat();
        // petQueue.pollAll();
        // System.out.println(petQueue.isEmpty());

        Scanner scanner = new Scanner(System.in);
        int actions = Integer.parseInt(scanner.nextLine());
        Class<CatAndDogQueue> petClass = CatAndDogQueue.class;
        CatAndDogQueue aQueue = petClass.newInstance();
        while (actions!=0){
            String command = scanner.nextLine();
            String[] arr = command.split(" ");
            if (arr.length==1){
                Method m = petClass.getMethod(arr[0]);
                Object res = m.invoke(aQueue);
                if (res!=null){
                    System.out.println(res.toString().equals("true")?"yes":"no");
                }
            }else {
                if (arr[1].equals("dog")){
                    aQueue.add(new Dog(Integer.parseInt(arr[2])));
                }else {
                    aQueue.add(new Cat(Integer.parseInt(arr[2])));
                }
            }
            actions--;
        }

    }


}

class CatAndDogQueue {
    Deque<Pet> myQueue = new LinkedList();
    boolean empty=true;
    boolean dogEmpty=true;
    boolean catEmpty=true;

    public void add(Pet p) {
        myQueue.add(p);
    }

    public void pollAll() {
        while (!myQueue.isEmpty()) {
            Pet pet = myQueue.remove();
            if (pet instanceof Dog) {
                System.out.println("dog " + pet.getType());
            } else {
                System.out.println("cat " + pet.getType());
            }
        }
    }

    public void pollDog(){
        pollDog(this.myQueue);
    }

    public void pollDog(Deque<Pet> queue){
        if (queue.isEmpty()){
            return;
        }

        Pet p = queue.removeLast();
        pollDog(queue);
        if (p instanceof Dog) {
            System.out.println("dog " + p.getType());
        }else {
            queue.offerLast(p);
        }
    }

    public void pollCat(){
        pollCat(this.myQueue);
    }

    public void pollCat(Deque<Pet> queue){
        if (queue.isEmpty()){
            return;
        }

        Pet p = queue.removeLast();
        pollCat(queue);
        if (p instanceof Cat) {
            System.out.println("cat " + p.getType());
        }else {
            queue.offerLast(p);
        }
    }

    public boolean isEmpty(){
        return isEmpty(this.myQueue);
    }

    public boolean isEmpty(Deque<Pet> queue){
        if (queue.size()==0){
            return true;
        }

        if (empty=false){
            return false;
        }

        Pet p = queue.removeFirst();
        if ((p instanceof Dog) || (p instanceof Cat)){
            queue.offerFirst(p);
            empty=false;
            return false;
        }
        boolean b = isEmpty(queue);
        queue.offerFirst(p);
        return b;
    }

    public boolean isDogEmpty(){
        return isDogEmpty(this.myQueue);
    }


    public boolean isDogEmpty(Deque<Pet> queue){
        if (queue.size()==0){
            return true;
        }

        if (dogEmpty=false){
            return false;
        }

        Pet p = queue.removeFirst();
        if (p instanceof Dog){
            queue.offerFirst(p);
            dogEmpty=false;
            return false;
        }
        boolean b = isDogEmpty(queue);
        queue.offerFirst(p);
        return b;
    }

    public boolean isCatEmpty(){
        return isCatEmpty(this.myQueue);
    }

    public boolean isCatEmpty(Deque<Pet> queue){
        if (queue.size()==0){
            return true;
        }

        if (catEmpty=false){
            return false;
        }

        Pet p = queue.removeFirst();
        if (p instanceof Cat){
            queue.offerFirst(p);
            return false;
        }
        boolean b = isCatEmpty(queue);
        queue.offerFirst(p);

        return b;
    }

}

class Pet {
    Integer type;

    public Pet(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return this.type;
    }
}

class Dog extends Pet {

    public Dog(Integer type) {
        super(type);
    }
}

class Cat extends Pet {

    public Cat(Integer type) {
        super(type);
    }
}
