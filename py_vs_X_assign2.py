"""
Zack Khalidov
"""

import time
import sys
sys.setrecursionlimit(500000)

def mergeSort2(list):
    """Recursive method for merge sort split by 2."""
    if len(list) > 1:
        mid = len(list) // 2

        left = list[:mid]
        right = list[mid:]

        mergeSort2(left)
        mergeSort2(right)

        i = 0
        j = 0
        k = 0

        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                list[k] = left[i]
                i += 1
            else:
                list[k] = right[j]
                j += 1
            k += 1

        while i < len(left):
            list[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            list[k] = right[j]
            j += 1
            k += 1

    return list


def mergeSort(list_of_items):
    """Main function for merge sort."""
    start_time = time.time()

    list_of_items = mergeSort2(list_of_items)

    elapsed_time = time.time() - start_time
    return (list_of_items, elapsed_time)


def assign02_main():
    with open('py_vs_X_assign2.txt') as f:
        list0 = [int(line.rstrip('\n')) for line in f]

    list1 = list(list0)

    # run sorting functions
    print("before merge, list1[:10] = ", list1[:10])
    mergeRes2 = mergeSort(list1)
    print("after merge,  list1[:10] = ", list1[:10])



    # Print results
    print(f"Python merge time: {mergeRes2[1]:.4f} sec")



# Check if the program is being run directly (i.e. not being imported)
if __name__ == '__main__':
    assign02_main()
