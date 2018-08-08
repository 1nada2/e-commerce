package com.Whitecape.e_commerce.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity	
@Table(name = "providers")
@Getter @Setter
@NoArgsConstructor
@ToString
public class Provider extends User{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id ;
@OneToMany(cascade = CascadeType.ALL,
fetch = FetchType.LAZY,
mappedBy = "provider")
private Set<Shop> shops = new HashSet<>();

}
