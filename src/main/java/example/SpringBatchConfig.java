package example;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig extends DefaultBatchConfigurer {

    @Autowired
    StepBuilderFactory stepBuilder;
    @Autowired
    private JobBuilderFactory jobs;

    @Bean("exampleJob")
    public Job job() {
        return jobs.get("exampleJob").start(step1()).next(step2()).build();
    }

    @Bean
    protected Step step1() {
        return stepBuilder.get("step1").chunk(1).reader(getReader()).processor(getProcessor()).writer(getWriter()).build();
    }

    @Bean
    protected Step step2() {
        return stepBuilder.get("step2").chunk(1).reader(getReader()).processor(getProcessor()).writer(getWriter()).build();
    }

    @Bean
    @StepScope
    public Reader getReader() {
        return new Reader();
    }

    @Bean
    @StepScope
    public Writer getWriter() {
        return new Writer();
    }

    @Bean
    @StepScope
    public Processor getProcessor() {
        return new Processor();
    }


    @Override
    public void setDataSource(DataSource dataSource) {
        //This BatchConfigurer ignores any DataSource
    }

}
