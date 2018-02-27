package airportSecurityState.airportStates;


import airportSecurityState.util.MyLogger;
public class Helper
{

	private int day = 0;
	private int count = 0;
	private int prohibited_item = 0;
	private int today = 0;
	private int total_days = 0;


	public Helper()
	{
		MyLogger.writeMessage("Helper object is initialized",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void updateStatus(String day, String item)
	{
		count++;
		this.day = Integer.parseInt(day);
		if(item.equals("NailCutter") || item.equals("Gun") || item.equals("Blade") || item.equals("Knife"))
		{
			prohibited_item++;
		}

		if(today != Integer.parseInt(day))
		{
			total_days++;
			today = Integer.parseInt(day);
		}
	}

	public int avg_traffic_per_day()
	{
		return (count/total_days);
	}

	public int avg_prohibited_items_per_day()
	{
		return (prohibited_item/total_days);
	}

}
