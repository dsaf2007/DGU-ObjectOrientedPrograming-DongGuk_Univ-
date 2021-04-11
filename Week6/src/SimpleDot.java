import java.util.*;
public class SimpleDot {
    Pair[] locationCells;//dot의 좌표를 위한 Pair 배열(x y)
    int numOfHits = 0;//적중 횟수
    Pair[] completeLocation = new Pair[4];//이미 적중한 좌표 확인을 위한 배열
    boolean kill = false;// 이미 KILL된적이 있는지 판단
    SimpleDot()
    {
        for(int j=0;j<4;j++)//completeLocatin초기화
        {
            completeLocation[j] = new Pair(-1,-1);
        }
    }
    int x=0;
    public void setLocationCells(Pair[] locs)//생성한 좌표를 입력받는 메소드
    {
        locationCells=locs;

    }
    public String checkYourself(String xStringGuess,String yStringGuess) {//적중여부확인
        int guessX = Integer.parseInt(xStringGuess);
        int guessY = Integer.parseInt(yStringGuess);
        String result = "miss";
        boolean exist = false;//이미 HIT한 좌표인지 확인

            for (int i = 0; i < locationCells.length; i++) {//생성된 DOT개수만큼
                if (guessX == locationCells[i].row && guessY == locationCells[i].col) {//좌표가 일치할경우
                    for (int j = 0; j < 4; j++) {
                        if (guessX == completeLocation[i].row && guessY == completeLocation[i].col)//이미 hit한 전적 확인
                            exist = true;
                    }
                    if (exist == false) {//처음인경우
                        result = "hit";
                        numOfHits++;
                        completeLocation[x++] = new Pair(locationCells[i].row, locationCells[i].col);//hit목록에 추가.
                        break;
                    } else {
                        result = "already";//이미 추가된경우.
                    }
                }
            }

            if (numOfHits == locationCells.length) {//히트 횟수 == 길이인경우 kill
                result = "kill";
                kill = true;
            }

            return result;
        }
    }
