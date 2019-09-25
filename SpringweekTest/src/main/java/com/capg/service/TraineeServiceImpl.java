package com.capg.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.dao.TraineeDao;
import com.capg.model.TraineeDetails;

@Transactional
@Service
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	TraineeDao traineeDao;
	@Override
	public TraineeDetails addTrainee(TraineeDetails traineeDetails) {
		
		return traineeDao.addTrainee(traineeDetails);
	}

	@Override
	public TraineeDetails modifyTrainee(TraineeDetails traineeDetails) {
		
		return traineeDao.modifyTrainee(traineeDetails);
	}

	@Override
	public TraineeDetails deleteTrainee(int traineeId) {
	
		return traineeDao.deleteTrainee(traineeId);
	}

	@Override
	public TraineeDetails retrieveTrainee(int traineeId) {
		
		return traineeDao.retrieveTrainee(traineeId);
	}

	@Override
	public ArrayList<TraineeDetails>  retrieveAllTrainee() {
		
		return traineeDao.retrieveAllTrainee();
	}

	
}
