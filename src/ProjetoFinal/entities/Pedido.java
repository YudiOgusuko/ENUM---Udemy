package ProjetoFinal.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    public final static SimpleDateFormat nascimento = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat momento_pedido = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date data = new Date();

    private Date momento;
    private StatusPedido status;
    private Cliente cliente;

    private final List<ItemPedido> itemPedidoList = new ArrayList<>();


    public Pedido(){
    }
    public Pedido(Cliente cliente, StatusPedido status){
        this.cliente = cliente;
        this.status = status;
        this.momento = data;
    }

    public void adicionarItem(ItemPedido itemPedido){
        itemPedidoList.add(itemPedido);
    }

    public void removerItem(ItemPedido itemPedido){
        itemPedidoList.remove(itemPedido);
    }

    public double total(){
        double soma = 0;
        for(ItemPedido itens: itemPedidoList){
            soma += itens.sub_Total();
        }
        return soma;
    }

    public Date getMomento() {return this.momento;}
    public StatusPedido getStatus() {return this.status;}
    public Cliente getCliente() {return this.cliente;}
    public List<ItemPedido> getItemPedidoList() {return itemPedidoList;}

    public void setMomento(Date momento) {this.momento = momento;}
    public void setStatus(StatusPedido status) {this.status = status;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nSumário do Pedido>>> \n");
        sb.append("Momento do Pedido: "+momento_pedido.format(momento)+"\n");
        sb.append("Status do Pedido: "+this.getStatus()+"\n");
        try {
            sb.append("Cliente: "+cliente.getNome()+" ("+nascimento.format(getCliente().getData_Nascimento())+")"+" - "+cliente.getEmail()+"\n");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        sb.append("Item(s) Pedido(s):\n");
        for(ItemPedido itens: itemPedidoList){
            sb.append("Produto: "+itens.getProduto().getNome_produto()+", Preço: R$"+String.format("%.2f",itens.getPreco())+
                    ", Quantidade(s): "+itens.getQuantidade()+", SubTotal: R$"+String.format("%.2f", itens.sub_Total())+"\n");
        }
        sb.append("Valor Total: R$"+String.format("%.2f", this.total()));

        return sb.toString();
    }
}
