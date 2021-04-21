//2016112154 정동구
import java.text.DecimalFormat;
import java.util.*;
public class Main
{

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        CardGame game = new CardGame();
        int numOfCards=0;//뽑은 카드 갯수
        game.createCardset();//실행 직후에도 동작하게 우선 생성
        DecimalFormat format = new DecimalFormat();
        format.applyLocalizedPattern("0.00");//소숫점 자리 표시
        while(true)
        {
            System.out.println("1.카드생성 2.카드뽑기 3.승리 확률 계산 4.게임 종료");
            System.out.println("Enter menu : ");
            int cmd;
            cmd = sc.nextInt();
            switch(cmd)
            {
                case 1:
                    System.out.println("create new cardset");
                    game.createCardset();//새 카드셋 생성시 카드 갯수도 초기화
                    numOfCards=0;
                    break;
                case 2:
                    if(numOfCards<3)//3장 이상 뽑지 못하게
                    {
                        game.getCard();
                        numOfCards++;
                    }
                    else System.out.println("you already got 3 cards : ");
                    break;
                case 3:
                    System.out.println("Win possibility is :"+format.format(game.WinProbability())+"%");//승리 확률계산
                    break;
                case 4:
                    System.out.println("exit program");//4입력시 프로그램 종료
                    System.exit(0);
                    break;
            }
            if(game.isWin())//승리했을 경우
            {
                System.out.println("You won the game!");
                System.out.println("New cardset Created");
                game = new CardGame();//바로 다음게임을 위해 초기화
                game.createCardset();
                numOfCards = 0;
            }
            if(numOfCards ==3 && !game.isWin())// 승리하지 못하고 카드가 세장일 때 패배 System.out.println("you lost the game!");
            {
                System.out.println("You lost the game!");
                System.out.println("New cardset Created");
                game = new CardGame();//바로 다음게임을 위해 초기화
                game.createCardset();
                numOfCards = 0;
            }
        }

    }
}
