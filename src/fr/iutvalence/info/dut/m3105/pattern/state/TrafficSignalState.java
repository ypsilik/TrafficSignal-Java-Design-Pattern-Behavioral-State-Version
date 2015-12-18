package fr.iutvalence.info.dut.m3105.pattern.state;


public abstract class TrafficSignalState 
{
	protected final TrafficSignalContext context;
	protected int durationInSeconds;
	private final TrafficSignalStateName name;
	
	public TrafficSignalState(TrafficSignalContext context, int durationInSeconds, TrafficSignalStateName name)
	{
		super();
		this.context = context;
		this.durationInSeconds = durationInSeconds;
		this.name = name;
	}

	public void buttonPressed() {
	}

	public void secondEllapsed() 
	{
		this.durationInSeconds--;
		this.context.notifyDurationTime(this.durationInSeconds);
	}

	public TrafficSignalStateName getName()
	{
		return this.name;
	}
}
