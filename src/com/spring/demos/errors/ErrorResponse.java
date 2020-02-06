package com.spring.demos.errors;

public class ErrorResponse {
	private int status;
    private String message;
    private long temps;
    
    public long getTemps() {
		return temps;
	}
	public void setTemps(long temps) {
		this.temps = temps;
	}
	public ErrorResponse()
    {
        super();
    }
    public ErrorResponse(int status, String message)
    {
        super();
        this.status = status;
        this.message = message;
    }
    
    public int getStatus()
    {
        return status;
    }
    public void setStatus(int status)
    {
        this.status = status;
    }
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    @Override
    public String toString()
    {
        return "ErrorResponse [status=" + status + ", message=" + message + "]";
    }
}
