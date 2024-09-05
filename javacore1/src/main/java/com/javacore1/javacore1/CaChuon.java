package com.javacore1.javacore1;

public class CaChuon extends LopCa {
  
  private String colorEye;
  private String colorSkin;

  //default constructor: no parameters
  public CaChuon(){

  } 

  public String getColorEye() {
    return this.colorEye;
  }

  public String getColorSkin() {
    return this.colorSkin;
  }


    // Overriding 
    @Override
    public void boi(){
      System.out.println("Ca Chuon boi theo kieu cua Ca Chuon");
    }
}
