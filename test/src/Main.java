public class Main {

    public static void main(String[] args)
    {
        /*student s = new student("student");

        System.out.println(s.name);
        s = new student("change1");
        System.out.println(s.name);*/

        //비트연산자
        int c =-1; long d=(long)(-1);
        System.out.println("c>>>2= " +(c>>>2));
        System.out.println("d>>>2= " +(d>>>2));


        char ch = 'a';
        int a = 1; double b = 2;
        System.out.println("원래 문자 : "+ch +", int로 명시적 형변환 :" + (int)ch);
        System.out.println("int 1 / double 2 : "+a/b);
    }
}
//int 32bit long 64bit. -1은 비트가 전부 1로 채워짐.
class student
{
    public String name;
    public student(String name)
    {this.name =name;}
}

