//2016112154 정동구
public class Test {
    public static Animal[] animals;
    public static void main(String[] args)
    {
        animals = new Animal[3];
        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = new Cow();

        for(int i = 0; i < animals.length; i++)
        {
            animals[i].bark();
        }
    }
}
