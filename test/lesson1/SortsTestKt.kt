package lesson1

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.*

class SortsTestKt {
    private val r = Random(Calendar.getInstance().timeInMillis)

    private fun assertSorted(arr: IntArray, prefix: String) {
        for (i in 0 until arr.size - 1) {
            assertTrue(prefix + " ERROR: i = " + i + " a[i] = " + arr[i] + " a[i+1] = " + arr[i + 1],
                    arr[i] <= arr[i + 1])
        }
    }

    private fun <T : Comparable<T>> assertSorted(arr: Array<T>, prefix: String) {
        for (i in 0 until arr.size - 1) {
            assertTrue(prefix + " ERROR: i = " + i + " a[i] = " + arr[i] + " a[i+1] = " + arr[i + 1],
                    arr[i] <= arr[i + 1])
        }
    }

    @Test
    fun insertionSort() {
        val arr = intArrayOf(3, 7, 5, 9, 1, 6, 19, 13)
        insertionSort(arr)
        assertSorted(arr, "INSERTION SORT")
    }

    @Test
    fun insertionSortStrings() {
        val arr = arrayOf("beta", "omega", "alpha", "", "!!!", "teta", "O")
        insertionSort(arr)
        assertSorted(arr, "INSERTION SORT")
    }

    @Test
    fun mergeSort() {
        val arr = intArrayOf(3, 7, 5, 9, 1, 6, 19, 13)
        mergeSort(arr)
        assertSorted(arr, "MERGE SORT")
    }

    @Test
    fun longInsertionSort() {
        val length = 65536
        val arr = IntArray(length)
        for (i in 0 until length) {
            arr[i] = r.nextInt()
        }
        insertionSort(arr)
        assertSorted(arr, "INSERTION SORT LONG")
    }

    @Test
    fun longMergeSort() {
        val length = 65536
        val arr = IntArray(length)
        for (i in 0 until length) {
            arr[i] = r.nextInt()
        }
        mergeSort(arr)
        assertSorted(arr, "MERGE SORT LONG")
    }

    @Test
    fun longHeapSort() {
        val length = 65536
        val arr = IntArray(length)
        for (i in 0 until length) {
            arr[i] = r.nextInt()
        }
        heapSort(arr)
        assertSorted(arr, "HEAP SORT LONG")
    }

    @Test
    fun quickSort() {
        val arr = intArrayOf(3, 7, 5, 9, 1, 6, 19, 13)
        quickSort(arr)
        assertSorted(arr, "QUICK SORT")
    }

    @Test
    fun longQuickSort() {
        val length = 65536
        val arr = IntArray(length)
        for (i in 0 until length) {
            arr[i] = r.nextInt()
        }
        quickSort(arr)
        assertSorted(arr, "QUICK SORT LONG")
    }

    @Test
    fun longCountingSort() {
        val length = 65536
        val limit = 262144
        val arr = IntArray(length)
        for (i in 0 until length) {
            arr[i] = r.nextInt(limit)
        }
        val result = countingSort(arr, limit - 1)
        assertSorted(result, "COUNTING SORT LONG")
        quickSort(arr)
        assertArrayEquals(arr, result)
    }
}