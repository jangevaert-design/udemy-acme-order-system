package com.acme.testing;

import com.acme.domain.Good;
import com.acme.domain.Good.UnitOfMeasureType;
import com.acme.domain.Order;
import com.acme.domain.Service;
import com.acme.domain.Solid;
import com.acme.utils.MyDate;

public class TestOrders {

  public static void main(String[] args) {
    MyDate date1 = new MyDate(1, 20, 2008);
    Solid s1 = new Solid("Acme Anvil", 1_668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25,
        0.3);
    Order anvil = new Order(date1, 2_000.00, "Wile E Coyote", s1, 10);

    /* Good g = new Good("Acme Earthquake Pills", 1304, 0.15,
        UnitOfMeasureType.CUBIC_FEET, false, 1);
        Since we made Good.java an abstract class we cannot create an instance of Good.java.
        The Good class works as a template for Liquid.java and Solid.java where instances can and
        will be created.
    */

    MyDate date2 = new MyDate(4, 10, 2008);
    Solid s2 = new Solid("Acme Balloon", 1_401, 15, UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
    Order balloons = new Order(date2, 1000.00, "Bugs Bunny", s2, 125);

    System.out.println(anvil);
    System.out.println(balloons);

    System.out.println("The tax Rate is currently: " +
        Order.taxRate);
    Order.computeTaxOn(3000.00);
    anvil.computeTax();
    balloons.computeTax();

    Order.setTaxRate(0.06);
    System.out.println("The tax Rate is currently: " +
        Order.taxRate);
    Order.computeTaxOn(3000.00);
    anvil.computeTax();
    balloons.computeTax();
    System.out.println("The total bill for: " + anvil + " is " +
        anvil.computeTotal());
    System.out.println("The total bill for: " + balloons + " is " + balloons.computeTotal());

    MyDate date3 = new MyDate(4, 10, 2008);
    Service s3 = new Service("Road Runner Eradication", 14, false);
    Order birdEradication = new Order(date3, 20000, "Daffy Duck", s3, 1);
    System.out.println("The total bill for: " + birdEradication
        + " is " + birdEradication.computeTotal());

    Order.setRushable((orderDate, orderAmount) -> orderAmount > 1_500);
    System.out.println("Anvil isPriorityOrder: " + anvil.isPriorityOrder());
    System.out.println("Balloons isPriorityOrder: " + balloons.isPriorityOrder());
  }
}

