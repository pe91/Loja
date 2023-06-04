import java.sql.*;
import java.text.*;
import java.util.*;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, ParseException, ClassNotFoundException {
        int mode = 0;
        System.out.println("Digite 1 para modo de adm ou 2 para modo de usuario");
        mode = Integer.parseInt(in.nextLine());
        if (mode == 1)
            adm();
        else
            usr();
    }

    public static void usr() throws SQLException, ParseException, ClassNotFoundException {
        Usuario u = new Usuario();
        Connection connection = new Connect().getConnection();
        int escolha = -1;
        JogoController jg = new JogoController();
        DesenvolvedorController dv = new DesenvolvedorController();
        UsuarioController us = new UsuarioController();
        while (true) {
            u = us.login(connection);
            if (u == null)
                System.out.println("Erro ao fazer login");
            else {
                while (true) {
                    System.out.println("Digite:\n0 para sair\t1 para listar os jogos do catalogo\n"
                            + "2 para listar os jogos de um desenvolvedor\t3 para comprar um jogo\n"
                            + "4 para mostrar sua biblioteca\t5 para escrever uma avaliacao\n"
                            + "6 para mostrar todas as avaliacoes e a nota media de um jogo");
                    escolha = Integer.parseInt(in.nextLine());
                    switch (escolha) {
                        case 0:
                            return;
                        case 1:
                            jg.listarJogos(connection);
                            break;
                        case 2:
                            dv.listarItens(connection);
                            jg.listarDosDesenvolvedores(connection);
                            break;
                        case 3:
                            jg.listarJogos(connection);
                            us.comprar(connection, u.getId());
                            break;
                        case 4:
                            jg.listarDoUsuario(connection, u.getId());
                            break;
                        case 5:
                            jg.listarDoUsuario(connection, u.getId());
                            us.avaliar(connection, u.getId());
                            break;
                        case 6:
                            jg.listarJogos(connection);
                            us.mostrarAvaliacoes(connection);
                            break;
                        default:
                            System.out.println("Opcao invalida");
                    }
                }
            }

        }

    }

    public static void adm() throws SQLException, ParseException, ClassNotFoundException {
        Connection connection = new Connect().getConnection();
        int escolha = -1;
        JogoController jg = new JogoController();
        DesenvolvedorController dv = new DesenvolvedorController();
        UsuarioController us = new UsuarioController();
        while (true) {
            System.out.println("Digite:\n0 para sair\t1 para cadastrar um desenvolvedor\n"
                    + "2 para cadastrar um jogo\t3 para cadastrar um Usuario\n"
                    + "4 para listar todos os desenvolvedores\t5 para listar todos os jogos\n"
                    + "6 para listar todos os usuarios");
            escolha = Integer.parseInt(in.nextLine());
            switch (escolha) {
                case 0:
                    return;
                case 1:
                    dv.createDesenvolvedor(connection);
                    break;
                case 2:
                    dv.listarItens(connection);
                    jg.createjogo(connection);
                    break;
                case 3:
                    us.createUsuario(connection);
                    break;
                case 4:
                    dv.listarItens(connection);
                    break;
                case 5:
                    jg.listarJogos(connection);
                    break;
                case 6:
                    us.listarItens(connection);
                    break;
                default:
                    System.out.println("opcao invalida");
                    break;
            }
        }
    }
}
