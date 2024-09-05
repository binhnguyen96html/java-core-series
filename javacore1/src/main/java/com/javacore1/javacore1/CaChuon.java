package com.javacore1.javacore1;

public class CaChuon{
  
  private String colorEye;
  private String colorSkin;

  //default constructor: no parameters
  public CaChuon(){

  } 

  public CaChuon(String colorEye, String colorSkin) {
    this.colorEye = colorEye;
    this.colorSkin = colorSkin;
  }

  public String getColorEye() {
    return this.colorEye;
  }

  public void setColorEye(String colorEye) {
    this.colorEye = colorEye;
  }

  public String getColorSkin() {
    return this.colorSkin;
  }

  public void setColorSkin(String colorSkin) {
    this.colorSkin = colorSkin;
  }

}
