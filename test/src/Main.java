//2016112154  정동구
public class Main {

    public static void main(String[] args)
    {
        char ch = 'a';
        int a = 1; double b = 2;
        System.out.println("원래 문자 : "+ch +", int로 명시적 형변환 :" + (int)ch);// 명시적 형변환으로 char 타입을 정수형으로 출력(유니코드 출력됨)
        System.out.println("int 1 / double 2 : "+a/b);//큰값인 double type로 int type이 묵시적 형변환됨
        System.out.println("문제점 int 1 / double 2 : "+(int)(a/b)); // double type로 묵시적 형변환 된 값을 명시적 형변환 하여 소수가 표시 안됨.

        //비트연산자
        /*int c =-1; long d=(long)(-1);
        System.out.println("c>>>2= " +(c>>>2));
        System.out.println("d>>>2= " +(d>>>2));*/
    }
}

