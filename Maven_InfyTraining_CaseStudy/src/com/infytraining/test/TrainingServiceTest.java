package com.infytraining.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.infytraining.bean.Booking;
import com.infytraining.bean.Trainee;
import com.infytraining.resources.Factory;


public class TrainingServiceTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void bookAssessmentInvalidBatchName()throws Exception{
		
		Booking booking = new Booking();
		booking.setBatchName("JEE-rt1-cs");
		booking.setCourseName("FA1");
		Calendar adate= Calendar.getInstance();
		adate.add(Calendar.DATE, 5);
		booking.setAssessmentDate(adate);
		booking.setAssessmentType("Objective");
		//booking.setDurationInMin(90);
		Trainee t = new Trainee();
		t.setEmpNo(626262);
		t.setEmailId("John_626262");
		List<Trainee>list = new ArrayList<Trainee>();
		list.add(t);
		booking.setTraineesList(list);
	
		exception.expectMessage("Validator.INVALID_BATCH_NAME");
		Factory.createTrainingService().bookAssessment(booking);
	}
	
	@Test
	public void bookAssessmentInvalidEmailId()throws Exception{
		Booking booking = new Booking();
		booking.setBatchName("JEE-RT2-CS");
		booking.setCourseName("FA1");
		Calendar adate= Calendar.getInstance();
		adate.add(Calendar.DATE, 5);
		booking.setAssessmentDate(adate);
		booking.setAssessmentType("Hands-On");
		//booking.setDurationInMin(150);
		Trainee t = new Trainee();
		t.setEmpNo(626262);
		t.setEmailId("John_262626");
		List<Trainee>list = new ArrayList<Trainee>();
		list.add(t);
		booking.setTraineesList(list);
		
		exception.expectMessage("Validator.INVALID_EMAIL_ID");
		Factory.createTrainingService().bookAssessment(booking);		
	}
	
	@Test
	public void getAssessmentReportNotFound()throws Exception{
		exception.expectMessage("Service.NO_RECORDS_FOUND");
		
		Factory.createTrainingService().getAssessmentReport("IVS-RT1-CS");
	}
}
