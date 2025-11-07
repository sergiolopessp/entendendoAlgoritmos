# Change Log
Arquivo com as mudanças que tem entrado neste código seguindo os padrões.

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

# [1.11.0] 2025-11-07
### Changed
    - Versão do Java atualizada para a 24

### Added
  - Algoritmo de ConsistenceHashing

## [1.10.0] - 2024-10-01

### Changed
- Movido o Rastringim para dentro do pacote service

## [1.9.0] - 2024-09-30

### Added
- Adicionado o Package GrayWolves e o algoritmo GrayWolfOptimizer

### Changed
- Refatoração das classes Point e Rastringin para o package de Model

## [1.8.0] - 2024-09-18

### Added
- Adicionado o Package Whale e o Algoritmo WhaleOptimizer

### Changed
- Regua de compilação indo para o Java 22
- Atualização de versão do Jacoco

### Fixed
- Melhorando os testes unitários

## [1.6.0] - 2023-04-14

### Added
- Adicionado os comportamentos e testes para o Algoritmo de Kmeans Clustering
- Adicionado a Função de Ordenação ordenaPorComparadorDouble
- Adicionado os testes unitários para todos os novos cenários

### Changed
- Alterado o construtor da Lista de inteiros para um construtor unico nos testes de algoritmos de Sorting

### Fixed
- Correção em ordem de Assert nos testes de DistanciaEuclidianaTest
- Corrigido o uso de Random por SecureRandom
- Criando um método private para a classe utilitária
- Melhorando a qualidade dos testes
