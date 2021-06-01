import java.util.*;
import java.util.Comparator;
import java.util.Collections;

public class User {

    public ArrayList<Card> hand = new ArrayList<Card>();//손에 쥔 카드
    Scanner sc = new Scanner(System.in);


    public boolean searchAttack(Card table)
    {
        if(table.getNum().equals("2"))
        {
            for(int i =0; i< hand.size();i++)
            {
               if((hand.get(i).getShape().equals(table.getShape()) && hand.get(i).getNum().equals("A"))||hand.get(i).getNum().equals("2"))//모양같은 A이거나 숫자가 2일때
                   return true;
               if(hand.get(i).getShape().equals("joker"))return true;//혹은 조커가 있을 때
            }
        }
        if(table.getNum().equals("A"))
        {
            for(int i =0; i< hand.size();i++)
            {
                if(hand.get(i).getNum().equals("A"))//숫자가 A일때
                    return true;
                if(hand.get(i).getShape().equals("joker"))return true;
            }
        }
        if(table.getShape().equals("joker"))return false;

        return false;
    }
    public boolean compare(Card a, Card b)
    {
        boolean same = false;
        if(a.getShape().compareTo(b.getShape())==0 || a.getNum().compareTo(b.getNum())==0)
            same = true;
        else
            same = false;

        return same;
    }

    public void drawCard(Card draw)
    {
        this.hand.add(draw);
    }//카드 뽑기

    public boolean searchCard(Card table)//테이블에 카드가 패에 존재하는지 확인
    {
        for(int i =0; i< hand.size();i++)
        {
            if(compare(table,hand.get(i)))
                return true;
            if(hand.get(i).getNum().equals("7"))
                return true;
        }
        return false;
    }

    public Card playCard(Card table,boolean attack)
    {
        return new Card("","");
    }
    public Card playCard(Card table)//테이블에 존재하는 카드와 일치할 경우 낸다.
    {
        String shape;
        String num;
        int index=0;
        System.out.println("choose card to play");
        System.out.print("shape:");
        shape = sc.nextLine();
        System.out.print("num:");
        num = sc.nextLine();
        if(shape.equals("joker"))
        {
            for(int i = 0 ; i < hand.size(); i ++)
            {
                if(shape.equals(hand.get(i).getShape()) && num.equals(hand.get(i).getNum()))
                    index = i;
            }
            Card play = hand.get(index);
            hand.remove(index);//낸 후 손에서 제거
            return play;
        }
        while(!table.num.equals(num) && !table.shape.equals(shape) && !table.getShape().equals("joker"))//일치하지 않는 경우
        {
            if(num.equals("7"))
                break;
                System.out.println("cannot play card");
                System.out.println("choose card to play");
                System.out.print("shape:");
                shape = sc.nextLine();
                System.out.print("num:");
                num = sc.nextLine();
                sc.nextLine();
        }
        for(int i = 0 ; i < hand.size(); i ++)
        {
            if(shape.equals(hand.get(i).getShape()) && num.equals(hand.get(i).getNum()))
                index = i;
        }
        Card play = hand.get(index);
        hand.remove(index);//낸 후 손에서 제거
        return play;
    }

    public boolean win()//승리 여부
    {
        if(hand.size() == 0)
            return true;
        else
            return false;
    }

    public void clearHand()//손을 비운다.
    {
        hand.clear();
    }

    public void showHand()//패를 보여준다.
    {
        for(int i = 0 ; i <hand.size();i++)
        {
            System.out.print("["+hand.get(i).getShape()+" "+hand.get(i).getNum()+"] ");
            System.out.println();
        }
    }
}
