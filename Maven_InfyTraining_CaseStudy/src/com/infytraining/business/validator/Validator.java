package com.infytraining.business.validator;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.infytraining.bean.Booking;
import com.infytraining.bean.Trainee;

public class Validator {
	public void validate(Booking booking) throws Exception {
		String errorStatus = null;
		if (!isValidBatchName(booking.getBatchName())) {
			errorStatus = "Validator.INVALID_BATCH_NAME";
		} else if (!isValidCourseName(booking.getCourseName())) {
			errorStatus = "Validator.INVALID_COURSE_NAME";
		} else if (!isValidAssessmentDate(booking.getAssessmentDate())) {
			errorStatus = "Validator.INVALID_ASSESSMENT_DATE";		
		} else if (!isValidAssessmentType(booking.getAssessmentType())) {
			errorStatus = "Validator.INVALID_ASSESSMENT_TYPE";
		} else if (!isValidEmailId(booking.getTraineesList())) {
			errorStatus = "Validator.INVALID_EMAIL_ID";
		} 
		
		// Log exception in logger file.
		if (errorStatus != null) {
			Exception exception = new Exception(errorStatus);
			DOMConfigurator.configure("src/com/infytraining/resources/log4j.xml");
			Logger logger = Logger.getLogger(this.getClass());
			logger.error(exception.getMessage(), exception);
			throw exception;
		}
	}
	
	public Boolean isValidBatchName(String batchName) {
		Boolean isValid = false;
		String name[] = batchName.split("-");
		if(name.length == 3){
			if(name[0].equals("JEE")||name[0].equals("MS")||name[0].equals("IVS") )
				if(name[1].equals("RT1")||name[1].equals("RT2") )
					if(name[2].equals("CS")||name[2].equals("NCS"))			
							isValid = true;
		}	
					
		return isValid;
	}

	public Boolean isValidCourseName(String courseName) {
		Boolean isValid = true;
			
		if( courseName.length() != 3){
			isValid=false;
		}
		
		if ( !(courseName.startsWith("FA"))) {
			isValid= false;
		}
		
		Character lastChar=courseName.charAt(courseName.length()-1);
			if(!(lastChar.toString().matches("[1-9]+"))){
				isValid=false;
			}
		
		return isValid;
	}
	
	public Boolean isValidAssessmentDate(Calendar assessmentDate) {
		Boolean isValid = false;
		Calendar today = Calendar.getInstance();
		Calendar limit = Calendar.getInstance();
		limit.add(Calendar.DATE, 9);
		int day=limit.get(Calendar.DAY_OF_WEEK);
		if(day==Calendar.SATURDAY)
			limit.add(Calendar.DATE, 2);
		if(day==Calendar.SUNDAY)
			limit.add(Calendar.DATE, 1);
				
		String aday =assessmentDate.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
		if(!(aday.equalsIgnoreCase("saturday")|| aday.equalsIgnoreCase("sunday")))
		if(assessmentDate.after(today)&& (assessmentDate.equals(limit) || assessmentDate.before(limit)))
				isValid=true;
		
	
		
		return isValid;
	}

	
	public Boolean isValidAssessmentType(String assessmentType) {
	
		Boolean isValid = false;
		if(assessmentType.equals("Objective")|| assessmentType.equals("Hands-On"))
			isValid=true;
		
		return isValid;
	}

	public Boolean isValidEmailId(List<Trainee>traineesList) {
		
		Boolean isValid = false;
		int count=0;
		for(Trainee t:traineesList){
			String email = t.getEmailId();
			Integer eid = t.getEmpNo();
			String eidString=eid.toString();
			String mail[]=email.split("_");
			if(mail.length==2){				
					
				if(mail[0].matches("[a-zA-Z]+") && mail[1].equals(eidString))
					count=count+1;		
				
			}		
				
		}
		if(count==traineesList.size())
			isValid=true;
		
		return isValid;
	}
}
