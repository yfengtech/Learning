package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.function.IntFunction;

/**
 * 大根堆
 */
public class MaxHeap {


    public static void main(String[] args) {

//        Comparable<? super MaxHeap> key = (Comparable<? super MaxHeap>) new MaxHeap();

        int[] aa = new int[2];
        int b = 0;
        aa[b++] = 1;


        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i = 0;
        while (i < 100) {
            i++;
            heap.add(new Random().nextInt(1000));
        }
        while (heap.size() > 0) {
            System.out.println(heap.poll());
        }
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;

        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            // 左右child比较，取最大下标
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 父和较大child比较，区最大下标
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index)
                break;
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }

    }

    public static void printAsTree(Object[] data, int size) {
        int lineNum = 1;//首先遍历第一行
        int lines = (int) (Math.log(size) / Math.log(2)) + 1;//lines是堆的层数
        int spaceNum = (int) (Math.pow(2, lines) - 1);
        for (int i = 1; i <= size; ) { //因为在[1...size]左闭右闭区间存数据，data[0]不存数据

            //每层都是打印这个区间[2^(层数-1) ... (2^层数)-1]。如果堆里的数不够(2^层数)-1个，那就打印到size。所以取min((2^层数)-1,size).
            for (int j = (int) Math.pow(2, lineNum - 1); j <= Math.min(size, (int) Math.pow(2, lineNum) - 1); j++) {
                for (int s = 0; s < spaceNum; s++) {
                    System.out.print(" ");
                }
                if (j < size) {
                    System.out.printf("%3s", data[j]);//打印数据
                }
                System.out.printf("%3s", "");//图片中绿色方框
                for (int s = 0; s < spaceNum; s++) {
                    System.out.print(" ");
                }
                i++;//每打印一个元素就 + 1
            }
            lineNum++;
            spaceNum = spaceNum / 2;
            System.out.println();
        }
    }
}
