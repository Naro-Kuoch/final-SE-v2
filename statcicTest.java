public class statcicTest {
    static int num = 0;
    static String str = "abc";
    static char ch = 'a';

    public static void main(String[] args) {
        num++;
        str += " new";
        ch = 'b';
        System.out.println(num + " " + str + " " + ch);
        String str1 = "ab";
        String str2 = "afa";
        boolean t = str1.equals(str2);
        boolean t2 = str1 == str2;
        System.out.println(t);
        System.out.println(t2);
    }
}
