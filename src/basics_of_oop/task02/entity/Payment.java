package basics_of_oop.task02.entity;

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
}