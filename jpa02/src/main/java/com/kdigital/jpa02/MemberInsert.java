package com.kdigital.jpa02;

import java.time.LocalDate;

import com.kdigital.jpa02.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MemberInsert {

	public static void main(String[] args) {
		// 1) Factory 생성
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpastudy");
		
		// 2) Manager 생성
		EntityManager manager = factory.createEntityManager();
		
		// 3) Transaction 생성
		EntityTransaction tx = manager.getTransaction();
		
		try {
		// 4) transaction 시작
			tx.begin();
			
			Member member = new Member("01"+"@naver.com", "김일", LocalDate.now(), 25);
			manager.persist(member);	
			
			for(int i=2; i<=10; ++i) {
				member = new Member("0"+i+"@naver.com", "김일-"+i, LocalDate.now(), 25+i);
				manager.persist(member);	
			}
			
			tx.commit();
			System.out.println("저장 완료");
		
		} catch (Exception e) {
			tx.rollback();
			System.out.println("저장 실패");
		} finally {
			manager.close();
		}
		
		factory.close();
	}

}
