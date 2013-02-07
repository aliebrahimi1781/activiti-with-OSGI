package services;

import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;

public class Service_ActivitiBehaviour implements ActivityBehavior {

	@Override
	public void execute(ActivityExecution arg0) throws Exception {
		System.out.println("second: " + arg0.getProcessBusinessKey());
	}

}
