
public class BuildADroid {
	
	// instance fields 
	String droidName;
	String factoryCode;
	int energyLevel;
	String owner;
	
	// constructor
	
	public BuildADroid(String droidName, String owner) {
		
		this.droidName = droidName;
		energyLevel = 100;
		this.owner = owner;
		
		generateFactoryCode();
		System.out.println("Hello " + owner + ". My name is " + generateFactoryCode() + ". You can call me " + droidName + ".");
		
	}
	
	// methods 
	
	// energy report
	
	public void energyReport() {
		
		System.out.println(droidName + "'s energy level: " + energyLevel);
		
	}
	
	// perform task
	
	public void performTask(String taskName, int energyRequirement) {
		
		// would be cool to do a look-up table of some sort where a task is already associated with energyRequirement
		
		// if energy level is 0
			// advise droid needs to be recharged
		// else if droid energy level < energy required to perform task
			// advise how much more energy droid needs and energyReq of task 
		// else 
			// perform task 
			energyLevel -= energyRequirement;
	}
	
	// generate factory code
	
	public String generateFactoryCode() {
		
		// factory code should be of format ***-***-***-manufacturerName
			// randomised alphanumerics for each slot
		
		
		return "***-***-***-manufacturerName";
		
	}
	
	// energy transfer
	
	public void energyTransfer(BuildADroid droidName, int energyToTransfer) {
		
	}
	
	public String toString() {
		
		// prints out droid's factory code
		
		return "";
		
	}
	
	
	public static void main(String[] args) {
		
		BuildADroid Ernie = new BuildADroid("Ernie", "Christopher");
		
		
	}
	
}