package com.locations.batch.locationsbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;

import com.locations.batch.locationsbatch.dto.LocationDTO;
import com.locations.batch.locationsbatch.listener.JobNotificationListener;
import com.locations.batch.locationsbatch.model.Location;
import com.locations.batch.locationsbatch.processor.LocationItemProcessor;
import com.locations.batch.locationsbatch.writer.LocationItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder().build();
	}

	@Bean
	public FlatFileItemReader<LocationDTO> reader() {

		return new FlatFileItemReaderBuilder<LocationDTO>().name("locationItemReader")
				.resource(new ClassPathResource("csv/restaurantes.csv")).linesToSkip(1).maxItemCount(100000).delimited()
				.delimiter("|")
				.names(new String[] { "ID", "NAME", "EVALUATION", "GOOD_EVALUATION", "BAD_EVALUATION", "PHONENUMBER",
						"STATE", "CITY", "DISTRICT", "STREET", "STREETNUMBER", "LATITUDE", "LONGITUDE", "CATEGORY" })
				.fieldSetMapper(new BeanWrapperFieldSetMapper<LocationDTO>() {
					{
						setTargetType(LocationDTO.class);
					}
				}).build();
	}

	@Bean
	public Job importLocationJob(JobNotificationListener jobListener, Step step1, Step step2) {
		return jobBuilderFactory.get("importLocationJob").incrementer(new RunIdIncrementer()).listener(jobListener)
				.flow(step1).end().build();
	}

	@Bean
	public Step step1(FlatFileItemReader<LocationDTO> reader, LocationItemProcessor processor,
			LocationItemWriter writer) {
		return stepBuilderFactory.get("step1").<LocationDTO, Location>chunk(10000).reader(reader).processor(processor)
				.writer(writer).build();
	}

}
