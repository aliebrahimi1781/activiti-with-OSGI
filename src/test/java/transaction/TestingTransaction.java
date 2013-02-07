package transaction;

import java.util.Iterator;
import java.util.List;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Job;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import transaction.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("activiti-context.xml")
public class TestingTransaction extends AbstractTest {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private ProcessEngine processEngine;

	@Test
	public void test(){
		repositoryService.createDeployment()
        .addClasspathResource("diagrams/MyProcess.bpmn20.xml").deploy();
		
		System.out.println("Anzahl deploys: " + repositoryService.createProcessDefinitionQuery().count());
		runtimeService.startProcessInstanceByKey("myProcess");
		
		ManagementService managementService = processEngine.getManagementService();
		
		while(!managementService.createJobQuery().executable().list().isEmpty()){
			Job job = managementService.createJobQuery().executable().list().get(0);
			System.out.println("ID: " + job.getId());
			managementService.executeJob(job.getId());
		}

		
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		System.out.println("Hello World!");
	}
}
