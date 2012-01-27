package gui;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostMessage {
    private String subject;
    private String content;
    private String timeStamp;
    private String messageType;
    private String messagePack;
    
    public PostMessage(String s1,String s2){
	this.subject=s1;
	this.content=s2;
	
	SimpleDateFormat f=new SimpleDateFormat("yyyy-mm-dd:hh:mm:ss");
	this.timeStamp=f.format(new Date());
	messagePack="Re:"+subject+" Content:"+content+" Time:"+timeStamp;
    }
    
    public void castMessage(){
	
	
//	System.out.print(subject);
//	System.out.print(content);
//	System.out.print(timeStamp);
//	System.out.print("\n");
	
	ParseMessage pM = new ParseMessage(messagePack);
	
    }

}
