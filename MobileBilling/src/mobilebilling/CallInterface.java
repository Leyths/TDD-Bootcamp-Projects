package mobilebilling;

import java.util.Date;

public interface CallInterface {

	public final static int TYPE_DIRECTDIAL = 991;
	public final static int TYPE_REVERSEDIAL = 634;
	
	//Getters
	int getType();
	String getCallingNumber();
	String getCalledNumber();
	Date getStartTime();
	int getDuration();
}
