import java.util.*;
class classroom{
        static String UniversityName="Divyansh";
        final int rollNumber;
        String name;
	String grade;
        static int totstu=0;
        public classroom(int rollNumber,String grade,String name){
                this.rollNumber=rollNumber;
                this.grade=grade;
                this.name=name;
                totstu++;
        }
        public static void displayTotalStudent(){
        System.out.println("Total Number of Students are :"+totstu);
        }
        public void Display(){
        System.out.println("Student name is :"+name);
        System.out.println("Student Roll Number is : "+rollNumber);
        System.out.println("Student Grades is :"+grade);
}
}
public class Student{
public static void main(String args[]){

classroom obj1=new classroom(8,"A+","DIVYANSH");
classroom obj2=new classroom(9,"O","SHUKLA");

if(obj1 instanceof classroom){
obj1.Display();
System.out.println();
}
else
System.out.println("obj 1 NOt a instance of classroom");

if(obj2 instanceof classroom){
obj2.Display();
System.out.println();
}
else
System.out.println("Obj 2 NOt a instance of classroom");

classroom.displayTotalStudent();
}
}
