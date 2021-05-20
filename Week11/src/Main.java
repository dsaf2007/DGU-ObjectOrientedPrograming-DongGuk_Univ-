//2016112154 정동구
public class Main {

    static exercise select(int i)//매개변수로 정수를 받고 switch-case문으로 exercise 객체 초기화.
    {
        int num = i%4;
        exercise out=new exercise();
        switch(num)
        {
            case 0:
                out = new exercise("exercise");
                break;
            case 1:
                out = new exercise("baseball");
            break;
            case 2:
                out = new exercise("soccer");
            break;
            case 3:
                out = new exercise("basketball");
            break;
        }

        return out;
    }

    static void exe(exercise ex)//매개변수로 exercise클래스를 받아 play() 실행
    {
        ex.play();
    }

    public static void main(String[] args)
    {
        exercise[] ex_list = new exercise[4];

        for(int i = 0 ; i<4;i++)
        {
            ex_list[i] = select(i);
            exe(ex_list[i]);

        }
    }
}

class exercise{

    String ex;
    exercise(){}//default 생성자
    exercise(String input)//String을 input으로 받는 생성자
    {
        this.ex = input;
    }

    public void play()//출력
    {
        System.out.println("play "+ex);
    }
}
