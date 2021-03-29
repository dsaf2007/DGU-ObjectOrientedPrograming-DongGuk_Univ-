import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
//2016112154 정동구

public class Main {

   public static Scanner sc = new Scanner(System.in);//입력을 위한 Scanner객체 선언

    public static void main(String[] args)
    {

        String arr[] = new String[20];// 최대 20개의 단어를 받으므로 20짜리 크기의 배열 선언
        int index =0;
        while(true)
        {
            System.out.println("select menu");
            System.out.println("1: 오름차순 출력");
            System.out.println("2: 내림차순 출력");
            System.out.println("3: 단어 추가(20개 max)");
            System.out.println("4: 프로그램 종료");
            int caseNum = sc.nextInt();

            switch(caseNum)
            {
                case 1:
                    Arrays.sort(arr,0,index);//첫번째 부터 현재 배열에 들어간 값 만큼의 범위에서 오름차순 정렬
                    for(int i = 0 ; i <index ; i++)
                    {
                        System.out.println(i+"번째 : " + arr[i]);
                    }
                    break;
                case 2:
                    Arrays.sort(arr,0,index,Collections.reverseOrder());//첫번째 부터 현재 배열에 들어간 값 만큼의 범위에서 내림차순 정렬
                    for(int i = 0 ; i <index ; i++)
                    {
                        System.out.println(i+"번째 : " + arr[i]);
                    }
                    break;
                case 3:
                    if(index < 20 &&index>=0)//index가 0보다 크고 20보다 작을때만 입력이 가능하도록(20이 max)이므로
                    {
                        System.out.print("단어를 입력하시오 : ");
                        arr[index] = sc.next();
                        index++;
                    }
                    else if(index >=20)//index가 19일때가 최대이므로 20부터는 입력가능갯수 초과로 입력 불가
                    {
                        System.out.println("최대 입력 가능 개수를 초과하였습니다.");
                    }
                    break;
                case 4:
                    System.out.println("exit program");//4입력시 프로그램 종료
                    System.exit(0);
                    break;
            }
        }
    }
}
