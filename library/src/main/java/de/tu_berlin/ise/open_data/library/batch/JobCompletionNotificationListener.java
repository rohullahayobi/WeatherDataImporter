package de.tu_berlin.ise.open_data.library.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

/**
 * Instance of this class can be passed to a job execution to track the job.
 * * Created by ahmadjawid on 5/21/17.
 *
 * */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	/**
	 * Check the status of the job after job is done
	 * @param jobExecution
	 * */
	@Override
	public void afterJob(JobExecution jobExecution) {

		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			LOGGER.info("!!! JOB FINISHED! Time to verify the results");

		}
	}
}
