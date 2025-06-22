package LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<Integer>(2);
        linkedList.printAll();
//
//        linkedList.append(3);
//        linkedList.printAll();
//        linkedList.append(4);
//        linkedList.printAll();
//
//        linkedList.prepend(5);
//        linkedList.printAll();
//        linkedList.prepend(6);
//        linkedList.printAll();

        linkedList.insert(1, -3);
        linkedList.printAll();

        linkedList.insert(2, -2);
        linkedList.printAll();

        linkedList.insert(0, -1);
        linkedList.printAll();

        linkedList.insert(8, -4);
        linkedList.printAll();

//        linkedList.removeLast();
//        linkedList.printAll();

//        linkedList.removeLast();
//        linkedList.printAll();
//
//        linkedList.removeLast();
//        linkedList.printAll();
//
//        linkedList.removeLast();
//        linkedList.printAll();
//
//        linkedList.removeLast();
//        linkedList.printAll();
//
//        linkedList.prepend(8);
//        linkedList.printAll();

//        linkedList.removeFirst();
//        linkedList.printAll();
//        linkedList.removeFirst();
//        linkedList.printAll();
//        linkedList.removeFirst();
//        linkedList.printAll();
//        linkedList.removeFirst();
//        linkedList.printAll();

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.get(4));

        linkedList.set(1, 0);
        linkedList.printAll();

        System.out.println(linkedList.remove(2).value);

    }
}
