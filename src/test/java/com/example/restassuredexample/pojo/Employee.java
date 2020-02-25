package com.example.restassuredexample.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Employee{

	@SerializedName("name")
	private String name;

	@SerializedName("salary")
	private String salary;

	@SerializedName("age")
	private String age;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSalary(String salary){
		this.salary = salary;
	}

	public String getSalary(){
		return salary;
	}

	public void setAge(String age){
		this.age = age;
	}

	public String getAge(){
		return age;
	}

	@Override
 	public String toString(){
		return 
			"Employee{" + 
			"name = '" + name + '\'' + 
			",salary = '" + salary + '\'' + 
			",age = '" + age + '\'' + 
			"}";
		}
}