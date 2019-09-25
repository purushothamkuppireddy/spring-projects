package com.capg.dao;

import java.util.ArrayList;

import com.capg.model.TraineeDetails;

public interface TraineeDao {
	 public TraineeDetails addTrainee(TraineeDetails traineeDetails);
	 public TraineeDetails modifyTrainee(TraineeDetails traineeDetails);
	 public TraineeDetails deleteTrainee(int traineeId);
	 public TraineeDetails retrieveTrainee(int traineeId);
	 public ArrayList<TraineeDetails> retrieveAllTrainee();
}
