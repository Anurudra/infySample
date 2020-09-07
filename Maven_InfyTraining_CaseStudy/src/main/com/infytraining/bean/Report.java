//my name is supriya 
package com.infytraining.bean;

import java.util.Calendar;

public class Report {
	
	private String batchName;
	private String courseName;
	private Calendar assessmentDate;
	private String assessmentType;
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Calendar getAssessmentDate() {
		return assessmentDate;
	}
	public void setAssessmentDate(Calendar assessmentDate) {
		this.assessmentDate = assessmentDate;
	}
	public String getAssessmentType() {
		return assessmentType;
	}
	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}
}
