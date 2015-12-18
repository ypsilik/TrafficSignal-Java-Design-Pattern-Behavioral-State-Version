package fr.iutvalence.info.dut.m3105.pattern.state;

public class ObserverTraficSignal implements ObserverInterface
{

	public void notifyTime(int durationInSeconds)
	{
		System.out.println(durationInSeconds);
	}

	@Override
	public void notifyState(TrafficSignalStateName name)
	{
		System.out.println("Traffic signal state is "+ name);	
	}

	@Override
	public void notifyButton()
	{
		System.out.println("button pressed!");
	}

}
