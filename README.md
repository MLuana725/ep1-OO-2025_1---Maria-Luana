# Sistema Acadêmico - FCTE

## Descrição do Projeto

Desenvolvimento de um sistema acadêmico para gerenciar alunos, disciplinas, professores, turmas, avaliações e frequência, utilizando os conceitos de orientação a objetos (herança, polimorfismo e encapsulamento) e persistência de dados em arquivos.

O enunciado do trabalho pode ser encontrado aqui:
- [Trabalho 1 - Sistema Acadêmico](https://github.com/lboaventura25/OO-T06_2025.1_UnB_FCTE/blob/main/trabalhos/ep1/README.md)

## Dados do Aluno

- **Nome completo:** Maria Luana Soares Lopes
- **Matrícula:** 241011448
- **Curso:** Engenharias
- **Turma:** Turma 02

---

## Instruções para Compilação e Execução

1. **Compilação:**
   É necessário utilizar o vscode. Baixe todo o arquivo do projeto. No VsCode, se ainda não tiver, baixe toda a extensão do pacote Java
   - (que também pode ser encontrada no site ode-visualstudio-com.translate.goog/docs/java/extensions?_x_tr_sl=en&_x_tr_tl=pt&_x_tr_hl=pt&_x_tr_pto=tc).

    Em seguida, abra o projeto no VsCode e o execute
   e automaticamente o VsCode irá o compilar.
   
   Caso não funcione, siga os passos:
   
   Abra o terminal no VS Code, navegue até a raiz do projeto, se necessário, e execute o seguinte comando:
   javac -d bin src/*.java

3. **Execução:**  
   Vá para a classe InterfacePrincipal e execute o main, apertando (no VsCode) o botão "Run Java", que está no canto direito da tela. Caso não funcione, execute os passos:
   
   Após a compilação, para executar o programa principal, utilize:
   java -cp bin InterfacePrincipal no terminal

5. **Estrutura de Pastas:**  
   As pastas, no vscode, devem ficar desse modo:
   
ep1_OO_TrabalhoML/
- src/                    
    - InterfacePrincipal.java
    - Aluno.java
    - AlunoInfo.java
    - AlunoEspecial.java
    - DisciplinaInfo.java
    - Turma.java
    - GerenciadorTurma.java

- bin/                    
- lib/                    
- .vscode/                
    - settings.json       

- alunos.txt             
- turmas.txt              
- disciplinas.txt         

- README.md              



3. **Versão do JAVA utilizada:**  
   A versão Java utilizada foi a JavaSE-21

---

## Vídeo de Demonstração

- [Inserir o link para o vídeo no YouTube/Drive aqui]

---

## Prints da Execução

1. Menu Principal:  
   ![Menu principal](https://github.com/user-attachments/assets/57bda57f-93b2-48f7-bc68-a792c212c789)


2. Método de Criação de turmas:  
   ![Método para criar nova turma](https://github.com/user-attachments/assets/aec8a238-6018-40e6-99e8-b23a886c5255)


3. Métodos de salvamento em arquivo dos dados das turmas:  
  ![Métodos de Salvamento de arquivos txt](https://github.com/user-attachments/assets/cfba3d0e-699d-48cf-b0f3-de9a414e3765)


---

## Principais Funcionalidades Implementadas

- [ X] Cadastro, listagem, matrícula e trancamento de alunos (Normais e Especiais)
- [ X] Cadastro de disciplinas e criação de turmas (presenciais e remotas)
- [ X] Matrícula de alunos em turmas, respeitando vagas e pré-requisitos
- [ ] Lançamento de notas e controle de presença
- [ ] Cálculo de média final e verificação de aprovação/reprovação
- [ ] Relatórios de desempenho acadêmico por aluno, turma e disciplina
- [X ] Persistência de dados em arquivos (.txt ou .csv)
- [ X] Tratamento de duplicidade de matrículas
- [ X] Uso de herança, polimorfismo e encapsulamento

---

## Observações (Extras ou Dificuldades)

- Em questão de dificuldades, uma delas foi manter a organização das classes, que, com a necessidade de criação de novos métodos conforme o progresso do código, fazia com que multiplas vezes eu cogitasse criar uma nova classe ou repensar a função de outra. Além disso, lembrar e aplicar corretamente as relações de metodos de classes diferentes também foi um desafio, pois acabava confundido que informação era enviada para qual método ou simplesmente trocava a que classe pertencia certo método, o que as vezes fazia os dados serem perdidos ou não utilizados no progama. Tive que aprender como salvar em arquivo .txt e com isso, fui capaz de entender como o salvamento de dados funciona nos códigos, algo que até então não compreendia completamente. Aprender a formatar o modo que os dados são escritos nos arquivos foi um conhecimento a mais que achei interessante.
- As turmas e alunos do mostrados nos vídeos não serão os mesmos dos arquivos, pois era só uma demonstração, mas o funcionamento é o mesmo

---

## Contato

- [Opcional: E-mail pessoal do aluno.]
