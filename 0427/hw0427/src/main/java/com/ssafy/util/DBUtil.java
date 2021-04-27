package com.ssafy.util;

public class DBUtil {
	public static void close(AutoCloseable... autoCloseables) {
		for (AutoCloseable c : autoCloseables) {
			if(c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
