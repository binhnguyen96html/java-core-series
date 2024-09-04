package com.javacore1.javacore1;

public class LopCa {

  protected String colorEye;
  protected String colorSkin;

  // Tinh da hinh - polymorphism: trong 1 class co nhieu method cung ten nhung
  // tham so se khac nhau => overloading
  protected void boi() {
    System.out.println("ca nao ma cha biet boi");
  }

  protected void boi(String style) {
    System.out.println(style);
  }

  public String getColorEye() {
    return colorEye;
  }

  public String getColorSkin() {
    return colorSkin;
  }

}
