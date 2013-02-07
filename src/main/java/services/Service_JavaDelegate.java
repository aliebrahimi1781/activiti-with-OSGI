package services;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class Service_JavaDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		System.out.println("I am the " + arg0.getProcessBusinessKey() + "-Service!!!");
		System.out.print("working");
		for (int i = 0;i<5;i++){
			Thread.sleep(1000);
			System.out.print('.');
		}
		System.out.println();
		System.out.println("ready with working....");
	}

}
