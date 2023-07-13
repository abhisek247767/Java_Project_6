package com.first.demo.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Job_Posting")
public class Posti {
	private String desc;
	private int  exp;
	private String profile;
	private String techstack[];
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String[] getTechstack() {
		return techstack;
	}
	public void setTechstack(String[] techstack) {
		this.techstack = techstack;
	}

	@Override
	public String toString() {
		return "Posti [ desc=" + desc + ", exp=" + exp + ", profile=" + profile + ", techstack="
				+ Arrays.toString(techstack) + "]";
	}
	public Posti() {
		super();
	}

	

}
