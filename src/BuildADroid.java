import java.util.Random;


public class BuildADroid {
	
	// instance fields 
	String droidName;
	String factoryCode;
	int energyLevel;
	String owner;
	String status;
	
	// constructor
	
	public BuildADroid(String droidName, String owner) {
		
		this.droidName = droidName;
		energyLevel = 100;
		this.owner = owner;
		this.status = "active";
		
		generateFactoryCode();
		
		System.out.println();
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
		// how to program automatic verb change into present tense "cook" to "cooking"
		
		System.out.println();

		if (status.equals("charging")) {
			System.out.println(droidName + " cannot perform \"" + taskName + ".\" Currently charging.");
		} else {
			
			if (energyLevel < energyRequirement) {
				energyReport();
				int energyAmountRequired = energyRequirement - energyLevel;
				System.out.println(energyAmountRequired + " energy required to perform \"" + taskName + "\"");
				System.out.println("Please recharge " + droidName + " or select another task.");
			} else {
				System.out.println(droidName + " currently: " + taskName);
				energyLevel -= energyRequirement;			
			}
			
		}

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
		
		for (int i = 0; i < 13; i++) {
			
			if (batchCount == 3) {
				factoryCode += "-";
				batchCount = 0;
			} else {
				
			}
		}
	
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
		
		System.out.println();
		energyReport();
		donorDroid.energyReport();
		
		if (energyLevel == 100) {
			System.out.println(droidName + "'s battery already full.");
			
		} else {
			
			System.out.println();
			System.out.println("Starting energy transfer from " + donorDroid.droidName.toUpperCase() + " to " + droidName.toUpperCase() + "...");
			
			if (energyToTransfer > donorDroid.energyLevel) { //if energy requested to transfer is greater than available donor energy, drain the donor of all energy (if necessary)
							
				checkMaxEnergy(donorDroid, donorDroid.energyLevel);
				
			} else {
				
				checkMaxEnergy(donorDroid, energyToTransfer);
			
			}
		}
		
		System.out.println();
		System.out.println("Transfer complete");
		energyReport();
		donorDroid.energyReport();

	}
	
	
	public void checkMaxEnergy(BuildADroid donorDroid, int energyToAdd) {
		
		// don't allow display of negative energy levels or energy > 100 - cap at 0 and 100
		
		int intialEnergyLevel = energyLevel;
		int doneeFinalEnergy = energyLevel + energyToAdd;
		
		if (doneeFinalEnergy >= 100) {
			
			energyLevel = 100;
			
			int energyUsed = 100 - intialEnergyLevel;
				
			donorDroid.energyLevel -= energyUsed;
			
		} else {
			
			energyLevel += energyToAdd;
			donorDroid.energyLevel -= energyToAdd;
			
		}
		
		if (donorDroid.energyLevel < 0) {
			donorDroid.energyLevel = 0;
		}
			
	}
	
	public void recharge() {
		
		// while it's charging, it can't be used to perform any actions
		// TODO would be cool to somehow set something that actually adds 10 energy corresponding to system's timer where every minute = 1hr
		// calculation of charging time
			// every minute in real world time = 1 hr in program time
			// 1 hr = 10 energy gained 

		System.out.println();
		
		if (energyLevel == 100) {
			System.out.println(droidName + "battery already full.");
		} else {
			
			int timeToRecharge = (100 - energyLevel) / 10;
			
			System.out.println(droidName + " recharging...");
			
			if (timeToRecharge > 1) {
				System.out.println("Please allow " + timeToRecharge + " hours.");
			} else {
				System.out.println("Please allow " + timeToRecharge + " hour.");
			}
			
			status = "charging";	
		}
		
	}
	
	public String toString() {
		
		// prints out droid's factory code
		factoryCode = "droid#";
		
		return factoryCode += generateFactoryCode();
		
	}
	
	
	public static void main(String[] args) {
		
		BuildADroid Ernie = new BuildADroid("Ernie", "Christopher");
		System.out.println(Ernie);
		Ernie.energyReport();
		Ernie.performTask("dancing", 10);
		Ernie.performTask("building rocketship", 70);
		Ernie.performTask("commit heinous crimes", 100);
		
		BuildADroid ErnieJr = new BuildADroid("Ernie Jr", "Ernie");
		System.out.println(ErnieJr);
		ErnieJr.energyReport();
		ErnieJr.performTask("shadowing Ernie", 10);
		
		Ernie.energyTransfer(ErnieJr, 90);
		
		Ernie.performTask("commit heinous crimes", 80);
		
		Ernie.energyTransfer(ErnieJr, 100);
		ErnieJr.recharge();
		
		ErnieJr.performTask("complete Science Project", 20);
		
	}
	
}