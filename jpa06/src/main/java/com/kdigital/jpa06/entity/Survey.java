package com.kdigital.jpa06.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name="survey")
public class Survey {
	@Id
	private String id;
	private String name;
	
	@OneToMany
	@JoinColumn(name="survey_id")							/* 연관 관계를 가지는 column */
	@OrderColumn(name="order_no")							/* 리스트 안에 들어가는 번호 지정 */
	private List<Question> questions = new ArrayList<>();
}
