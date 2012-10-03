package mobilebilling.dummy;

import java.util.Date;

import mobilebilling.CallInterface;

public class Call implements CallInterface {
	
	int type;
	String callingNumber;
	String calledNumber;
	Date startTime;
	int duration;
	
	public Call(int type, String callingNumber, String calledNumber, Date startTime, int duration)
	{
		this.type = type;
		this.callingNumber = callingNumber;
		this.calledNumber = calledNumber;
		this.startTime = startTime;
		this.duration = duration;
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public String getCallingNumber() {
		return callingNumber;
	}

	@Override
	public String getCalledNumber() {
		return calledNumber;
	}

	@Override
	public Date getStartTime() {
		return startTime;
	}

	@Override
	public int getDuration() {
		return duration;
	}

}
