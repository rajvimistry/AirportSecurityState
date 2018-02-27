package airportSecurityState.driver;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.airportStates.State;
import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStates.Helper;
import java.lang.NumberFormatException;

public class Driver
{
	public static void main(String args[])
	{

		if(args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || Integer.parseInt(args[2])<0 || Integer.parseInt(args[2])>4)
		{}
		else
		{
			int a = 0;
			try{
				a = Integer.parseInt(args[2]);
			}
			catch(NumberFormatException e)
			{
				System.out.println(e.getMessage());
			}
			MyLogger.setDebugValue(a);
			FileProcessor fp1 = new FileProcessor(args[0]);
			Helper h = new Helper();
			State st = new State();
			Results r = new Results();
			String s1, var_state = null;
			while((s1 = fp1.readLine()) != null)
			{
				var_state = st.tightenOrLoosenSecurity(h,s1);
				r.storeNewResult(var_state);
				r.writeToStdout(var_state);
			}
			r.writeToFile(args[1]);
		}
	}
}
