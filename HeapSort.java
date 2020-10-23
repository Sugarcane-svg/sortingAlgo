import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins.LateRegistration;

public class HeapSort {
    public static int left(int index){
        return 2*index+1;
    }
    public static int right(int index){
        return 2*index+2;
    }
    public static int parent(int index){
        return Math.floor(index/2);
    }
    public static void maxHeapify(int[] arr, int heapSize, int index){
        int largest=index;
        int left = left(index);    //left child
        int right = right(index);    //right child

        //compare left child with its parent
        if(left < heapSize && arr[left] > arr[index]){
            largest = left;
        }
        //conpare right child with left 
        if(right < heapSize && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != index){
            swap(arr, index, largest);
            maxHeapify(arr, heapSize, largest);
        }
        
    }

    //build maxHeap
    public static void buildMaxHeap(int[] arr, int heapSize){
        for(int i = (int)(Math.floor(heapSize/2)-1); i>=0; i--){
            maxHeapify(arr, heapSize, i);
        }
    }

    public static void heapSort(int[] arr, int heapSize){
        buildMaxHeap(arr,heapSize); //build the heap 
        for(int i = heapSize-1; i>0; i--){
            swap(arr, i, 0);
            maxHeapify(arr, i, 0); 
        }
    }
    public static void swap(int[] arr, int index, int b){
        int temp = arr[index];
        arr[index] = arr[b];
        arr[b]=temp;
    }
    //print arr
    public static void print(int[] arr){
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args){
        int[] A = {3,6,1,8,12,4,7};
        heapSort(A, A.length);
        print(A);
    }

}
