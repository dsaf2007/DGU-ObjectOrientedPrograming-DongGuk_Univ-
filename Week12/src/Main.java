//2016112154 정동구
import java.util.Random;
public class Main {

    public static void main(String[] args)
    {
        Car.print_car_number();
        Car ca1 = new Car("car1",1234);
        Car ca2 = new Car("car2");
        Car ca3 = new Car("car3");

        Car.print_car_info(ca1);
        Car.print_car_info(ca2);

        ca1.price();ca2.price();ca3.price();
        Car.print_car_number();
    }
}

class Car
{
    static int car_count =0;//static변수로 선언하여 모든 객체가 공유함.
    public String name;
    public String car_number="";
    public String car_price="";

    public char[] num = {'0','1','2','3','4','5','6','7','8','9','0'};
    Random rnd = new Random();
    Car(String name)
    {

        car_count ++;
        this.name=name;

        for(int i =0 ; i<3;i++)//랜덤한 문자열로 자동차 가격 생성
        {
            for(int j = 0; j<3 ; j++)
            {
                car_price+=num[rnd.nextInt(10)];
            }
            car_price +=",";
        }
        for(int i=0;i<4;i++)//랜덤한 문자열로 자동차 번호 생성
        {
            car_number += num[rnd.nextInt(10)];
        }
        System.out.println("make "+name+"& number is "+car_number);
    }

    Car(String name, int car_number)
    {
        car_count ++;
        this.name = name;
        this.car_number = Integer.toString(car_number);//정수로 입력받은 자동차 번호 문자열 변환
        for(int i =0 ; i<3;i++)//랜덤한 문자열로 자동차 가격 생성
        {
            for(int j = 0; j<3 ; j++)
            {
                car_price+=num[rnd.nextInt(10)];
            }
            car_price +=",";
        }
        System.out.println("make "+name+"& number is "+car_number);
    }

    static void print_car_number()//객체 개수
    {
        System.out.println("car_count is "+car_count);
    }

    static void print_car_info(Car car)//자동차 정보 출력
    {
        System.out.println("car_name is "+car.name+" & car_number is "+car.car_number);
    }

    void price()//가격 출력
    {
        System.out.println("The price is "+car_price);
    }
}
