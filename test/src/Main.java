public class Main {

    public static void main(String[] args)
    {
        student s = new student("student");

        System.out.println(s.name);
        s = new student("change1");
        System.out.println(s.name);
    }
}

class student
{
    public String name;
    public student(String name)
    {this.name =name;}
}

