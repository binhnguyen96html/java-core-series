package com.javacore1.javacore1;

public class CaChuon extends LopCa {
  
  private String colorEye;
  private String colorSkin;

  //default constructor: no parameters
  public CaChuon(){

  }


  public CaChuon(String colorEye, String colorSkin, String colorEyeParent, String colorSkinParent){
    this.colorEye = colorEye;
    this.colorSkin = colorSkin;
    super.colorEye = colorEyeParent;
    super.colorSkin = colorSkinParent;
  }


  public String getColorEye() {
    return "Children: " + this.colorEye + " , Parent: " + super.colorEye;
  }

  public String getColorSkin() {
    return this.colorSkin;
  }


}
