package com.daloz.factorymail.dataobjects;


public class FileProcessResponse
{
	private String message;
	private Double durationProcess;
	private Boolean success;
	
	
	public void generatingMappingSatisfactory(String message, Long startTime, Long endTime)
	{
		this.message = message;
		this.success = true;
		this.durationProcess = (endTime - startTime) / 1000000000.0; 
	}
	
	
	public void generatingMappingErrors(Exception e)
	{
		this.message = e.getMessage();
		this.success = false;
		this.durationProcess = 0.0;
		
	}
	
	
	public String getReport()
	{
		StringBuilder report = new StringBuilder();
		
		report.append("Proceso exitoso? --> ").append(this.success)
		       .append(", duración: ").append(this.durationProcess)
		       .append(", mensaje: ").append(this.message);
		
		return report.toString();
	}
	
	// GET
	public String getMessage()
	{
		return message;
	}


	public Double getDurationProcess()
	{
		return durationProcess;
	}


	public Boolean getSuccess()
	{
		return success;
	}
	
	 
	
	
}
