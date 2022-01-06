package com.schedule.activity.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.schedule.activity.Model.ActivityModel;
import com.schedule.activity.dao.ActivityDao;



@Service
public class ActivityService {

	
	@Autowired
	private ActivityDao activityDao;
	
	@Value("${enable.activity}")
	private String enableActivity;
	
	
	@Scheduled(cron="0/5 * * * * *") // we can change the scheduler timing here as (second min hours day month year)
	public void startActivity() {
		
		
		System.out.println("activities are generated here ");

		Random random = new Random();
		if(enableActivity.equalsIgnoreCase("Y")) {
			
			String activityName = "Act"+ random.nextInt(2121212);		
			System.out.println("activityName : "+activityName);
			ActivityModel activityModel = new ActivityModel();
			activityModel.setActivityName(activityName);
			activityModel.setActivityStatus("Running");
			activityDao.save(activityModel);
			System.out.println("Activity added and in running state");
		}else {
			System.out.println("Activity in paused state");
		}
	
		
		
		
		
	}
}
