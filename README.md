# Teste Prático - Iniflex

Projeto desenvolvido para o teste prático de programação.

## Sobre o projeto

O objetivo é gerenciar uma lista de funcionários de uma indústria, realizando manipulações, cálculos e formatações com base nos requisitos solicitados:

1. Classe `Pessoa` contendo nome (`String`) e data de nascimento (`LocalDate`).
2. Classe `Funcionario` herdando de `Pessoa`, com salário (`BigDecimal`) e função (`String`).
3. Classe `Principal` executando as ações:
   - Inserção dos funcionários da tabela original.
   - Remoção do funcionário "João".
   - Impressão formatada (data em `dd/mm/aaaa` e valores com ponto no milhar e vírgula no decimal).
   - Aplicação de 10% de aumento no salário.
   - Agrupamento dos funcionários por função utilizando `Map`.
   - Impressão dos funcionários agrupados por função.
   - Filtragem dos aniversariantes dos meses 10 e 12.
   - Identificação do funcionário mais velho (exibindo nome e idade).
   - Ordenação da lista por ordem alfabética.
   - Cálculo e exibição da soma total dos salários.
   - Cálculo de quantos salários mínimos cada funcionário recebe (considerando R$ 1.212,00).

## Como executar

Necessário ter o Java 17 (ou superior) instalado.

Pelo terminal, na raiz do projeto:

```bash
javac -d bin -cp src src/Principal.java
java -cp bin Principal
```

Ou abra o projeto em sua IDE (VS Code, Eclipse, IntelliJ) e execute a classe `Principal.java`.
