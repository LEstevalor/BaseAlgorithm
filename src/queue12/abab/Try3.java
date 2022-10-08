package queue12.abab;

public class Try3 {
    public static void main(String[] args) {
        char[][] ch = new char[2][4];
        ch[0] = "LANN".toCharArray();
        ch[1] = "QIAO".toCharArray();

        int sum = 0;  //递增序列数
        for(int i = 0; i < 1; i++) {
            for(int j = 0; j < 4; j++){
                for(int k = j + 1; k < 4; k++) {
                    if(ch[i][j] < ch[i][k]) {sum++; }   //+4
                }
                for(int k = i + 1; k < 2; k++) {
                    if(ch[i][j] < ch[k][j]) {sum++; }   //+3
                }
                for(int a = i + 1, b = j + 1; a < 2 && b < 4; a++, b++) {
                    if(ch[i][j] != ch[a][b]) {sum++; }  //2
                }
                if(j != 0){
                    for(int a = i + 1, b = j - 1; a < 2 && b >= 0; a++, b--) {
                        if(ch[i][j] != ch[a][b]) {sum++; }  //3
                    }
                }
            }
        }

        for(int j = 0; j < 3; j++) {
            for(int k = j + 1; k < 4; k++) {
                if(ch[1][j] < ch[1][k]) {sum++; }  //+2
            }
        }
        System.out.println(sum);
        boolean a = false;
        int bb = 0;
        if((bb = 1) == 1){a = true;}
        System.out.println(a);
    }
}
