package util;

import org.joda.time.DateTime;

public class ObjectHelper {
	
	public static boolean isNull(Object object) {
		return object == null;
	}

	public static boolean isNotNull(Object object) {
		return object != null;
	}

	public static String returnEmptyWithNull(Object object) {

		String retorno = "";

		if (isNull(object)) {
			return retorno;
		} else {
			return object.toString();
		}
	}

	public static String returnEmptyOrHour(DateTime datetime) {

		if (isNotNull(datetime)) {
			return DateHelper.formatToDataQuery(datetime, "HH:mm:ss");
		} else {
			return "null";
		}

	}

}
