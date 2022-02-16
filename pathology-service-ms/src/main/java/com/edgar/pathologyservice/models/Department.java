package com.edgar.pathologyservice.models;

public class Department {

	private String Id;
	private String trainingType;
	private String timeframe;

	public Department() {

	}

	public Department(String id, String trainingType, String timeframe) {
		super();
		Id = id;
		this.trainingType = trainingType;
		this.timeframe = timeframe;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	

	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

	public String getTimeframe() {
		return timeframe;
	}

	public void setTimeframe(String timeframe) {
		this.timeframe = timeframe;
	}

	@Override
	public String toString() {
		return "Department [Id=" + Id + ", diseaseName=" + trainingType + ", timeframe=" + timeframe + "]";
	}

	
	

}
