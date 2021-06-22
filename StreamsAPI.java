package ds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import ds.StreamsAPI.Gender;

class Student {
	  private final String name;
	  private final int age;
	  private final Gender gender;

	  public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	public Student(String name, int age, Gender gender) {
	    this.name = name;
	    this.age = age;
	    this.gender = gender;
	  }

	  public String getName() {
	    return name;
	  }
	  
	  public String toString() {
		  return "Student: name="+name+" age="+age+" gender="+gender;
	  }
	  
}

public class StreamsAPI {
	private static List<Student> getStudent() {
	    return List.of(
	        new Student("Amit", 20, Gender.MALE),
	        new Student("Trevor", 33, Gender.FEMALE),
	        new Student("Joshua", 27, Gender.MALE),
	        new Student("Ali", 39, Gender.MALE),
	        new Student("Dayle", 14, Gender.FEMALE),
	        new Student("Priyanka", 39, Gender.MALE),
	        new Student("Heidi", 17, Gender.FEMALE),
	        new Student("Fatima", 90, Gender.FEMALE)	        
	    );
	  }
	public enum Gender {MALE, FEMALE}; //0-MALE, 1- FEMALE
	
	public static void main(String []args) {
		List<Student> students= getStudent();
		
		// Imperative approach
//		List<Student> females= new ArrayList<>();
//		for(Student student:students) {
//			if(student.getGender().equals(Gender.FEMALE)) {
//				females.add(student);
//			}
//		}
//		females.forEach(System.out::println);
		
		// Declarative approach
		
		//Filter
		List<Student> females= students.stream()
				.filter(student -> student.getGender().equals(Gender.FEMALE))
				.collect(Collectors.toList());
		//females.forEach(System.out::println);
		
		//Sort
		List<Student> student= students.stream()
				.sorted(Comparator.comparing(Student::getAge).thenComparing(Comparator.comparing(Student::getName).reversed()))
				.collect(Collectors.toList());
		//student.forEach(System.out::println);
		
		//All match
//		System.out.println(students.stream()
//		.allMatch(s->s.getAge()>14));
		
		//Any Match
//		System.out.println(students.stream()
//		.anyMatch(s->s.getAge()>59));
		
		// None match
//		System.out.println(students.stream()
//		.noneMatch(s->s.getName().equals("Ali")));
		
		//Max
//		students.stream()
//		.max(Comparator.comparing(Student::getAge))
//		.ifPresent(System.out::println);
		
		//Min
//		students.stream()
//		.min(Comparator.comparing(Student::getAge))
//		.ifPresent(System.out::println);
		
		//group by
		Map<Gender, List<Student>> s=students.stream()
		.collect(Collectors.groupingBy(Student::getGender));
		
//		s.forEach((gender, students1)->{
//			System.out.println(gender);
//			students1.forEach(System.out::println);
//			System.out.println();
//		});
		
		Optional<String> youngestMale= students.stream()
		.filter(s1 -> s1.getGender().equals(Gender.MALE))
		.min(Comparator.comparing(Student::getAge))
		.map(Student::getName);
		
		youngestMale.ifPresent(System.out::println);
	}
	}
