package airportSecurityState.airportStates;

public class HighRiskState implements airportStateI
{
	public void tightenOrLoosenSecurity(State st, String day, String item, Helper h)
	{
		h.updateStatus(day,item);
		int average_prohibited_items_per_day = h.avg_prohibited_items_per_day();
		int average_traffic_per_day = h.avg_traffic_per_day();

		if((average_traffic_per_day>=8)||(average_prohibited_items_per_day>=2))
		{
			st.setState(new HighRiskState());
		}
		else if((average_traffic_per_day>=4 && average_traffic_per_day<8)||(average_prohibited_items_per_day>=1 && average_prohibited_items_per_day < 2))
		{
			st.setState(new ModerateRiskState());
		}
	}

	public String doOperation()
	{
		return "2 4 6 8 10";
	}
}
