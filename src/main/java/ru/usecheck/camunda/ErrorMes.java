package ru.usecheck.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ErrorMes implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution){
        if((Boolean) delegateExecution.getVariable("decision")){
            System.out.printf("Перевод на акцепте.\n",
                    ErrorMes.class.getName());
        } else{
            System.out.printf("[%s] В переводе от %s отказано.\n",
                    ErrorMes.class.getName(),
                    delegateExecution.getVariable("username"));
        }
    }
}