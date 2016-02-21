

package cn.hi321.browser.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;
import android.util.Log;
import cn.hi321.browser2.R;

/**
 * Utilities for date / time management.
 */
public class DateUtils {
	
	/**
	 * Get the default date format.
	 * @param context The current context.
	 * @return The default date format.
	 */
	private static String getDefaultFormat(Context context) {
		return context.getResources().getString(R.string.DATE_FORMAT_ISO8601);
	}
	
	/**
	 * Get a string representation of the current date / time in a format suitable for a file name.
	 * @return A string representation of the current date / time.
	 */
	public static String getNowForFileName() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		
		return sdf.format(c.getTime());
	}
	
	/**
	 * Parse a string representation of a date in default format to a Date object.
	 * @param context The current context.
	 * @param date The date to convert.
	 * @return The converted date. If an error occurs during conversion, will be the current date.
	 */
	public static Date convertFromDatabase(Context context, String date) {
		SimpleDateFormat sdf = new SimpleDateFormat(getDefaultFormat(context));
		
		try {
			
			return sdf.parse(date);
			
		} catch (ParseException e) {
			Log.w(DateUtils.class.toString(), "Error parsing date (" + date + "): " + e.getMessage());
			
			return new Date();
		}
	}

}
