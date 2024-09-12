public class Rectangulo {
    public Double base;
    public Double altura;

    public Rectangulo(Double base, Double altura) {
        this.altura=altura;
     this.base = base;
 }
 public Double Calculararea() {
        return (this.base*this.altura)*2;
 }
 public Double Calcularperimetro() {
        return (this.base+this.altura)*2;
 }
 public Double Calculararea(Double base, Double altura) {
        return (base * altura);
 }
public Double Calcularperimetro(Double base, Double altura) {
        return (base + altura)*2;
}
public Double Calculararea(Double base) {
        return (base * this.altura);
}
public Double Calcularperimetro(Double base) {
        return (base + this.altura)*2;
}
}