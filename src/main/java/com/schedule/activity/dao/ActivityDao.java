package com.schedule.activity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schedule.activity.Model.ActivityModel;
@Repository
public interface ActivityDao extends JpaRepository<ActivityModel, Integer> {

}
