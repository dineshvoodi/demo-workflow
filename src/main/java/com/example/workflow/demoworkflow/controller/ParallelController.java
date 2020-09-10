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
public class ParallelController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RuntimeService runtimeService;

	@GetMapping("/startParallelFlow/{employeeId}")
	public void startParallelFlow(@PathVariable String employeeId) {
		Map<String, Object> variableMap = new HashMap<>();
		variableMap.put("a", 10);
		variableMap.put("b", 5);
		runtimeService.startProcessInstanceByKey("parallelProcess", employeeId, variableMap);
	}
	
	@GetMapping("/completeAddition/{employeeId}")
	public void completeAddition(@PathVariable String employeeId) {
		ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(employeeId).singleResult();
		List<Task> taskList = taskService.createTaskQuery().processInstanceId(pi.getProcessInstanceId()).list();
		
		for(Task task : taskList) {
			if("Addition".equals(task.getName())) {
				System.out.println("Completing task " + task.getName() + " ,Business ID " + task.getBusinessKey());
				Map<String, Object> variableMap = new HashMap<>();
				variableMap.put("addComplete", true);
				taskService.complete(task.getId(), variableMap);
			}
		}
	}
	
	@GetMapping("/completeSubtraction/{employeeId}")
	public void completeSubtraction(@PathVariable String employeeId) {
		ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(employeeId).singleResult();
		List<Task> taskList = taskService.createTaskQuery().processInstanceId(pi.getProcessInstanceId()).list();
		
		for(Task task : taskList) {
			if("Subtraction".equals(task.getName())) {
				System.out.println("Completing task " + task.getName() + " ,Business ID " + task.getBusinessKey());
				Map<String, Object> variableMap = new HashMap<>();
				variableMap.put("subtractComplete", true);
				taskService.complete(task.getId(), variableMap);
			}
		}
	}
	
	@GetMapping("/completeDivision/{employeeId}")
	public void completeDivision(@PathVariable String employeeId) {
		ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(employeeId).singleResult();
		List<Task> taskList = taskService.createTaskQuery().processInstanceId(pi.getProcessInstanceId()).list();
		
		for(Task task : taskList) {
			if("Division".equals(task.getName())) {
				System.out.println("Completing task " + task.getName() + " ,Business ID " + task.getBusinessKey());
				Map<String, Object> variableMap = new HashMap<>();
				variableMap.put("divideComplete", true);
				taskService.complete(task.getId(), variableMap);
			}
		}
	}
	
	@GetMapping("/completeMultiplication/{employeeId}")
	public void completeMultiplication(@PathVariable String employeeId) {
		ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(employeeId).singleResult();
		List<Task> taskList = taskService.createTaskQuery().processInstanceId(pi.getProcessInstanceId()).list();
		
		for(Task task : taskList) {
			if("Multiplication".equals(task.getName())) {
				System.out.println("Completing task " + task.getName() + " ,Business ID " + task.getBusinessKey());
				Map<String, Object> variableMap = new HashMap<>();
				variableMap.put("multiplyComplete", true);
				taskService.complete(task.getId(), variableMap);
			}
		}
	}
	
}
