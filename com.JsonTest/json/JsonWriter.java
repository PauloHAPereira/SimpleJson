package json;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWriter {

	@SuppressWarnings("unchecked")
	public void genericWrite(String path,String fileName){
		String filePath = path+fileName;
		//creating a json object
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Nome", "Paulo");
		jsonObject.put("Idade", "25");
		jsonObject.put("Sexo", "M");
		//creating an array
		JSONArray empresas = new JSONArray();
		empresas.add("Empresa: Google");
		empresas.add("Empresa: Intel");
		empresas.add("Empresa: Embraer");
		//put this array on jsonObject
		jsonObject.put("Empresas",empresas);
		
		//save the JsonFile
		try{
			@SuppressWarnings("resource")
			FileWriter file = new FileWriter(filePath);
			file.write(jsonObject.toJSONString());
			file.flush();
		}catch (IOException IOe) {
			System.out.println(IOe.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	public void write(String path,String fileName,ArrayList<Student> students){
		String filePath = path+fileName;
		//this node will be the root
		JSONArray jsonRoot = new JSONArray();
		//scans student list and added to Json
		for (Student student : students) {
			//creating a node
			JSONObject jsonNode = new JSONObject();
			//put the student atributes on node
			jsonNode.put("Name", student.getName());
			jsonNode.put("Age", Integer.toString(student.getAge()));
			jsonNode.put("Sex", Boolean.toString(student.isSex()));
			//add the node to root
			jsonRoot.add(jsonNode);
		}
		//save the date in a Json file
		try {
			@SuppressWarnings("resource")
			FileWriter file = new FileWriter(filePath);
			file.write(jsonRoot.toJSONString());
			file.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Serializer sucefull");
	}
	

}
