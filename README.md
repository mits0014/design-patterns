#  Atividade Prática: Refatoração com Design Patterns
## Disciplina: Arquitetura de Software

Bem-vindo ao repositório da nossa atividade prática sobre Design Patterns!

O objetivo deste exercício é treinar nossa capacidade de identificar "code smells" (cheiros de código) em um software legado e aplicar os padrões de projeto corretos para refatorar e melhorar a solução.

---

## Workflow da Atividade

O trabalho será realizado em duplas/grupos e seguirá o seguinte fluxo:

1.  **Fork:** Um membro da dupla/grupo deve fazer um **Fork** deste repositório para sua própria conta no GitHub.
2.  **Clone:** Todos os membros devem clonar o repositório "forkado" para suas máquinas locais.
    ```bash
    git clone [https://github.com/SEU_USUARIO/design-patterns.git](https://github.com/SEU_USUARIO/design-patterns.git)
    ```
3.  **Importar:** Abra o projeto na sua IDE de preferência (IntelliJ IDEA, Eclipse, etc.). O projeto é um projeto **Maven Multi-Módulo**. A IDE deve reconhecê-lo e carregar todos os módulos automaticamente.
4.  **Designar Módulos:** O professor irá designar quais módulos (padrões) sua equipe deverá refatorar.
5.  **Analisar e Refatorar:** Para cada módulo designado, vocês deverão:
    a. Analisar o código problemático no pacote `gohorse`.
    b. Escrever a solução refatorada no pacote `designpattern`.
6.  **Commit & Push:** Ao finalizar, façam o `commit` e `push` das alterações para o repositório "forkado".
7.  **Entrega:** A entrega será feita (conforme orientação do professor) através da apresentação do código no repositório "forkado" ou via um Pull Request para este repositório original.

---

## 🛠️ Estrutura do Projeto

Este é um projeto **Maven Multi-Module**. Isso significa que o `pom.xml` na raiz gerencia vários "subprojetos" (módulos) independentes.

Cada padrão de projeto que estudamos está em seu próprio módulo:

* `/adapter`
* `/builder`
* `/decorator`
* `/factory`
* `/observer`
* `/singleton`
* `/state`
* `/strategy`

### 🌟 Estrutura Dentro de CADA Módulo

Ao expandir qualquer um dos módulos (ex: `/factory`), você encontrará a seguinte estrutura principal em `src/main/java/`:

Estrutura de pastas dentro de cada módulo:

    └── design-patterns/
        └── src 
            └── main 
                └── java 
                    ├── gohorse/ │ 
                        ├── ... (Classes com o código "Go-Horse") 
                            │ └── ...
                    ├── designpattern/ 
                        ├── ... (Aqui que você vai escrever seu código!) 
                        └── ...



#### 1. Pacote `gohorse`
Neste pacote está o código original, "Go-Horse".
* **Seu objetivo:** Ler, analisar e discutir por que este código é ruim.
* **O que ele viola?** (SOLID? OCP? SRP?)
* **Qual o problema de manutenção?** (Alto acoplamento? Baixa coesão?)
* 🚨 **NÃO ALTERE AS CLASSES DENTRO DESTE PACOTE!** Elas servem como referência do "antes".

#### 2. Pacote `designpattern`
Este pacote está (inicialmente) vazio.
* **Seu objetivo:** Escrever, **do zero**, a solução refatorada.
* Vocês deverão criar as novas classes, interfaces e toda a estrutura necessária para aplicar o Design Pattern correto para aquele módulo.
* Sinta-se à vontade para criar uma classe `Main.java` ou `Cliente.java` dentro deste pacote para demonstrar sua solução funcionando.

---

## 📦 Compilando o Projeto

Para compilar todos os módulos de uma vez (após ter o Maven instalado), você pode executar o seguinte comando na pasta raiz (`design-patterns`):

```bash
mvn clean install