/**
 * The Easter Egg  Project.
 * @author Soup, Salad, and Breadsticks
 * @version 1.0
 */
public class EasterEgg {

	public static void main(String[] args) {
		EasterEgg output = new EasterEgg();
		output.startingEgg();
		output.StephanieEgg();
		output.CassieEgg();
		output.CynthiaEgg();
		//TODO: Everyone call their methods
		//TODO: Everyone write java doc for the method.

	}

	public void startingEgg() {
		System.out.println("We Are Soup, Salad, and Breadsticks.");
		
	}
	
	public void BryanEgg() {
		
	}
	
	/**
	 * This is Stephanie's message.
	 * Pre condition: None
	 * Post Condition: Message Displayed
	 */
	public void StephanieEgg() {
		System.out.println("I'm Stephanie, I'll only eat the breadsticks.");
		
	}
	
	/**
	 * This is Cassie's message. 
	 * Pre condition: None
	 * Post condition: Message displayed 
	 */
	public void CassieEgg() {
		System.out.println("This is Cassie! if you don't order extra breadsticks to take home, "
				+ "how are you even living?");
	}
	
	/**
	 * This is Cynthia's message. 
	 * Pre condition: None
	 * Post condition: Message displayed 
	 */
	public void CynthiaEgg() {
		System.out.println ("This is Cynthia...Ya'll can fight over your breadsticks. "
				 + "It's all about that soup though!");
		
	}
}
