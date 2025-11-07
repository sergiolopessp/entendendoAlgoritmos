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

# Versão 1.9.0 (30/09/2024)
- Implantação do Algoritmo GrayWolfOptimizer
  - Este algoritmo metaheurístico foi proposto por Seyedali Mirajaliali, Seyed Muhammad e Andrew Lewis em um artigo de 2014. Foi inspirado na hierarquia social nas técnicas de caça dos lobos cinzentos.
  - PseudoCodigo:
    - Begin
      Initialize the parameters popsize, maxiter, ub and lb where
      popsize: size of population,
      maxiter: maximum number of iterations,
      ub: upper bound(s) of the variables,
      lb: lower bound(s) of the variables;
      Generate the initial positions of gray wolves with ub and lb;
      Initialize and Calculate the fitness of each gray wolf;
      alpha = the gray wolf with the first maximum fitness;
      beta = the gray wolf with the second maximum fitness;
      delta = the gray wolf with the third maximum fitness;
      While
      for  : popsize
      Update the position of the current gray wolf  ;
      end for
      Update and
      Calculate the fitness of all gray wolves;
      Update alpha, beta, and delta;
      ;;
      end while
      Return alpha;
      End

# Versão 1.10.0 (01/10/2024)
- Implantação do Algoritmo Bat
  - O algoritmo bat está alinhado com os outros algoritmos metaheurísticos, que aproximam problemas NP-difíceis. Xin-She Yang desenvolveu o algoritmo em 2010.
  - Este algoritmo é baseado nas capacidades de ecolocalização dos micromorcegos, onde a taxa de emissão e o volume são variados.
  - Pseudocde:
    -  Objective function f(x), x = (x1, ..., xd)
       Initialize the bat population Xi (i = 1, 2, . . ., n)
       Define the pulse rate ri and the loudness Ai
       Input: Initial bat population
       while ( t < Max number of iterations ) do
       Generate new solutions by adjusting frequency, and updating velocities and locations/solutions (Equations in 2-10 )
       if ( rand > ri ) then
       Select a solution among the best solutions
       Generate a local solution around the selected best solution
       end if
       Generate a new solution by flying randomly
       if ( rand < Ai & f(Xi) < f(X∗) ) then
       Accept the new solutions
       Increase emission rate and reduce loudness
       end if
       Rank the bats and find the current best Xbest
       end while
       Output: Best bat found (i.e. best solution)

# Versão 1.11.0 (07/11/2025)
  - Implantação do Algoritmo de ConsistenceHashing
_______________________________________________________
Os pré-requisitos para acompanhar esses links:

- Java 24+ 
- IDE de Desenvolvimento (Usei o Intellij Community)
- Junit 5 (para os testes Unitários)
