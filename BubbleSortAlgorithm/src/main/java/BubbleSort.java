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
    /*
    * Метод подстановки:
    * T(n) = 2T([n/2]) + n
    * T(n/2) <= C(n/2)^2
    * T(n) <= 2(C(n/2)^2) + n
    * = C * n^2/2 + n
    * = Cn^2/2 + n
    * <= n^2
    * Выполняется при c >= 1
    * if (n == 1) {
    *   1/2 + 1 = 3/2 <= 1^2 | False
    * }
    * if (n == 2) {
    *   2 + 2 = 4 <= 4 | True
    * }
    * if (n == 3) {
    *   9/2 + 3 = 15/2 <= 9 | True
    * }
    * if (n == 4) {
    *   16/2 + 4 = 12 <= 16 | True
    * }
    *
        Инвариант цикла
    Д-во.
    Инициализация.
    Доказывается, что выражение инварианта истинно перед началом цикла.
    i=0
    инвариант: a[i]>a[i-k] для любого k>0
    доказательство: a[0] - первый элемент, a[-k] нет
    Доказывается, что выражение инварианта сохраняет свою истинность после выполнения тела цикла; таким образом, по индукции, доказывается, что по завершении всего цикла инвариант будет выполняться.

    инвариант: a[i]>a[i-k] для любого k>0
    после i++: i=1
    a[1]>a[0] т.к. по условию если (a[0] > a[1]), то swap(a[0], a[1]), т.е. наибольшим будет a[1].
    На i=j итерации: a[i]>a[i-1] по аналогии и т.к. на предыдущей итерации достигнуто a[i-1] > a[i-2], а a[i-1] и a[i] меняются значениями так, что бы a[i] был наибольшим, то a[i]>a[i-2], аналогично для всех a[i-k]
    Таким образом по индукции доказано a[i]<a[i-k] при k>0
        Завершение:
     Т.к. a[i]>a[i-k] для любого k>0 и i>0 i<N (N – размер массива), то массив отсортирован
    *
    *
    *
    *
    *
    *
     */
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
