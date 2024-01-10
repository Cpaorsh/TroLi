package com.newspage.dao;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;       
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;  

import com.newspage.beans.Doc;


public class DocDao {  
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}   
	
	private static final byte[] HEX_ARRAY = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);
	public static String bytesToHex(byte[] bytes) {
	    byte[] hexChars = new byte[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars, StandardCharsets.UTF_8);
	}

	
	public int save(Doc p){    
	    if(p.getBytefi()==null){
	    	String sql="insert into doc(title) values('"+p.getTitle()+"')";    
	    	return template.update(sql); 
	    } else{
	    	String sql="insert into doc(title, bytefi, namefi) values('"+p.getTitle()+"', X'"+p.getBytefi()+"', '"+p.getNamefi()+"' )";    
	    	return template.update(sql);
		}
	}    
	public int update(Doc p){  
		if(p.getBytefi()==null){
		    String sql="update doc set title='"+p.getTitle()+"' where id="+p.getId()+"";    
		    return template.update(sql); 
		} else{
			String sql="update doc set title='"+p.getTitle()+"', bytefi=X'"+p.getBytefi()+"', namefi='"+p.getNamefi()+"' where id="+p.getId()+"";    
		    return template.update(sql);
		}
	}    
	
	public int delete(int id){    
	    String sql="delete from doc where id="+id+"";    
	    return template.update(sql);    
	}    
	public Doc getDocById(int id) {
        String sql = "select * from doc where id=?";
        return template.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
	        	Doc e=new Doc();    
	            e.setId(rs.getInt(1));    
	            e.setTitle(rs.getString(2)); 
	            e.setHexfi(rs.getBlob(3));
	            e.setNamefi(rs.getString(4));
	            return e;
        });

    }    
	
	

	public List<Doc> getDocs(){    
	    return template.query("select * from doc order by title asc",new RowMapper<Doc>(){    
	        public Doc mapRow(ResultSet rs, int row) throws SQLException {    
	            Doc e=new Doc();    
	            e.setId(rs.getInt(1));    
	            e.setTitle(rs.getString(2)); 
	            e.setHexfi(rs.getBlob(3));
	            e.setNamefi(rs.getString(4));
	            return e;    
	        }    
	    });    
	} 
	

	


}

