package ru.usecheck.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class AcceptRecip implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution){
        if((Boolean) delegateExecution.getVariable("decision")){
            System.out.printf("[%s] Данные о переводе от %s одобрены. \n",
                    AcceptRecip.class.getName(),
                    delegateExecution.getVariable("username")
            );
        }
    }
}
