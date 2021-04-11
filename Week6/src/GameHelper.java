import java.io.*;

public class GameHelper {//라인을 입력받을 game helper
    public String getUserInput(String prompt)
    {
        String inputLine = null;
        System.out.print(prompt + " ");
        try
        {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
        } catch (IOException e) {
            System.out.print("IOException: "+e);
        }
        return inputLine;
    }

}