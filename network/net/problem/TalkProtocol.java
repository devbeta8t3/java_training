package net.problem;

public class TalkProtocol {

	// ID, CHAT, CHATALL, MESSAGE, CHATLIST
	// 로그인, 개인채팅, 전체채팅, 쪽지, 접속자리스트

	// (Client -> Server) ID:aaa;1234
	// (Server -> Client) ID:T (성공), ID:F (실패), ID:C (이중접속)
	// (Server -> Client) CHATLIST: aaa;bbb;ccc;ddd;
	public static final String ID = "ID";
	
	// (Client -> Server) 	CHAT:받는아이디;메세지 	ex) CHAT:bbb;밥먹자
	// (S->C) 				CHAT:보낸아이디;메세지	ex) CHAT:aaa;밥먹자
	public static final String CHAT = "CHAT";
	
	// (Client -> Server) 	CHATALL:메세지
	// (S->C)				CHATALL:[보낸아이디]메세지
	public static final String CHATALL = "CHATALL";
	
	// (Client -> Server) 	MESSAGE:받는아이디;쪽지내용 	ex) MESSAGE:bbb;밥먹자
	// (S->C) 				MESSAGE:보낸아이디;메세지	ex) MESSAGE:aaa;밥먹자
//	public static final String MESSAGE = "MESSAGE";
	
	// (Server -> Client) CHATLIST: aaa;bbb;ccc;ddd;
//	public static final String CHATLIST = "CHATLIST";
	
}
