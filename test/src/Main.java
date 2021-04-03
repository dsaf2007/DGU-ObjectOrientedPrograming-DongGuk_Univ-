//2016112154  정동구
public class Main {

    public static void main(String[] args)
    {
        char ch = 'a';
        int a = 1; double b = 2;
        System.out.println("원래 문자 : "+ch +", int로 명시적 형변환 :" + (int)ch);
        System.out.println("int 1 / double 2 : "+a/b);
        System.out.println("문제점 int 1 / double 2 : "+(int)(a/b));

        //비트연산자
        /*int c =-1; long d=(long)(-1);
        System.out.println("c>>>2= " +(c>>>2));
        System.out.println("d>>>2= " +(d>>>2));*/
    }
}

