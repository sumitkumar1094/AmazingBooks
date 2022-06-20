package com.amazingbooks.customer.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.amazingbooks.customer.model.Customer;

public class CustomerDetailsImpl implements UserDetails {

	private Integer id;
	private String emailId;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	public CustomerDetailsImpl(Customer customer, List<GrantedAuthority> authorities) {
		super();
		this.id = customer.getId();
		this.emailId = customer.getEmailId();
		this.password = customer.getPassword();
		this.authorities = authorities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return emailId;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public static CustomerDetailsImpl build(Customer customer) {
		List<GrantedAuthority> authorities = customer.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
		return new CustomerDetailsImpl(customer, authorities);
	}
}
