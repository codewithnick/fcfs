import java.util.*; 

class Fcfs{
    public static void main(String args[]){
        
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
        System.out.print("enter no of process you want to add\n");
        int pno=sc.nextInt(),i;
        Process job_queue[] =new Process[pno];
        Process ready_queue[] =new Process[pno];
        for( i=0;i<pno;i++){
            System.out.print("enter arrival time ");  
            int arrivaltime= sc.nextInt();  
            System.out.print("enter burst time ");  
            int bursttime= sc.nextInt();  
            Process p = new Process(arrivaltime,bursttime);
            job_queue[i]=p;
        }
        System.out.println("starting Processor");
        int time=0,j=0;
        //sorting wrt arrival time
        for( i=0;i<pno;i++){
            if( job_queue[i].arrivaltime <= time){
                ready_queue[j]=job_queue[i];
                i=0;
                time=job_queue[i].arrivaltime;
            }
            if(ready_queue.length==0){
                time++;
                i=0;
            }
        }

        //fcfs
        time=0;//processortime
        for(i=0;i<ready_queue.length;i++){
            time+=ready_queue[i].bursttime;
            ready_queue[i].terminated=true;
            ready_queue[i].completiontime=time;
        }
        //printing output
        for( i=0;i<pno;i++){
            
            System.out.println("printing output");
            System.out.println("processno\t at\t bt\t ct\t wt\t tat");
            System.out.print("\t"+i+"\t"+job_queue[i].arrivaltime+"\t"+job_queue[i].completiontime+"\t"
            +job_queue[i].waitingtime+"\t"+job_queue[i].turnaroundtime+"\n");
        }

    }
}

class Process{
    public Process (int at,int bt){
        int arrivaltime=at;
        int bursttime=bt;
        int completiontime=0;
        int waitingtime=0;
        int turnaroundtime=0;
        boolean terminated=false;
    }
}
