package com.capg.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import com.capg.model.TraineeDetails;

@Repository
@EntityScan("com.capg.model")
public class TraineeDaoImpl implements TraineeDao{

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public TraineeDetails addTrainee(TraineeDetails traineeDetails) {
		entityManager.persist(traineeDetails);
		return null;
	}

	@Override
	public TraineeDetails modifyTrainee(TraineeDetails traineeDetails) {
		entityManager.merge(traineeDetails);
		return null;
	}

	@Override
	public TraineeDetails deleteTrainee(int traineeId) {
		TraineeDetails trainee=new TraineeDetails();
		trainee.setTraineeID(traineeId);
		entityManager.remove(retrieveTrainee(traineeId));
		return null;
	}

	@Override
	public TraineeDetails retrieveTrainee(int traineeId) {
		TraineeDetails trainee=entityManager.find(TraineeDetails.class, traineeId);
		return trainee;
		
	}

	@Override
	public ArrayList<TraineeDetails> retrieveAllTrainee() {
			
			@SuppressWarnings("unchecked")
			Query<TraineeDetails> query = (Query<TraineeDetails>) entityManager.createQuery("from TraineeDetails ");
			ArrayList<TraineeDetails> list =(ArrayList<TraineeDetails>) query.list();
			return list;
		}
		
	}

	
	


