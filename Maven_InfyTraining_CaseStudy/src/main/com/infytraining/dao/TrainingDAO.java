package com.infytraining.dao;

import java.util.List;
import java.util.Map;

import com.infytraining.bean.Booking;
import com.infytraining.bean.Report;

public interface TrainingDAO {

	public Integer bookAssessment(Booking booking);
	public Map<String,Integer> getExamDuration();
	public List<Report> getAssessmentReport();
}
