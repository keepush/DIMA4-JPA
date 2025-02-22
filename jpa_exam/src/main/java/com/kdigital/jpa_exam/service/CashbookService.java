package com.kdigital.jpa_exam.service;

import java.util.List;

import com.kdigital.exam.entity.Cashbook;


public interface CashbookService {
	public boolean insert(Cashbook cashbook);
	public boolean delete(int id);
	public List<Cashbook> selectData(String date);		// 월별 지출 내역 조회
	public List<Cashbook> statistics(String date);
	
	public List<Cashbook> selectAll();    // x
}
