package java_Ch04_ClassObject_Ex;

public class Song {
	
	private String title;
	private String artist;
	private int year;
	private String country;
	
	public Song() {	
	}
	
	public Song(String t, String a, int y, String c) {
		title = t;
		artist = a;
		year = y;
		country = c;
	}
	
	public void show() {
		System.out.println(year+ "년 " +country+ "국적의 " +artist+ "가 부른 " +title);
	}
}
