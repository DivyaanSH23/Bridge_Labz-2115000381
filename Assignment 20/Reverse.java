import java.util.*;
class Reverse{
  class Node{
	Node next;
	int data;
	Node(int data){
	this.data=data;
	this.next=null;
}
}
Node head;
void reverse() {
    Node curr = head;
    Node prev = null;
    Node temp;

    while (curr != null) {
        temp = curr.next;
        curr.next = prev;
        prev = curr;
	curr = temp;
    }

    head = prev;
}

void display(){ Node curr=head;
   while(curr!=null){ 
	System.out.print(curr.data+"->"); 
	curr=curr.next;
}
System.out.println();
}

void AddFirst(int data){
             Node newNode=new Node(data);
             if(head==null){
             head=newNode;
            return;
            }
             newNode.next=head;
             head=newNode;
        }
void AddLast(int data){
            Node newNode=new Node(data);
            if(head==null){
                head=newNode;
                return;
            }
            Node currNode=head;
             while(currNode.next!=null){
                 currNode=currNode.next;
             }
             currNode.next=newNode;
             currNode=newNode;
         }


void Rev(ArrayList<Integer> List){
int left=0;
int right=List.size()-1;
while(left<right){
int temp=List.get(left);
List.set(left,List.get(right));
List.set(right,temp);
left++;
right--;
}
}
public static void main(String args[]){
Reverse obj=new Reverse();
ArrayList<Integer> List=new ArrayList<>();
List.add(5566);
List.add(100);
List.add(98);
List.add(00);
List.add(56);

System.out.println("Array list before rev:");
System.out.println(List);
obj.Rev(List);
System.out.println("After rev");
System.out.println(List);

	obj.AddLast(50);
	obj.AddFirst(64);
	obj.AddFirst(88);
	obj.AddLast(100);
	obj.AddLast(101);
	obj.display();
	obj.reverse();

	obj.display();

	
}
}
