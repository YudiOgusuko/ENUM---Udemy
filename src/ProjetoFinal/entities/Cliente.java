package ProjetoFinal.entities;

import java.text.ParseException;
import java.util.Date;

public class Cliente {

    private String nome;
    private String email;
    private Date data_Nascimento;

    public Cliente(){
    }

    public Cliente(String nome, String email, Date data_Nascimento){
        this.nome = nome;
        this.email = email;
        this.data_Nascimento = data_Nascimento;
    }

    public String getNome() {return this.nome;}
    public String getEmail() {return this.email;}
    public Date getData_Nascimento() throws ParseException {return data_Nascimento;}

    public void setNome(String nome) {this.nome = nome;}
    public void setEmail(String email) {this.email = email;}
    public void setData_Nascimento(Date data_Nascimento) {this.data_Nascimento = data_Nascimento;}
}
