import java.util.Scanner;

class Student{
    int Maths;
    int English;
    int Science;
    int Computer;
    char grade;
    int total(){
        return Maths+English+Science+Computer;
    }
    double average(){
        return (Maths+English+Science+Computer)/4;
    }
    void setGrade(){
        double avg = average();
        if(avg>=90 && avg<=100) grade = 'O';
        else if(avg>=80 && avg<90) grade = 'A';
        else if(avg>=70 && avg<80) grade = 'B';
        else if(avg>=60 && avg<70) grade = 'C';
        else if(avg>=50 && avg<60) grade = 'D';
        else grade = 'F';
    }
}
public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int n = sc.nextInt();
        Student[] s = new Student[n];
        for(int i=0; i<s.length; i++){
            s[i] = new Student();
            System.out.println("Enter the marks of Maths of student " + (i+1));
            s[i].Maths = sc.nextInt();
            System.out.println("Enter the marks of English of student " + (i+1));
            s[i].English = sc.nextInt();
            System.out.println("Enter the marks of Science of student " + (i+1));
            s[i].Science = sc.nextInt();
            System.out.println("Enter the marks of Computer of student " + (i+1));
            s[i].Computer = sc.nextInt();
            s[i].setGrade();
        }
        System.out.println("Student No\tTotal Marks\t\tAverage\t\tGrade");
        for(int i=0; i<s.length; i++){
            System.out.print("\t" + (i+1) + "\t\t");
            System.out.print("\t" + s[i].total() + "\t\t");
            System.out.printf("\t%.2f\t\t", s[i].average());
            System.out.printf("\t%c", s[i].grade);
            System.out.println();
        }
    }
}
