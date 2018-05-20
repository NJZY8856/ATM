package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * @author Lanny
 */
public class StrADate {
	public boolean checkDate(String strDate) {
		if (strDate.matches("(\\d{4})(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|3[0-1])")||strDate.equals("")) {
			// \\d{4}年 (0[1-9]|1[0-2])月 (0[1-9]|[1-2]\\d|3[0-1])日
			return true;
		} else{
			return false;
		}
	}
}
