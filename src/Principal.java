import model.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;
import java.time.Period;
import java.util.Comparator;
import java.math.RoundingMode;

public class Principal {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();

        // REQUISITO 3.1: Inserir os funcionários

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // REQUISITO 3.2: Remover o funcionário "João"

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().equals("João")) {
                funcionarios.remove(i);
                break;
            }
        }

        // REQUISITO 3.3: Imprimir a lista formatada

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat formatadorSalario = new DecimalFormat("#,##0.00",
                new DecimalFormatSymbols(new Locale("pt", "BR")));

        System.out.println("--- Lista de funcionários ---");
        for (Funcionario f : funcionarios) {
            System.out.println(("Nome: " + f.getNome()) +
                    " |  Data de Nascimento: " + f.getDataNascimento().format(formatter) +
                    " |  Salário: R$ " + formatadorSalario.format(f.getSalario()) +
                    " |  Função: " + f.getFuncao());
        }

        // REQUISITO 3.4: Aumento de 10% no salário

        for (Funcionario f : funcionarios) {
            BigDecimal novoSalario = f.getSalario().multiply(new BigDecimal("1.10"));
            f.setSalario(novoSalario);
        }

        // REQUISITO 3.5: Agrupar funcionários por função

        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

        for (Funcionario f : funcionarios) {
            String funcao = f.getFuncao();
            if (!funcionariosPorFuncao.containsKey(funcao)) {
                funcionariosPorFuncao.put(funcao, new ArrayList<>());
            }

            funcionariosPorFuncao.get(funcao).add(f);
        }

        // REQUISITO 3.6: Imprimir a lista agrupada por função

        System.out.println("\n--- Funcionários agrupados por função ---");
        for (String funcao : funcionariosPorFuncao.keySet()) {
            System.out.println("\nFunção: " + funcao);
            for (Funcionario f : funcionariosPorFuncao.get(funcao)) {
                System.out.println("  - " + f.getNome() + " | Salário: R$ " + formatadorSalario.format(f.getSalario()));
            }
        }

        // REQUISITO 3.7: NÃO MENCIONADO NO ENUNCIADO

        // REQUISITO 3.8: Aniversariantes dos meses 10 e 12.

        System.out.println("\n--- Aniversariantes de Outubro (10) e Dezembro (12) ---");
        for (Funcionario f : funcionarios) {
            int mes = f.getDataNascimento().getMonthValue();
            if (mes == 10 || mes == 12) {
                System.out.println(
                        "Nome: " + f.getNome() + " | Data de nascimento: " + f.getDataNascimento().format(formatter));
            }
        }

        // REQUISITO 3.9: Imprimir o funcionario com a maior idade, exibindo nome e idade.

        Funcionario maisVelho = funcionarios.get(0);

        for (Funcionario f : funcionarios) {
            if (f.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = f;
            }
        }
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();

        System.out.println("\n--- Funcionário mais velho ---");
        System.out.println("Nome: " + maisVelho.getNome() + " | Idade: " + idade + " anos");

        // REQUISITO 3.10: Imprimir lista de funcionarios por ordem alfabética.

        funcionarios.sort(Comparator.comparing(Funcionario::getNome));

        System.out.println("\n--- Funcionários por ordem alfabética ---");
        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome() +
                    " | Data de Nascimento: " + f.getDataNascimento().format(formatter) +
                    " | Salário: R$ " + formatadorSalario.format(f.getSalario()) +
                    " | Função: " + f.getFuncao());
        }

        // REQUISITO 3.11: Imprimir o total dos salários dos funcionários 

        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            totalSalarios = totalSalarios.add(f.getSalario());
        }

        System.out.println("\n--- Total dos salários ---");
        System.out.println("Total: R$ " + formatadorSalario.format(totalSalarios));

        // REQUISITO 3.12: Quantidade de salários mínimos

        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        
        System.out.println("\n--- Quantidade de salários mínimos ---");
        for (Funcionario f : funcionarios) {
            BigDecimal qtdSalarios = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtdSalarios + " salários mínimos.");
        }
    }
}