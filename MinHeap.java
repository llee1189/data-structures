public class MinHeap {
    // int[] testArr = new int[] {10, 5, 7, 4, 15};
    private int[] heap;
    private int size;
    private int max;

    MinHeap(int max) {
        this.max = max;
        size = 0;
        this.heap = new int[max];
    }

    public int getMin() {
        return heap[0]; // returns root
    }

    public void extractMin() {
        // removes root and replaces with last leaf
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
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
        int pIndex = (size - 1) / 2; // parent index

        heap[index] = e; // adds to the end of the tree

        while (heap[pIndex] > heap[index]) { // repeat while parent > index
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

    private void heapify(int index) {
        if (index >= (size / 2) && index <= size) {
            return; // if leaf, stop
        }
        int leftChild = (index * 2) + 1;
        int rightChild = (index * 2) + 2;
        int temp;
        if (heap[index] > heap[leftChild] || heap[index] > heap[rightChild]) {
            // if either child is less than the current index, then...
            if (heap[leftChild] < heap[rightChild]) {
                // if the left is less than right, swap index with left
                temp = heap[leftChild];
                heap[leftChild] = heap[index];
                heap[index] = temp;

                heapify(leftChild);
            } else if (heap[rightChild] < heap[leftChild]) {
                // if right < left, index = right
                temp = heap[rightChild];
                heap[rightChild] = heap[index];
                heap[index] = temp;

                heapify(rightChild);
            }
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
        System.out.println(heap[i]);
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(9);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(11);
        minHeap.insert(10);
        minHeap.insert(27);
        minHeap.insert(15);
        minHeap.insert(7);
        minHeap.insert(13);
        minHeap.insert(2);
        minHeap.extractMin();
        minHeap.print();
        System.out.println("The minimum value of this heap is: " + minHeap.getMin());
    }
}
