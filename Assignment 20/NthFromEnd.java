import java.util.*;
class NthFromEnd{
  class Node{
	Node next;
	int data;
	Node(int data){
	this.data=data;
	this.next=null;
}
}
Node head;
void display()
	{
	 Node curr=head;
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
void reverse(){
Node curr=head;
Node temp=null;
Node prev=null;
while(curr!=null){
temp=curr.next;
curr.next=prev;
prev=curr;
curr=temp;
}
head=prev;
}

int find(int x){
	int c=1;
	Node curr=head;
	while(c!=x){
	curr=curr.next;
	c++;
}
return curr.data;
}
public static void main(String args[]){
NthFromEnd obj=new NthFromEnd();
obj.AddFirst(1);
obj.AddLast(2);
obj.AddFirst(0);
obj.AddFirst(99);
obj.AddLast(10);
obj.AddFirst(9669);
obj.AddLast(56);

obj.AddLast(3);
obj.AddFirst(69);
obj.AddLast(100);
obj.display();

obj.reverse();


System.out.println("THE 4RD ELEMENT FROM BACK IS :"+obj.find(4));
}
}

