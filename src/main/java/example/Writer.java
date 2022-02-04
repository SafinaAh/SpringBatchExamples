package example;

import lombok.NoArgsConstructor;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@NoArgsConstructor
public class Writer implements ItemWriter {

    private StepExecution stepExecution;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution){
        this.stepExecution = stepExecution;
    }
    @Override
    public void write(List items) throws Exception {
       System.out.println("In "+stepExecution.getStepName()+" ***** writer instance hashcode ** "+this.hashCode());
        return;
    }
}
