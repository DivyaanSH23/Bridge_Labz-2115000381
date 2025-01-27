import java.util.*;
 class Rounds{
        public static void main(String args[]){
                Scanner sc = new Scanner(System.in);
                double side1 = sc.nextDouble();
                double side2 = sc.nextDouble();
                double side3 = sc.nextDouble();
                double perimeter = side1+side2+side3;
                double distance = 5;
                double rounds = distance/perimeter;
                System.out.println("The total number of rounds the athlete will run is "+rounds+" to complete 5 km");
}
}

