public class mergeSortArr {
    public static void main(String[] args) {
    int [] array = {3, 4, 12, 54, 7, 1, 67, 34};
    mergeSort(array);
    for (int i = 0; i < array.length; i++){
        System.out.print(array[i] + " ");
    }
    }
    
    public static void mergeSort (int[] arr){
        int size = arr.length;
        if (size == 1) return;
        int middle = size / 2;
        int [] leftPart = new int [middle];
        int [] rightPart = new int [size - middle];

        for (int i = 0; i < middle; i++){
            leftPart[i] = arr[i];
        }

        for (int i = middle; i < size; i++){
            rightPart[i - middle] = arr [i];
        }

        mergeSort(leftPart);
        mergeSort(rightPart);
        merge (arr, leftPart, rightPart);

    }

    private static void merge (int [] arr, int [] leftPart, int [] rightPart){
        int left = leftPart.length;
        int right = rightPart.length;
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < left && j < right){
            if (leftPart[i] < rightPart[j]){
                arr[index] = leftPart[i];
                i++;
            } else{
                arr[index] = rightPart[j];
                j++;
            }
            index++;            
        }

        for (int lastleft = i; lastleft < left; lastleft++){
            arr[index ++] = leftPart[lastleft];
    
        }
       
        for (int lastrigt = j; lastrigt < right; lastrigt++){
            arr[index ++] = rightPart[lastrigt];
            
        }

    }
}
