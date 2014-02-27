package liang.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_user")
public class User {
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
	private Integer id;
    @Column(name = "userName", unique = true, nullable = false, updatable = true,length=40)
	private String userName;
    @Column(name = "password", unique = false, nullable = false, updatable = true,length=40)
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
