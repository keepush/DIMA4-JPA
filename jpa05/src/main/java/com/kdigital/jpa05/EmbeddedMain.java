package com.kdigital.jpa05;

import java.time.LocalDate;

import com.kdigital.jpa05.entity.Address;
import com.kdigital.jpa05.entity.Grade;
import com.kdigital.jpa05.entity.Hotel;
import com.kdigital.jpa05.util.MyEntityManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmbeddedMain {

	public static void main(String[] args) {
		insertHotel();
		printHotel();
	}
	
	// 호텔 정보 추가
	private static void insertHotel(){
		EntityManager manager = MyEntityManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			Address address = new Address("부산시 사하구", "몰라동 123번지", "000-4568");
			Hotel hotel = new Hotel("h_02", "부산 호텔", LocalDate.now(), Grade.S2, address);
			manager.persist(hotel);
			
			tx.commit();
			System.out.println("저장 완료!!");
			
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			
		} finally {
			manager.close();
		}
	}
	
	private static void printHotel(){
		EntityManager manager = MyEntityManager.getManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			tx.begin();
			
			Hotel hotel = manager.find(Hotel.class, "h_02");
			if(hotel != null) {
				System.out.println("호텔 정보: " + hotel.toString());
				System.out.println("호텔 주소정보: " + hotel.getAddress());
			}
			
			tx.commit();
			
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			
		} finally {
			manager.close();
		}
	}

}
