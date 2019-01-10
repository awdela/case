package com.test.time;

public class LocalDataTimeTest {

	public static void main(String args[]) {
//		String timeStr = "2018-02-27T08:33:45";
//		String timer = "1524638105000";
//		Date date = new Date(new Long(timer));
//		Instant instant = Instant.ofEpochMilli(date.getTime());
//		//java8鍑虹殑鏂版棩鏈�
//		LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//
//		System.out.println(ldt.toString());
	    try {
	    long t1 = System.currentTimeMillis();
            Thread.sleep(1000);
            long t2 = System.currentTimeMillis();
            System.out.println(t2-t1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}

}
