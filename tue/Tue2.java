package tue;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import thi1.Student;

public class Tue2 {

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

		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap min: ");
		Double min = scan.nextDouble();
		System.out.println("Nhap max: ");
		Double max = scan.nextDouble();

		List<Student> studentValids = new ArrayList<Student>();

		for (Student obj : students) {
			if (obj.getScore() > min && obj.getScore() < max) {
				studentValids.add(obj);
			}
			;
		}

		try {

			FileOutputStream fileout = new FileOutputStream("src\\thi1\\student2.txt");

			for (Student obj : studentValids) {
				fileout.write(obj.getInfo().getBytes());
				fileout.flush();
			}
			fileout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
