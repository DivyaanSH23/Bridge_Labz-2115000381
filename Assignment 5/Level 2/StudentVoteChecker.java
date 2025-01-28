import java.util.*;
class StudentVoteChecker{
public static boolean canStudentVote(int age){
if(age>=18)
return true;
else
return false;
}
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int arr[]=new int[10];

System.out.println("ENTER THE AGES OF 10 STUDENTS");
for(int i=0;i<10;i++){
arr[i]=sc.nextInt();
if(canStudentVote(arr[i])){
System.out.printf("%d cam vote ,he is eligible %n",arr[i]);

}
else
System.out.println("NOT ELIGIBLE");
}
}

}
