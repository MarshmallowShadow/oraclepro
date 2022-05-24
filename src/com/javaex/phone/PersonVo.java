package com.javaex.phone;

public class PersonVo {
	//필드
	private int personId;
	private String name;
	private String hp;
	private String company;
	
	//생성자
	public PersonVo() {
		super();
	}
	public PersonVo(String name, String hp, String company) {
		this();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	public PersonVo(int personId, String name, String hp, String company) {
		this(name, hp, company);
		this.personId = personId;
	}
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
