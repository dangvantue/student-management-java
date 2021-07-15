package thi1;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Student {

	private String id;
	private String name;
	private Date birthday;
	private Double score;

	public Student() {
		super();
	}

	public Student(String id, String name, Date birthday, Double score) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public void print() {
		System.out.println("id: " + this.getId());
		System.out.println("name: " + this.getName());
		System.out.println("birthday: " + this.getBirthday());
		System.out.println("score: " + this.getScore());
	}

	public String getInfo() {
		return "id: " + this.getId() + " name: " + this.getName() + " birthday: " + this.getBirthday() + " score: "
				+ this.getScore() + "\n";
	}

	public boolean isOld(int age) {
		Date today = new Date();
		Calendar caleToday = Calendar.getInstance();
		caleToday.setTime(today);

		Calendar caleBirthday = Calendar.getInstance();
		caleBirthday.setTime(this.birthday);
		int realAge = caleToday.get(Calendar.YEAR) - caleBirthday.get(Calendar.YEAR);
		return realAge > age;
	}

}
