package org.snowpark.service;

import java.util.List;
import java.util.Optional;

import org.snowpark.model.Activity;
import org.snowpark.repository.ActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService{
	
	private ActivityRepository activityRepository;
	
	public ActivityServiceImpl(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	@Override
	public List<Activity> getAllActivities() {
		
		return activityRepository.findAll();
	}

	@Override
	public Activity addActivity(Activity activity) {
		return activityRepository.save(activity);
	}

	@Override
	public Activity findActivityById(Long activityId) {
		Optional<Activity> opt=activityRepository.findById(activityId);
		if (opt.isPresent())
		{
			return opt.get();
			
		}else
		{
			return null;
		}
		
	}

	@Override
	public Activity updateActivity(Activity activity) {
		return activityRepository.save(activity);
	}

	@Override
	public Activity deleteActivity(Long activityId) {
		Activity act=activityRepository.findById(activityId).get();
		 activityRepository.deleteById(activityId);
		 return act;
	}

}
