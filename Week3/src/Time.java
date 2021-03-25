//2016112154 정동구
import java.awt.desktop.SystemEventListener;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Time {

    Time(){}//생성자
    Scanner sc = new Scanner(System.in);
    public void run()//구동하는 메소드
    {
        SimpleDateFormat form1 = new SimpleDateFormat("HH:mm:ss");//출력할 시간의 형식을 지정한다.

        while(true)
        {
            System.out.println("select menu");
        System.out.println("1: current time");
        System.out.println("2:timer");
        System.out.println("3: exit");
            Date time = new Date();//Date객체 선언
        int mode;
        double timer=0;//타이머 종료를 위해 쓸 변수
        mode= sc.nextInt();
        switch(mode)
        {
            case 1:
                System.out.println("현재 시간은 "+ form1.format(time));//현재시간 출력
                break;
            case 2:
                long start = System.currentTimeMillis();//시작시간
                System.out.println("enter 5 to stop the timer");
                while(timer !=5)//timer가 5일때 반복문을 종료한다.
                {
                    timer = sc.nextInt();
                }
                long end = System.currentTimeMillis();//종료시간
                System.out.println("시간 차는 "+ (end -start)/1000.000 + "초 입니다.");
                break;
            case 3:
                System.out.println("exit program");
                System.exit(0);
                break;
        }
    }
    }
}
