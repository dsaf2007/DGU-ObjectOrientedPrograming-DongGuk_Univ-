//2016112154 정동구
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        CardGame game = new CardGame();
        System.out.println("Start Card Game");
        game.createCardset();
        game.initializeCard();
        int turn = 1;
        boolean skip = false;
        while(true)
        {
            System.out.println("table Card is ["+game.getTable_card().getShape()+" "+game.getTable_card().getNum()+"]");
            int cmd;
            System.out.println("Choose command");
            System.out.println("1. Draw Card");
            System.out.println("2. Play Card");
            System.out.println("3. Show hand");
            System.out.println("Command : ");
            cmd = sc.nextInt();


            for(int i = 0;i<3;i+=turn)
            {
                if(i == 0) {
                    switch (cmd) {
                        case 1:
                            game.players.get(0).drawCard(game.dealCard());
                            break;
                        case 2:
                            game.setTable_card(game.players.get(0).playCard(game.getTable_card()));
                            break;
                        case 3:
                            game.players.get(0).showHand();
                            continue;
                    }
                }
                else
                {
                    if(game.getTable_card().getNum().compareTo(("J"))==0)//턴 스킵
                    continue;
                if(game.getTable_card().getNum().compareTo("K")==0)
                    i--;

                System.out.println(game.players.get(i).getClass().getName()+" is playing");
                if(game.players.get(i).searchCard(game.getTable_card())==true) {
                    game.setTable_card(game.players.get(i).playCard(game.getTable_card()));
                    System.out.println(game.players.get(i).getClass().getName()+"has played ["+game.getTable_card().getShape()+" "+game.getTable_card().getNum()+"]");
                }
                else
                    game.players.get(i).drawCard(game.dealCard());
            }
            }
            int win = 0; boolean game_end=false; String winner =""; String second = "";
            for(int i = 0;i<game.players.size();i++) {
                if (game.players.get(i).win() == true) {
                    win = i;
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
