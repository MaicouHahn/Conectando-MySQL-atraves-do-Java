# Conectando-MySQL-atraves-do-Java
Estudo de metodo de conexão ao branco de dado MySQL baseado nas video aulas do canal Kana Chan

A classe contato possui os atributos do objeto junto dos metodos get e set de cada atributo
A classe ConnectionFactory possui o metodo que faz a conexão do banco de dados passando URL USUARIO e SENHA e um metodo main para checar se esta conectando
A classe ContatoDAO possui os metodos CRUD(create, read, update e delete) onde alguns recebem os atributos de um objeto da classe Contato e dentro do metodo tratam
esses dados e criam, inserem, leem ou deletam dentro do banco MySQL
Na classe Main criando um objeto da classe Contato e passando seus atributos é possivel chamar outro objeto da classe ContatoDAO e passa-lo como parametro dentro 
da operação com o banco desejada

Para testar os metodos criei essa simples interface no netbeans e relacionei os botões e campos com os metodos citados acima

![Captura de tela 2022-10-20 103649](https://user-images.githubusercontent.com/111459606/196995232-fb0f545d-4092-47db-9a91-3cde221fbe5d.png)
