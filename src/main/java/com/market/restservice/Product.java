package com.market.restservice;

public record Product() {

  public static String name = "";
  public static long price = 0;


  public String getName() {
    return name;
  }

  public String setName(String newName) {
    return name = newName;
  }

  public long getPrice() {
    return price;
  }

  public long setPrice(long newPrice) {
    return price = newPrice;
  }
}
