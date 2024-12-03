package bcc.ifsuldeminas.sistemaDeTelefonia.model.entities.pessoal;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ClientePessoaJuridica")
public class ClientePessoaJuridica extends Cliente{
    private String cnpj;

    public ClientePessoaJuridica() {}

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
