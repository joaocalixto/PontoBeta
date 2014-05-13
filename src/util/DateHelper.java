package util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateHelper {

	public static final String format = "dd/MM/yyyy";
	
	public static String formatToDataQuery(DateTime data) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern(format);
		return fmt.print(data);
	}
	
	public static String formatToDataQuery(DateTime data, String format) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern(format);
		return fmt.print(data);
	}

}
