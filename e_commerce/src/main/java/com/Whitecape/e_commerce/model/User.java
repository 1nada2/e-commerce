package com.Whitecape.e_commerce.model;

/*import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity	
@Table(name = "user")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable, UserDetails {
	public static enum Role{ USER }
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
@Column(name = "Username", nullable = false)
private String username;
@Column(name = "email", nullable = false)
private String email;
@Column(name = "password", nullable = false)
private String password;
@Column(unique = true)
private String cin;
@Column
private String Adresse;
@Column
private Date DateOfBirth;
@Temporal(TemporalType.TIMESTAMP)
@Column
private String phone;
@Column
private String PostalCode;
@OneToMany(cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "user")
private Set<Order> orders = new HashSet<>();
@OneToOne(fetch = FetchType.LAZY,
        cascade =  CascadeType.ALL,
        mappedBy = "user")
private Basket basket;
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
private Collection<Role> roles;
public void setRoles(String string) {
	// TODO Auto-generated method stub
	
}
private String  role;
@JsonIgnore
@Override
public boolean isEnabled() {
	return true;
}

@JsonIgnore
@Override
public boolean isCredentialsNonExpired() {
	return true;
}

@JsonIgnore
@Override
public boolean isAccountNonLocked() {
	return true;
}

@JsonIgnore
@Override
public boolean isAccountNonExpired() {
	return true;
}

@JsonIgnore
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	Collection<GrantedAuthority> authorities = new ArrayList<>();
	authorities.add(new SimpleGrantedAuthority(role));
	return authorities;
}

public User(String username, String email, String password) {
	super();
	this.username = username;
	this.email = email;
	this.password = password;
}




}
*/
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="User")
@Scope("session")
public  class User implements UserDetails{
	public static enum Role{ USER }
	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;
	/**
	 * Description of the property email.
	 */
	@Column(unique = true)
	private String username ;
	/**
	 * Description of the property password.
	 */
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password ;
	/**
	 * Description of the property role , to grant authority to the user .
	 */
    private String  role;
    /**
	 * Description of the property full name.
	 */
    private String fullName;

    public User(){
    	
    }
    
    public User(String username,String password,String fullName){
    	this.username=username;
    	this.password= password;
    	this.fullName=fullName;
    }
	public User(String dBuserName, String password2, List<GrantedAuthority> asList) {
		// TODO Auto-generated constructor stub
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role +
				 ",]";
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getId() {
		return id;
	}
	
	
	
}