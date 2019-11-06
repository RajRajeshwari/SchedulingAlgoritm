
package operating.system1;
import java.util.Scanner;

class function
{    
    public void fcfs(String ch[],int x[],int y[],int n)                 //function for implementing FCFS
    {
       int temp1,temp,i,j1,sum=0,avgtat=0,avgwt=0;                     //declaration of variables
       int end []=new int[10];                   //stores ending time of each process
       int tat []=new int[10];                  //turnaround time of each process
       int wt []=new int[10];                   //waiting time of each process
       int q []=new int[10];                    //idle time in between
       float avtat,avwt;                       //average turnaround and waiting time                         
       String temp2;                            //temporary variable for swapping names of processes
       int idle=0;
       for(i=0;i<n-1;i++)                       //1st loop to sort
       {
           for(int j=i+1;j<n;j++)               //2nd loop to sort
           {
               if(x[i]>x[j])
               {
                   temp=x[i];               //swap arrival time
                   x[i]=x[j];
                   x[j]=temp;
                   
                   temp1=y[i];              //swap waiting time
                   y[i]=y[j];
                   y[j]=temp1;
                           
                   
                   temp2=ch[i];             //swap processes
                   ch[i]=ch[j];
                   ch[j]=temp2;
               }
           }
       }
       int min=x[0];
        System.out.println("Arranging processes acording to arrival time");             //to print the table
        System.out.println("---------------------------------------------------");      
        System.out.println("| Process name\t| Arrival time\t| Processing Time |");
        System.out.println("---------------------------------------------------");
        for(i=0;i<n;i++)
        {
            
            System.out.println("|\t"+ch[i]+"\t|\t"+x[i]+"\t|\t"+y[i]+"\t  |");
        }
        
        System.out.println("---------------------------------------------------");
        if(min!=0)                       //to find processing time with in between idle time
        {
            q[0]=min;
        }
        else if(min==0)
        {
            q[0]=0;
        }
        end[0]=q[0]+y[0];
        sum=end[0];
        for(i=1;i<n;i++)
        {
            if(x[i]>end[i-1])
            {
                q[i]=x[i]-end[i-1];
                end[i]=q[i]+y[i]+end[i-1];
            }
            else if(x[i]<=end[i-1])
            {
                q[i]=0;
                end[i]=end[i-1]+y[i];
            }        
        }
              sum=end[n-1];         //total processing time          
      // boolean flag=false;
          System.out.println("Gantt Chart:");               // Gantt chart 
          for(i=0;i<n;i++)
          {
//              if((min!=0) && (flag==false))
//                {
//                  System.out.print(" | X | ");
//                  flag=true;
//                }       
            if(q[i]!=0)                             //to represent idle time values
            {
                System.out.print(" |X|"+ch[i]);
            }
            else if(q[i]==0)                        //to print process name on gantt chart
            {
                System.out.print(" | "+ch[i]+"  ");
            }
          }
          System.out.print("|\n");
           System.out.print("--------------------------------------------\n");
           for(i=0;i<n;i++)
            {
                if((q[i]!=0)&&(i==0))
            {
                System.out.print(" x "+q[i]+" "+end[i]);
            }
              if((q[i]!=0)&&(i>0))
            {
                System.out.print(" x "+(end[i-1]+q[i])+" "+end[i]);
            }
            else if(q[i]==0)
            {
                System.out.print("     "+end[i]);
            }
                
          }
           System.out.println("\nTotal Processing time is:"+sum);
           System.out.println("Final table with turnaround time and waiting time:"); //to print final turnaround and waiting time table 
           for(i=0;i<n;i++)
           {
               tat[i]=end[i]-x[i];
               wt[i]=tat[i]-y[i];
           }
        System.out.println("----------------------------------------------------");
        System.out.println("| Process name\t|Turnaround time|  Waiting Time  |");
        System.out.println("----------------------------------------------------");
        for(i=0;i<n;i++)
        {
            
            System.out.println("|\t"+ch[i]+"\t|\t"+tat[i]+"\t|\t"+wt[i]+"\t  |");
        }
        
        System.out.println("----------------------------------------------------");
       for(i=0;i<n;i++)
       {
           avgtat=avgtat+tat[i];
           avgwt=avgwt+wt[i];
       }
       for(i=0;i<n;i++)
       {
           idle=idle+q[i];
       }
       avtat=(float)avgtat/n;
       avwt=(float)avgwt/n;
       System.out.println("Average turnaround time:"+avtat);
       System.out.println("Average waiting time:"+avwt); 
       float Throughput=(float)n/(sum-x[0]);
       System.out.println("Throughput of given processes:"+(Throughput*100)+"%");
       float CPU=(float)sum/(sum+idle);
       System.out.println("CPU Utilisation for the given processes is:"+(CPU*100)+"%");
    }
}
public class FCFS 
{
    public static void main(String args[])
    {
        String p[]=new String[10];
        int i;
        int a[]=new int[10];
        int b[]=new int[10];
        System.out.println("Enter the number of processes:");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        for(i=0;i<n;i++)
        {
            System.out.println("Enter the names of processes:");
            p[i]=sc.next();
            System.out.println("Enter the arrival time for "+p[i]+" process:");
            a[i]=sc.nextInt();
            System.out.println("Enter the processing time for "+p[i]+" process:");
            b[i]=sc.nextInt();
        } 
            System.out.println("---------------------------------------------------");
            System.out.println("| Process name\t| Arrival time\t| Processing Time |");
            System.out.println("---------------------------------------------------");
        for(i=0;i<n;i++)
        {  
            System.out.println("|\t"+p[i]+"\t|\t"+a[i]+"\t|\t"+b[i]+"\t  |");
        }
            System.out.println("---------------------------------------------------");
          function f=new function();
          f.fcfs(p,a,b,n);
    }
    
}
