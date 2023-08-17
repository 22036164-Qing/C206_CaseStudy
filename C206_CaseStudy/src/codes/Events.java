package codes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Events {
	
	//Fields
	private String eventName;
	private String place;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private double duration;
	private String information;

	//Constructor - with information
	public Events(String eventName, String place, LocalDate date, LocalTime startTime, LocalTime endTime, double duration,
			String information) {
		super();
		this.eventName = eventName;
		this.place = place;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.information = information;
	}
	
	//Constructor - without information
	public Events(String eventName, String place, LocalDate date, LocalTime startTime, LocalTime endTime, double duration) {
		super();
		this.eventName = eventName;
		this.place = place;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.information = "Stay tuned for more information";
	}
	
	//Getter and Setters method
	public String getEventName() {
		return eventName;
	}

	public String getPlace() {
		return place;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public double getDuration() {
		return duration;
	}

	public String getInformation() {
		return information;
	}
	
	public void display() {
		
	}
}
