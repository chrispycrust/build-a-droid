
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
		
		//TODO would be cool to do a look-up table of some sort where a task is already associated with energyRequirement
		// how to change verb into present tense "cook" to "cooking"
		
		
		// if energy level is 0
			// advise droid needs to be recharged
		// else if droid energy level < energy required to perform task
			// advise how much more energy droid needs and energyReq of task 
		// else 
			// perform task 
			energyLevel -= energyRequirement;
	}
	
	// generate factory code
	
	public void generateFactoryCodeTest() {
		// code
	}
	
	public String generateFactoryCode() {
		
		// factory code should be of format ***-***-***-manufacturerName
			// randomised alphanumerics for each slot
		
		String factoryCode = "";
		int batchCount = 0;
		String element = "";
		int elementNumber;
		
		// for each element in the format (12 elements including dashes)
		
			// if batchCount = 3
				// add dash to factoryCode string
				// reset batchCount to 0
		
			// else, if batchCount != 3
		
				// randomise elementNumber to be 0 (integer) and 1 (character)
				// if 0 
					// randomise digit 0-9
					// convert to string
					// element = digit 
				// else, if element = 1
					// randomise character
					// convert char to string
					// reset element = character
				
				// add element to factory code
				// increase batchCount by 1
		
		String[] factoryNames = {"Java_Junkyard", "Python_Plastics", "Rust_Repairs", "C_Steelworks"};
		// randomise an indexPosition based on the number of elements in factoryNames
		// get value at index position and add to factoryCode
		
		
		return factoryCode;
		
	}
	
	// energy transfer
	
	public void energyTransfer(BuildADroid donorDroid, int energyToTransfer) {
		
		// if donee droid already has max energy 100
			// notify that nothing else can be transferred
		// else, if donee droid doesn't have max energy
			// transfer energy 
			// if energy to transfer > donorDroid energy level
				// checkMaxEnergy()
				// add all of donorDroid's energy to doneeDroid
					// check whether energyToTransfer + donee droid is > 100
			// else if energy to transfer <= donorDroid energy level
				// transfer as usual
				// checkMaxEnergy()
		
	}
	
	
	public void checkMaxEnergy() {
		
		// check whether energyToTransfer + donee droid is > 100
		// if it is, set droid energy to max energy to 100
		// donor droid - ( energyNotTransferred = ((energyToTransfer + donee droid energy level) - 100)
			// e.g. donee droid = 90, energyToTransfer = 30, 120 - 100 = 20 leftover 
		
	}
	
	public String toString() {
		
		// prints out droid's factory code
		factoryCode = "droid#";
		
		return factoryCode += generateFactoryCode();
		
	}
	
	
	public static void main(String[] args) {
		
		BuildADroid Ernie = new BuildADroid("Ernie", "Christopher");
		System.out.println(Ernie);
		
		
		
	}
	
}