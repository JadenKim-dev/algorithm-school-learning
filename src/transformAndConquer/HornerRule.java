package transformAndConquer;

import java.util.Arrays;
import java.util.Scanner;

public class HornerRule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] heap = new int[size+1];
        for(int i=1; i<=size; i++) {
            heap[i] = sc.nextInt();
        }
        heapBottomUp(heap, size);
        System.out.println("result : " + Arrays.toString(heap));
    }

    private static void heapBottomUp(int[] heap, int size) {
        for (int i = size/2; i > 0; i--) {
            int parent = i;
            int key = heap[parent];
            boolean is_parent_dominant = false;
            while(!is_parent_dominant && 2*parent <= size) {
                int child = 2*parent;
                if (child < size && heap[child] < heap[child+1]) {
                    child = child+1;
                }
                if (key < heap[child]) {
                    heap[parent] = heap[child];
                    parent = child;
                } else {
                    is_parent_dominant = true;
                }
            }
            heap[parent] = key;
        }
    }
}
