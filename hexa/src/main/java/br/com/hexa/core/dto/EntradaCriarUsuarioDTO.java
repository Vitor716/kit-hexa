package br.com.hexa.core.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "usuario")
public class EntradaCriarUsuarioDTO {

    @Id
    @GeneratedValue
    private Integer id;

    private String primeiroNome;

    private String ultimoNome;

    public EntradaCriarUsuarioDTO() {
    }

    public EntradaCriarUsuarioDTO(Integer id, String primeiroNome, String ultimoNome) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }
}
