package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Assets")
public class AssetsBean {
@Id
@GeneratedValue
//@Column(name="Assets Id")
int asst_id;
//@Column(name="Assets Name")
String asst_name;
int status;
public int getAsst_id() {
	return asst_id;
}
public void setAsst_id(int asst_id) {
	this.asst_id = asst_id;
}
public String getAsst_name() {
	return asst_name;
}
public void setAsst_name(String asst_name) {
	this.asst_name = asst_name;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
}
