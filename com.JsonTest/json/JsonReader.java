package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
	public void genericReader(String path, String fileName){
		//creating a json parser
		JSONParser parser = new JSONParser();
		String filePath = path+fileName;
		try {
			//store the path where the file is
			FileReader file = new FileReader(filePath);
			//convert the file to an object
			Object object = parser.parse(file);
			//creating a jsonObject
			JSONObject jsonObject = new JSONObject();
			//cast the object to JsonObject
			jsonObject = (JSONObject) object;
			
			//get the value by the tag
			String nome = (String) jsonObject.get("Nome");
			String idade = (String) jsonObject.get("Idade");
			String sexo = (String) jsonObject.get("Sexo");
			
			//print the values
			System.out.println("Nome: " + nome);
			System.out.println("Idade: " + idade);
			System.out.println("Sexo: " + sexo);
			
			//scanning the JsonArray
			//creating a json array
			JSONArray jsonArray = (JSONArray) jsonObject.get("Empresas");
			@SuppressWarnings("unchecked")
			//creating a String list with all jsonObjects in JsonArray
			Iterator<String> iterator = jsonArray.iterator();
			while(iterator.hasNext()){
				//print the values
				System.out.println(iterator.next());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//deserializer the Json in Student list
	public ArrayList<Student> read(String path, String fileName){
		//the path where the file is
		String filePath = path+fileName;
		ArrayList<Student> students = new ArrayList<Student>();
		JSONParser parser = new JSONParser();
		//variable to get the value inside the node
		String name="";
		String age="";
		String sex="";
		
		try {
			FileReader file = new FileReader(filePath);
			Object obj = parser.parse(file);
			JSONArray jsonRoot = new JSONArray();
			jsonRoot = (JSONArray) obj;
			@SuppressWarnings("unchecked")
			//creating a JsonObject list with all jsonObjects in jsonRoot
			Iterator<JSONObject> iterator = jsonRoot.iterator();
			//deserializer the Json to Student class
			while(iterator.hasNext()){
				
				JSONObject jsonNode = iterator.next();
				jsonNode.toJSONString();
				Student student = new Student();
				//get the value by the tag and convert to String
				name=(String) jsonNode.get("Name");
				age=(String) jsonNode.get("Age");
				sex=(String) jsonNode.get("Sex");
				//set the value to student atributes
				student.setName(name);
				student.setAge(Integer.parseInt(age));
				student.setSex(Boolean.parseBoolean(sex));
				//add the student to student List
				students.add(student);
			}
		} catch (ParseException pE) {
			System.out.println(pE.getMessage());
		} catch (FileNotFoundException fNFE) {
			System.out.println(fNFE.getMessage());
		} catch (IOException iOE) {
			System.out.println(iOE.getMessage());
		}
		//fedback mensage "sucefull"
		System.out.println("Deserealizer sucefull");
		return students;
	}
}
