package ru.usecheck.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class SuccessMes implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution){
        if((Boolean) delegateExecution.getVariable("accept")){
            System.out.printf("[%s] Заявка на перевод от %s одобрена\n",
                    SuccessMes.class.getName(),
                    delegateExecution.getVariable("username")
            );
        } else{
            System.out.printf("[%s] Заявка от %s отклонена банком.\n",
                    SuccessMes.class.getName(),
                    delegateExecution.getVariable("username")
            );
        }

    }
}