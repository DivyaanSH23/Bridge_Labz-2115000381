import java.util.*;
class ListOfSentence{
public static void main(String args[]){
Scanner sc=new Scanner (System.in);
int n=sc.nextInt();
String a[]=new String[n];
sc.nextLine();
for(int i=0;i<n;i++){
a[i]=sc.nextLine()+" ";
}
int x=0;
System.out.println("ENTER THE WORD TO BE SEARCHED");
String q=sc.next();
for(int i=0;i<n;i++){
	String str=a[i];
	String s="";
		for(int j=0;j<str.length();j++){
			while(str.charAt(j)!=' '){
				s=s+str.charAt(j);
				j++;
			}
			if(s.equals(q)){
				System.out.println("WORD FOUND IN SENTENCE : "+str);
				x=1;
				return;
			}
			s="";
		}
	}
if(x==0){
System.out.println("NOT FOUND");
}
}

}







