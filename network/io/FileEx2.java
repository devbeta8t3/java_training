package io;

import java.io.File;

public class FileEx2 {

	public static void main(String[] args) {

		String dir = "C:/Windows";
		File fdir = new File(dir);
		if (fdir.isDirectory()) {
			System.out.println("검색 디렉토리 " +dir);
			System.out.println("========================");
			
			String list[] = fdir.list();
			for (int i = 0; i < list.length; i++) {
//				System.out.println(list[i]);	// 디렉토리 내용 출력
				File f = new File(dir + File.separator + list[i]);
				
				if (f.isDirectory()) {
					System.out.println("[" +list[i]+ "]");	// 디렉토리(폴더명)이면 [] 속에 넣어서 출력
				}
				else {
					System.out.println(list[i]);			// 파일이면 그냥 출력
				}
			}

		}
		else {
			System.out.printf("지정한 s%는 디렉토리가 아닙니다.", dir);	// printf는 가변인수 사용.
			System.out.print("지정한 " +dir+ "는 디렉토리가 아닙니다.");
		}
	}

}
