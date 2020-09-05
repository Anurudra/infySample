package com.infytraining.business.service;

import java.util.List;

import com.infytraining.bean.Booking;
import com.infytraining.bean.Report;

public interface TrainingService {

	public Integer bookAssessment(Booking booking) throws Exception;
	public Integer getDurationOfExam(String assessmentType);
	public List<Report> getAssessmentReport(String batchName) throws Exception;
}
