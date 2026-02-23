# 📚 Biblioteca Digital

> Sistema de gerenciamento de acervo bibliotecário e ludográfico com arquitetura em camadas, orientado a objetos e interface no console.

<div align="center">

![Java](https://img.shields.io/badge/Java-11%2B-007396?style=for-the-badge&logo=java&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)

</div>

---

## 📖 Sobre o Projeto

A **Biblioteca Digital** é uma aplicação Java desenvolvida para gerenciar itens de um acervo cultural, incluindo **livros** e **jogos eletrônicos**. O sistema permite cadastro, consulta, listagem e remoção de itens através de uma interface de linha de comando intuitiva e visualmente agradável.

### ✨ Funcionalidades

| Funcionalidade | Descrição |
|---------------|-----------|
| ➕ **Adicionar Livro** | Cadastro de livros com título, autor, categoria, ano e estoque |
| ➕ **Adicionar Jogo** | Cadastro de jogos com título, plataforma, categoria, ano e estoque |
| 🗑️ **Remover Item** | Exclusão de itens pelo título (busca case-insensitive) |
| 📋 **Listar Acervo** | Exibição formatada de todos os itens cadastrados |
| 🔍 **Buscar por Título** | Consulta exata de um item pelo nome |
| 🏷️ **Buscar por Categoria** | Filtragem de itens por gênero/categoria |
| 🎨 **Interface Colorida** | Console com cores ANSI, emojis e formatação visual |
| ✅ **Validação Robusta** | Tratamento de entradas inválidas e exceções personalizadas |

---

## 🏗️ Arquitetura do Projeto

O projeto segue o padrão de **camadas (layers)** para separação de responsabilidades:

