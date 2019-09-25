package com.capg.service;

import java.util.ArrayList;

import com.capg.model.TraineeDetails;

public interface TraineeService {
 public TraineeDetails addTrainee(TraineeDetails traineeDetails);
 public TraineeDetails modifyTrainee(TraineeDetails traineeDetails);
 public TraineeDetails deleteTrainee(int traineeId);
 public TraineeDetails retrieveTrainee(int traineeId);
 public ArrayList<TraineeDetails> retrieveAllTrainee();

 
}
