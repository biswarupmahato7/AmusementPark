package org.snowpark.repository;

import java.util.List;

import org.snowpark.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Long>{
	public List<Activity> findByActivityDesc(String activityDesc);
	public List<Activity> findByActivityCharges(Integer activityCharges);

}
