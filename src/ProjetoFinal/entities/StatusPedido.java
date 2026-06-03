package ProjetoFinal.entities;

import java.util.Scanner;

public enum StatusPedido {

    PAGAMENTO_PENDENTE("Pendente"),
    PROCESSANDO("Processando"),
    PEDIDO_ENVIADO("Enviado"),
    PEDIDO_ENTREGUE("Entregue");

    private String valor;

    StatusPedido(String valor){
        this.valor = valor;
    }

    public static StatusPedido statusPedido(Scanner scanner, String status){
        String verificandostatus = status;
        while (true){
            for(StatusPedido statusPedido: values()){
                if(statusPedido.getValor().equalsIgnoreCase(verificandostatus)){
                    return statusPedido;
                }
            }
            System.out.println("Status Inválido");
            System.out.print("Status: ");
            verificandostatus = scanner.next();
        }
    }


    public String getValor() {
        return valor;
    }
}
