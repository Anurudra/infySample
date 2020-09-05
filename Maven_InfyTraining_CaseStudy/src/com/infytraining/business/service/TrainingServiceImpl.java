package com.infytraining.business.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.infytraining.bean.Booking;
import com.infytraining.bean.Report;
import com.infytraining.business.validator.Validator;
import com.infytraining.dao.TrainingDAO;
import com.infytraining.resources.Factory;

public class TrainingServiceImpl implements TrainingService {
	
	public Integer bookAssessment(Booking booking) throws Exception{
		Validator validator=new Validator();
		validator.validate(booking);
		booking.setDurationInMin(getDurationOfExam(booking.getAssessmentType()));
		
		TrainingDAO dao = Factory.createRegistrationDao();
		return dao.bookAssessment(booking);
	}
	
	public Integer getDurationOfExam(String assessmentType){
		TrainingDAO dao = Factory.createRegistrationDao();
		return dao.getExamDuration().get(assessmentType);
	}
	
	public List<Report> getAssessmentReport(String batchName) throws Exception{
		
		TrainingDAO dao = Factory.createRegistrationDao();
		List<Report> finalList = new ArrayList<Report>();
		try{
			
			List<Report> assessmentList = dao.getAssessmentReport();
			Calendar today = Calendar.getInstance();
		
			for(Report report: assessmentList){
				if(report.getBatchName().equals(batchName) && report.getAssessmentDate().after(today)){
					finalList.add(report);
				}
			}

			if(finalList.isEmpty())
				throw new Exception("Service.NO_RECORDS_FOUND");
			
			return finalList;
		}
		catch (Exception e) {
			DOMConfigurator.configure("src/com/infytraining/resources/log4j.xml");
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
}
 