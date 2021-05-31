import java.util.*;
public class CardGame {

    public ArrayList<Card> deck = new ArrayList<Card>();
    public String[] cardName = {"spade","dia","heart","clover"};//모양 종류
    public String[] cardNum = {"A","J","Q","K","2","3","4","5","6","7","8","9","10"};//숫자 종류

    public ArrayList<User> players=new ArrayList<User>();
    
    public Card table_card;

    CardGame()
    {
        players.add(new Player());
        players.add(new Computer1());
        players.add(new Computer2());
    }
    public void createCardset()//카드셋 생성
    {
        deck.clear();
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 13; j++)
            {
                deck.add(new Card(cardName[i],cardNum[j]));//모양별 숫자 2-10까지 add
            }
        deck.add(new Card("joker","joker"));
        Collections.shuffle(deck);//무작위로 섞는다
    }

    public void initializeCard()
    {
        createCardset();
        for(int i = 0 ; i < 5;i++){//5장씩 배부
            for(int j =0 ;j<players.size();j++)
            {
                players.get(j).drawCard(deck.get(0));
                deck.remove(0);
            }
        }
        table_card = deck.get(0);//카드 한장 뒤집기
            deck.remove(0);
    }

    public Card dealCard()//유저가 카드를 뽑아 갈 때
    {
        Card temp = deck.get(0);
        deck.remove(0);
        return temp;
    }

    public Card getTable_card()
    {
        return this.table_card;
    }
    public void setTable_card(Card new_table)
    {
        this.table_card = new_table;
    }

}
