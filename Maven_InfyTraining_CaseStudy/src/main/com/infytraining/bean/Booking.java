package com.infytraining.bean;

import java.util.Calendar;
import java.util.List;

public class Booking {

	private String batchName;
	private String courseName;
	private String assessmentType;
	private Calendar assessmentDate;
	private Integer durationInMin;
	private List<Trainee>traineesList;
	
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
	public String getAssessmentType() {
		return assessmentType;
	}
	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}
	public Calendar getAssessmentDate() {
		return assessmentDate;
	}
	public void setAssessmentDate(Calendar assessmentDate) {
		this.assessmentDate = assessmentDate;
	}
	public Integer getDurationInMin() {
		return durationInMin;
	}
	public void setDurationInMin(Integer durationInMin) {
		this.durationInMin = durationInMin;
	}
	public List<Trainee> getTraineesList() {
		return traineesList;
	}
	public void setTraineesList(List<Trainee> traineesList) {
		this.traineesList = traineesList;
	}
}
