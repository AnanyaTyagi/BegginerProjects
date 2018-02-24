#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
struct node
{
   int at,pt,x;
   struct node *next;	
};
struct node * getnode(int,int,int);
struct node * insertend(struct node *head,int a,int p,int x);
void avg(struct node * head,int c);
main()
{
	struct node *head,*q;
	int ch,a,p,c=0,x=0;
	head=NULL;
	do
	{
	    printf("Enter your coice:1)Enter a new Process\t 2)Calculate average Turnaroud time and average waiting time \t3)Exit");
	    scanf("%d",&ch);
	    switch(ch)
	    {
	    	case 1:x++;
			       printf("Enter the arrival time:");
	    	       scanf("%d",&a);
			       printf("Enter the processing time:"); 
			       scanf("%d",&p);
			       head=insertend(head,a,p,x);
			       c++;
   	   	           break;       
			case 2:avg(head,c);
	    		    break;
	    	case 3:break;
		}
    }while(ch!=4);
}
struct node * getnode(int a,int p,int x)
{
	struct node *q;
	q=(struct node *)malloc(sizeof(struct node));
	q->at=a;
	q->pt=p;
	q->x=x;
	q->next=NULL;
	return q;
}
struct node * insertend(struct node *head,int a,int p,int x)
{
	struct node *q,*r;
	q=getnode(a,p,x);
	if(head==NULL)
	{
			head=q;
			head->next=NULL;
	}
  else
	{
		r=head;
		while(r->next!=NULL)
		r=r->next;
		r->next=q;
		q->next=NULL;
	}
	return head;
}
void avg(struct node * head,int c)
{
	 int time=0,smallest,i,n=0,t,end,z=0;
	 float avgtat=0;
	 struct node *p,*q;
	 p=head;
	  while(p!=NULL)
	  {
	  	z=z+p->pt;
	  	p=p->next;
	  }
	 for(time=0;n!=c;time++)
     {	
      p=head;
      smallest=999;
      //for(i=1;p!=NULL||i<=c;i++)
      while(p!=NULL)
	  {
       if((p->at<=time)&& (p->pt<smallest) && (p->pt>0))
       {
       	smallest=p->pt;
       	t=p->x;
	   } 
	   p=p->next; 	   
      }
      p=head;
       while(p->x!=t)
       {
       	p=p->next;
	   }
	   p->pt=(p->pt)-1;
      if(p->pt==0)
      {
       n++;
        end=time+1;
         avgtat= avgtat+end-(p->at);
      }
 }
 printf("\n");
 printf("Average turnaround time = %f",(avgtat)/c);
 printf("\n");
 printf("Average waiting time = %f",(avgtat-z)/5);
 printf("\n");
}

