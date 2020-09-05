package com.infytraining.ui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.infytraining.bean.Booking;
import com.infytraining.bean.Report;
import com.infytraining.bean.Trainee;
import com.infytraining.business.service.TrainingService;
import com.infytraining.resources.AppConfig;
import com.infytraining.resources.Factory;

public class UserInterface {
	
	public static void main(String[] args) {
		try
		{
			bookAssessment();
			//getAssessmentReport();

		} catch (Exception e) {
			System.out.println("\nERROR:"+ AppConfig.PROPERTIES.getProperty(e.getMessage()));
		}
	}
	
	public static void bookAssessment() throws Exception{
		
		Booking booking = new Booking();
		Calendar assessmentDate1 = Calendar.getInstance();
		assessmentDate1.add(Calendar.DATE, 3);

		booking.setAssessmentDate(assessmentDate1);		
		booking.setAssessmentType("Hands-On");
		booking.setBatchName("IVS-RT2-NCS");		
		booking.setCourseName("FA1");
		
		Trainee trainee1 = new Trainee();
		trainee1.setEmpNo(600001);
		trainee1.setEmailId("Arun_600001");
		
		Trainee trainee2 = new Trainee();
		trainee2.setEmpNo(600002);
		trainee2.setEmailId("Remi_600002");		
		
		List<Trainee>tlist = new ArrayList<Trainee>();
		tlist.add(trainee1);
		tlist.add(trainee2);
		
		booking.setTraineesList(tlist);
		TrainingService trainingService = Factory.createTrainingService();
		Integer duration = trainingService.bookAssessment(booking);
		
		if(duration==null || (duration!=180 && duration!=90))
			System.out.println("\n" +AppConfig.PROPERTIES.getProperty("UserInterface.FAIL") );
		else
			System.out.println("\n" +AppConfig.PROPERTIES.getProperty("UserInterface.SUCCESS")+" "+ duration+ " minutes");
	}

	public static void getAssessmentReport() throws Exception{
		String batchName="IVS-RT2-NC";
		TrainingService trainingService = Factory.createTrainingService();
		List<Report> reportList = trainingService.getAssessmentReport(batchName);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	
		System.out.println("\n\n\n\tCourseName      AssessmentType        AssessmentDate       ");
		System.out.println("--------------------------------------------------------------");
		for (Report report : reportList) {
			System.out.println("\t "+report.getCourseName()+"\t\t"+report.getAssessmentType() + "\t\t"
			+ sdf.format(report.getAssessmentDate().getTime()) + " \t\t");
		}
	}
}
