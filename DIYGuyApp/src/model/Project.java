/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * Project Object containing relavent project information
 * @author Cynthia Mora Olmedo
 *
 */
public final class Project {

	String projectName;
	ArrayList<String> materials;
	ArrayList<String> steps; //aka directions/instructions
	String description;
	String energyType;
	double estimatedTime; //in hours, 1.3h, 2.75 hr, etc
	double totalCost;
	
	
	/**
	 * Project Constructor.
	 * @param projectName project title/name
	 * @param materials list of materials needed
	 * @param steps list of steps to complete project
	 * @param energyType type of energy this project saves for
	 * @param estimatedTime it takes to complete project
	 * @param totalCost of all materials.
	 */
	public Project(String projectName, ArrayList<String> materials, ArrayList<String> steps, String description, 
			String energyType, double estimatedTime,double totalCost) {
		this.projectName = projectName;
		this.materials = materials;
		this.steps = steps;
		this.description = description;
		this.energyType = energyType;
		this.estimatedTime = estimatedTime;
		this.totalCost = totalCost;
	}
	
	/**
	 * Compares Project  0 means they are equal;
	 * positive  means first bill has high cost, negative
	 * means second bill has higher cost.
	 * @param a first project being compared
	 * @param b second project being compared
	 * @return 0 if a is larger, 1 if b is larger
	 */
	public static int compareProjectPrice(Project a, Project b){
		int val = java.lang.Double.compare(a.getTotalCost(),b.getTotalCost());
		int rtn;
		if (val == 0) {
			rtn = 0;
		} else if (val > 0) {
			rtn = 1;
		} else {
			rtn = -1;
		}
		return rtn;
	}
	}

	//Getters and Setters
	/**
	 * @return the projectName
	 */
	public final String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public final void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the materials
	 */
	public final ArrayList<String> getMaterials() {
		ArrayList<String> mats = new ArrayList<>();
		for(String material: materials) {
			mats.add(material);
		}
		return materials;
	}

	/**
	 * @param materials the materials to set
	 */
	public final void setMaterials(ArrayList<String> materials) {
		this.materials = materials;
	}

	/**
	 * @return the steps
	 */
	public final ArrayList<String> getSteps() {
		ArrayList<String> stps = new ArrayList<>();
		for(String step: steps) {
			stps.add(step);
		}
		return stps;
	}

	/**
	 * @param steps the steps to set
	 */
	public final void setSteps(ArrayList<String> steps) {
		this.steps = steps;
	}
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the energyType
	 */
	public final String getEnergyType() {
		return energyType;
	}

	/**
	 * @param energyType the energyType to set
	 */
	public final void setEnergyType(String energyType) {
		this.energyType = energyType;
	}

	/**
	 * @return the estimatedTime
	 */
	public final double getEstimatedTime() {
		return estimatedTime;
	}

	/**
	 * @param estimatedTime the estimatedTime to set
	 */
	public final void setEstimatedTime(double estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	/**
	 * @return the totalCost
	 */
	public final double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public final void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
	
}
