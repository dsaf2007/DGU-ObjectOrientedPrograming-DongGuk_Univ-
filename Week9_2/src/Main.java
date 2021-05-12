import java.util.Scanner;
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public void main(String[] args)
    {
        CardGame game = new CardGame();
        System.out.println("Start Card Game");
        game.createCardset();
        game.initializeCard();
        while(true)
        {
            int cmd;
            System.out.println("Choose command");
            System.out.println("1. Draw Card");
            System.out.println("2. Play Card");
            System.out.println("Command : ");
            cmd = sc.nextInt();

            switch(cmd)
            {
                case 1:
                    game.players[0].drawCard(game.dealCard());
                    break;
                case 2:
                    game.players[0].playCard(game.getTable_card());
            }
            for(int i = 1;i<3;i++)
            {
                if(game.players[i].searchCard(game.getTable_card())==true)
                    game.setTable_card(game.players[i].playCard(game.getTable_card()));
                else
                    game.players[i].drawCard(game.dealCard());
            }
        }

    }
}
