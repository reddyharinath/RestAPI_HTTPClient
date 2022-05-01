package utilPackage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityClass {
	
	
	public static String getCurrentDataAndTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return dateFormat.format(currentDate);
	}
}
