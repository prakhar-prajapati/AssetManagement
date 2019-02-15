package bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Request")
public class RequestBean {
@Id
@GeneratedValue
int request_id;
int emp_id,manger_id,Status,asst_id;

String asset_name;
Date managerApprovedDate;
String requestDate;

public int getAsst_id() {
	return asst_id;
}
public void setAsst_id(int asst_id) {
	this.asst_id = asst_id;
}

public int getRequest_id() {
	return request_id;
}
public void setRequest_id(int request_id) {
	this.request_id = request_id;
}
public int getEmp_id() {
	return emp_id;
}
public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}
public int getManger_id() {
	return manger_id;
}
public void setManger_id(int manger_id) {
	this.manger_id = manger_id;
}
public int getStatus() {
	return Status;
}
public void setStatus(int status) {
	Status = status;
}
public String getAsset_name() {
	return asset_name;
}
public String getRequestDate() {
	return requestDate;
}
public void setRequestDate(String requestDate) {
	this.requestDate = requestDate;
}
public void setAsset_name(String asset_name) {
	this.asset_name = asset_name;
}

public Date getManagerApprovedDate() {
	return managerApprovedDate;
}
public void setManagerApprovedDate(Date managerApprovedDate) {
	this.managerApprovedDate = managerApprovedDate;
}
}
