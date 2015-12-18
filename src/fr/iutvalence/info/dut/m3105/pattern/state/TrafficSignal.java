package fr.iutvalence.info.dut.m3105.pattern.state;

import java.util.LinkedList;
import java.util.List;



public class TrafficSignal extends Thread implements TrafficSignalContext, TrafficSignalUserInterface
{
	private TrafficSignalState state;
	private List<ObserverInterface> observers = new LinkedList<>();
	
	@Override
	public void setTrafficSignalState(TrafficSignalState state)
	{
		notifyState(state.getName());
		this.state = state;		
	}
	
	private void notifyState(TrafficSignalStateName name){
		for (ObserverInterface observer : observers) {
			observer.notifyState(name);
		}
	}
	
	@Override
	public void notifyDurationTime(int durationInSeconds)
	{
		for (ObserverInterface observer : observers) {
			observer.notifyTime(durationInSeconds);
		}
	}

	@Override
	public void pressButton()
	{
		notifyButtonPressed();
		this.state.buttonPressed();
	}
	
	private void notifyButtonPressed()
	{
		for (ObserverInterface observer : observers) {
			observer.notifyButton();
		}
		
	}
	
	public void run()
	{
		this.setTrafficSignalState(new TrafficSignalGreenState(this));
		while (true)
		{
			try
			{
				Thread.sleep(1000);
				this.state.secondEllapsed();
			}
			catch (InterruptedException e)
			{
				break;
			}
		}
	}

	public void register(ObserverTraficSignal observerTraficSignal)
	{
		this.observers.add(observerTraficSignal);
	}



	
	
}
