package tue;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import thi1.Student;

public class Tue3 {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		try {
			BufferedReader buff = new BufferedReader(new FileReader("src\\thi1\\student.csv"));
			String line;
			while ((line = buff.readLine()) != null) {
				String[] result = line.split(",");

				String id = result[0];
				String name = result[1];
				SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd");
				Date birthday = simple.parse(result[2]);
				Double score = Double.parseDouble(result[3]);

				Student student = new Student(id, name, birthday, score);
				students.add(student);
			}
			buff.close();
		} catch (Exception e) {
			System.out.println("loi roi");
		}

		List<Student> studentValids = new ArrayList<Student>();
		for (Student obj : students) {
			if (obj.isOld(20)) {
				studentValids.add(obj);
			}
			;
		}

		System.out.println("Number of student old than 20: " + studentValids.size());

	}

}
