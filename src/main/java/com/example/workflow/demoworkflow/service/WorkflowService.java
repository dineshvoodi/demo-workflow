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
	public void createUserTask(DelegateTask task) {
		String a = (String) task.getVariable("employeeId");
		System.out.println("Create User Stage " + a);
	}
	public void assignUserTask(DelegateTask task) {
		String a = (String) task.getVariable("employeeId");
		System.out.println("Assign User Stage " + a);
	}
	public void completeUserTask(DelegateTask task) {
		String a = (String) task.getVariable("employeeId");
		System.out.println("Complete User Stage " + a);
	}
	public void printUserTask() {
		System.out.println("All User Stage");
	}
	public void endUserTask(DelegateExecution execution) {
		String a = (String) execution.getVariable("employeeId");
		System.out.println("End User Stage " + a);
	}
	// User task ended
	
}
