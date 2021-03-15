package model;

public class Student {
	String name;
	int age;

	public Student() {
	}

	public Student(String n, int a) {
		name = n;
		age = a;
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
    public String toString() {
    	return name+"->"+age;
    }
}
