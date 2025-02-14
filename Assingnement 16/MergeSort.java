import java.util.*;
class MergeSort{
public static void merge(int a[], int l, int m, int r){
int n1 = m - l + 1, n2 = r - m;
int L[] = new int[n1], R[] = new int[n2];
for(int i=0;i<n1;i++) L[i] = a[l + i];
for(int j=0;j<n2;j++) R[j] = a[m + 1 + j];
int i=0, j=0, k=l;
while(i<n1 && j<n2){
if(L[i] <= R[j]) a[k++] = L[i++];
else a[k++] = R[j++];
}
while(i<n1) a[k++] = L[i++];
while(j<n2) a[k++] = R[j++];
}
public static void mergeSort(int a[], int l, int r){
if(l < r){
int m = l + (r - l) / 2;
mergeSort(a, l, m);
mergeSort(a, m + 1, r);
merge(a, l, m, r);
}
}
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int a[]=new int[n];
for(int i=0;i<n;i++){
a[i]=sc.nextInt();
}
mergeSort(a, 0, n-1);
for(int i=0;i<n;i++){
System.out.print(a[i]+" ");
}
System.out.println();
}
}
