package ca.sheridancollege.beans;

import java.io.Serializable;

import lombok.Data;

@Data
public class Login implements Serializable
{

	private static final long serialVersionUID = 617240237276036708L;
	
	private String userName;
	private String password;
	
}
