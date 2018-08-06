package examples.collections;

import java.util.*;

public class CollectionExamples {

    public static void main(String[] args) {
        queue();
        priorityQueue();
        stack();
    }

    private static void queue() {
        // kolejka FIFO
        System.out.println("--- Queue ---");
        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        while (!queue.isEmpty()) {
            // poll() - zwraca element i usuwa go z kolejki, remove() - tak samo, ale rzuca wyjatek gdy kolejka jest pusta
            // peek() zwraca element, ale nie usuwa go z kolejki, element() - tak samo ale rzuca wyjatek gdy kolejka jest pusta
            System.out.println("queue element: " + queue.poll());
        }
        System.out.println("queue element: " + queue.poll()); // poll() zwraca null gdy kolejka jest pusta
    }

    private static void priorityQueue() {
        System.out.println("\n--- Priority Queue ---");
        // jest to kopiec binarny min (wartosc wezla jest mniejsza od wartosci jego dzieci)
        Queue<Integer> minQueue = new PriorityQueue<>();
        minQueue.add(3);
        minQueue.add(1);
        minQueue.add(5);
        minQueue.add(2);
        while (!minQueue.isEmpty()) {
            System.out.println("minQueue element: " + minQueue.poll());
        }

        // mozna zrobic kopiec binarny podajac inny komparator
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        // Queue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a);
        maxQueue.add(3);
        maxQueue.add(1);
        maxQueue.add(5);
        maxQueue.add(2);
        while (!maxQueue.isEmpty()) {
            System.out.println("maxQueue element: " + maxQueue.poll());
        }
    }

    private static void stack() {
        System.out.println("--- Stack ---");
        // Dequeue - m.in. dostarcza metody pozwalajace na uzywanie go jako stosu (LIFO). Zastepuje interfejs Stack.
        Deque<String> stack = new LinkedList<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        while (!stack.isEmpty()) {
            System.out.println("stack element: " + stack.pop()); // peek() - zwraca element, ale nie usuwa go ze stosu
        }
    }
}
