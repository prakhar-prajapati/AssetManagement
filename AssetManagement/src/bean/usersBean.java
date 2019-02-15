package bean;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Users")
public class usersBean {
@Id
@GeneratedValue
int uid;	
String firstName,lastName,email_Id,password,Designation;
int manager_Id,emp_id,support_id,Active;
public Date getDateOfJoining() {
	return dateOfJoining;
}
public void setDateOfJoining(Date dateOfJoining) {
	this.dateOfJoining = dateOfJoining;
}
Date dateOfJoining;

public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getSupport_id() {
	return support_id;
}
public void setSupport_id(int support_id) {
	this.support_id = support_id;
}
public int getActive() {
	return Active;
}
public void setActive(int active) {
	Active = active;
}
long mobile;

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail_Id() {
	return email_Id;
}
public void setEmail_Id(String email_Id) {
	this.email_Id = email_Id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDesignation() {
	return Designation;
}
public void setDesignation(String designation) {
	Designation = designation;
}
public int getManager_Id() {
	return manager_Id;
}
public void setManager_Id(int manager_Id) {
	this.manager_Id = manager_Id;
}
public int getEmp_id() {
	return emp_id;
}
public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
@Override
public String toString() {
	return "usersBean [uid=" + uid + ", firstName=" + firstName + ", lastName=" + lastName + ", email_Id=" + email_Id
			+ ", password=" + password + ", Designation=" + Designation + ", manager_Id=" + manager_Id + ", emp_id="
			+ emp_id + ", support_id=" + support_id + ", Active=" + Active + ", dateOfJoining=" + dateOfJoining
			+ ", mobile=" + mobile + "]";
}

}
