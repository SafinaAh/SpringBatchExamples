package example;

import lombok.NoArgsConstructor;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;


@NoArgsConstructor
public class Reader implements ItemReader {

    private StepExecution stepExecution;
    private int count;

    @BeforeStep
    public void beforeStep(StepExecution stepExecution){
          this.stepExecution = stepExecution;
          count=0;
    }

    @Override
    public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(count==0) {
        System.out.println("In "+stepExecution.getStepName()+" ***** reader instance hashCode ** "+this.hashCode() +" ***");
            count++;
            return "";
        }
        return null;
    }

}
