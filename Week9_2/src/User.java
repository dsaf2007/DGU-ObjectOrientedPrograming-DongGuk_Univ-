import java.util.*;
import java.util.Comparator;
import java.util.Collections;

public class User {

    public ArrayList<Card> hand = new ArrayList<Card>();//손에 쥔 카드
    Scanner sc = new Scanner(System.in);
    public boolean compare(Card a, Card b)
    {
        boolean same = false;
        if(a.getShape()==b.getShape() || a.getNum()==b.getNum())
            same = true;
        else
            same = false;

        return same;
    }

    public void drawCard(Card draw)
    {
        this.hand.add(draw);
    }

    public boolean searchCard(Card table)
    {
        for(int i =0; i< hand.size();i++)
        {
            if(compare(table,hand.get(i)))
                return true;
        }
        return false;
    }


    public Card playCard(Card table)
    {
        String shape;
        int num;
        System.out.println("choose card to play");
        System.out.print("shape:");
        shape = sc.nextLine();
        System.out.print("num:");
        num = sc.nextInt();
        while(table.getNum() != num && table.getShape() != shape)
        {
                System.out.println("cannot play card");
                System.out.println("choose card to play");
                System.out.print("shape:");
                shape = sc.nextLine();
                System.out.print("num:");
                num = sc.nextInt();
        }
        int index=0;
        for(int i = 0 ; i < hand.size(); i ++)
        {
            if(shape == hand.get(i).getShape() && num == hand.get(i).getNum())
                index = i;
        }
        Card play = hand.get(index);
        hand.remove(index);
        return play;
    }

    public boolean win()
    {
        if(hand.size() == 0)
            return true;
        else
            return false;
    }

}
