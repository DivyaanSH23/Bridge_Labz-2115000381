import java.util.*;
class QuickSort{
public static void quickSort(int a[], int low, int high){
if(low < high){
int pi = partition(a, low, high);
quickSort(a, low, pi - 1);
quickSort(a, pi + 1, high);
}
}
public static int partition(int a[], int low, int high){
int pivot = a[high];
int i = low - 1;
for(int j = low; j < high; j++){
if(a[j] < pivot){
i++;
int temp = a[i];
a[i] = a[j];
a[j] = temp;
}
}
int temp = a[i + 1];
a[i + 1] = a[high];
a[high] = temp;
return i + 1;
}
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int a[]=new int[n];
for(int i=0;i<n;i++){
a[i]=sc.nextInt();
}
quickSort(a, 0, n-1);
for(int i=0;i<n;i++){
System.out.print(a[i]+" ");
}
System.out.println();
}
}
