package string.com;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import string.com.MeuJob;

public class Main {
    public static void main(String[] args) {
        try {
            String cron = "0 30 2 * * ?";
            String cronTest = "0 0/2 * * * ?";

            // Criação do Scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // Definição do Job
            JobDetail job = JobBuilder.newJob(MeuJob.class)
                    .withIdentity("meuJob", "grupo1")
                    .build();

            // Definição do Trigger com expressão cron
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("meuTrigger", "grupo1")
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronTest))
                    .build();

            // Agendamento do Job no Scheduler
            scheduler.scheduleJob(job, trigger);

            // Iniciar o Scheduler
            scheduler.start();

            System.out.println("Scheduler iniciado. Pressione Ctrl+C para sair.");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    }
