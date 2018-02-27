package airportSecurityState.airportStates;

public interface airportStateI{

	public void tightenOrLoosenSecurity(State st,String day, String item, Helper h);
	public String doOperation();
}
