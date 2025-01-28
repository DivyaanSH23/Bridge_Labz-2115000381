import java.util.*;
class height{
    public static double sum(double []a){
        double sum=0;
        for(int i=0;i<11;i++){
            sum=sum+a[i];
        }
        return sum;
    }
    public static double min(double []a){
        double shortest=Integer.MAX_VALUE;
        for(double s:a){
            shortest=Math.min(shortest,s);
        }
        return shortest;
    }
    public static double max(double []a){
                double Largest=Integer.MIN_VALUE;
            for(double s:a){
                Largest=Math.max(Largest,s);
            }
            return Largest;
        }
    public static void main(String[] args) {
        double arr[]=new double[11];
        for(int i=0;i<11;i++){
            arr[i]=150+(int)(Math.random()*101);
        }
        for(int i=0;i<11;i++){
         System.out.print(arr[i]+" ");
         }
         System.out.println();
        double sum=sum(arr);
        double min=min(arr);
        double max=max(arr);
        double mean=sum/11;
        System.out.printf("THE SMALLEST HEIGHT IS %.2f AND LARGEST HEIGHT IS %.2f AND MEAN HEIGHT IS %.2f AND THE SUM OF ALL HEIGHTS IS %.2f",min,max,mean,sum);
        
    }

}