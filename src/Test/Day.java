package Test;

@SuppressWarnings({"all"})
public class Day {
    public static void main(String[] args) {}

    // 判断一个八位数是否为合法日期格式
    public static boolean isDate(int n) {
        int year = n / 10000;
        int month = n % 10000 / 100;
        int day = n % 100;
        int i = 0;

        if (month > 13) return false;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            i = 31;
        } else if (month == 2) {
            i = year % 400 == 0 ||(year % 4 == 0 && year % 100 != 0) ? 28 : 27;
        } else {
            i = 30;
        }
        if (day > i) return false;
        return true;
    }
}
