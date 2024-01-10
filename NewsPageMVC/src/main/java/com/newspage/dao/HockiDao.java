package com.newspage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Hocki;

public class HockiDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	} 
	
	public int addHk(String str){  
		String che = str.length() > 2 ? str.substring(str.length() - 2) : str;
		int bef = Integer.parseInt(che)-1;
		int aft = Integer.parseInt(che)+1;
		if (str.contains("Học kì 1")) {
			String sql="insert into hocki(tenhk) values('Học kì 2 - Năm học 20"+bef+"-20"+che+"')";    
			return template.update(sql);   
		} else {
			String sql="insert into hocki(tenhk) values('Học kì 1 - Năm học 20"+che+"-20"+aft+"')";    
		    return template.update(sql); 
		}
	}
	
	public int deleteHk(int id){    
	    String sql="delete from hocki where id="+id+"";    
	    return template.update(sql);    
	} 
	
	public Hocki getLastHk(){  
		String sql= "select * from hocki order by id desc limit 1";
	    return template.queryForObject(sql,new BeanPropertyRowMapper<Hocki>(Hocki.class));    
	}
	
	public List<Hocki> getHks(){    
	    return template.query("select * from hocki order by id desc",new RowMapper<Hocki>(){    
	        public Hocki mapRow(ResultSet rs, int row) throws SQLException {    
	        	Hocki h=new Hocki();    
	            h.setId(rs.getInt(1));    
	            h.setTenhk(rs.getString(2));
	            
	            return h;    
	        }    
	    });    
	}
	
	

}
