package br.com.str;

public class StringTest {
public static void main(String[] args) {
	String strAlbum = "album";
	String str = "c:\\redhot\\album\\scrum";
	int lastIndex = str.lastIndexOf(strAlbum);
	System.out.println(str.substring(0,lastIndex+strAlbum.length()));
}
}
