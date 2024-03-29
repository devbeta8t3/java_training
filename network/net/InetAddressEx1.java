package net;

import java.net.InetAddress;

public class InetAddressEx1 {
	
	public static void main(String[] args) {
		// ip 및 도메인 객체화
		
		try {
			InetAddress add = InetAddress.getLocalHost();
			System.out.println("Host Name : " +add.getHostName());
			System.out.println("Host Address : " +add.getHostAddress());
			
			add = InetAddress.getByName("auction.co.kr");
			System.out.println("Auction Address : " +add.getHostAddress());
			
			InetAddress adds[] = InetAddress.getAllByName("naver.com");
			System.out.println("----------------------");
			// 배열 밑에는 항상 for loop이 있다.
			for (int i=0; i<adds.length ; i++) {
				System.out.println("naver: " +adds[i]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
