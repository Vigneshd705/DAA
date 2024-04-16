import java.util.Arrays;

class Merge_Sort{
	public static void main(String[] args){
		int[] arr = {5,4,3,2,1};
		int l=0;
		int r = arr.length - 1;
		mergesort(arr,l,r);
		System.out.println(Arrays.toString(arr));
	}
	public static void mergesort(int[] arr, int l, int r){
		if(l < r){
			int mid = ( l + r ) / 2;
			
			mergesort(arr,l,mid);
			mergesort(arr,mid+1,r);
			merge(arr,l,mid,r);
		}
	}
	public static void merge(int[] arr, int l ,int mid, int r){
		int n1 = mid - l + 1;	
		int n2 = r - mid;
		int i=0,j=0,k = l;
		int[] l1 = new int[n1];
		int[] r1 = new int[n2];

		for(int a = 0; a<n1; a++)
			l1[a] = arr[l + a];
		for(int a = 0; a<n2; a++)
			r1[a] = arr[mid + 1 + a];

		while(i < n1 && j < n2){
			if(l1[i] <= r1[j]){
				arr[k++] = l1[i++];
			}
			else{
				arr[k++] = r1[j++];
			}
		}
		while(i < n1)
			arr[k++] = l1[i++];
		while( j < n2 )
			arr[k++] = r1[j++];
	
	}
}
