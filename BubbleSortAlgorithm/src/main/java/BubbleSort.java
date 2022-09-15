import java.util.Random;

public class BubbleSort {

    private Integer arraySize;
    private Integer[] arr;

    public BubbleSort(Integer maxArraySize) {
        this.arraySize = new Random().nextInt(maxArraySize);
        this.arr = new Integer[arraySize];
        for (int i = 0; i < this.arraySize; i++) {
            arr[i] = new Random().nextInt(1000);
        }
    }

    // SWAPPED - Инвариант.
    // Если за прохождение всего массива не найдется пары, у которой число,
    // имеющее больший индекс, меньше второго числа, то этот массив отсортирован
    // (т.е. все числа в массиве расположены в неубывающем порядке).
    public void sort() {
        boolean swapped = true;                             //Анализ алгоритма
        for (int j = 1; j < arraySize && swapped; j++) {    // n
            swapped = false;
            for (int i = 0; i < arraySize - j; i++) {       // n*(n-1)/2
                if (arr[i] > arr[i + 1]) {                  // n*(n-1)/2
                    swap(i, i + 1);                         //T(n) = C1 * n + C2 * n*(n-1)/2 + C3 * n*(n-1)/2
                    swapped = true;                         //T(n) = C1 * n + C2 * (n^2 - n)/2 + C3 * (n^2 - n)/2    |C2 = C2/2 - новая константа, C3 = C3/2 - новая константа.|
                }                                           //T(n) = C1*n + C2*n^2 - C2*n + C3*n^2 - C3*n
            }                                               //T(n) = n^2(C2 + C3) + n*(C1 - C2 - C3)
        }                                                   //O(n^2) - асимптотическая сложность алгоритма
    }

    public void recursionSort(int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(i, i + 1);
            }
        }
        if (n - 1 > 1) {
            recursionSort(n - 1);
        }
    }

    public void swap(int firstIndex, int secondIndex) {
        Integer temp = arr[secondIndex];
        arr[secondIndex] = arr[firstIndex];
        arr[firstIndex] = temp;
    }

    public Integer getArraySize() {
        return arraySize;
    }

    public void setArraySize(Integer arraySize) {
        this.arraySize = arraySize;
    }

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }
}
