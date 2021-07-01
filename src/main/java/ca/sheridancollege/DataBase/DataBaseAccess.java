package ca.sheridancollege.DataBase;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.beans.Login;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

@Repository
public class DataBaseAccess 
{
	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	public void addUser(Login login)
	{
		String query = "INSERT INTO LOGINDETAILS VALUES ( '" + login.getUserName() + "','" + login.getPassword() +"')";
		jdbc.update(query, new HashMap());
	}
	
}
