public class Pair {//x좌표 y좌표를 한번에 묶기 위해 만든 class

    int row;//가로
    int col;//세로

    public Pair(int row,int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }
    public int getCol()
    {
        return col;
    }
}
