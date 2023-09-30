package org.snowpark.controller;

import java.util.ArrayList;
import java.util.List;

import org.snowpark.model.Activity;
import org.snowpark.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	
	@GetMapping("/addactivity")
	public String addActivity(Model model) {
			
		Activity activity = new Activity();
		model.addAttribute("activity", activity);
		return "ActivityJsp/addactivity";
	}
	
	
	@PostMapping("/addactivity")
	public String addActivityProcess(@ModelAttribute("activity") Activity activity) {
		if(activityService.addActivity(activity)==null) {
			return "ActivityJsp/unsuccessactivity";
		}else
			return "ActivityJsp/successactivity";
	}
	
	
	@GetMapping("/listactivity")
	public String listActivity(Model model) {
		List<Activity> list = activityService.getAllActivities();
		model.addAttribute("activities",list);
		return "ActivityJsp/listactivity";
	}
	
	@GetMapping("/modifyactivity")
	public String modifyActivity(Model model) {
	 Activity activity=new Activity();
	 model.addAttribute("activity",activity);
	 return "ActivityJsp/modifyactivity";
}
	@PostMapping("/fetchactivity")
	public String fetchActivity(@ModelAttribute("activity")Activity activity,Model model) {
		activity=activityService.findActivityById(activity.getActivityId());
		if(activity==null) {
			return "ActivityJsp/activitynotfound";
		}else {
			model.addAttribute("activity",activity);
			return "ActivityJsp/activitymodifyfound";
		}
	}
	
	@PostMapping("/modifyactivityprocess")
	public String modifyActivityProcess(@ModelAttribute("activity")Activity activity) {
		Activity act=activityService.updateActivity(activity);
		if(act==null) {
			return "ActivityJsp/modifyfailed";
		}else {
			return "ActivityJsp/modifysuccess";
		}
		
	}
	
	@GetMapping("/deleteactivity")
	public String deleteActivity(Model model) {
		Activity activity=new Activity();
		model.addAttribute("activity", activity);
		return "ActivityJsp/deleteactivity";
		}
	
	
	@PostMapping("/fetchfordeleteactivity")
	public String fetchForDeleteActivity(@ModelAttribute("activity")Activity activity,Model model) {
		activity=activityService.findActivityById(activity.getActivityId());
		if(activity==null) {
			return "ActivityJsp/activitynotfound";
		}else {
			model.addAttribute("activity",activity);
			return "ActivityJsp/activitydeletefound";
		}
	}
	
	
	@PostMapping("/deleteactivityprocess")
	public String deleteActivityProcess(@ModelAttribute("activity")Activity activity) {
		Activity act=activityService.deleteActivity(activity.getActivityId());
		if(act==null) {
			return "ActivityJsp/deletefailed";
		}else {
			return "ActivityJsp/deletesuccess";
		}
		
	}
	
	@GetMapping("/viewactivity")
	public String viewActivity(@RequestParam("acitvityid") Long activityId, Model model) {
		
		Activity activity = activityService.findActivityById(activityId);
		model.addAttribute("activity", activity);
		return "ActivityJsp/viewactivity";
	}

}
