package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
  public static void main(String[] args) {
    // MÉDOTO USANDO PARA SELECIONAR OS SALÁRIOS
    analisarCandidato(1900.0);
    analisarCandidato(2200.0);
    analisarCandidato(2000);
    // MÉDOTO USANDO PARA SELECIONAR A VAGA
    selecaoCandidatos();
    // MÉDOTO USADO PARA IMPRIMIR OS CADIDATOS SELECIONADOS
    imprimirSelecionados();
    // MÉTODO USANDO PARA FAZER CONTATO VIA TELEFONE
    String[] candidatos = { "Lavínia", "Paulo", "Beatriz", "Leticia", "Carlos" };

    for (String candidato : candidatos) {
      entrandoEmContato(candidato);
    }
  }

  static void entrandoEmContato(String candidato) {
    int tentativasRealizadas = 1;
    boolean continuarTentando = true;
    boolean atendeu = false;

    do {
      atendeu = atender();
      continuarTentando = !atendeu;

      if (continuarTentando) {
        tentativasRealizadas++;
      } else {
        System.out.println("CONTATO REALIZADO COM SUCESSO!");
      }
    } while (continuarTentando && tentativasRealizadas < 3);

    if (atendeu) {
      System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
    } else {
      System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MAXIMA DE TENTATIVAS " + tentativasRealizadas);
    }

  }

  static boolean atender() {
    return new Random().nextInt(3) == 1;
  }

  static double valorPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800, 2200);
  }

  static void selecaoCandidatos() {
    String[] candidatos = { "Lavínia", "Paulo", "Beatriz", "Leticia", "Carlos", "Igor", "Mayara", "Nicoly", "Ana",
        "Júlia" };

    int candidatosSelecionados = 0;
    int candidatosAtual = 0;
    double salarioBase = 2000.0;

    while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
      String candidato = candidatos[candidatosAtual];
      double salarioPretendido = valorPretendido();

      System.out.println("O canditato " + candidato + " solicitou " + salarioPretendido);

      if (salarioBase > salarioPretendido) {
        System.out.println("O canditato " + candidato + " foi selecionado para a vaga");
        candidatosSelecionados++;
      } else if (salarioBase < salarioPretendido) {
        System.out.println("O canditato " + candidato + " não foi selecionado para a vaga");
      }
      candidatosAtual++;
    }

  }

  static void imprimirSelecionados() {
    String[] candidatos = { "Lavínia", "Paulo", "Beatriz", "Leticia", "Carlos" };

    System.out.println("Impimindo a lista de selecionados com indice");

    for (int indice = 0; indice < candidatos.length; indice++) {
      System.out.println("O candidato de nº " + (indice + 1) + " é " + candidatos[indice]);
    }

    System.out.println("Imprimindo a lista de selecionados na forma mais simples:");
    for (String candidato : candidatos) {
      System.out.println("O candidato selecionado foi " + candidato);
    }
  }

  static void analisarCandidato(double salarioPrentendido) {
    double salarioBase = 2000.0;
    if (salarioBase > salarioPrentendido) {
      System.out.println("LIGAR PARA O CANDIDATO");
    } else if (salarioBase == salarioPrentendido) {
      System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
    } else {
      System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
    }
  }
}
