package string.com;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MeuJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        myMethod();

    }

    public boolean myMethod(){
        System.out.println("Hello");
        return false;
    }
}
