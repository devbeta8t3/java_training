package net;

public class ChatProtocol2 {
	
	//ID, CHAT, CHATALL, MESSAGE, CHATLIST
	
	//(C->S) ID:aaa 
	//(S->C) CHATLIST:aaa;bbb;ccc;ddd;
	public  static final String ID = "ID";
	
	//(C->S) CHAT:�޴¾��̵�;�޼��� ex) CHAT:bbb;�����
	//(S->C) CHAT:�������̵�;�޼��� ex) CHAT:aaa;�����
	public  static final String CHAT = "CHAT";
	
	//(C->S) CHATALL:�޼���
	//(S->C) CHATALL:[�������̵�]�޼���
	public  static final String CHATALL = "CHATALL";
	
	//(C->S) MESSAGE:�޴¾��̵�;�������� ex) MESSAGE:bbb;�����
	//(S->C) MESSAGE:�������̵�;�������� ex) MESSAGE:aaa;�����
	public  static final String MESSAGE = "MESSAGE";
	
	//(S->C) CHATLIST:aaa;bbb;ccc;ddd;
	public  static final String CHATLIST = "CHATLIST";
	
}





