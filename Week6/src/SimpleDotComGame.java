//2016112154 정동구
import java.util.*;
public class SimpleDotComGame {

    public static void main(String[] args)
    {
        int numOfGuesses =0;
        int numOfDots = (int)(Math.random()*2 +3);//3~5
        GameHelper helper = new GameHelper();
        SimpleDot[] theDotCom = new SimpleDot[numOfDots];

        for(int j = 0; j < numOfDots;j++) //3-5개의 dot생성
        {
            int xCoordinate = (int) (Math.random() * 10);//x좌표 생성
            int yCoordinate = (int) (Math.random() * 10);//y좌표 생성

            Random random = new Random();
            boolean shape = random.nextBoolean();//가로 세로 결정.
            Pair[] axis = new Pair[4];//객체 배열 생성
            if (shape == true)//가로
            {
                if(xCoordinate+4 >9)//dot이 범위 벗어나는 것 방지
                    xCoordinate=xCoordinate-4;
                for (int i = 0; i < 4; i++)
                    axis[i] = new Pair(xCoordinate + i, yCoordinate);
            }else//세로로
            {
                if(yCoordinate+4 >9)
                    yCoordinate=yCoordinate-4;
                for (int i = 0; i < 4; i++)
                    axis[i] = new Pair(xCoordinate, yCoordinate + i);
            }

            for (int i = 0; i < 4; i++) {//dot 좌표 출력( 채점용 )
                System.out.println(axis[i].getRow() + " " + axis[i].getCol());
            }System.out.print("\n");
            theDotCom[j] = new SimpleDot();
            theDotCom[j].setLocationCells(axis);//location입력
        }

        boolean isAlive = true;


        while (isAlive == true)//simpledotgame
        {
            String guess = helper.getUserInput("enter coordinates(X Y):");//x 공백 y
            StringTokenizer str1 = new StringTokenizer(guess," ");//입력받은 문자열 공백기준으로 파싱
            String xAxis = str1.nextToken();
            String yAxis = str1.nextToken();
            int hitNum=0; int overlap=0; int miss=0; int killed=0;int kill=0;
            for(int i = 0; i< numOfDots;i++)// 적중판별.
            {
                if(theDotCom[i].checkYourself(xAxis, yAxis)=="hit")hitNum++;//적중시
                else if(theDotCom[i].checkYourself(xAxis, yAxis)=="already")overlap++;// 이미 적중했던 값 입력시

                if(theDotCom[i].checkYourself(xAxis, yAxis)=="kill")//kill했을 시
                {
                    System.out.println(i+"th dot com Killed");//n번째 dot이 kill됨
                    killed=1;//하단 miss가 출력되지 않기 위한 변수
                }
                if(theDotCom[i].checkYourself(xAxis, yAxis)=="miss")miss++;//빗나간 경우.

            }
            numOfGuesses++;
            if(numOfGuesses == 60)//입력 횟수 제한
            {
                System.out.println("out of limit. you loose");//입력 제한 횟수 초과
                break;
            }
            System.out.println(60-numOfGuesses + "guesses left");//잔여 추측 횟수
            for(int i = 0;i < numOfDots; i++)// kill된 dot 갯수 확인
            {
                if(theDotCom[i].kill == true) kill++;//theDotCom의 kill이 true일 경우 ++
            }
            if(hitNum>0)System.out.println(hitNum + "hits");//중복 고려하여 hit된 갯수
            else if(overlap>0)System.out.println(overlap+"alreay hit");//이미 hit한 좌표 입력시
            else if(miss > 0&&killed==0)System.out.println("miss");//kill하지 않았을 때 miss 출력

            if(kill > 0 && kill<numOfDots)//kill한 갯수와 잔여 dot갯수
            {
                System.out.println(kill + "kills "+ (numOfDots-kill)+"Dots left");
            }
            if(kill == numOfDots)//모든 dot kill한 경우 추측횟수와 victory 출력후 종료.
            {
                isAlive = false;
                System.out.println(numOfGuesses + "guesses");
                System.out.println("Victory!!");
            }
        }
    }
}