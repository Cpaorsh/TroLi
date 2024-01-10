package com.newspage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Sinhvien;

public class SinhvienDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int saveSvien(Sinhvien s){    
	    String sql="insert into sinhvien(hoten, ngaysinh, lop) values('"+s.getHoten()+"', '"+s.getNgaysinh()+"',  '"+s.getLop()+"')";    
	    return template.update(sql);    
	}    
	public int updateSvien(Sinhvien s){    
	    String sql="update sinhvien set hoten='"+s.getHoten()+"', ngaysinh='"+s.getNgaysinh()+"', lop='"+s.getLop()+"' where msv="+s.getMsv()+"";    
	    return template.update(sql);    
	}    
	public int deleteSvien(int msv){    
	    String sql="delete from sinhvien where msv="+msv+"";    
	    return template.update(sql);    
	}    
	public Sinhvien getSinhvienById(int msv){    
	    String sql="select * from sinhvien where msv=?";    
	    return template.queryForObject(sql, new Object[]{msv},new BeanPropertyRowMapper<Sinhvien>(Sinhvien.class));    
	}
	
	public List<Sinhvien> getSinhviens(){    
	    return template.query("select * from sinhvien",new RowMapper<Sinhvien>(){    
	        public Sinhvien mapRow(ResultSet rs, int row) throws SQLException {    
	        	Sinhvien e=new Sinhvien();    
	            e.setMsv(rs.getString(1));    
	            e.setHoten(rs.getString(2));    
	            e.setNgaysinh(rs.getString(3));    
	            e.setLop(rs.getString(4));     
	            e.setChucvu(rs.getString(5));  
	            return e;    
	        }    
	    });    
	}
}
