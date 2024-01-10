package com.newspage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Doc;
import com.newspage.beans.Slieu;

public class ManageDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	} 

	public Slieu getTongtt(int id) {
        String sql = "SELECT COUNT(*), SUM(IF(duyet=0, 1, 0)), SUM(IF(duyet=2, 1, 0)), SUM(IF(duyet=1, 1, 0)) FROM ttcn where idhk=?";     
        return template.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
	        	Slieu e=new Slieu();    
	            e.setTtt(rs.getInt(1));
	            e.setTtcd(rs.getInt(2));
	            e.setTtkd(rs.getInt(3));
	            e.setTtdd(rs.getInt(4));
	            return e;
        });
    }
	
	public Slieu getTongkl(int id) {
        String sql = "SELECT COUNT(*), SUM(IF(duyet=0, 1, 0)), SUM(IF(duyet=2, 1, 0)), SUM(IF(duyet=1, 1, 0)) FROM kltn where idhk=?";     
        return template.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
	        	Slieu e=new Slieu();    
	            e.setTkl(rs.getInt(1));
	            e.setKlcd(rs.getInt(2));
	            e.setKlkd(rs.getInt(3));
	            e.setKldd(rs.getInt(4));
	            return e;
        });
    }
	
	public List<Slieu> getLops(){    
	    return template.query("SELECT lop, count(*), SUM(IF(tthai='Chưa đánh giá', 1, 0)), SUM(IF(tthai='Sinh viên đã đánh giá', 1, 0)), SUM(IF(tthai='Lớp trưởng đã đánh giá', 1, 0)), SUM(IF(tthai='Giảng viên đã đánh giá', 1, 0))  FROM drl LEFT JOIN sinhvien ON sinhvien.msv = drl.msv GROUP BY sinhvien.lop;",new RowMapper<Slieu>(){    
	        public Slieu mapRow(ResultSet rs, int row) throws SQLException {    
	        	Slieu e=new Slieu();       
	            e.setTen(rs.getString(1)); 
	            e.setTong(rs.getInt(2));
	            e.setChuadg(rs.getInt(3));
	            e.setTudg(rs.getInt(4));
	            e.setLtdg(rs.getInt(5));
	            e.setGvdg(rs.getInt(6));
	            return e;    
	        }    
	    });    
	}

}
