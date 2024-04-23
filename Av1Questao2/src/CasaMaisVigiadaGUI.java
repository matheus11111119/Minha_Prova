import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

public class CasaMaisVigiadaGUI {
    private static ArrayList<Jogador> participantes;

    public static void main(String[] args) {

        participantes = new ArrayList<>();
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


        JFrame frame = new JFrame("Votação - Casa Mais Vigiada");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());


        JButton botaoVotar = new JButton("Votar");


        botaoVotar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarVotacao();
            }
        });


        frame.add(botaoVotar);


        frame.setVisible(true);
        System.out.println("Apurar resultados");
    }

    private static void realizarVotacao() {

        String voto;
        do {
            voto = JOptionPane.showInputDialog("Em quem você vota para sair da casa? (Digite 'sair' para encerrar)");
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
                    JOptionPane.showMessageDialog(null, "Participante não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } while (!voto.equalsIgnoreCase("sair"));

        // Determinando o participante mais votado
        Jogador maisVotado = participantes.get(0);
        for (Jogador jogador : participantes) {
            if (jogador.getVotos() > maisVotado.getVotos()) {
                maisVotado = jogador;
            }
        }


        String mensagem = "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir dizer. o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te eliminar com alegria. Com " + maisVotado.getVotos() + " votos, é você quem sai " + maisVotado.getNome();


        String[] frases = mensagem.split("\\.");


        StringBuilder mensagemFinal = new StringBuilder();
        for (String frase : frases) {
            mensagemFinal.append(frase.trim()).append(".\n");
        }

        JOptionPane.showMessageDialog(null, mensagemFinal.toString(), "Eliminação", JOptionPane.INFORMATION_MESSAGE);
    }
}
