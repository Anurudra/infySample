package com.infytraining.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infytraining.bean.Booking;
import com.infytraining.bean.Report;

public class TrainingDAOImpl implements TrainingDAO {
	
	public Integer bookAssessment(Booking booking) {
		return booking.getDurationInMin();
	}
	
	public Map<String,Integer> getExamDuration(){
		Map<String,Integer> durationMap=new HashMap<String,Integer>();
		durationMap.put("Hands-On", 180);
		durationMap.put("Objective", 90);
		return durationMap;
	}


	public List<Report> getAssessmentReport(){
		
		List<Report> assessmentList = new ArrayList<Report>();
		Report report1 = new Report();	
		
		report1.setBatchName("JEE-RT1-NCS");
		report1.setAssessmentType("Objective");			
		report1.setCourseName("FA1");			
		Calendar assessmentDate1 = Calendar.getInstance();
		assessmentDate1.add(Calendar.DATE,1);
		report1.setAssessmentDate(assessmentDate1);
		
		Report report2 = new Report();	
		report2.setBatchName("JEE-RT1-NCS");
		report2.setAssessmentType("Objective");			
		report2.setCourseName("FA2");			
		Calendar assessmentDate2 = Calendar.getInstance();	
		assessmentDate2.add(Calendar.DATE, -1);
		report2.setAssessmentDate(assessmentDate2);
		
		Report report3 = new Report();
		report3.setBatchName("JEE-RT1-NCS");
		report3.setAssessmentType("Hands-on");			
		report3.setCourseName("FA3");				
		Calendar assessmentDate3 = Calendar.getInstance();	
		assessmentDate3.add(Calendar.DATE,2);
		report3.setAssessmentDate(assessmentDate3);
		
		Report report4 = new Report();	
		report4.setBatchName("MS-RT2-CS");
		report4.setAssessmentType("Hands-on");				
		report4.setCourseName("FA2");				
		Calendar assessmentDate4 = Calendar.getInstance();	
		report4.setAssessmentDate(assessmentDate4);
		
		Report report5 = new Report();	
		report5.setBatchName("MS-RT2-CS");
		report5.setAssessmentType("Objective");				
		report5.setCourseName("FA3");				
		Calendar assessmentDate5 = Calendar.getInstance();	
		assessmentDate5.add(Calendar.DATE, 1);
		report5.setAssessmentDate(assessmentDate5);
		
		Report report6 = new Report();	
		report6.setBatchName("IVS-RT1-CS");
		report6.setAssessmentType("Objective");				
		report6.setCourseName("FA3");				
		Calendar assessmentDate6 = Calendar.getInstance();	
		assessmentDate6.add(Calendar.DATE, -2);
		report6.setAssessmentDate(assessmentDate6);
		
		assessmentList.add(report1);
		assessmentList.add(report2);
		assessmentList.add(report3);
		assessmentList.add(report4);
		assessmentList.add(report5);
		assessmentList.add(report6);	
		
		return assessmentList;
	}
}
