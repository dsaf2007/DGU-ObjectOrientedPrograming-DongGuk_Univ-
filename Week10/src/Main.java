//2016112154 정동구
public class Main {

    public static void main(String[] args)
    {
        TV tv = new TV();
        dog a = new dog();
        cat b = new cat();
        human me = new human();
        Airplane plane = new Airplane();
        microwave micro = new microwave();
    
        tv.On();
        tv.Off();
        tv.channelUp();
        tv.channelDown();
        System.out.println("----------------------------------");
        a.back();
        a.front();
        a.right();
        a.left();
        a.changeEat();
        a.eat();
        a.changeSleep();
        a.sleep();
        System.out.println("----------------------------------");

        b.sleep();
        b.eat();
        b.back();
        b.front();
        b.right();
        b.left();
        b.changeEat();
        b.changeSleep();
        System.out.println("----------------------------------");
        me.changeEat();
        me.changeSleep();
        me.back();
        me.front();
        me.left();
        me.right();
        me.eat();
        me.sleep();
        System.out.println("----------------------------------");
        plane.back();
        plane.front();
        plane.left();
        plane.right();
        plane.getAirline();
        plane.getModel();
        System.out.println("----------------------------------");
        micro.Off();
        micro.On();
        micro.setPower(50);
        micro.setTime(30);


    }
}

class TV implements on_off{

    public int channel=0;
    public String channel_name;
    public boolean on_off = false;
    public int prev_channel=0;
    public String prev_channel_name ="";
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
    public void channelUp()
    {
        this.prev_channel = this.channel;
        this.channel ++;
        System.out.println("channel is "+channel);
    }
    public void channelDown()
    {
        this.prev_channel = this.channel;
        this.channel --;
        System.out.println("channel is "+channel);
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
    }//앞
    public void back()
    {
        System.out.println("Dog moves back");
    }//뒤
    public void left()
    {
        System.out.println("Dog moves left");
    }//왼
    public void right()
    {
        System.out.println("Dog moves right");
    }//오
    public void eat()//식사중 여부
    {
        if(eating == true)
            System.out.println("Dog is eating");
        else
            System.out.println("Dog is not eating");
    }
    public void sleep()//취침 여부
    {
        if(sleeping == true)
            System.out.println("Dog is sleeping");
        else
            System.out.println("Dog is not sleeping");
    }

    public void changeEat()//식사 여부 변경
    {
        if(sleeping == true)
            this.eating = false;
        else
            this.eating = true;
    }

    public void changeSleep() // 취침여부 변경
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
    public String name="Garfeild";
    public String sex = "male";

    public void front()
    {
        System.out.println("cat moves front");
    }//앞
    public void back()
    {
        System.out.println("cat moves back");
    }//뒤
    public void left()
    {
        System.out.println("cat moves left");
    }//왼
    public void right()
    {
        System.out.println("cat moves right");
    }//오
    public void eat()//식사 여부
    {
        if(eating == true)
            System.out.println("cat is eating");
        else
            System.out.println("cat is not eating");
    }
    public void sleep()//취침여부
    {
        if(sleeping == true)
            System.out.println("cat is sleeping");
        else
            System.out.println("cat is not sleeping");
    }

    public void changeEat()//식사 여부 변경
    {
        if(sleeping == true)
            this.eating = false;
        else
            this.eating = true;
    }

    public void changeSleep()//취침여부 변경
    {
        if(sleeping == true)
            this.sleeping = false;
        else
            this.sleeping = true;
    }
}

class microwave implements on_off{

    public boolean on_off = false;
    public int time = 0 ; //sec
    public int power = 0 ; // 0-100%
    public String mode = "";
    public boolean backlight = false;

    public void On()//전원 키기
    {
        if(on_off = true)
        {
            this.on_off = false;
            System.out.println("micorwave가 켜졌습니다.");
        }
        else
        {
            System.out.println("micorwave가 이미 켜져있습니다.");
        }
    }
    public void Off()//전원 끄기
    {
        if(on_off = true)
        {
            this.on_off = false;
            System.out.println("micorwave가 꺼졌습니다.");
        }
        else
        {
            System.out.println("micorwave가 이미 꺼져있습니다.");
        }
    }

    public void setTime(int input)//시간 설정
    {
        this.time = input;
    }

    public void setPower(int power)//출력 설정
    {
        if(power < 0 || power >=100)
            System.out.println("Poewer out of range");
        else
            this.power = power;
    }

}

class human implements move,life
{
    public boolean eating = false;
    public boolean sleeping = false;
    public int age=0;
    public String name="DongGU";
    public String sex = "male";

    public void front()
    {
        System.out.println("human moves front");
    }//앞
    public void back()
    {
        System.out.println("human moves back");
    }//뒤
    public void left()
    {
        System.out.println("human moves left");
    }//왼
    public void right()
    {
        System.out.println("human moves right");
    }//오
    public void eat()//식사여부
    {
        if(eating == true)
            System.out.println("human is eating");
        else
            System.out.println("human is not eating");
    }
    public void sleep()//취침여부
    {
        if(sleeping == true)
            System.out.println("human is sleeping");
        else
            System.out.println("human is not sleeping");
    }

    public void changeEat()//식사여부 변경
    {
        if(sleeping == true)
            this.eating = false;
        else
            this.eating = true;
    }

    public void changeSleep()//취침여부 변경
    {
        if(sleeping == true)
            this.sleeping = false;
        else
            this.sleeping = true;
    }
}

class Airplane implements move{

    public String model ="707";
    public String destination = "Korea";
    public String airline = "Korean Airline";
    public boolean flying = false;
    public boolean charging_gas = false;

    public void front()
    {
        System.out.println("human moves front");
    }//앞
    public void back()
    {
        System.out.println("human moves back");
    }//뒤
    public void left()
    {
        System.out.println("human moves left");
    }//왼
    public void right()
    {
        System.out.println("human moves right");
    }//오

    public void getAirline()//항공사 출력
    {
        System.out.println(airline);
    }

    public void getModel()//항공기 모델 출력
    {
        System.out.println(model);
    }

}