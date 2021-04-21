//2016112154 정동구
import java.util.ArrayList;
import java.util.*;
//카드게임 진행을 위한 메소드들
public class CardGame {

    public ArrayList<Card> Cardset = new ArrayList<Card>();//카드셋
    public ArrayList<Card> SelectedCard = new ArrayList<Card>();//뽑은 카드
    public String[] cardName = {"spade","dia","heart","clover"};//모양 종류
    public int[] cardNum = {2,3,4,5,6,7,8,9,10};//숫자 종류
    int sum = 0;
    public void createCardset()//카드셋 생성
    {
        Cardset.clear();
        SelectedCard.clear();
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 9; j++)
            {
                Cardset.add(new Card(cardName[i],cardNum[j]));//모양별 숫자 2-10까지 add
            }
        Collections.shuffle(Cardset);//무작위로 섞는다
            sum = 0;//뽑은 카드 숫자 총합 0으로 초기화

    }
    void getCard()//카드를 뽑는다
    {
        if(SelectedCard.size()==3)//뽑은 카드 세장인경우 바로 return
            return;
        Card temp;//ArrayList에 add하기 위한 임시값
        temp = Cardset.get(0);//카드셋의 가장 첫 카드를 뽑는다.
        Cardset.remove(0);//뽑고 제거
        SelectedCard.add(temp);//ArrayLIst에 추가
        sum += temp.getNum();//합산
        System.out.println("selected card is : "+temp.getShape()+" "+temp.getNum());
    }
    boolean isWin()
    {
        if(sum > 15) return true;//합이 15이상일경우 승리
        else return false;
    }
    double WinProbability()
    {
        double probability =0;//초기확률
        int denominator =0,numerator=Cardset.size();//분모는 남은 카드셋 갯수
        int scoreNeed = 15-sum +1; //승리하기 위해 필요한 점수
        int repeat = 3-SelectedCard.size();

        for (int i = 0; i < Cardset.size(); i++) {
        if (Cardset.get(i).getNum() >= scoreNeed)
        {
            denominator ++;//승리 가능 카드가 나올때마다 분자 ++
        }
        probability = (double)denominator/(double)numerator;
        }
        return probability*100;//퍼센테이지로 표시하기 위함
    }
}
