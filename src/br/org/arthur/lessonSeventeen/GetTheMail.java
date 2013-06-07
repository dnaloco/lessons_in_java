package br.org.arthur.lessonSeventeen;

public class GetTheMail implements Runnable{
	
	private int startTime;
	private String emailChecked;
	public GetTheMail(int startTime, String emailCheched)
	{
		this.startTime = startTime;
		this.emailChecked = emailCheched;
	}
	
	public void run()
	{
		try
		{
			Thread.sleep(this.startTime * 1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("Checking Mail." + this.emailChecked);
	}
}
