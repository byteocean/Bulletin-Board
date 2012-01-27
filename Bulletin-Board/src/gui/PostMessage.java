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
    }
    
    public void castMessage(){
	//FOR TESTS
	
    }

}
