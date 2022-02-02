package aplicativos.classes;

public class Pilotos extends Pessoa {

  private String breve;
  private String matricula;
  private Aeronave aeronave;

  public Pilotos() {
  }

  public Pilotos(String nome, String cpf, String breve, String matricula, Aeronave aeronave) {
    super(nome, cpf);
    this.breve = breve;
    this.matricula = matricula;
    this.aeronave = aeronave;
  }

  public String getBreve() {
    return breve;
  }

  public void setBreve(String breve) {
    this.breve = breve;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public Aeronave getAeronave() {
    return aeronave;
  }

  public void setAeronave(Aeronave aeronave) {
    this.aeronave = aeronave;
  }

}
