
package com.example.bookTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.DAO.CoffeeDao;
import com.example.bookTest.Dto.CoffeeDto;

@Service
public class CoffeeService {
	
	@Autowired
	private CoffeeDao coffeeDao;
	
	
	public void remove(int id) {
		coffeeDao.delete(id);
	}
	
	
	public CoffeeDto getMenu(int id) {
		return coffeeDao.findById(id);
	}
	
	public List<CoffeeDto> selectAll(){
		
		return coffeeDao.select();
	}
	
	
	public void menuInsert(CoffeeDto coffeeDto) {
		if( coffeeDto != null)
			coffeeDao.save(coffeeDto);
	}


	public void update(CoffeeDto coffeeDto) {
		// TODO Auto-generated method stub
		
	}
}
