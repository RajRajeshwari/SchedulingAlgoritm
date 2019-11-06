#include<stdio.h>
int P[10],AT[10],BT[10],Status[10],n,i,Q,T=0,flag=0,TT[10];
float WaitingTime=0.0f,TurnaroundTime=0.0f;

int isComplete()
{
	for(i=0;i<n;i++)
	{
		if(Status[i]!=0)
		return 0;
	}
	return 1;
}

int main()
{
	
	printf("Enter the no of Processes:\t");
	scanf("%d",&n);
	printf("\n");
	for(i=0;i<n;i++)
	{
	 P[i]=i+1;
	 printf("PROCESS : %d\n",i+1);
	 printf("Enter the Arrival time :\t");
	 scanf("%d",&AT[i]);
	 printf("Enter the Burn time :\t");
	 scanf("%d",&BT[i]);
	 Status[i]=BT[i];
	 printf("\n");
    }
    
    printf("Enter the Quant Time :\t");
    scanf("%d",&Q);
    printf("\n\n-----------------------------------Gantt Chart-----------------------------------\n\n");
    do
    {
    	for(i=0;i<n;i++)
    	{
    		if(AT[i]<=T)
    		{
    			if(Status[i]==0);
    			else if(Status[i]<=Q)
    			{
    				T+=Status[i];
    				printf(" P%d(%d - %d) ,",P[i],T-Status[i],T);
    				Status[i]=0;
    				TT[i]=T;
    				flag=1;
    			}
    			else
    			{
    				T+=Q;
    				printf(" P%d(%d - %d) ,",P[i],T-Q,T);
    				Status[i]=Status[i]-Q;
    				flag=1;
    			}
    		}	
    	}
    	if(flag==0)
    	T++;
        flag=0;
    }while(isComplete()!=1);
    
    printf("\n\n\n\n-----------------------------------TABLE-----------------------------------");
    for(i=0;i<n;i++)
    {
    	printf("\n");
    	printf("PROCESS %d\n",P[i]);
    	printf("Arival Time : %d , Burst Time : %d , Turnaround Time : %d , Waiting Time : %d\n",AT[i],BT[i],TT[i],TT[i]-BT[i]);
    	TurnaroundTime+=TT[i];
    	WaitingTime+=TT[i]-BT[i];
    }
    
    printf("\n\nAverage Waiting Time =%f\nAverage Turnaround Time=%f",(WaitingTime/n),(TurnaroundTime/n));
}