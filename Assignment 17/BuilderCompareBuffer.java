import java.util.*;
class BuilderCompareBuffer{
public static void main(String args[]){
StringBuilder sb=new StringBuilder();
StringBuffer buf=new StringBuffer();
String s="Ram";

long start=System.nanoTime();
for(int i=0;i<1000000;i++){
sb.append(s);
}
long end=System.nanoTime();


long start2=System.nanoTime();
for(int i=0;i<1000000;i++){
buf.append(s);
}
long end2=System.nanoTime();

System.out.println("THE time taken but BUILDER IS : "+ (end-start)+"ns");

System.out.println("THE time taken but BUFFER IS : "+(end2-start2)+"ns");


System.out.println("THE FASTEST OF THE TWO IS");

if((end-start)<(end2-start2))
System.out.println("STRING BUILDER");
else
System.out.println("STRING BUFFER");

}
}

