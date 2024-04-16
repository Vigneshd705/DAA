package Divide_and_Conquer;

public class Kartsuba {
    public static void main(String[] args) {
        int n1 = 12354;
        int n2 = 39;
        System.out.println(katsubha(n1,n2));
    }
    public static int katsubha(int n1, int n2){
        if (n1 < 10 || n2 <10)
            return n1*n2;
        int size = String.valueOf(Math.max(n1,n2)).length();
        int m = size/2;
        int a1 = n1/(int) Math.pow(10,m);
        int a2 = n1%(int) Math.pow(10,m);
        int b1 = n2/(int) Math.pow(10,m);
        int b2 = n2%(int) Math.pow(10,m);
        int A = katsubha(a1,b1);
        int B = katsubha(a2,b2);
        int C = katsubha(a1+a2,b1+b2);
        return (A * (int)Math.pow(10,2*m) + (C-A-B)*(int)Math.pow(10, m) + B);
    }
}
