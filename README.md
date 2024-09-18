# Entendendo Algoritmos

Este repositório visa guardar todos os códigos referentes a série Entendendo Algoritmos, onde a idéia é revisar nosso conhecimento de algoritmos, e ele vai crescendo conforme a gente vai avançando nas implementações de código para os mais diferentes cenários.

# Ordenação (Sort)

- https://deviniciative.wordpress.com/2022/10/14/entendendo-algoritmos-de-ordenacao-sort/

# Busca (Search)
- https://deviniciative.wordpress.com/2022/11/11/entendendo-algoritmos-de-busca-search/

# PageRank 
- https://deviniciative.wordpress.com/2022/12/19/entendendo-algoritmos-conhecendo-o-page-rank/

# Breadth-First Search
- https://deviniciative.wordpress.com/2023/02/07/entendendo-algoritmos-breadth-first-search/

# Depth-First Search
- https://deviniciative.wordpress.com/2023/02/26/entendendo-algoritmos-depth-first-search/
------
# Versão 1.8.0 (18/09/2024)
- Atualizado para o Java 22
- Refactor no testes do Kmeans
- Estudo sobre Threads
- Implementação dos Algorithmos de Whale Optimizer
  - O algoritmo de otimização de baleias (WOA) é um algoritmo metaheurístico baseado em enxame recentemente desenvolvido, baseado na técnica de manobra de caça à rede de bolhas para resolver problemas complexos de otimização. Tem sido uma técnica de inteligência de enxame amplamente aceita em vários campos da engenharia devido à sua estrutura simples, operador menos necessário, velocidade de convergência rápida e melhor capacidade de equilíbrio entre as fases de exploração e exploração. Devido ao seu ótimo desempenho e eficiência, as aplicações do algoritmo são amplamente utilizadas em campos multidisciplinares.
  - PseudoCodigo:
    - Randomly initialize the whale population.
      Evaluate the fitness values of whales and find out the best search agent X* .
      Initialize the whales population Xi (i = 1, 2, ..., n)
      Calculate the fitness of each search agent
      X*=the best search agent
      while (t < maximum number of iterations)
      for each search agent
      Update a, A, C, l, and p
      if1 (p<0.5)
      if2 (|A| < 1)
      Update the position of the current search agent by the Eq. (2.1)
      else if2 (|A|>=1)
      Select a random search agent ( )
      Update the position of the current search agent by the Eq. (2.3)
      end if2
      else if1 (p >=0.5)
      Update the position of the current search by the Eq. (2.3)
      end if1
      end for
      Check if any search agent goes beyond the search space and amend it
      Calculate the fitness of each search agent
      Update X* if there is a better solution
      t=t+1
      end while
      return X*


Os pré-requisitos para acompanhar esses links:

- Java 22+ 
- IDE de Desenvolvimento (Usei o Intellij Community)
- Junit 5 (para os testes Unitários)
