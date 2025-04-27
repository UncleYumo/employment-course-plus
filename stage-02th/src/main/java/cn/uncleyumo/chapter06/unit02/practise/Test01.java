package cn.uncleyumo.chapter06.unit02.practise;

import java.util.Arrays;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 4/27/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    public static void main(String[] args) {
        practise02();
    }

    /**
     * 快速排序（Quick Sort）是一种基于分治思想的排序算法。
     * 它的基本思想是选择一个基准元素，将数组分成两个子数组，
     * 一部分小于等于基准元素，一部分大于等于基准元素，然后对这两个子数组分别递归地进行排序。
     * 请在网上了解一下快速排序，编写一个程序实现该功能
     */
    private static void practise02() {
        int[] arr = {3, 1, 5, 8, 3, 10, 5, 10};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 如果数组为空或长度为1，则无需排序
        }
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int left, int right) {
        if (left >= right) {
            return; // 当左指针大于等于右指针时，结束递归
        }

        // 分区操作，返回基准值的正确位置
        int pivotIndex = partition(arr, left, right);

        // 对基准值左边的部分递归排序
        quickSortHelper(arr, left, pivotIndex - 1);

        // 对基准值右边的部分递归排序
        quickSortHelper(arr, pivotIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        // 选择最右侧元素作为基准值
        int pivot = arr[right];
        int i = left; // i 指向当前小于等于 pivot 的最后一个元素的位置

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                // 将小于等于 pivot 的元素交换到左侧
                swap(arr, i, j);
                i++;
            }
        }

        // 将基准值放到正确的位置
        swap(arr, i, right);

        return i; // 返回基准值的索引
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 面试官要求我们写一个测试类，实现如下下功能：
     * ① 定义一个递归方法，该方法可以实现计算0-n之间所有奇数的和
     * ② 在主方法中调用该方法，并将0-100之间所有奇数的和打印在控制台
     */
    private static void practise01() {
        System.out.println(recursive(5));  // 5 + 3 + 1
        System.out.println(recursive(6));  // 5 + 3 + 1
    }

    private static int recursive(int n) {
        // 当n小于等于0时，返回0
        if (n <= 0) {
            return 0;
        }
        // 如果n是偶数，跳过它，继续处理前一个数
        if (n % 2 == 0) {
            return recursive(n - 1);
        }
        // 如果n是奇数，累加当前值并递归处理前两个数
        return n + recursive(n - 2);
    }
}
