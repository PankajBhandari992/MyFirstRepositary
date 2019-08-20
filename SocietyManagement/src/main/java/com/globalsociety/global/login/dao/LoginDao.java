package com.globalsociety.global.login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.globalsociety.global.login.bean.Login;


@Repository
public class LoginDao {
	
	Logger logger= LoggerFactory.getLogger(LoginDao.class);
	
	@Autowired
	LoginRepositary loginRepo;

	@Autowired
	JdbcTemplate jdbcTemplate;
	/*
	 * public Login getLoginDetilsByUsername(String username) {
	 * logger.info("inside service :"); // Optional<Login> login =
	 * loginRepo.findByusername(username); //logger.info("login::"+
	 * login.get().getUsername() ); Login login= new Login(); login =
	 * loginRepo.findByusername(username); //Optional<Login>
	 * login1=login.findFirst(); logger.info("login::"+ login.getUsername() );
	 * //logger.info("userId: "+ login.getUsername()+" pasword: "+
	 * login.getPassword() ); return login; }
	 */

	
	public List<Login> getLoginDetilsByUsername(String username)  {
		
		List<Login> loginDetails = (List<Login>) jdbcTemplate.query("select * from LOGIN_DETAILS where userName=? ",new Object[] {username}, new LoginDetailsMapper()	);
		
		return loginDetails;
	}
	
	
	public int addUser(Login login) {
		
		logger.info("inside addUser");
		
	    return jdbcTemplate.update(
		        "INSERT INTO LOGIN_DETAILS (login_pk, username, password) VALUES (login_details_sequence.nextval, ?, ?)", new Object[] {login.getUsername(), login.getPassword() });
	}
	class LoginDetailsMapper implements RowMapper{

		@Override
		public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
			Login login=new Login();
			
			login.setLoginPk(rs.getLong("login_pk"));
			login.setUsername(rs.getString("username"));
			login.setPassword(rs.getString("password"));
			return login;
		}
		
	}

	public Login saveUser(Login login) {
		// TODO Auto-generated method stub
		logger.info("inside LoginDao :: Saving user ");
		return loginRepo.save(login);
		
	}
	
}
