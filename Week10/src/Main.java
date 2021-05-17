public class Main {

    public static void main(String[] args)
    {
        TV tv = new TV();

        tv.On();
        tv.Off();
        tv.channelUp();
        tv.channelDown();
    }
}

class dog implements move,life{

    public boolean eating = false;
    public boolean sleeping = false;
    public int age=0;
    public String name="choco";
    public String sex = "male";

    public void front()
    {
        System.out.println("Dog moves front");
    }
    public void back()
    {
        System.out.println("Dog moves back");
    }
    public void left()
    {
        System.out.println("Dog moves left");
    }
    public void right()
    {
        System.out.println("Dog moves right");
    }
    public void eat()
    {
        if(eating == true)
            System.out.println("Dog is eating");
        else
            System.out.println("Dog is not eating");
    }
    public void sleep()
    {
        if(sleeping == true)
            System.out.println("Dog is sleeping");
        else
            System.out.println("Dog is not sleeping");
    }

    public void changeEat()
    {
        if(sleeping == true)
            this.eating = false;
        else
            this.eating = true;
    }

    public void changeSleep()
    {
        if(sleeping == true)
            this.sleeping = false;
        else
            this.sleeping = true;
    }
}

class cat implements move,life{

    public boolean eating = false;
    public boolean sleeping = false;
    public int age=0;
    public String name="choco";
    public String sex = "male";

    public void front()
    {
        System.out.println("cat moves front");
    }
    public void back()
    {
        System.out.println("cat moves back");
    }
    public void left()
    {
        System.out.println("cat moves left");
    }
    public void right()
    {
        System.out.println("cat moves right");
    }
    public void eat()
    {
        if(eating == true)
            System.out.println("cat is eating");
        else
            System.out.println("cat is not eating");
    }
    public void sleep()
    {
        if(sleeping == true)
            System.out.println("cat is sleeping");
        else
            System.out.println("cat is not sleeping");
    }

    public void changeEat()
    {
        if(sleeping == true)
            this.eating = false;
        else
            this.eating = true;
    }

    public void changeSleep()
    {
        if(sleeping == true)
            this.sleeping = false;
        else
            this.sleeping = true;
    }
}

class microwave implements on_off{

    public boolean on_off = false;
    public void On()
    {
        if(on_off = true)
        {
            this.on_off = false;
            System.out.println("TV가 켜졌습니다.");
        }
        else
        {
            System.out.println("TV가 이미 켜져있습니다.");
        }
    }
    public void Off()
    {
        if(on_off = true)
        {
            this.on_off = false;
            System.out.println("TV가 꺼졌습니다.");
        }
        else
        {
            System.out.println("TV가 이미 꺼져있습니다.");
        }
    }
}