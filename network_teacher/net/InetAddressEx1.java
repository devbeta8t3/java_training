package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx1 {
	
	public static void main(String[] args) {
		try {
			//ip �� ������ ��üȭ
			InetAddress add = InetAddress.getLocalHost();
			System.out.println("Host Name : " + add.getHostName());
			System.out.println("Host Address : " + add.getHostAddress());
			add = InetAddress.getByName("auction.co.kr");
			System.out.println("auction Address : " + add.getHostAddress());
			InetAddress adds[] = InetAddress.getAllByName("naver.com");
			System.out.println("----------------");
			//�迭 �ؿ����� �׻� for�� �ִ�.
			for (int i = 0; i < adds.length; i++) {
				System.out.println("naver : " + adds[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}







