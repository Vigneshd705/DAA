public class Insertionsort {
    static void Insertionsort(int n, int arr[]) {
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int j = i;
            try{
                while (arr[j] < arr[j - 1] && j - 1 >= 0) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
            }
            catch(Exception e){}
            
        }

    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 1, 3, 8, 5 };
        int n = 6;
        Insertionsort(n, arr);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);

        }
    }

}
