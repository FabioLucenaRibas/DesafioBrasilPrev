package com.brasilprev.desafio.dto;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Client {

	@Id
	@NotBlank(message = "{cpf.not.blank}")
	private String cpf;
	
	@NotBlank(message = "{name.not.blank}")
	private String name;
	
	@NotBlank(message = "{address.not.blank}")
	private String address;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Client)) {
			return false;
		}
		Client castOther = (Client) other;
		return Objects.equals(cpf, castOther.cpf) && Objects.equals(name, castOther.name)
				&& Objects.equals(address, castOther.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, name, address);
	}

}
