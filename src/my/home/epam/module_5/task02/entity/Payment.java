package my.home.epam.module_5.task02.entity;

import java.util.List;

/*
 * Задача 2. Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */

public class Payment {
    private List<Product> listOfProducts;
    private double totalAmount;

    public Payment() {
	super();
    }

    public Payment(List<Product> listOfProducts, double totalAmount) {
	super();
	this.listOfProducts = listOfProducts;
	this.totalAmount = totalAmount;
    }

    public List<Product> getListOfProducts() {
	return listOfProducts;
    }

    public void setListOfProducts(List<Product> listOfProducts) {
	this.listOfProducts = listOfProducts;
    }

    public double getTotalAmount() {
	return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((listOfProducts == null) ? 0 : listOfProducts.hashCode());
	long temp;
	temp = Double.doubleToLongBits(totalAmount);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Payment other = (Payment) obj;
	if (listOfProducts == null) {
	    if (other.listOfProducts != null)
		return false;
	} else if (!listOfProducts.equals(other.listOfProducts))
	    return false;
	if (Double.doubleToLongBits(totalAmount) != Double.doubleToLongBits(other.totalAmount))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Payment [listOfProducts=" + listOfProducts + ", totalAmount=" + totalAmount + "]";
    }

    
    public static class Product {
	private String name;
	private double price;

	public Product(String name, double price) {
	    super();
	    this.name = name;
	    this.price = price;
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
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((name == null) ? 0 : name.hashCode());
	    long temp;
	    temp = Double.doubleToLongBits(price);
	    result = prime * result + (int) (temp ^ (temp >>> 32));
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    Product other = (Product) obj;
	    if (name == null) {
		if (other.name != null)
		    return false;
	    } else if (!name.equals(other.name))
		return false;
	    if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
		return false;
	    return true;
	}

	@Override
	public String toString() {
	    return "Product [name=" + name + ", price=" + price + "]";
	}
    }
}