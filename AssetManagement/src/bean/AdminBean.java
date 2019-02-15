package bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AdminLogin")
public class AdminBean {
@Id
//String email;
//String email_Id;
String password;
String Designation;
int aid;

public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
/*public String getEmail_Id() {
	return email_Id;
}
public void setEmail_Id(String email_Id) {
	this.email_Id = email_Id;
}*/
public String getDesignation() {
	return Designation;
}
public void setDesignation(String designation) {
	Designation = designation;
}
//
//public String getEmail() {
//	return email;
//}
//public void setEmail(String email) {
//	this.email = email;
//}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
