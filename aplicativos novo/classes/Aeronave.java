package aplicativos.classes;

public class Aeronave {

  private String modelo;
  private String categoria;
  private Pilotos piloto;

  public Aeronave() {
  }

  public Aeronave(String modelo, String categoria, Pilotos piloto) {
    this.modelo = modelo;
    this.categoria = categoria;
    this.piloto = piloto;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public Pilotos getPiloto() {
    return piloto;
  }

  public void setPiloto(Pilotos piloto) {
    this.piloto = piloto;
  }

}
