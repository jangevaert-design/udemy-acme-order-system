//import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Or;

public class Order {
  MyDate orderDate;
  double orderAmount = 0.00;
  String customer;
  String product;
  int quantity;

  static double taxRate = 0.05;

  public Order(MyDate d, double amt, String c, String p, int q){
    orderDate=d;
    orderAmount=amt;
    customer=c;
    product=p;
    quantity=q;
  }

  public double computeTax() {
    System.out.println("The tax for this order is: " + orderAmount*Order.taxRate);
    return orderAmount*Order.taxRate;
  }

  public static void setTaxRate(double newRate) {
    taxRate = newRate;
  }

  public static void computeTaxOn(double anAmount) {
    System.out.println("The tax for " +anAmount + " is: " + anAmount*Order.taxRate);
  }

  public String toString(){
    return quantity + " ea. " + product + " for " + customer;
  }

}
