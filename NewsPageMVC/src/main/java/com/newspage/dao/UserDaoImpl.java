package com.newspage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Sinhvien;
import com.newspage.beans.Giangvien;
import com.newspage.beans.Kltn;
import com.newspage.beans.Login;
import com.newspage.beans.User;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

//  public int register(User user) {
//    String sql = "insert into users values(?,?,?)";
//
//    return jdbcTemplate.update(sql, new Object[] { user.getMax(), user.getUsername(), user.getPassword()  });
//  }

	public User getUserById(String max){    
	    String sql="select * from users where max like '"+max+"'";    
	    return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class));    
	}
  
	public int changePassword(User u) {
		String sql = "update users set password='"+u.getPassword()+"' where max="+u.getMax()+"";
		return jdbcTemplate.update(sql);
	}
  //		return jdbcTemplate.update(sql, new Object[] { u.getMax(), u.getUsername(), u.getPassword()  });
  
	public User validateUser(Login login) {
		if (login.getUsername().matches("-?\\d+")) {
			String sql = "select * from users INNER JOIN sinhvien ON users.max = sinhvien.msv left join ttcn on users.max=ttcn.msv left join kltn on users.max=kltn.msv where username='" + login.getUsername() + "' and password='" + login.getPassword()+ "'";
			List<User> users = jdbcTemplate.query(sql, new UserMapper());
			return users.size() > 0 ? users.get(0) : null;
		}else {
			String sql = "select * from users INNER JOIN giangvien ON users.max = giangvien.mgv where username='" + login.getUsername() + "' and password='" + login.getPassword()+ "'";
			List<User> users = jdbcTemplate.query(sql, new UserMapper());
			return users.size() > 0 ? users.get(0) : null;
		}  
	}
}

class UserMapper implements RowMapper<User> {
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setMax(rs.getString("max"));
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setHoten(rs.getString("hoten"));
    user.setChucvu(rs.getString("chucvu"));
    user.setLop(rs.getString("lop"));
    if (user.getMax().matches("\\d+")) {
    	user.setDuyettt(rs.getString("ttcn.duyet"));
    	user.setDuyetkl(rs.getString("kltn.duyet"));
    }
    return user;
  }
}