import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieDAO {

	public static void main(String[] args) throws IOException {

		System.out.println("Welcome to Movies JDBC ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("PRESS 1 to ADD");
			System.out.println("PRESS 2 to UPDATE");
			System.out.println("PRESS 3 to DELETE");
			System.out.println("PRESS 4 to DISPLAY");
			System.out.println("PRESS 5 to EXIT");

			int c = Integer.parseInt(br.readLine());

			switch (c) {
			case 1:
				// 1. Add Movie..
				System.out.println("Enter Id :");
				int id = Integer.parseInt(br.readLine());

				System.out.println("Enter Title :");
				String title = br.readLine();

				System.out.println("Enter Genre :");
				String genre = br.readLine();

				System.out.println("Enter Year Of Release :");
				int yearOfRelease = Integer.parseInt(br.readLine());

				// Creating object of Movie class
				Movie obj = new Movie(id, title, genre, yearOfRelease);

				System.out.println(obj);

				// Calling of method to insert into table and passing the object of Movie class
				boolean result = MovieOperation.insert(obj);
				if (result) {
					System.out.println("Successfully added.");
				} else {
					System.out.println("Something went wrong.");
				}
				break;

			case 2:
				// 2. Update movie..
				System.out.println("Enter Title :");
				String updateTitle = br.readLine();

				System.out.println("Enter Genre :");
				String updateGenre = br.readLine();

				System.out.println("Enter Year Of Release :");
				int updateYearOfRelease = Integer.parseInt(br.readLine());

				// Creating object of Movie class
				Movie updateObj = new Movie(updateTitle, updateGenre, updateYearOfRelease);

				System.out.println("Enter Id to which update :");
				int sid = Integer.parseInt(br.readLine());

				// Calling of method to update table and pass the obj of Movie class
				boolean updateResult = MovieOperation.update(updateObj, sid);
				if (updateResult) {
					System.out.println("Successfully updated.");
				} else {
					System.out.println("Something went wrong.");
				}
				break;

			case 3:
				// 3. Delete movie..
				System.out.println("Enter Movie id to delete :");
				int deleteId = Integer.parseInt(br.readLine());

				// Calling method to delete a particular row
				boolean deleteResult = MovieOperation.delete(deleteId);
				if (deleteResult) {
					System.out.println("Successfully deleted.");
				} else {
					System.out.println("Something went wrong.");
				}
				break;

			case 4:
				// 4. Display movie..
				// Calling method display to display the table values
				MovieOperation.display();
				break;

			case 5:
				// 5. Exit
				System.out.println("GoodBye!");
				return;

			default:
				System.out.println("Wrong input!");
				break;
			}
		}
	}

}

