package com.Whitecape.e_commerce.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;


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
public class User implements Serializable {
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
@Column(name = "created_at", nullable = false, updatable = false)
@CreatedDate
private Date created_at;
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



}
