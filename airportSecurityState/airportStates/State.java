package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class State
{
	private airportStateI currentState = null;
	private airportStateI previousState = null;

	public State()
	{
		this.currentState = new LowRiskState();
		this.previousState = new LowRiskState();
		MyLogger.writeMessage("State object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void setState(airportStateI s)
	{
		this.currentState = s;
		if(!previousState.getClass().equals(currentState.getClass()))
		{
			previousState = currentState;
			MyLogger.writeMessage("Current State is changed",MyLogger.DebugLevel.IN_RUN);
		}
	}

	public airportStateI getState()
	{
		return currentState;
	}

	public String tightenOrLoosenSecurity(Helper h,String s1){

		String[] temp = s1.split(";");
		String[] temp1 = temp[0].split(":");
		String[] temp2 = temp[3].split(":");
		this.currentState.tightenOrLoosenSecurity(this, temp1[1], temp2[1], h);
		return this.currentState.doOperation();
	}
}
