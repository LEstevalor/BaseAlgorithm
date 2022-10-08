package book;

public class Four {
    public static void main(String[] args) {
    }
}
/*
class Order{
    public int sum(int[] arr){
        if(arr.length == 1){
            return arr[0];
        } else {
            return arr[0] + sum(arr);
        }
    }
}
*/
class Atry{
    int index(String s,String t,int pos){
        int i = pos;
        int j = 1;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        while(i <= s1.length && j <= t1.length){
            if(s1[i] == t1[j]){
                ++i;
                ++j;
            } else{
                i -= (j-2);
                j = 1;
            }
        }
        if( j > t1.length){
            return i-t1.length;
        } else {
            return 0;
        }
    }
}