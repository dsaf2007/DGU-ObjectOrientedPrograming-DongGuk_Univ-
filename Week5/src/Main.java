//2016112154 정동구
import java.util.Scanner;


public class Main {

    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        Student student = new Student();

        for(int i = 0 ; i < student.size ; i++)//while문 for문으로 변경
        {
            System.out.print("이름을 입력해주세요 : ");
            student.u_name[i]=sc.nextLine();
        }
        for(int i = 0 ; i < student.size ; i++) // while 문 for문으로 변경
        {
            System.out.print(student.u_name[i]+"의 점수를 입력해주세요 : ");
            student.u_score[i]=sc.nextInt();
        }
        for(int i = 0 ; i < student.size ; i++)
        {
            switch(student.u_score[i]/10)//case를 성적/10으로 나눔.
            {
                case 10:
                    System.out.println(student.u_name[i] + " grade is A");
                    break;
                case 9:
                    System.out.println(student.u_name[i] + " grade is A");
                    break;
                case 8:
                    System.out.println(student.u_name[i] + " grade is B");
                    break;
                case 7:
                    System.out.println(student.u_name[i] + " grade is C");
                    break;
                default:
                    System.out.println(student.u_name[i] + " grade is d");
            }


        }
    }
}


class Student
{
    public String u_name[];
    public int u_score[];
    public int size=3;
    Student()
    {
        u_name = new String[size];
        u_score = new int[size];
    }


}
