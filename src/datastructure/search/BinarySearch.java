package datastructure.search;

public class BinarySearch{

    //递归实现
    public int search(int[] array, int target, int low, int high){
        if(low > high){
            return -1;
        }
        int mid = low + (high - low)/2;

        if(array[mid] == target){
            return mid;
        }

        if(target < array[mid]){
            return search(array, target, low, mid - 1);
        } else {
            return search(array, target, mid+1, high);
        }
    }

    //迭代实现
    public int search(int[] array, int target){
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + ((high - low)>>>1);
            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] integers = new int[]{5, 6, 7, 32, 32, 35, 36, 43, 64, 67, 74, 84, 87, 94, 237};
        System.out.println(bs.search(integers, 237));
    }
}
