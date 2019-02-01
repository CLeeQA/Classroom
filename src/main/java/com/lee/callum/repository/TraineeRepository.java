package com.lee.callum.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lee.callum.persistence.domain.Trainee;
import com.lee.callum.util.JSONUtil;

public class TraineeRepository implements ClassroomInterface {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	private Map<Long, Trainee> traineeMap = new HashMap<>();

	public String addEntry() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	public String getAllEntries() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	public String deleteEntry(long traineeID) {
		Trainee traineeInDB = getTraineeID(traineeID);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
		}
		return "Trainee Deleted!";
	}

	private Trainee getTraineeID(long traineeID) {
		return manager.find(Trainee.class, traineeID);
	}

	public String updateEntry(long id, String name) {
		
		Trainee selectedTrainee = util.getObjectForJSON(name, Trainee.class);
		traineeMap.put(id, selectedTrainee);
		
		return null;
	}

}
