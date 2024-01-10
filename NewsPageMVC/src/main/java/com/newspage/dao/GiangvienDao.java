package com.newspage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Giangvien;

public class GiangvienDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int saveGvien(Giangvien s){    
	    String sql="insert into giangvien(hoten, ngaysinh, lop) values('"+s.getHoten()+"', '"+s.getNgaysinh()+"',  '"+s.getLop()+"')";    
	    return template.update(sql);    
	}    
	public int updateGvien(Giangvien s){    
	    String sql="update giangvien set hoten='"+s.getHoten()+"', ngaysinh='"+s.getNgaysinh()+"', lop='"+s.getLop()+"' where mgv='"+s.getMgv()+"'";    
	    return template.update(sql);    
	}    
	public int deleteGvien(String mgv){    
	    String sql="delete from giangvien where mgv='"+mgv+"'";    
	    return template.update(sql);    
	}    
	public Giangvien getGiangvienById(String mgv){    
	    String sql="select * from giangvien where mgv=?";    
	    return template.queryForObject(sql, new Object[]{mgv},new BeanPropertyRowMapper<Giangvien>(Giangvien.class));    
	}
	
	public List<Giangvien> getGiangviens(){    
	    return template.query("select * from giangvien",new RowMapper<Giangvien>(){    
	        public Giangvien mapRow(ResultSet rs, int row) throws SQLException {    
	        	Giangvien e=new Giangvien();    
	            e.setMgv(rs.getString(1));    
	            e.setHoten(rs.getString(2));    
	            e.setNgaysinh(rs.getString(3));    
	            e.setLop(rs.getString(4));     
	            e.setChucvu(rs.getString(5));  
	            return e;    
	        }    
	    });    
	}
}
