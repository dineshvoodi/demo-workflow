package com.example.workflow.demoworkflow.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService {
	
	// Service task start
	public void startTask(DelegateExecution execution) {
		int a = (int) execution.getVariable("a");
		System.out.println("Start Service Task Stage" + a);
	}
	
	public void print(DelegateExecution execution) {
		int a = (int) execution.getVariable("a");
		System.out.println("Execution Service Stage" + a);
	}
	
	public void endTask(DelegateExecution execution) {
		int a = (int) execution.getVariable("a");
		System.out.println("End Service Stage" + a);
	}
	// Service task end
	
	// User task start
	public void startUserTask(DelegateExecution execution) {
		String a = (String) execution.getVariable("employeeId");
		System.out.println("Start User Stage " + a);
	}
	public void createUserTask(DelegateTask task, DelegateExecution execution) {
		String a = (String) task.getVariable("employeeId");
		String a1 = (String) execution.getVariable("employeeId");
		System.out.println("Create User Stage " + a + a1);
	}
	public void assignUserTask(DelegateTask task) {
		String a = (String) task.getVariable("employeeId");
		System.out.println("Assign User Stage " + a);
	}
	public void completeUserTask(DelegateTask task) {
		String a = (String) task.getVariable("employeeId");
		System.out.println("Complete User Stage " + a);
		String approval = (String) task.getVariable("approval");
		System.out.println("Complete User Stage for employee " + a + " ,approval "  + approval);
	}
	public void printUserTask() {
		System.out.println("All User Stage");
	}
	public void endUserTask(DelegateExecution execution) {
		String a = (String) execution.getVariable("employeeId");
		System.out.println("End User Stage " + a);
	}
	public void printServiceTask(DelegateExecution execution) {
		String approval = (String) execution.getVariable("approval");
		System.out.println("Execution Service Stage " + approval);
	}
	// User task ended
	
}
