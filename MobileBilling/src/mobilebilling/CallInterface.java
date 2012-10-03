package mobilebilling;

import java.util.Date;

public interface CallInterface {
	
	//Getters
	int getType();
	String getCallingNumber();
	String getCalledNumber();
	Date getStartTime();
	int getDuration();
}
