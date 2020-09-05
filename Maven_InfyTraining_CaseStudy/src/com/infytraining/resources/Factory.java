package com.infytraining.resources;

import com.infytraining.business.service.TrainingServiceImpl;
import com.infytraining.dao.TrainingDAOImpl;

public class Factory {
	
	public static TrainingServiceImpl createTrainingService()
	{
		return new TrainingServiceImpl();
	}

	public static TrainingDAOImpl createRegistrationDao()
	{
		return new TrainingDAOImpl();
	}
}
