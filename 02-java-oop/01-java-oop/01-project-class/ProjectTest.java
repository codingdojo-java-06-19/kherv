
public class ProjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Project project1 = new Project();

		System.out.println(project1.getName());

		System.out.println(project1.elevatorPitch());

		project1.setDescription("the red short building");

		System.out.println(project1.elevatorPitch());

		Project project2 = new Project("foundation", "prepare and pour concrete");
		
		project2.setInitialCost(452.75);

		System.out.println(project2.elevatorPitch());

	}

}
