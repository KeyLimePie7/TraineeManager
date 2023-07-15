package com.service;

import com.bean.Trainee;
import com.dao.TraineeDao;

public class TraineeService {
	public Trainee searchTrainee(int empId) {
		TraineeDao dao=new TraineeDao();
		return dao.searchTrainee(empId);
	}
	
	public boolean deleteTrainee(int empId) {
		TraineeDao dao=new TraineeDao();
		return dao.deleteTrainee(empId);
	}
}
