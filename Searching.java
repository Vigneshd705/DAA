import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Searching {
  public static void main(String[] args) {
    int n[] = { 100, 500, 1000, 2000 };
    int m = 0, j = 0, key, flag = 0,x=0;
    int arr[] = new int[4];
    int arr1[] = new int[4];
    int keys[]=new int[4];
    ArrayList<Integer> num = new ArrayList<>();
    Random rand = new Random();
    for (int k = 0; k < 4; k++) {
      try {
        File file = new File("file.txt");
        FileOutputStream fos = new FileOutputStream(file);
        DataOutputStream dout = new DataOutputStream(fos);
        for (int i = 0; i < n[m]; i++) {
          key=rand.nextInt(1000);
          dout.writeInt(key);
          num.add(key);
        }
        key = rand.nextInt(1000);
        keys[k]=key;
        dout.close();
        fos.close();
        FileInputStream fin = new FileInputStream(file);
        DataInputStream din = new DataInputStream(fin);
        // Linear Search
        for (int i = 0; i < n[m]; i++) {
          int val = din.readInt();
          // num.add(val);
          if (key == val) {
            arr[j++] = i;
            flag = 1;
            System.out.println("Linear Search: "+key + " found at index " + i);
            break;
          }
        }
        if (flag == 0) {
          arr[j++] = n[m];
          System.out.println("Linear Search: "+key + " not found");
        }

        // Binary Search
        // System.out.println(num);
          Collections.sort(num);
          int l = 0, r = n[m] - 1, mid = (l + r) / 2, count = 0;
          while (l < r) {
            if (num.get(mid) == key) {
              arr1[x++] = count;
              flag = 1;
              System.out.println("Binary Search: "+key + " found at index " + mid);
              break;
            } else if (num.get(mid) > key) {
              r = mid - 1;
              mid = (l + r) / 2;
              count++;
            } else if (num.get(mid) < key) {
              l = mid + 1;
              mid = (l + r) / 2;
              count++;
            }
        }
        if(flag==0){
          System.out.println("Binary Search: "+key+" not found");
          count++;
          arr1[x++]=count;
        }
      }
      catch (Exception e) {
      }
      m++;
    }
    System.out.printf("S.No\t\tKey\t\tLinear Search\t\tBinary Search\n");
    for(int i=0;i<4;i++){
      System.out.printf("%d%17d%22d%25d\n",i+1,keys[i],arr[i],arr1[i]);
    }

  }
}