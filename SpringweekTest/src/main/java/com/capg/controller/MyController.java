package com.capg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capg.model.TraineeDetails;
import com.capg.service.TraineeService;

import java.util.ArrayList;

@ComponentScan("com")
@RestController
public class MyController {
	
	@Autowired
	TraineeService traineeService;

	@RequestMapping("/")
	public String general() {
		System.out.println("hi");
		return "welcome";
	}

	@PostMapping("/add")
	public ResponseEntity insertData(@RequestBody TraineeDetails traineeDetails) {
		traineeService.addTrainee(traineeDetails);
		return new ResponseEntity("Succesfully added",HttpStatus.OK);
		}
	
	@DeleteMapping("/delete")
	public ResponseEntity deleteData(@RequestBody int traineeId) {
		traineeService.deleteTrainee(traineeId);
		return new ResponseEntity("Deleted",HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public ResponseEntity updateData(@RequestBody TraineeDetails traineeDetails) {
		traineeService.modifyTrainee(traineeDetails);
		return new ResponseEntity("modified",HttpStatus.OK);
	}
	
	
	@GetMapping("/retrieve")
	public ResponseEntity getByid(@RequestBody int traineeId) {
		TraineeDetails trainee= traineeService.retrieveTrainee(traineeId);
			return new ResponseEntity(trainee,HttpStatus.OK);
	}

	@GetMapping("/retrieveAll")
	public ArrayList<TraineeDetails> getAllDetails(){
		ArrayList<TraineeDetails> trainees = traineeService.retrieveAllTrainee();
		return trainees;
	}
	
	
}
