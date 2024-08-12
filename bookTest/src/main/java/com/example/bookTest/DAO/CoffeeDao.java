
package com.example.bookTest.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.CoffeeDto;

@Repository
public class CoffeeDao {
	private final JdbcTemplate db;
	
	@Autowired
	public CoffeeDao(JdbcTemplate jdbc) {
		this.db= jdbc;
	}
	
	// 커피 삭제
	public void	delete(int bid) {
		String sql="delete from coffee where coffee_id=?";
		
		db.update(sql, bid);
	}
	
	
	
	// 커피메뉴상세 
	public CoffeeDto findById(int cid) {
		String sql="select * from coffee where coffee_id=?";
		
		CoffeeDto dto = db.queryForObject(sql, new CoffeeDtoRowMapper(), cid);
		
		return dto;
	}
	
	
	public List<CoffeeDto> select(){
		String sql="select * from coffee";
		
		List<CoffeeDto> list = db.query(sql , new CoffeeDtoRowMapper() );
		
		return list;
	}
	
	
	public void save(CoffeeDto coffeeDto) {
		String sql="insert into coffee(item_name, price, decaffein) values(?,?,?)";
		
		db.update(sql , coffeeDto.getItemName(), coffeeDto.getPrice(),
				coffeeDto.isDecaffein() );
	}
	
	public class CoffeeDtoRowMapper implements RowMapper<CoffeeDto>{

		@Override
		public CoffeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			CoffeeDto dto = new CoffeeDto();
			dto.setDecaffein(rs.getBoolean("decaffein"));
			dto.setPrice( rs.getInt("price"));
			dto.setItemName( rs.getString("item_name"));
			dto.setCoffeeId( rs.getInt("coffee_id"));
			return dto;
		}
		
	}
	
	public void update(CoffeeDto coffeeDto) {
		String sql = "update coffee set item_name=? , price=? , decaffein=? where coffee_id=?";
		db.update(sql, coffeeDto.getItemName(), coffeeDto.getPrice(), coffeeDto.isDecaffein(), coffeeDto.getCoffeeId());
	}
}
