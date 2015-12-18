package fr.iutvalence.info.dut.m3105.pattern.state;

public interface ObserverInterface
{
	void notifyState(TrafficSignalStateName name);
	
	void notifyTime(int durationInSeconds);

	void notifyButton();
}
