package com.example.workflow.demoworkflow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkflowController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RuntimeService runtimeService;

	@GetMapping("/status")
	public String status() {
		return "Success";
	}
	
	@GetMapping("/startServiceTask") 
	public void startServiceTask() {
		
		Map<String, Object> variableMap = new HashMap<>();
		variableMap.put("a", 1);
		runtimeService.startProcessInstanceByKey("serviceProcess", variableMap);
	}
	
	@GetMapping("/startUserTask/{employeeId}") 
	public void startUserTask(@PathVariable String employeeId) {
		
		Map<String, Object> variableMap = new HashMap<>();
		variableMap.put("employeeId", employeeId);
		runtimeService.startProcessInstanceByKey("userProcess", employeeId, variableMap);
	}
	
	@GetMapping("/completeUserTask/{employeeId}") 
	public void completeUserTask(@PathVariable String employeeId) {
		ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(employeeId).singleResult();
		Task task = taskService.createTaskQuery().processInstanceId(pi.getProcessInstanceId()).singleResult();
		
		System.out.println("Completing task " + task.getName() + " ,Business ID " + task.getBusinessKey());
		taskService.complete(task.getId());
	}
	
	@GetMapping("/getlistOfUserTask") 
	public void getlistOfUserTask() {
		List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().processDefinitionKey("userProcess").list();
		list.stream().forEach(a -> System.out.println("Process Instance ID " + a.getProcessInstanceId() + " ,IsEnded " + a.isEnded() + " ,BusinessId " + a.getBusinessKey()));
	}
	
}
