//2016112154
public class Card {//카드 모양과 숫자를 하나로 묶기 위함
    String shape;//가로
    int num;//세로
    public Card(String shape,int num)
    {
        this.shape = shape;
        this.num = num;
    }
    public String getShape() {
        return shape;
    }
    public int getNum()
    {
        return num;
    }
}