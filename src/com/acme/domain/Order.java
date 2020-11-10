package com.acme.domain;//import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Or;

import com.acme.utils.MyDate;
public class Order {
  private MyDate orderDate;
  private double orderAmount = 0.00;
  private String customer;
  private String product;
  private int quantity;

  public MyDate getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(MyDate orderDate) {
    this.orderDate = orderDate;
  }

  public double getOrderAmount() {
    return orderAmount;
  }

  public void setOrderAmount(double orderAmount) {
    if (orderAmount < 0) {
      System.out.println("Wrong amount");
    } else {
      this.orderAmount = orderAmount;
    }
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    if (quantity > 0) {
      this.quantity = quantity;
    } else {
      System.out.println("quantity has to bigger than zero.");
    }
  }

  public static double getTaxRate() {
    return taxRate;
  }

  public static double taxRate = 0.05;
  public static void setTaxRate(double newRate) {
    taxRate = newRate;
  }
  public static void computeTaxOn(double anAmount) {
    System.out.println("The tax for " + anAmount + " is: " +
        anAmount
            * Order.taxRate);
  }
  public Order(MyDate d, double amt, String c, String p, int q)
  {
    orderDate = d;
    orderAmount = amt;
    customer = c;
    product = p;
    quantity = q;
  }
  public String toString() {
    return quantity + " ea. " + product + " for " + customer;
  }
  public double computeTax() {
    System.out.println("The tax for this order is: " +
        orderAmount
            * Order.taxRate);
    return orderAmount * Order.taxRate;
  }


  public char jobSize() {
    if (quantity <= 25) {
      return 'S';
    } else if (quantity <= 75) {
      return 'M';
    } else if (quantity <= 150) {
      return 'L';
    }
    return 'X';
  }

  public double computeTotal() {
    double total = orderAmount;
    switch (jobSize()) {
      case 'M': total = total - (orderAmount * 0.01);
      break;
      case 'L': total = total - (orderAmount * 0.02);
      break;
      case 'X': total = total - (orderAmount * 0/03);
    }
    if (orderAmount <= 1_500) {
      total = total + computeTax();
    }
    return total;
  }

}
