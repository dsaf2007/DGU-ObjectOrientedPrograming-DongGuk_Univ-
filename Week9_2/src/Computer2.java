import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Computer2 extends User{
    public Card playCard(Card table)
    {
        ArrayList<Card> same_card = new ArrayList<Card>();
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

        return same_card.get(0);
    }
}
