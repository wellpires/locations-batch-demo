package com.locations.batch.locationsbatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.locations.batch.locationsbatch.repository.LocationRepository;

@Component
public class JobNotificationListener extends JobExecutionListenerSupport {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void beforeJob(JobExecution jobExecution) {
		logger.info("O Job {} foi iniciado ás {}", jobExecution.getJobInstance().getJobName());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {

		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			logger.info("O Job '{}' finalizou com sucesso!", jobExecution.getJobInstance().getJobName());
			logger.info("The batch processed {} records", locationRepository.count());
		}

	}

}
