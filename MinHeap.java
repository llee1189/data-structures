import java.lang.Math;
public class MinHeap {
    //int[] testArr = new int[] {10, 5, 7, 4, 15};
    private int[] heap;
    private int size;
    private int max;

    MinHeap(int max) {
        this.max = max;
        size = 0;
        this.heap = new int[max];
    }    

    public int getMin() {
        return heap[0];
    }

    public void extractMin() {
        int index = 0;
        int leftChild = (index * 2) + 1;
        int rightChild = (index * 2) + 2;
        int temp;
        heap[index] = heap[size];
        if (heap[index] > heap[leftChild]) {
            temp = heap[leftChild];
            heap[leftChild] = heap[index];
            heap[index] = temp;

            index = leftChild;
            leftChild = (index * 2) + 1;
            rightChild = (index * 2) + 2;
        } else if (heap[index] > heap[rightChild]) {
            temp = heap[rightChild];
            heap[rightChild] = heap[index];
            heap[index] = temp; 

            index = rightChild;
            leftChild = (index * 2) + 1;
            rightChild = (index * 2) + 2;
        }
    }

    public void insert(int e) {
        if (size == max) {
            System.out.println("ERROR: The heap is maxed out! Cannot add anymore.");
        }
        if (size == 0) {
            heap[0] = e; // if empty, create
            size++;
            return;
        }
        int index = size;
        int pIndex = (size - 1) / 2;

        heap[index] = e; // adds to the end of the tree

        while (heap[pIndex] > heap[index]) {
            int temp = heap[pIndex];
            heap[pIndex] = heap[index];
            heap[index] = temp; // switches parent to children

            if (pIndex == 0) {
                break; // if at root, done
            }

            index = pIndex;
            pIndex = (index - 1) / 2; // updates new current position and parent position

        }
        size++;
        return;
    }

    public void heapify() {

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(heap[i]);
        }
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(6);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(2);
        minHeap.insert(13);
        minHeap.insert(7);
        minHeap.insert(4);
        minHeap.print();
        System.out.println("The minimum value of this heap is: " + minHeap.getMin());
    }
}
