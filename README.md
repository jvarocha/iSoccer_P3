# iSoccer_P3
FUNCIONALIDADES:
  Esse projeto tem como objetivo um sistema de gerênciamento de um time de futebol.Tendo como operador( administrador ) que executa funções que envolva seus funcionários,estrutura do clube e sócios.
 
CLASSES:
  As classes foram criadas para separar os diferentes funcionários,como também o administrador,sócio torcedor e estrutura do clube. Há também uma classe chamada pessoa que contém características genéricas como nome, telefone,cpf,salário e e-mail.
  
 DISTRIBUIÇÃO DOS MÉTODOS:
  Os métodos foram divididos em duas camadas,a primeira camada são as funcionalidades que estão no administrador, nele poderar ser direcionada para o método funções, tendo acessado o método funções, depedendo da funcionalidade selecionada, podemos chegar na segunda camada, onde há o método procurar.
  
  HERANÇA:
    Todos os funcionários,sócios e administrador herdam características da classe pessoa.
  
  INTERFACES:
    Há duas interfaces a Admfuncoes que contém métodos relacionados a tarefas que envolvem os funcionários como contratar,demitir, alterar dados e sócio torcedor. A outra se chama Admrecursos que contém os métodos relacionados com os recursos físicos do clube, porém esses métodos não foram implementados.
    
  TRATAMENTO DE EXEÇÕES:
    Não há.
    
   EXTENSIBILIDADE:
    Foi criado uma classe chamada de funcoes, essa classe contém todos os tipos de funcionários, ela foi extendida para a classe adm ( administrador ), pois assim o próprio adm poderá consultar os dados dos funcionários.
   
   REUSOS:
    O método alterar dados ele é utilizados para todos os funcionários e sócio torcedores, pois características como nome,e-mail,telefone e cpf são dados que todos tem.
