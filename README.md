
# GitHubFinder 🐙

**GitHubFinder** é uma aplicação Java simples e eficiente para consultar perfis públicos do GitHub via API oficial. Através de um menu interativo no console, você pode buscar perfis, visualizar informações detalhadas, acompanhar um histórico local de consultas e gerenciar esse histórico.

---

## 🚀 Funcionalidades

- 🔎 Busca de perfis públicos do GitHub por nome de usuário  
- 📋 Exibição detalhada das informações do perfil (nome, ID, bio, URL)  
- 📚 Histórico local das pesquisas realizadas, armazenado em arquivo JSON (`historico.txt`)  
- 🧹 Limpeza fácil do histórico via menu  
- 🔄 Navegação simples e contínua via menu no console  

---

## 💻 Tecnologias Utilizadas

- Java 17+  
- [GitHub REST API](https://docs.github.com/en/rest/users/users#get-a-user)  
- HTTP Client (`java.net.http`) para comunicação com a API  
- [GSON](https://github.com/google/gson) para parsing e formatação JSON  

---
 **Siga as instruções no console para:**

   * Pesquisar perfis
   * Visualizar histórico
   * Limpar histórico
   * Sair da aplicação

---

## 🗂 Estrutura do Projeto

```
br.com.projeto.LocaizadorDePerfilGITHUB/
├── principal/        # Classe Principal e menu interativo
├── funcionalidade/   # Busca via API, histórico e salvamento em arquivo
├── perfil/           # Modelagem dos dados do perfil GitHub
└── erros/            # Exceções personalizadas
```

---

## 📬 Contato

**Ryan Miranda Barbosa**
📧 [ryandilei17@gmail.com](mailto:ryandilei17@gmail.com)
| [LinkedIn](https://www.linkedin.com/in/ryan-miranda-978910302/)

---


> Desenvolvido com 💙 para facilitar consultas rápidas de perfis no GitHub.

