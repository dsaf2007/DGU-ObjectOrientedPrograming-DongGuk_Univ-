//2016112154 정동구
import java.util.Scanner;

public class Calculator {

    Scanner sc = new Scanner(System.in);

    public int num1;
    public int num2;

    public Calculator()//생성자 num1 num2 초기화
    {
        num1 = 0;
        num2=0;
    }

    public void Addition()
    {
        System.out.println("reslut is : " + (num1+num2));
    } // 더하기를 진행하는 메소드

    public void Substraction()
    {
        System.out.println("reslut is : " + (num1-num2));
    } //빼기를 진행하는 메소드

    public void Multiplication()
    {
        System.out.println("reslut is : " + (num1*num2));
    } //곱셈을 진행하는 메소드

    public void Division() // 나누기를 진행하는 메소드. 나누는 수가 0인경우 오류 메시지 출력
    {
        if(num2 == 0)
        {
            System.out.println("num 2 is 0 cannot divide");
        }
        else {
            double div = (double) num1 / (double) num2;
            System.out.println("reslut is : " + div);
        }
    }

    public void GetNum() //연산에 이용할 수를 입력받는다.
    {
        System.out.print("Enter num1 : ");
        num1 =sc.nextInt();
        System.out.print("Enter num2 : ");
        num2 =sc.nextInt();
        System.out.println();
    }


    public void run() //계산기를 구동하는 메소드
    {

        while (true)
        {
            System.out.println("select menu");
            System.out.println("1 : addition(num1+num2)");
            System.out.println("2 : substraction(num1-num2)");
            System.out.println("3 : multiplication(num1*num2)");
            System.out.println("4 : division(num1/num2)");
            System.out.println("5 : exit");

            int mode = sc.nextInt();

            switch (mode) {//num1 num2먼저 get하고 연산 수행
                case 1:
                    GetNum();
                    Addition();
                    break;
                case 2:
                    GetNum();
                    Substraction();
                    break;
                case 3:
                    GetNum();
                    Multiplication();
                    break;
                case 4:
                    GetNum();
                    Division();
                    break;
                case 5:
                    System.out.println("exit program");
                    System.exit(0);
                    break;
            }
        }
    }
}
