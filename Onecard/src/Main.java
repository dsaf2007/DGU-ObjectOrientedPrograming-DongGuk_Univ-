//2016112154 정동구
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        CardGame game = new CardGame();
        System.out.println("Start Card Game");
        game.createCardset();
        game.initializeCard();
        Card temp_card = new Card("","");
        int card_draw =0;//A,2,joker일시에 추가로 뽑을 카드 매수
        int one_turn = 0; //한턴을 세기 위한 변수
        boolean draw = false;
        int turn = 1;
        boolean skip = false;
        int i = 0;
        while(true)
        {

            int cmd;

            one_turn = 0;
            while(one_turn < 3)
            {
                if (temp_card.getNum().compareTo("J")==0)//J일 경우 턴 스킵
                {
                    i +=turn;
                }
                temp_card = new Card("","");//빈 카드로 초기화
                if(i == 0) {
                    System.out.println("table Card is ["+game.getTable_card().getShape()+" "+game.getTable_card().getNum()+"]");
                    System.out.println("Choose command");
                    System.out.println("1. Draw Card");
                    System.out.println("2. Play Card");
                    System.out.println("3. Show hand");
                    System.out.println("Command : ");
                    cmd = sc.nextInt();
                    switch (cmd) {
                        case 1:
                            game.players.get(0).drawCard(game.dealCard());
                            break;
                        case 2:
                            temp_card = game.players.get(0).playCard(game.getTable_card());
                            game.setTable_card(temp_card);
                            break;
                        case 3:
                            game.players.get(0).showHand();
                            //i -=turn;
                            continue;
                    }
                    if(temp_card.getNum().equals("7"))
                    {
                        sc.nextLine();
                        System.out.println("change shape to : ");
                        String change_shape=sc.nextLine();
                        game.setTable_card(new Card(change_shape,"7"));
                        temp_card = new Card("","");//빈 카드로 초기화
                    }

                }
                else
                {
                    if(game.getTable_card().getNum().compareTo(("J"))==0)//턴 스킵
                        i+=turn;
                    temp_card = new Card("","");//빈 카드로 초기화

                System.out.println(game.players.get(i).getClass().getName()+" is playing");
                if(game.players.get(i).searchCard(game.getTable_card())==true) {
                    temp_card = game.players.get(i).playCard(game.getTable_card());
                    game.setTable_card(temp_card);
                    System.out.println(game.players.get(i).getClass().getName()+"has played ["+game.getTable_card().getShape()+" "+game.getTable_card().getNum()+"]");
                    if(temp_card.getNum().equals("7"))
                    {
                        Random rnd = new Random();
                        String change_shape= game.cardName[rnd.nextInt(4)];
                        System.out.println("change shape to : " + change_shape);
                        game.setTable_card(new Card(change_shape,"7"));
                    }
                }
                else
                    game.players.get(i).drawCard(game.dealCard());
                }

                if (temp_card.getNum().compareTo("Q")==0)//순서 변경
                {
                    if(turn ==1)
                        turn = -1;
                    else if(turn ==-1)
                        turn = 1;

                    one_turn = 0;
                }
                i +=turn;
                if(temp_card.getNum().compareTo("K")==0)//turn 을 빼서 루프가 한번 돌아서 자신차례가 한번 더 오게 한다.
                { i -= turn; one_turn --;}

                if(turn == 1 && i ==3)
                    i=0;
                if(turn ==-1 && i ==-1)
                    i =2;
                one_turn ++;


            }
            int win = 0; boolean game_end=false; String winner =""; String second = "";
            for(int j = 0;j<game.players.size();j++) {
                if (game.players.get(j).win() == true) {
                    win = j;
                    game_end = true;
                }
            }
            sc.nextLine();
           if(game_end == true) {
               //game.ranking();
               System.out.println("Winner is "+game.players.get(win).getClass().getName());
               game.players.remove(win);
               if(game.players.get(0).hand.size()<game.players.get(1).hand.size())
                   System.out.println("Second Rank is "+game.players.get(0).getClass().getName());
               else if(game.players.get(0).hand.size()>game.players.get(1).hand.size())
                   System.out.println("Second Rank is "+game.players.get(1).getClass().getName());
               else if(game.players.get(0).hand.size()==game.players.get(1).hand.size())
                   System.out.println("Second Rank is "+game.players.get(0).getClass().getName()+" and "+game.players.get(1).getClass().getName());
               String restart;

               System.out.print("restart game? (y/n) :");
               restart = sc.nextLine();
               switch(restart)
               {
                   case "y":
                       game.deck.clear();
                       game.initializeCard();
                       System.out.println("Start new Game");
                       break;
                   case "n":
                       System.out.println("exit game");
                       System.exit(0);
               }

           }
           else
           {
               System.out.println(game.players.get(1).getClass().getName()+"has "+game.players.get(1).hand.size()+"cards in hand");
               System.out.println(game.players.get(2).getClass().getName()+"has "+game.players.get(2).hand.size()+"cards in hand");
           }
           }
        }

}
