package net;

public class ChatProtocol2 {

	// ID, CHAT, CHATALL, MESSAGE, CHATLIST

	// (Client -> Server) ID:aaa then (S->C) CHATLIST: aaa;bbb;ccc;ddd;
	public static final String ID = "ID";
	
	// (Client -> Server) 	CHAT:받는아이디;메세지 	ex) CHAT:bbb;밥먹자
	// (S->C) 				CHAT:보낸아이디;메세지	ex) CHAT:aaa;밥먹자
	public static final String CHAT = "CHAT";
	
	// (Client -> Server) 	CHATALL:메세지
	// (S->C)				CHATALL:[보낸아이디]메세지
	public static final String CHATALL = "CHATALL";
	
	// (Client -> Server) 	MESSAGE:받는아이디;쪽지내용 	ex) MESSAGE:bbb;밥먹자
	// (S->C) 				MESSAGE:보낸아이디;메세지	ex) MESSAGE:aaa;밥먹자
	public static final String MESSAGE = "MESSAGE";
	
	// (Server -> Client) CHATLIST: aaa;bbb;ccc;ddd;
	public static final String CHATLIST = "CHATLIST";
	
}
