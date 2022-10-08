package queue12.abab;

public class Try1 {
    public static void main(String[] args) {
        int distance = 2;
        int arr[] = new int[1500];
        int oi = 0;
        boolean boo = true;
        //获取质数列
        for(int j = 2; j < 10000; j++) {
            boo = true;
            for(int i = 2; i < j/2; i++) {
                if(j % i == 0) {
                    boo = false;
                }
            }
            if(boo) {arr[oi++] = j;}
        }

        int ino = 1;
        // n n+d n+2d n+3d ... n+9d
        flag: for(int i = 0; i < 1300; i++) {
            int ori = arr[i];
            for(distance = 1; distance < 1000; distance++) {
                for(int j = 1; j < 1400; j++) {
                    if(ori + distance == arr[j]) {ino++;}
                    if(ori + 2*distance == arr[j]) {ino++;}
                    if(ori + 3*distance == arr[j]) {ino++;}
                    if(ori + 4*distance == arr[j]) {ino++;}
                    if(ori + 5*distance == arr[j]) {ino++;}
                    if(ori + 6*distance == arr[j]) {ino++;}
                    if(ori + 7*distance == arr[j]) {ino++;}
                    if(ori + 8*distance == arr[j]) {ino++;}
                    if(ori + 9*distance == arr[j]) {ino++;}
                }
                if(ino == 10) {break flag;}
                else {ino = 1;}
            }
        }
        System.out.println(distance);

        // System.out.println(210);
    }
}
