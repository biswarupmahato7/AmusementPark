package org.snowpark.service;

import java.util.List;

import org.snowpark.model.Activity;
import org.springframework.stereotype.Service;

@Service
public interface ActivityService {
	
	public List<Activity> getAllActivities();
	public Activity addActivity(Activity activity);
	public Activity findActivityById(Long activityId);
	public Activity updateActivity(Activity activity);
	public Activity deleteActivity(Long activityId);
}
