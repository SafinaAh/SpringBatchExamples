package example;

import lombok.NoArgsConstructor;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;


@NoArgsConstructor
public class Processor implements ItemProcessor {

    private StepExecution stepExecution;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution){
        this.stepExecution = stepExecution;
    }

    @Override
    public Object process(Object item) throws Exception {
        System.out.println("In "+stepExecution.getStepName()+" ***** processor instance hashcode ** "+this.hashCode());
        return null;
    }
}
