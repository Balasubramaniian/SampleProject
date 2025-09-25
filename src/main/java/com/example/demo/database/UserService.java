package com.example.demo.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	public int createUser(Users user) {
		
		List<Object> users=new ArrayList<>();
		users.add(user.getName());
		users.add(user.getEmail());
		
		String sql="insert into Users(?,?)";
		
		RowMapper<Users> rowMapper= new BeanPropertyRowMapper<>(Users.class);
		
		return jdbcTemplate.update(sql,user.getName(),user.getEmail());
		
	}
    public List<Users> findBynameAndEmail(Users user) {
		
		List<Object> users=new ArrayList<>();
		users.add(user.getName());
		users.add(user.getEmail());
		
		String sql="select * from users where name= ? and email=?";
		
		RowMapper<Users> rowMapper= new BeanPropertyRowMapper<>(Users.class);
		
		
		return jdbcTemplate.query(sql, rowMapper,users.toArray());
	}
	
    
    public int[] createUsers(List<Users> user){
    	
    	String sql="insert into Users(?,?)";
    	
    	return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Users users = user.get(i);
                ps.setString(2, users.getName());
                ps.setString(3, users.getEmail());
            }

            @Override
            public int getBatchSize() {
                return user.size();
            }
    	});
    }
    
    public int updateUser(Users user) {
    	
    	List<Object> users=new ArrayList<>();
		users.add(user.getName());
		users.add(user.getEmail());
    	
    	String Sql= "Update users SET name=? where id=?";
    	
    	return jdbcTemplate.update(Sql,users.toArray());
    }
    
    public List<Users> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Users.class));
    }
	
    
    public int delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
	
}
