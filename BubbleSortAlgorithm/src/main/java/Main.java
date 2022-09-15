public class Main {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort(10000);
        long startTime = System.currentTimeMillis();
        bubbleSort.sort();
        System.out.println("BubbleSort Time: " + (System.currentTimeMillis() - startTime));
        //System.out.println("Sorted array[" + bubbleSort.getArraySize() + "]: " + Arrays.toString(bubbleSort.getArr()));
    }
}
