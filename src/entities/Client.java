package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	private String name;
	private String email;
	private Date birthDate;
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyy");
	
	public Client() {}

	public Client(String name, String email, String birthDate) throws ParseException {		
		this.name = name;
		this.email = email;
		Date bd = sdf1.parse(birthDate);
		this.birthDate = bd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) throws ParseException {
		
		Date bd = sdf1.parse(birthDate);
		this.birthDate = bd;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Client: ");
		sb.append(name );
		sb.append("("+ sdf1.format(birthDate) +")");
		sb.append(" - ");
		sb.append(email);
		
		return sb.toString();
	}
	
}
