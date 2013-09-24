package ic.tcc00175.biblioteca.controller;
// Generated Sep 19, 2013 8:00:03 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;

/**
 * Revista generated by hbm2java
 */
public class Revista  implements java.io.Serializable {


     private long materialCodigo;
     private Material material;
     private BigDecimal numero;
     private BigDecimal mes;
     private BigDecimal ano;

    public Revista() {
    }

	
    public Revista(long materialCodigo, Material material) {
        this.materialCodigo = materialCodigo;
        this.material = material;
    }
    public Revista(long materialCodigo, Material material, BigDecimal numero, BigDecimal mes, BigDecimal ano) {
       this.materialCodigo = materialCodigo;
       this.material = material;
       this.numero = numero;
       this.mes = mes;
       this.ano = ano;
    }
   
    public long getMaterialCodigo() {
        return this.materialCodigo;
    }
    
    public void setMaterialCodigo(long materialCodigo) {
        this.materialCodigo = materialCodigo;
    }
    public Material getMaterial() {
        return this.material;
    }
    
    public void setMaterial(Material material) {
        this.material = material;
    }
    public BigDecimal getNumero() {
        return this.numero;
    }
    
    public void setNumero(BigDecimal numero) {
        this.numero = numero;
    }
    public BigDecimal getMes() {
        return this.mes;
    }
    
    public void setMes(BigDecimal mes) {
        this.mes = mes;
    }
    public BigDecimal getAno() {
        return this.ano;
    }
    
    public void setAno(BigDecimal ano) {
        this.ano = ano;
    }




}

