package edu.test;

public class Todo {
  private Long id;
  private String beschrijving;
  private Long status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBeschrijving() {
    return beschrijving;
  }

  public void setBeschrijving(String beschrijving) {
    this.beschrijving = beschrijving;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }
}
