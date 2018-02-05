package json;

public class Student {
	private String name;
	private int age;
	private boolean sex;	//Sex; false = man, true = woman
	
	public Student(String name,int age, boolean sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public Student(){	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	
}
