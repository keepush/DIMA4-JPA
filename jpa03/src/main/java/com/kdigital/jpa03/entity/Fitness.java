package com.kdigital.jpa03.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="fitness")
public class Fitness {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String gender;
	private double height;
	private double weight;
	
	@Column(name="std_weight")
	private double stdWeight;
	private double bmi;
	
	@Column(name="bmi_result")
	private String bmiResult;
	
	// 생성자
	public Fitness() { }
	
	// id는 DB에서 auto_increment이므로 전달인자로 받지 않는다.
	public Fitness(String name, String gender, double height, double weight) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		
		calcStdWeight();
		calcBMI();
	}

	// Setter, Getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}
	// 키가 수정되면 표준체중과 BMI를 재계산 하기 위해
	public void setHeight(double height) {
		this.height = height;
		calcStdWeight();
		calcBMI();
	}

	public double getWeight() {
		return weight;
	}
	// 몸무게가 수정되면 표준체중과 BMI를 재계산 하기 위해
	public void setWeight(double weight) {
		this.weight = weight;
		calcStdWeight();
		calcBMI();
	}

	public double getStdWeight() {
		return stdWeight;
	}

	public double getBmi() {
		return bmi;
	}

	public String getBmiResult() {
		return bmiResult;
	}
	
	// 일반메소드로 stdWeight, bmi, bmiResult 처리하도록 함
	// 계산되어 나오는 결과이므로!
	private void calcStdWeight() {
		double temp = height / 100;   // m로 환산된 키

		// 남자인지 여자인지 판단해서 표준체중을 다르게 계산해야함
		if(gender.equals("남")) {  // 기본자료형만 ==으로 비교
			stdWeight = temp * temp * 22;	
		} else {
			stdWeight = temp * temp * 21;	
		}
	}
	
	private void calcBMI() {
		double temp = height / 100;   // m로 환산된 키
		
		bmi = weight / (temp * temp);
		calcBmiResult();
	}

	private void calcBmiResult() {
		// BMI 결과 처리
		if(bmi >= 35) 		bmiResult = "고도 비만";
		else if(bmi >= 30) 	bmiResult = "중(重)도 비만 (2단계 비만)";
		else if(bmi >= 25) 	bmiResult = "경도 비만 (1단계 비만)";
		else if(bmi >= 23) 	bmiResult = "과체중";
		else if(bmi >= 18.5)bmiResult = "정상";
		else 				bmiResult = "저체중";
	}
	
	@Override
	public String toString() {
		return String.format("%2d %s %s %.2fcm %.2fKg 표준체중: %.2f BMI: %.2f %s%n",
				id, name, gender, height, weight, stdWeight, bmi, bmiResult);
	}
}
