import java.util.ArrayList;
import java.util.Scanner;

class Jogador {
    private String nome;
    private int votos;

    public Jogador(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }

    public void incrementaUmVoto() {
        this.votos++;
    }
}

public class CasaMaisVigiada {

    public static void main(String[] args) {
        ArrayList<Jogador> participantes = new ArrayList<>();
        participantes.add(new Jogador("Alane Dias"));
        participantes.add(new Jogador("Beatriz Reis"));
        participantes.add(new Jogador("Davi Brito"));
        participantes.add(new Jogador("Deniziane Ferreira"));
        participantes.add(new Jogador("Fernanda Bande"));
        participantes.add(new Jogador("Giovanna Lima"));
        participantes.add(new Jogador("Giovanna Pitel"));
        participantes.add(new Jogador("Isabelle Nogueira"));
        participantes.add(new Jogador("Juninho"));
        participantes.add(new Jogador("Leidy Elin"));
        participantes.add(new Jogador("Lucas Henrique"));
        participantes.add(new Jogador("Lucas Luigi"));
        participantes.add(new Jogador("Lucas Pizzane"));
        participantes.add(new Jogador("Marcos Vinicius"));
        participantes.add(new Jogador("Matteus Amaral"));
        participantes.add(new Jogador("Maycon Cosmer"));
        participantes.add(new Jogador("MC Bin Laden"));
        participantes.add(new Jogador("Michael Nogueira"));
        participantes.add(new Jogador("Nizam"));
        participantes.add(new Jogador("Raquel Cardozo"));
        participantes.add(new Jogador("Rodriguinho"));
        participantes.add(new Jogador("Thalyta Alvez"));
        participantes.add(new Jogador("Vanessa Lopez"));
        participantes.add(new Jogador("Vinicius Rodrigues"));
        participantes.add(new Jogador("Wanessa Camargo"));
        participantes.add(new Jogador("Yasmim Brunette"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Votação iniciada. Digite o nome do participante para votar ou 'sair' para encerrar:");
        String voto;
        do {
            System.out.print("Em quem você vota para sair da casa? ");
            voto = scanner.nextLine();
            if (!voto.equalsIgnoreCase("sair")) {
                boolean encontrado = false;
                for (Jogador jogador : participantes) {
                    if (jogador.getNome().equalsIgnoreCase(voto)) {
                        jogador.incrementaUmVoto();
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Participante não encontrado!");
                }
            }
        } while (!voto.equalsIgnoreCase("sair"));
        Jogador maisVotado = participantes.get(0);
        for (Jogador jogador : participantes) {
            if (jogador.getVotos() > maisVotado.getVotos()) {
                maisVotado = jogador;
            }
        }

        System.out.println("Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te eliminar com alegria. Com " + maisVotado.getVotos() + " votos, é você quem sai " + maisVotado.getNome());
    }
}
