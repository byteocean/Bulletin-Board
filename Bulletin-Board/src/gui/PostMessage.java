package gui;

public class PostMessage {
    private String subject;
    private String content;
    
    public PostMessage(String s1,String s2){
	this.subject=s1;
	this.content=s2;
    }
    
    public void castMessage(){
	System.out.print(subject);
	System.out.print(content);
    }

}
