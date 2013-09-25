import java.util.Hashtable;

public class T2 {

    // functions

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }
    
    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static LinkedListNode randomLinkedList(int N, int min, int max) {
        LinkedListNode root = new LinkedListNode(randomIntInRange(min, max), null, null);
        LinkedListNode prev = root;
        for (int i = 1; i < N; i++) {
            int data = randomIntInRange(min, max);
            LinkedListNode next = new LinkedListNode(data, null, null);
            prev.setNext(next);
            prev = next;
        }
        return root;
    }

    // 2.1
    public static void deleteDups(LinkedListNode n) {
        Hashtable table = new Hashtable();
        LinkedListNode previous = null;
        while (n != null) {
            if (table.containsKey(n.data)) { 
                previous.next = n.next;
            } else {
                table.put(n.data, true);
                previous = n;
            }
            n = n.next;
        }
    }

    // 2.1 2
    public static void deleteDups2(LinkedListNode head) {
        if (head == null) return;
        LinkedListNode previous = head;
        LinkedListNode current = previous.next;
        while (current != null) {
            LinkedListNode runner = head;
            while (runner != current) {
                if (runner.data == current.data) {
                    LinkedListNode tmp = current.next;
                    previous.next = tmp;
                    current = tmp;
                    break;
                }
                runner = runner.next;
            }
            if (runner == current) {
                previous = current;
                current = current.next;
            }
        }
    }

    // 2.2
    public static LinkedListNode nthToLast(LinkedListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        for (int j = 0; j < n - 1; ++j) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    // 2.3
    public static boolean deleteNode(LinkedListNode n) {
        if (n == null || n.next == null) {
            return false;
        }
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    // 2.4
    public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return null;
        }
        LinkedListNode result = new LinkedListNode(carry, null, null);
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        result.data = value % 10;
        LinkedListNode more = addLists(l1 == null ? null : l1.next,
            l2 == null ? null : l2.next,
            value > 10 ? 1 : 0);
        result.setNext(more);
        return result;
    }
    public static int linkedListToInt(LinkedListNode node) {
        int value = 0;
        if (node.next != null) {
            value = 10 * linkedListToInt(node.next);
        }
        return value + node.data;
    }
    // 2.5
    public static FindBeginning(LinkedListNode head) {
        LinkedListNode n1 = head;
        LinkedListNode n2 = head;

        while (n2.next != null) {
            n1 = n1.next;
            n2 = n2.next;
            if (n1 == n2) {
                break;
            }
        }
        if (n2.next == null) {
            return null;
        }
        n1 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n2;
    }

    public static void main(String[] args) {
        System.out.println("\n===2.1===");
        LinkedListNode head = randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        deleteDups(head);
        System.out.println(head.printForward());
        System.out.println("");

        System.out.println("\n===2.1_2===");
        LinkedListNode head2 = randomLinkedList(10, 0, 10);
        System.out.println(head2.printForward());
        deleteDups2(head2);
        System.out.println(head2.printForward());
        System.out.println("");

        System.out.println("\n===2.2===");
        LinkedListNode head3 = randomLinkedList(10, 0, 10);
        System.out.println(head3.printForward());
        int nth = 4;
        LinkedListNode n = nthToLast(head3, nth);
        if (n != null) {
            System.out.println(nth + "th to last node is " + n.data);
        } else {
            System.out.println("null");
        }

        System.out.println("\n===2.3===");
        LinkedListNode head4 = randomLinkedList(10, 0, 10);
        System.out.println(head4.printForward());
        deleteNode(head4.next.next.next.next); // delete node 4
        System.out.println(head4.printForward());

        System.out.println("\n===2.4===");
        LinkedListNode list1 = randomLinkedList(5, 0, 9);
        LinkedListNode list2 = randomLinkedList(5, 0, 9);
        LinkedListNode list3 = addLists(list1, list2, 0);
        System.out.println("  " + list1.printForward());        
        System.out.println("+ " + list2.printForward());            
        System.out.println("= " + list3.printForward());    
        
        int l1 = linkedListToInt(list1);
        int l2 = linkedListToInt(list2);
        int l3 = linkedListToInt(list3);
        
        System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
        System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
        System.out.println("");

    }
}

class LinkedListNode {
    public LinkedListNode next;
    public LinkedListNode prev;
    public int data;
    public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
        data = d;
        setNext(n);
        setPrevious(p);
    }
    
    public void setNext(LinkedListNode n) {
        next = n;
        if (n != null && n.prev != this) {
            n.setPrevious(this);
        }
    }
    
    public void setPrevious(LinkedListNode p) {
        prev = p;
        if (p != null && p.next != this) {
            p.setNext(this);
        }
    }   
    
    public String printForward() {
        if (next != null) {
            return data + "->" + next.printForward();
        } else {
            return ((Integer) data).toString();
        }
    }
}