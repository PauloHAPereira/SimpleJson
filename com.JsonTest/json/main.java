package json;

import java.util.ArrayList;
/**
 * 
 * @author Paulo Pereira
 *
 */
public class main {

	public static void main(String[] args) {
		
		JsonWriter jsonWriter = new JsonWriter();
		JsonReader jsonReader = new JsonReader();
		System.out.println("================Generic Read and Write================\n");
		//generic read and write Json
		String genericFileName = "Generic.Json";
		String genericPath = "C:/Users/Paulo Pereira/Desktop/";
		jsonWriter.genericWrite(genericPath, genericFileName);
		jsonReader.genericReader(genericPath,genericFileName);
		
		System.out.println("\n================Serializer and Deserializer a StudentList================\n");
		//Serializer and deserializer a Student List
		ArrayList<Student> students = new ArrayList<Student>();
		Student student1 = new Student("Paulo", 25, false);
		Student student2 = new Student("Jessica", 25, true);
		students.add(student1);
		students.add(student2);
		
		String fileName = "JsonStudents.Json";
		String path = "C:/Users/Paulo Pereira/Desktop/";
		
		jsonWriter.write(path, fileName, students);
		ArrayList<Student> students2 = new ArrayList<Student>();
		students2 = jsonReader.read(path, fileName);
		
		for (Student student : students2) {
			System.out.println("Name: " + student.getName());
			System.out.println("Age: " + student.getAge());
			System.out.println("Sex: " + student.isSex());
		}
	}
}
