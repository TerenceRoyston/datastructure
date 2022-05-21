package junior.day04;

import static junior.day04.IsPalindromeList.printLinkedList;

public class SmallerEqualBigger {
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        head1 = listPartition1(head1, 5);
        printLinkedList(head1);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);
    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        Node[] arr = new Node[length];
        temp = head;
        for (int i = 0; i < length; i++) {
            arr[i] = temp;
            temp = temp.next;
        }
        arrPartition(arr, pivot);
        for (int j = 1; j < arr.length; j++) {
            arr[j - 1].next = arr[j];
        }
        arr[arr.length - 1].next = null;
        return arr[0];
    }

    //空间复杂度o(N) 普通分区方法
    private static void arrPartition(Node[] arr, int pivot) {
        int lessArea = -1;
        int moreArea = arr.length;
        int index = 0;
        while (index < moreArea) {
            if (arr[index].value < pivot) {
                swap(arr, index, lessArea + 1);
                index++;
                lessArea++;
            } else if (arr[index].value == pivot) {
                index++;
            } else {
                swap(arr, index, moreArea - 1);
                moreArea--;
            }
        }
    }

    public static void swap(Node[] arr, int a, int b) {
        Node temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //空间复杂度o(1)
    public static Node listPartition2(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node bH = null; // big head
        Node bT = null; // big tail
        Node next = null; // save next node
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        // small and equal reconnect
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        // all reconnect
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }
}
