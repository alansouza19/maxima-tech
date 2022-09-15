package tech.solutio.teste.dto;

import javax.validation.constraints.NotNull;

public class ProdutosDto {
    @NotNull
    private String nome;
    @NotNull
    private String fornecedor;
    @NotNull
    private Double valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
