
public class Project {
	private String name;
	private String description;
	private Double initialCost;

	public Project() {
		this.name = "High Rise";
		this.description = "The new tall building";
	}

	public Project(String name) {
		this.name = name;
		this.description = "The new tall building";

	}

	public Project(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String elevatorPitch() {
		return this.name + " (" + this.initialCost + "):" + this.description;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void setDescription(String d) {
		this.description = d;
	}

	public Double getInitialCost() {
		return this.initialCost;
	}

	public void setInitialCost(Double i) {
		this.initialCost = i;
	}

}
