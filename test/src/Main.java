//2016112154  정동구
public class Main {

    public static void main(String[] args)
    {

       int[] input = new int[20];
       int j =0;
       for(j = 0;j<20;j++)
       {
           input[j]=j++;
       }
       for(j=0;j<5;j++)
       {
           int temp = (int)((Math.random()*10000)%20);
           System.out.println(input[temp]);
       }
    }
}



