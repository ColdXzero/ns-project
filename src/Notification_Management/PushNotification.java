package Notification_Management;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


public class PushNotification {

}


@ClientEndpoint
 class reciverClient
{
	private Session session;
	//private reciver rec;
	
	public boolean isconnected()
	{
		if(this.session!=null)
			return true;
		return false;
	}
	public reciverClient(/*reciver rec*/) {
		super();
	//	this.rec = rec;
	}

	@OnOpen
	public void handle(Session session )
	{
		this.session=session;
		
	}
	
	@OnMessage
	public void handleMsg(String msg)
	{
//		rec.show(msg);
		System.out.println("from server"+msg);
	}

	public void close() {
		
		try {
			session.close();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

@ServerEndpoint("/server/{id}")
 class NsServer {
	
	//static Set<Session>  nsCLients=Collections.synchronizedSet(new HashSet<Session>());
	
	static Map<String,Session> nsCLients=new HashMap<String, Session>();
	///ws://localhost:8080/NotificationSystem/server/
	@OnOpen
	public void handleOpen(Session session,@PathParam("id") String id)
	{
		
		nsCLients.put(id, session);
		System.out.println("server conected...44. with new client "+id);
		System.out.println(nsCLients);
		
	}
	
	
	@OnMessage
	public void handleMsg(String msg)
	{
		if(msg.startsWith("@")){
			String [] s= msg.split("&");
			String clientsList= s[0];
			String message=s[1];
			
			String [] ss=clientsList.split("@");
			
			for(String x:ss)
			{
				for(String mem:nsCLients.keySet())
				{
					if(x.equals(mem))
					{
						Session session2=nsCLients.get(mem);
						try {
							session2.getBasicRemote().sendText(message);
							System.out.println("   "+x+"   " +message);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		System.out.println("llll"+msg);
	
		
	}
	
	@OnClose
	public void  handleClose(Session session)
	{

		nsCLients.remove(session);
		
	}
	
	@OnError
	public void handeErr(Throwable t)
	{
		t.printStackTrace();
	}
}

