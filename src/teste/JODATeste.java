package teste;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JODATeste {

	public static void main(String[] args) {

		DateTime dt = new DateTime();

		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy");
		String str = fmt.print(dt);
		
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		DateTime dt2 = formatter.parseDateTime(str);
		
		System.out.println(str);
		System.out.println(dt2);
	}

}
