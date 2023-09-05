//USING STATIC KEYWORD
public class Linkedlist{
     static int size=0;
        //creating a node class
        static class node{
        int data;
        node next;
        node(int data)
        {
            this.data=data;
            this.next=null;
        }
      } 
      //creating head and tail
        static node head;
        static node tail;

   //function to add first in the linkedlist
     static  void addFirst(int data)
      {
        node newnode=new node(data);
        size++;
        if(head==null)
        {
           head=tail=newnode;
           return;
        }
        newnode.next=head;
        head=newnode;

      }    
//function to add last  in the linkedlist
      static void addLast(int data)
      {
        node newnode=new node(data);
        size++;
        if(head==null)
         {
            System.out.println("sorry the linkedlist is empty");
            return;
         }
         tail.next=newnode;
         tail=newnode;
      }
  //function to add middle  in the linkedlist
      static void addMiddle(int data,int index)
      {
         if(index==0)
         {
            addFirst(data);
            return;
         }
         node newnode= new node(data);
         node temp=head;
         int i=0;
         while(i<index-1)
         {
            temp=temp.next;
            i++;

         }
         newnode.next=temp.next;
         temp.next=newnode;
         size++;

      }
//function to display the linkedlist
      static void display()
      {
        if(head==null)
        {
            System.out.println("linkedlist is empty");
            return;
        }
        node temp=head;
        int i=0;
        while(temp!=null)
        {
            System.out.println("node  no "+i+" value is "+temp.data);
            temp=temp.next;
            i++;
        }
         System.out.println("sucessfully printed all the linkedlsist");
      }
     //function to remove first in the linkedlist

    static int removeFirst()
    {
       
        if(size==0)
        {
            System.out.println("linkedlist is empty");
            return 0;
        }
        else if(size==1)
        {
            head=tail=null;
            size=0;
            return 0;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    //function to remove last in the linkedlist
    static int removeLast()
    {
       if(size==0)
        {
            System.out.println("linkedlist is empty");
            return 0;
        }
        else if(size==1)
        {
            head=tail=null;
            size=0;
            return 0;
        }
        node temp=head;
        for(int i=0;i<size-2;i++)
        {
            temp=temp.next;

        }
        int val=temp.next.data;
        temp.next=null;
        tail=temp;
        size--;
        return val;
    }
    //function to remove middle in the linkedlist

    static int removeMiddle(int index)
    {
        if(index==0)
        {
           int val= removeFirst();
           return val;
        }
       else if(index==size-1)
       {
        int val=removeLast();
        return val;
       }  

       node temp=head;
         int i=0;
         while(i<index-1)
         {
            temp=temp.next;
            i++;

         }
         int val=temp.next.data;
         temp.next=temp.next.next;
         size--;
         return val;

    }
    //function to reverse a list
    static  node reverseList (node head) {
        if(head==null)
          return head;
      node temp=head;
      node temp2=head.next;
      node temp3=head.next;
      int i=0;
        while(temp2!=null)
        {
            temp2=temp2.next;
            temp3.next=temp;
            if(i==0)
            {
                temp.next=null;
                i++;
            }
            temp=temp3;
            if(temp2!=null)
            temp3=temp2;
            
        }
        head=temp3;
        return head;
    }


    public static void main(String[] args) {
       addFirst(33);
       addFirst(66);
       addFirst(44);
       addFirst(99);
       addLast(100);
       addLast(101);
       addLast(102);
       addLast(103);
       addMiddle(401,0);
       addMiddle(501,1);
       addFirst(444);
       addLast(888);
       display();
       /*if(removeFirst()!=0)
       System.out.println(removeFirst()+" removed");
       System.out.println(removeLast()+" removed");
       display();
       System.out.println("size of linkedlist is "+size);*/
       System.out.println(removeFirst());
       System.out.println(removeLast());
       
       display();
       System.out.println(removeMiddle(1));
       Linkedlist ob=new Linkedlist();
       head= reverseList(head);
    
       display();
       
    }
 }








//WITHOUT USING STATIC KEYWORD
 public class Linkedlist{
      int size=0;
        //creating a node class
         class node{
        int data;
        node next;
        node(int data)
        {
            this.data=data;
            this.next=null;
        }
      } 
      //creating head and tail
        node head;
        node tail;

   //function to add first in the linkedlist
      void addFirst(int data)
      {
        node newnode=new node(data);
        size++;
        if(head==null)
        {
           head=tail=newnode;
           return;
        }
        newnode.next=head;
        head=newnode;

      }    
//function to add last  in the linkedlist
      void addLast(int data)
      {
        node newnode=new node(data);
        size++;
        if(head==null)
         {
            System.out.println("sorry the linkedlist is empty");
            return;
         }
         tail.next=newnode;
         tail=newnode;
      }
  //function to add middle  in the linkedlist
       void addMiddle(int data,int index)
      {
         if(index==0)
         {
            addFirst(data);
            return;
         }
         node newnode= new node(data);
         node temp=head;
         int i=0;
         while(i<index-1)
         {
            temp=temp.next;
            i++;

         }
         newnode.next=temp.next;
         temp.next=newnode;
         size++;

      }
//function to display the linkedlist
       void display()
      {
        if(head==null)
        {
            System.out.println("linkedlist is empty");
            return;
        }
        node temp=head;
        int i=0;
        while(temp!=null)
        {
            System.out.println("node  no "+i+" value is "+temp.data);
            temp=temp.next;
            i++;
        }
         System.out.println("sucessfully printed all the linkedlsist");
      }
     //function to remove first in the linkedlist

     int removeFirst()
    {
       
        if(size==0)
        {
            System.out.println("linkedlist is empty");
            return 0;
        }
        else if(size==1)
        {
            head=tail=null;
            size=0;
            return 0;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    //function to remove last in the linkedlist
     int removeLast()
    {
       if(size==0)
        {
            System.out.println("linkedlist is empty");
            return 0;
        }
        else if(size==1)
        {
            head=tail=null;
            size=0;
            return 0;
        }
        node temp=head;
        for(int i=0;i<size-2;i++)
        {
            temp=temp.next;

        }
        int val=temp.next.data;
        temp.next=null;
        tail=temp;
        size--;
        return val;
    }
    //function to remove middle in the linkedlist

    int removeMiddle(int index)
    {
        if(index==0)
        {
           int val= removeFirst();
           return val;
        }
       else if(index==size-1)
       {
        int val=removeLast();
        return val;
       }  

       node temp=head;
         int i=0;
         while(i<index-1)
         {
            temp=temp.next;
            i++;

         }
         int val=temp.next.data;
         temp.next=temp.next.next;
         size--;
         return val;

    }
    //function to reverse a list
     node reverseList (node head) {
        if(head==null)
          return head;
      node temp=head;
      node temp2=head.next;
      node temp3=head.next;
      int i=0;
        while(temp2!=null)
        {
            temp2=temp2.next;
            temp3.next=temp;
            if(i==0)
            {
                temp.next=null;
                i++;
            }
            temp=temp3;
            if(temp2!=null)
            temp3=temp2;
            
        }
        head=temp3;
        return head;
    }


    public static void main(String[] args) {
        Linkedlist ob=new Linkedlist();
       ob.addFirst(33);
       ob.addFirst(66);
       ob.addFirst(44);
       ob.addFirst(99);
       ob.addLast(100);
       ob.addLast(101);
       ob.addLast(102);
       ob.addLast(103);
       ob.addMiddle(401,0);
       ob.addMiddle(501,1);
       ob.addFirst(444);
       ob.addLast(888);
       ob.display();
       /*if(removeFirst()!=0)
       System.out.println(removeFirst()+" removed");
       System.out.println(removeLast()+" removed");
       display();
       System.out.println("size of linkedlist is "+size);*/
       System.out.println(ob.removeFirst());
       System.out.println(ob.removeLast());
       
       ob.display();
       System.out.println(ob.removeMiddle(1));
       ob.head= ob.reverseList(ob.head);
    
       ob.display();
       
    }
 }
