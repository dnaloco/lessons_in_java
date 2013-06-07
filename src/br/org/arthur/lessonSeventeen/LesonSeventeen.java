package br.org.arthur.lessonSeventeen;

public class LesonSeventeen {
	
	public static void main(String[] args)
	{
		Thread getTime = new GetTime20();
		Runnable getMail = new GetTheMail(10, "EMAIL 1");
		Runnable getMailAgain = new GetTheMail(20, "EMAIL 2");
		getTime.start();
		new Thread(getMail).start();
		new Thread(getMailAgain).start();
	}
	
}
