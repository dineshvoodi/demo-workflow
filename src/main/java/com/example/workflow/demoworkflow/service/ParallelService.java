package com.example.workflow.demoworkflow.service;

import org.activiti.engine.delegate.DelegateTask;
import org.springframework.stereotype.Service;

@Service
public class ParallelService {

	public void print(int a, int b, DelegateTask task) {
		System.out.println("In " + task.getName() + " with variables " + a + "," + b);
		System.out.println("Waiting for user to trigger" + task.getName());
	}
	
	public void add(int a, int b) {
		int c = a + b;
		System.out.println("Addition of two numbers is " + c);
	}
	
	public void subtract(int a, int b) {
		int c = a - b;
		System.out.println("Subtraction of two numbers is " + c);
	}
	
	public void divide(int a, int b) {
		int c = a / b;
		System.out.println("Division of two numbers is " + c);
	}
	
	public void multiply(int a, int b) {
		int c = a * b;
		System.out.println("Multiplication of two numbers is " + c);
	}
	
	public void printMessage(String message) {
		System.out.println(message);
	}
	
}
