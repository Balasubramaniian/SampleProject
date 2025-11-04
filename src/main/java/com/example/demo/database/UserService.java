package com.example.demo.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	
	private static final String ALL_USERS_KEY = "users:all";
	
	
	public int createUser(Users user) {
		
		List<Object> users=new ArrayList<>();
		users.add(user.getName());
		users.add(user.getEmail());
		
		String sql="insert into Users(?,?)";
		
		RowMapper<Users> rowMapper= new BeanPropertyRowMapper<>(Users.class);
		
		 redisTemplate.delete(ALL_USERS_KEY);
	     redisTemplate.delete("users:" + user.getName() + ":" + user.getEmail());
		
		return jdbcTemplate.update(sql,rowMapper);
		
	}
    public List<Users> findBynameAndEmail(Users user) {
    	
    	  String key = "users:" + user.getName() + ":" + user.getEmail();
          ValueOperations<String, Object> ops = redisTemplate.opsForValue();

          // Check Redis cache first
          List<Users> cached = (List<Users>) ops.get(key);
          if (cached != null) {
              System.out.println("✅ Returning from Redis cache");
              return cached;
          }

		
		List<Object> users=new ArrayList<>();
		users.add(user.getName());
		users.add(user.getEmail());
		
		String sql="select * from users where name= ? and email=?";
		
		RowMapper<Users> rowMapper= new BeanPropertyRowMapper<>(Users.class);
		
		 ops.set(key, jdbcTemplate.query(sql, rowMapper,users.toArray()), 10, TimeUnit.MINUTES);
	    
		return jdbcTemplate.query(sql, rowMapper,users.toArray());
	}
	
    
    public int[] createUsers(List<Users> user){
    	
    	String sql="insert into Users(?,?)";
    	
    	return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Users users = user.get(i);
                ps.setString(1, users.getName());
                ps.setString(2, users.getEmail());
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
       ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        List<Users> cachedUsers = (List<Users>) valueOps.get(ALL_USERS_KEY);

        if (cachedUsers != null && !cachedUsers.isEmpty()) {
            System.out.println("✅ Returning users from Redis cache");
            return cachedUsers;
        }

        // If cache miss → get from database
        System.out.println("💾 Cache miss — fetching from database");
        String sql = "SELECT * FROM users";
        List<Users> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Users.class));

        valueOps.set(ALL_USERS_KEY, users, 10, TimeUnit.MINUTES);

        return users;
    }
	
    
    public int delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
	
}
