package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="LOG")
public class LogInfo
{	
	@Id
	@Column(name = "LOG_ID")
	private String logId;

	@Column(name = "USER_ID")
	private String userId; //titulo

	@Column(name = "ACTION_TIME")
	private String actionTime;

	@Column(name = "ACTION_DATE")
	private String actionDate;

	@Column(name = "LOG_DESCRIPTION")
	private String description;
	
	public String getLogId() {
		return logId;
	}

	public void setLogId() {		
		UUID guid = UUID.randomUUID();
		this.logId = guid.toString();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getActionTime() {
		return actionTime;
	}

	public void setActionTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.actionTime = dateFormat.format(date);
	}

	public String getActionDate() {
		return actionDate;
	}

	public void setActionDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.actionDate = dateFormat.format(date);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
