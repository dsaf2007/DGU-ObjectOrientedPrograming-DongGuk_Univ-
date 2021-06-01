//2016112154 정동구

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Computer1 extends User{//User 상속
    public Card playCard(Card table,boolean attack)//메소드 오버라이딩
    {
        ArrayList<Card> same_card = new ArrayList<Card>();
        same_card.clear();
        if(attack ==true) {
            if (table.getNum().equals("2")) {
                for (int i = 0; i < hand.size(); i++) {
                    if ((hand.get(i).getShape().equals(table.getShape()) && hand.get(i).getNum().equals("A")) || hand.get(i).getNum().equals("2"))//모양같은 A이거나 숫자가 2일때
                    {
                        same_card.add(hand.get(i));
                        hand.remove(i);
                        return same_card.get(0);
                    }

                    if (hand.get(i).getShape().equals("joker"))//혹은 조커가 있을 때
                    {
                        same_card.add(hand.get(i));
                        hand.remove(i);
                        return same_card.get(0);
                    }
                }
            } else if (table.getNum().equals("A")) {
                for (int i = 0; i < hand.size(); i++) {
                    if (hand.get(i).getNum().equals("A"))//숫자가 A일때
                    {
                        same_card.add(hand.get(i));
                        hand.remove(i);
                        return same_card.get(0);
                    }
                    if (hand.get(i).getShape().equals("joker")) {
                        same_card.add(hand.get(i));
                        hand.remove(i);
                        return same_card.get(0);
                    }
                }
            }
        }
        else {
            for (int i = 0; i < hand.size(); i++) {
                if (compare(hand.get(i), table) == true)
                    same_card.add(hand.get(i));
            }

            if (same_card.size() == 0) { //낼 카드가 없는데 패에 7이 있을 때
                for (int i = 0; i < hand.size(); i++) {
                    if (hand.get(i).getNum().equals("7"))
                        same_card.add(hand.get(i));
                }
            }


            Collections.sort(same_card, new Comparator<Card>() {//숫자 기준 내림차순 정렬. 일치하는 카드 중 숫자가 가장 큰 카드 우선 제출
                @Override
                public int compare(Card o1, Card o2) {
                    if (o1.getNum().compareTo(o2.getNum()) > 0)
                        return -1;
                    else if (o1.getNum().compareTo(o2.getNum()) < 0)
                        return 1;
                    return 0;
                }
            });
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).getShape().equals(same_card.get(0).getShape()) && hand.get(i).getNum().equals(same_card.get(0).getNum()))
                    hand.remove(i);//낸 카드 패에서 삭제
            }

        }
        return same_card.get(0);
    }
}
