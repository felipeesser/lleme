/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.convertecor;

/**
 *
 * @author Luiz Leme
 */
public class RGB extends Cor {

  private int r, g, b;

  public RGB(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }
  public RGB(){}
  
  public CMYK toCMYK(){
  return null;
  }

  /**
   * @return the r
   */
  public int getR() {
    return r;
  }

  /**
   * @param r the r to set
   */
  public void setR(int r) {
    this.r = r;
  }

  /**
   * @return the g
   */
  public int getG() {
    return g;
  }

  /**
   * @param g the g to set
   */
  public void setG(int g) {
    this.g = g;
  }

  /**
   * @return the b
   */
  public int getB() {
    return b;
  }

  /**
   * @param b the b to set
   */
  public void setB(int b) {
    this.b = b;
  }

  @Override
  public Cor converte(Cor c) {
  
    return null;
  }
}
