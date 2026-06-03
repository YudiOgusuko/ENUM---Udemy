package ProjetoFinal;

import ProjetoFinal.entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static void main() throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Dados do Cliente>>>");

        System.out.print("Nome: ");
        String nome = scanner.nextLine().strip();

        System.out.print("E-mail: ");
        String email = scanner.nextLine().strip();
        verificaremail(scanner, email);

        System.out.print("Data de Nascimento (DD/MM/YYYY): ");
        Date data = simple.parse(scanner.next());

        System.out.println("Dados do Pedido>>>");
        System.out.print("Status: ");
        String statusteste = scanner.next();
        StatusPedido status= StatusPedido.statusPedido(scanner, statusteste);

        int quantidade_itens = leiaint("Quantos itens foi pedido: ");

        String produto_nome = "";
        double preco = 0;
        int quantidades = 0;

        Cliente cliente = new Cliente(nome, email, data);
        Pedido pedido = new Pedido(cliente, status);

        for(int i=0; i<quantidade_itens; i++){
            System.out.println("Dados do Item #"+(i+1)+" >>>");

            System.out.print("Produto: ");
            scanner.nextLine();
            produto_nome = scanner.nextLine().strip();

            System.out.print("Preço: ");
            preco = scanner.nextDouble();

            quantidades = leiaint("Quantidades: ");

            Produto produto = new Produto(produto_nome, preco);
            ItemPedido itemPedido = new ItemPedido(quantidades, preco, produto);
            pedido.adicionarItem(itemPedido);
        }

        System.out.println(pedido);

    }

    public static String verificaremail(Scanner scanner, String txt){
        String email = txt.strip();

        while(!email.matches("^[^@\\s]+@gmail\\.com$")){
            System.out.println("É necessário '@gmail.com'");
            System.out.print("E-mail: ");
            email = scanner.nextLine().strip();
        }
        return email;
    }

    public static int leiaint(String msg){
        Scanner scanner = new Scanner(System.in);
        boolean ok = false;
        int valor = 0;
        while(!ok){
            System.out.print(msg);
            String entrada = scanner.next().strip();
            try{
                valor = Integer.parseInt(entrada);
                ok = true;
            } catch (NumberFormatException e){
                System.out.println("Valor Inválido. Tente Novamente");
            }
        }
        return valor;
    }
}
