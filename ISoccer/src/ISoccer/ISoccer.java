package ISoccer;
import java.util.ArrayList;
import java.util.Scanner;

public class ISoccer{
	
	private static Scanner teclado;
	private static RecursosFisicos recursosfisicos;
	private static String funcionalidade;
	private static String funcionario;
	public static void main(String[] args) {
	 System.out.println("Deseja Criar Conta ou Acessar Conta");
	 Adm adm = new Adm();
	 teclado = new Scanner(System.in);
	 funcionalidade = teclado.nextLine();
	 int i=1;
	 while(i!=0) {
		 if(funcionalidade.equalsIgnoreCase("Criar Conta")) {
		 	adm = criar_conta();
		 	acessarconta(adm);
	 	}
	 	else if(funcionalidade.equalsIgnoreCase("Acessar Conta")) {
	 		acessarconta(adm);
	 	}
	 	else if(funcionalidade.equalsIgnoreCase("Relatorios")) {
	 		relatoriofuncionario(adm);
	 	}
		System.out.println("Deseja Criar Conta, Acessar Conta ou Relatorios");
		funcionalidade = teclado.nextLine();
	 }
	}
	
	public static Adm criar_conta() {
		
		Adm new_adm = new Adm();
		System.out.println("Digite os seguintes dados do novo administrador.");
		System.out.println("Nome:");
		new_adm.setNome(teclado.nextLine());
		System.out.println("E-mail:");
		new_adm.setEmail(teclado.nextLine());
		System.out.println("CPF:");
		new_adm.setCpf(teclado.nextLine());
		System.out.println("Telefone:");
		new_adm.setTelefone(teclado.nextDouble());
		System.out.println("Salário:");
		new_adm.setSalario(teclado.nextDouble());
		teclado.nextLine();
		new_adm.setLogin(new_adm.getNome());
		new_adm.setSenha(new_adm.getCpf(),new_adm.getNome());
		new_adm.setSociojunior(50);
		new_adm.setSociojunior(80);
		new_adm.setSociojunior(120);
		return new_adm;
	}
	
	public static void acessarconta(Adm adm) {
		
		String login;
		String senha;
		System.out.println("Login\n"+"Senha");
		login = teclado.nextLine();
		senha = teclado.nextLine();		
		if(login.equalsIgnoreCase(adm.getLogin()) && senha.equalsIgnoreCase(adm.getSenha())){
			funcoes(adm);
		}
		else {
			System.out.println("Erro!");
		}
		
	}
	
	public static void funcoes(Adm adm) {
		while(funcionalidade.equalsIgnoreCase("Sair") != true) {
		System.out.println("Deseja: Alterar Dados,Demitir, Contratar, Sócio Torcedor ou Sair.");
		funcionalidade = teclado.nextLine();
	
		if(funcionalidade.equalsIgnoreCase("Alterar Dados")) {
			int i;
			System.out.println("Digiti a profissão:\n");
			funcionario = teclado.nextLine();
			if(funcionario.equalsIgnoreCase("Presidente")) {
				adm.alterardados(adm.presidente);
			}
			else if(funcionario.equalsIgnoreCase("Técnico")) {
				adm.alterardados(adm.tecnico);
			}
			else if(funcionario.equalsIgnoreCase("Cozinheiro")) {
				i = Procurar(adm.cozinheiros);
				if(i != -1) {
					adm.alterardados(adm.cozinheiros.get(i));
				}
				else {
					System.out.println("Ocorreu um erro de digitação.\n"+"Por favor repita a operação.");
				}
			}
			if(funcionario.equalsIgnoreCase("Preparador Físico") || funcionario.equalsIgnoreCase("Preparador Fisico")) {
				i = Procurar(adm.prefisicos);
				if(i != -1) {
					adm.alterardados(adm.prefisicos.get(i));
				}
				else {
					System.out.println("Ocorreu um erro de digitação.\n"+"Por favor repita a operação.");
				}
			}
			if(funcionario.equalsIgnoreCase("Jogador")) {
				i = Procurar(adm.jogadores);
				if(i != -1) {
					adm.alterardados(adm.jogadores.get(i));
				}
				else {
					System.out.println("Ocorreu um erro de digitação.\n"+"Por favor repita a operação.");
				}
			}
			if(funcionario.equalsIgnoreCase("Motorista")) {
				i = Procurar(adm.motoristas);
				if(i != -1) {
					adm.alterardados(adm.motoristas.get(i));
				}
				else {
					System.out.println("Ocorreu um erro de digitação.\n"+"Por favor repita a operação.");
				}
			}
			if(funcionario.equalsIgnoreCase("Médico") || funcionario.equalsIgnoreCase("Medico")) {
				i = Procurar(adm.medicos);
				if(i != -1) {
					adm.alterardados(adm.medicos.get(i));
				}
				else {
					System.out.println("Ocorreu um erro de digitação.\n"+"Por favor repita a operação.");
				}
			}			
		}
		
		else if(funcionalidade.equalsIgnoreCase("Demitir")) {
			int i;
			System.out.println("Digiti a profissão:\n");
			funcionario = teclado.nextLine();
			if(funcionario.equalsIgnoreCase("Técnico")) {
				adm.demitir(adm,adm.tecnico);
			}
			else if(funcionario.equalsIgnoreCase("Cozinheiro")) {
				i = Procurar(adm.cozinheiros);
				if(i != -1) {
					adm.demitir(adm,adm.cozinheiros.get(i));
				}
				else {
					System.out.println("Ocorreu um erro de digitação.\n"+"Por favor repita a operação.");
				}
			}
			if(funcionario.equalsIgnoreCase("Preparador Físico") || funcionario.equalsIgnoreCase("Preparador Fisico")) {
				i = Procurar(adm.prefisicos);
				if(i != -1) {
					adm.demitir(adm,adm.prefisicos.get(i));
				}
				else {
					System.out.println("Ocorreu um erro de digitação.\n"+"Por favor repita a operação.");
				}
			}
			if(funcionario.equalsIgnoreCase("Jogador")) {
				i = Procurar(adm.jogadores);
				if(i != -1) {
					adm.demitir(adm,adm.jogadores.get(i));
				}
				else {
					System.out.println("Ocorreu um erro de digitação.\n"+"Por favor repita a operação.");
				}
			}
			if(funcionario.equalsIgnoreCase("Motorista")) {
				i = Procurar(adm.motoristas);
				if(i != -1) {
					adm.demitir(adm,adm.motoristas.get(i));
				}
				else {
					System.out.println("Ocorreu um erro de digitação.\n"+"Por favor repita a operação.");
				}
			}
			if(funcionario.equalsIgnoreCase("Médico") || funcionario.equalsIgnoreCase("Medico")) {
				i = Procurar(adm.medicos);
				if(i != -1) {
					adm.demitir(adm,adm.medicos.get(i));
				}
				else {
					System.out.println("Ocorreu um erro de digitação.\n"+"Por favor repita a operação.");
				}
			}			
		}
		else if(funcionalidade.equalsIgnoreCase("Contratar")) {
			System.out.println("Digiti a profissão:");
			funcionario = teclado.nextLine();
			if(funcionario.equalsIgnoreCase("Advogado")) {
				Advogado advogado = new Advogado();
				adm.addfuncionario(advogado);
				adm.advogados.add(advogado);
			}
			if(funcionario.equalsIgnoreCase("Técnico")) {
				if(adm.tecnico != null) {
					Tecnico tecnico = new Tecnico();
					adm.addfuncionario(tecnico);
					adm.tecnico = tecnico;
				}
				else {
					System.out.println("Ja há um técnico no cargo, para contratar um novo é preciso demitir o técnico atual.");
				}
			}
			if(funcionario.equalsIgnoreCase("Cozinheiro")) {
				Cozinheiro cozinheiro = new Cozinheiro();
				adm.addfuncionario(cozinheiro);
				adm.cozinheiros.add(cozinheiro);
			}
			if(funcionario.equalsIgnoreCase("Preparador Físico") || funcionario.equalsIgnoreCase("Preparador Fisico")) {
				PreparadorFisico preparador = new PreparadorFisico();
				adm.addfuncionario(preparador);
				adm.prefisicos.add(preparador);
			}
			if(funcionario.equalsIgnoreCase("Jogador")) {
				Jogador jogador = new Jogador();
				adm.addfuncionario(jogador);
				adm.jogadores.add(jogador);
			}
			if(funcionario.equalsIgnoreCase("Motorista")) {
				Motorista motorista = new Motorista();
				adm.addfuncionario(motorista);
				adm.motoristas.add(motorista);
			}
			if(funcionario.equalsIgnoreCase("Médico") || funcionario.equalsIgnoreCase("Medico")) {
				Medico medico = new Medico();
				adm.addfuncionario(medico);
				adm.medicos.add(medico);
			}
		}
		else if(funcionalidade.equalsIgnoreCase("Socio Torcedor") || funcionalidade.equalsIgnoreCase("Sócio Torcedor")) {
			SocioTorcedor socio = new SocioTorcedor();
			adm.sociotorcedor(socio, adm);			
		}
		
		}
	}
	
	public static int Procurar(ArrayList adm) {
		// i=-1, caso não encontre o funcionario
		int i=-1;
		String nome;
		System.out.println("Digite o nome do funcionário:");
		nome = teclado.nextLine();
		for (i = 0; i < adm.size() && nome.equalsIgnoreCase(((Pessoa) adm.get(i)).getNome()) != true; i++) {					
		}
		if(i < adm.size()) {
			return i;
		}
		return i;
	}
	
	public static void relatoriofuncionario(Adm adm) {
		System.out.println("Pressidente");
		System.out.println("Nome: "+adm.presidente.getNome());
		System.out.println("Email: "+adm.presidente.getEmail());
		System.out.printf("CPF: %.0f\n",adm.presidente.getCpf());
		System.out.printf("Telefone: %.0f\n",adm.presidente.getTelefone());
		System.out.printf("Salário: R$ %.2f\n",adm.presidente.getSalario());
		System.out.println("Técnico");
		System.out.println("Nome: "+adm.tecnico.getNome());
		System.out.println("Email: "+adm.tecnico.getEmail());
		System.out.printf("CPF:"+adm.tecnico.getCpf());
		System.out.printf("Telefone: %.0f\n",adm.tecnico.getTelefone());
		System.out.printf("Salário: R$ %.2f\n",adm.tecnico.getSalario());
		System.out.println("Jogadores");
		for(Jogador x: adm.jogadores) {
			System.out.println("Nome: "+x.getNome());
			System.out.println("Email: "+x.getEmail());
			System.out.println("CPF:"+x.getCpf());
			System.out.printf("Telefone: %.2f \n",x.getTelefone());
			System.out.printf("Salário: R$ %.2f \n",x.getSalario());
			System.out.println("Posição: "+x.getPosicao());
			System.out.println("Hapto para jogar: "+x.getStatus()+"\n");
		}
		System.out.println("Preparadores Físicos");
		for(PreparadorFisico x: adm.prefisicos) {
			System.out.println("Nome: "+x.getNome());
			System.out.println("Email: "+x.getEmail());
			System.out.printf("CPF:"+x.getCpf());
			System.out.printf("Telefone: %.0f\n",x.getTelefone());
			System.out.printf("Salário: R$ %.2f\n",x.getSalario());
		}
		System.out.println("Médicos");
		for(Medico x: adm.medicos) {
			System.out.println("Nome: "+x.getNome());
			System.out.println("Email: "+x.getEmail());
			System.out.printf("CPF:"+x.getCpf());
			System.out.printf("Telefone: %.0f\n",x.getTelefone());
			System.out.printf("Salário: R$ %.2f\n",x.getSalario());
			System.out.printf("CRM: %.0f\n",x.getCrm());
		}
		System.out.println("Advogados");
		for(Advogado x: adm.advogados) {
			System.out.println("Nome: "+x.getNome());
			System.out.println("Email: "+x.getEmail());
			System.out.printf("CPF:"+x.getCpf());
			System.out.printf("Telefone: %.0f\n",x.getTelefone());
			System.out.printf("Salário: R$ %.2f\n",x.getSalario());
		}
		System.out.println("Cozinheiros");
		for(Cozinheiro x: adm.cozinheiros) {
			System.out.println("Nome: "+x.getNome());
			System.out.println("Email: "+x.getEmail());
			System.out.printf("CPF:"+x.getCpf());
			System.out.printf("Telefone: %.0f\n",x.getTelefone());
			System.out.printf("Salário: R$ %.2f\n",x.getSalario());
		}
		System.out.println("Motoristas");
		for(Motorista x: adm.motoristas) {
			System.out.println("Nome: "+x.getNome());
			System.out.println("Email: "+x.getEmail());
			System.out.printf("CPF:"+x.getCpf());
			System.out.printf("Telefone: %.0f\n",x.getTelefone());
			System.out.printf("Salário: R$ %.2f\n",x.getSalario());
			System.out.printf("Habilitação: R$ %.0f\n",x.getHabilitacao());
			
		}
	}
}