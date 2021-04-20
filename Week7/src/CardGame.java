//2016112154 정동구
import java.util.ArrayList;

public class CardGame {

    public ArrayList<Card> Cardset = new ArrayList<Card>();
    public String[] cardName = {"spade","dia","heart","clover"};
    public int[] cardNum = {2,3,4,5,6,7,8,9,10};
    public void createCardset()
    {
        Cardset.clear();
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 9; j++)
            {
                Cardset.add(new Card(cardName[i],cardNum[j]));
            }

    }


}
