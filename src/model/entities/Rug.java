package model.entities;

import java.io.Serializable;

public class Rug implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private double price;

	public Rug() {

	}

	public Rug(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public Rug(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		// return "Tapetes [Tipo=" + name + ", preco=" + String.format("R$
		// %.2f",price)+"]";
		return name + ".";
	}

}
