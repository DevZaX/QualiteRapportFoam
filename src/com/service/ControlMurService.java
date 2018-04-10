package com.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import com.model.ControlMur;

@Service
public interface ControlMurService {
	
	public void addControlMur(ControlMur controlMur);

	public ControlMur fetchAll(Date startDate, Date endDate, String upperCase);

}
