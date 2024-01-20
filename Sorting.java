import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Sorting {
    static int cnt=0;
    static int Insertionsort(int n, int arr[]) {
        int count=0;
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int j = i;
            try{
                while (arr[j] < arr[j - 1] && j - 1 >= 0) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
                count++;
            }
            }
            catch(Exception e){}
            
        }
        return count;

    }
    static void merge(int arr[],int l,int mid,int r)
{
    int n1 = mid-l+1;
    int n2 = r-mid;
    int arr1[]=new int[n1];
    int arr2[]=new int[n2];
    for(int i=0;i<n1;i++)
    {
        arr1[i]=arr[l+i];
    }
    for(int i=0;i<n2;i++)
    {
        arr2[i]=arr[mid+1+i];
    }
    int i=0,j=0,k=l;
    while(i<n1 && j<n2)
    {
        if(arr1[i] <= arr2[j])
        {
            arr[k] = arr1[i];
            i++;
        }
        else if (arr1[i]>arr2[j])
        {
            arr[k]=arr2[j];
            j++;
        }
        k++;
    }
    while(i<n1)
        arr[k++] = arr1[i++];
    while(j<n2)
        arr[k++] = arr2[j++];
}
static void merge_sort(int arr[],int l,int r)
{
    if(r>l)
    {
        int mid = (l+r)/2;
        merge_sort(arr,l,mid);
        cnt++;
        merge_sort(arr,mid+1,r);
        cnt++;
        merge(arr,l,mid,r);
    }
}
  public static void main(String[] args) {
    int n[] = { 100, 500, 1000, 2000 };
    int m = 0, j = 0, key, flag = 0,x=0;
    int arr1[] = new int[4];
    int arr2[]=new int[4];
    Random rand = new Random();
    for (int k = 0; k < 4; k++) {
      try {
        File file = new File("file.txt");
        FileOutputStream fos = new FileOutputStream(file);
        DataOutputStream dout = new DataOutputStream(fos);
        for (int i = 0; i < n[m]; i++) {
          key=rand.nextInt(1000);
          dout.writeInt(key);
        }
        int arr[]=new int[n[m]];
        dout.close();
        fos.close();
        FileInputStream fin = new FileInputStream(file);
        DataInputStream din = new DataInputStream(fin);
        // Insertion Sort
        for (int i = 0; i < n[m]; i++) {
          int val = din.readInt();
          arr[i]=val;
        }
        arr1[j]=Insertionsort(n[m], arr);
        j++;
        din.close();
        fin.close();
        FileInputStream Fin = new FileInputStream(file);
        DataInputStream Din = new DataInputStream(Fin);
        //Merge Sort
        for (int i = 0; i < n[m]; i++) {
          int val = Din.readInt();
          arr[i]=val;
        }
        System.out.println("hi");
        merge_sort( arr,0,n[m]-1);
        arr2[x]=cnt;
        x++;
        cnt=0;
      }
      catch (Exception e) {
      }
      m++;
    }
    System.out.printf("S.No\t\tInsertion Sort\t\tMerge Sort\n");
    for(int i=0;i<4;i++){
      System.out.printf("%d%22d%25d\n",i+1,arr1[i],arr2[i]);
    }

  }
}