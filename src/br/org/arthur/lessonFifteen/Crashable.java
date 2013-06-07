package br.org.arthur.lessonFifteen;

public abstract class Crashable {
	boolean carDrivable = true;
	
	protected void youCrashed()
	{
		this.carDrivable = false;
	}
	
	public abstract void setCarStrength(int carStrength);
	
	public abstract int getCarStrength();
}
