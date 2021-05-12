import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Computer2 extends User{//컴퓨터 2 User를 상속한다.
    public Card playCard(Card table)//메소드 오버라이딩
    {
        ArrayList<Card> same_card = new ArrayList<Card>();
        same_card.clear();
        for(int i = 0;i<hand.size();i++)
        {
            if(compare(hand.get(i),table)==true)
                same_card.add(hand.get(i));
        }
        Collections.sort(same_card, new Comparator<Card>() {//숫자 기준 내림차순 정렬. 일치하는 카드 중 숫자가 가장 큰 카드 우선 제출
            @Override
            public int compare(Card o1, Card o2) {
                if(o1.getNum() > o2.getNum())
                    return -1;
                else if(o1.getNum() < o2.getNum())
                    return 1;
                return 0;
            }
        });
        for(int i = 0;i<hand.size();i++)
        {
            if(hand.get(i).getShape().equals(same_card.get(0).getShape()) && hand.get(i).getNum() == same_card.get(0).getNum())
                hand.remove(i);//낸 카드 패에서 삭제
        }
        return same_card.get(0);
    }
}