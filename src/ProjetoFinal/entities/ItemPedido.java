package ProjetoFinal.entities;

public class ItemPedido {

    private Integer quantidade;
    private Double preco;
    private Produto produto;

    public ItemPedido(){
    }

    public ItemPedido(Integer quantidade, Double preco, Produto produto){
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
    }

    public double sub_Total(){
        return this.quantidade * this.preco;
    }

    public Integer getQuantidade() {return this.quantidade;}
    public Double getPreco() {return this.preco;}
    public Produto getProduto() {return this.produto;}

    public void setQuantidade(Integer quantidade) {this.quantidade = quantidade;}
    public void setPreco(Double preco) {this.preco = preco;}
    public void setProduto(Produto produto) {this.produto = produto;}
}
