package ISoccer;

import java.util.ArrayList;
import java.util.Scanner;

public class Adm extends Funcoes implements AdmFuncoes,AdmRecursos {
	Scanner teclado = new Scanner(System.in);
	private String login;
	private String senha;
	ArrayList<SocioTorcedor> listajunior = new ArrayList<>();
	ArrayList<SocioTorcedor> listasenior = new ArrayList<>();
	ArrayList<SocioTorcedor> listaelite = new ArrayList<>();
	private double sociojunior;
	private double sociosenior;
	private double socioelite;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {		
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String cpf,String nome) {
		char[] senha = new char[6];
		senha[0] = nome.charAt(0);
		senha[1] = nome.charAt(1);
		senha[2] = cpf.charAt(0);
		senha[3] = cpf.charAt(1);
		senha[4] = cpf.charAt(2);
		senha[5] = cpf.charAt(3);
		String str = new String(senha);
		this.senha = str;
	}
	
	public double getSociojunior() {
		return sociojunior;
	}

	public void setSociojunior(double preço) {
		this.sociojunior = preço;
	}

	public double getSociosenior() {
		return sociosenior;
	}

	public void setSociosenior(double preço) {
		this.sociosenior = preço;
	}

	public double getSocioelite() {
		return socioelite;
	}

	public void setSocioelite(double preço) {
		this.socioelite = preço;
	}

	@Override
	public void addfuncionario(Object novo) {
		System.out.println("Digite os seguintes dados do novo "+novo.getClass().getSimpleName()+".");
		System.out.println("Nome:");
		((Pessoa) novo).setNome(teclado.nextLine());
		System.out.println("E-mail:");
		((Pessoa) novo).setEmail(teclado.nextLine());
		System.out.println("CPF:");
		((Pessoa) novo).setCpf(teclado.nextLine());
		System.out.println("Telefone:");
		((Pessoa) novo).setTelefone(teclado.nextDouble());
		System.out.println("Salário:");
		((Pessoa) novo).setSalario(teclado.nextDouble());
		if(novo.getClass().getSimpleName().equalsIgnoreCase("Jogador")) {
			System.out.println("Posição:");
			teclado.nextLine();
			((Jogador) novo).setPosicao(teclado.nextLine());
			System.out.println("Está hapto para jogar: sim ou não ?");
			String hapto = teclado.nextLine();
			if(hapto.equalsIgnoreCase("não")) {
				((Jogador) novo).setStatus("Não");					
			}
			else if(hapto.equalsIgnoreCase("sim")){
				((Jogador) novo).setStatus("Sim");					
			}
			else {
				System.out.println("Ocorreu um erro.\n"+"Por favor repita a operação.");				
			}
		}
		else if(novo.getClass().getSimpleName().equalsIgnoreCase("Motorista")) {
			System.out.println("Habilitação:");
			((Motorista) novo).setHabilitacao(teclado.nextDouble());
			teclado.nextLine();
		}
		else if(novo.getClass().getSimpleName().equalsIgnoreCase("Medico")) {
			System.out.println("CRM:");
			((Medico) novo).setCrm(teclado.nextDouble());
			teclado.nextLine();
		}
	}
	@Override
	public void alterardados(Object funcionario) {
		System.out.println("Digiti o que deseja alterar:");
		String alterar = teclado.nextLine();
		if(alterar.equalsIgnoreCase("Nome")) {
			((Pessoa) funcionario).setNome(teclado.nextLine());
		}
		else if(alterar.equalsIgnoreCase("Email")||alterar.equalsIgnoreCase("E-mail")) {
			((Pessoa) funcionario).setEmail(teclado.nextLine());
		}
		else if(alterar.equalsIgnoreCase("CPF")) {
			((Pessoa) funcionario).setCpf(teclado.nextLine());
		}
		else if(alterar.equalsIgnoreCase("Telefone")) {
			((Pessoa) funcionario).setTelefone(teclado.nextDouble());
		}
		else if((alterar.equalsIgnoreCase("Salário") || (alterar.equalsIgnoreCase("Salario")) && funcionario.getClass().getSimpleName().equalsIgnoreCase("Socio Torcedor") != true)) {
			((Pessoa) funcionario).setSalario(teclado.nextDouble());
		}
		else if(funcionario.getClass().getSimpleName().equalsIgnoreCase("Jogador")) {
			if(alterar.equalsIgnoreCase("Posição")) {
				((Jogador) funcionario).setPosicao(teclado.nextLine());
			}
			else if(alterar.equalsIgnoreCase("Status")) {
				if(((Jogador) funcionario).getStatus().equalsIgnoreCase("Sim")) {
					((Jogador) funcionario).setStatus("Não");				
				}
				else {
					((Jogador) funcionario).setStatus("Sim");					
				}
			}
			else {
				System.out.println("Ocorreu um erro.\n"+"Por favor repita a operação.");				
			}
		}
		else if(funcionario.getClass().getSimpleName().equalsIgnoreCase("Motorista")) {
			if(alterar.equalsIgnoreCase("Habilitação")) {
				((Motorista) funcionario).setHabilitacao(teclado.nextDouble());
			}
			else {
				System.out.println("Ocorreu um erro.\n"+"Por favor repita a operação.");				
			}
		}
		else if(funcionario.getClass().getSimpleName().equalsIgnoreCase("Medico")) {
			if(alterar.equalsIgnoreCase("CRM")) {
			((Medico) funcionario).setCrm(teclado.nextDouble());
			}
			else {
				System.out.println("Ocorreu um erro.\n"+"Por favor repita a operação.");				
			}
		}
		else if(funcionario.getClass().getSimpleName().equalsIgnoreCase("Sócio Torcedor")) {
			if(alterar.equalsIgnoreCase("endereço")) {
				((SocioTorcedor) funcionario).setEndereco(teclado.nextLine());				
			}
			else if(alterar.equalsIgnoreCase("Plano")) {
				System.out.println("Qual Plano deseja:");
				alterar = teclado.nextLine();
				if(alterar.equalsIgnoreCase("Júnior")) {
					((SocioTorcedor) funcionario).setCategoria("Júnior");
					((SocioTorcedor) funcionario).setValordecontribuicao(getSociojunior());
				}
				else if(alterar.equalsIgnoreCase("Sênior")) {
					((SocioTorcedor) funcionario).setCategoria("Sênior");
					((SocioTorcedor) funcionario).setValordecontribuicao(getSociosenior());					
				}
				else if(alterar.equalsIgnoreCase("Elite")) {
					((SocioTorcedor) funcionario).setCategoria("Elite");
					((SocioTorcedor) funcionario).setValordecontribuicao(getSocioelite());					
				}
				else {
					System.out.println("Ocorreu um erro.\n"+"Por favor repita a operação.");
				}
								
			}
			else if(alterar.equalsIgnoreCase("Status")) {
				if(((SocioTorcedor) funcionario).getAdimplente()) {
					((SocioTorcedor) funcionario).setAdimplente(false);					
				}
				else {
					((SocioTorcedor) funcionario).setAdimplente(true);					
				}
			}
		}
		else {
			System.out.println("Ocorreu um erro de digitação.\n"+"Por favor repita a operação.");				
		}
	}
	@Override
	public void demitir(Adm adm, Object funcionario) {
		if(funcionario.getClass().getSimpleName().equalsIgnoreCase("Presidente")) {
			adm.presidente = null;
		}
		if(funcionario.getClass().getSimpleName().equalsIgnoreCase("Técnico")) {
			adm.tecnico = null;
		}
		if(funcionario.getClass().getSimpleName().equalsIgnoreCase("Jogador")) {
			adm.jogadores.remove(funcionario);	
		}
		if(funcionario.getClass().getSimpleName().equalsIgnoreCase("Preparador Físico")) {
			adm.prefisicos.remove(funcionario);
		}
		if(funcionario.getClass().getSimpleName().equalsIgnoreCase("Médico")) {
			adm.medicos.remove(funcionario);
		}
		if(funcionario.getClass().getSimpleName().equalsIgnoreCase("Motorista")) {
			adm.motoristas.remove(funcionario);
		}
		if(funcionario.getClass().getSimpleName().equalsIgnoreCase("Cozinheiro")) {
			adm.cozinheiros.remove(funcionario);
		}
		if(funcionario.getClass().getSimpleName().equalsIgnoreCase("Advogado")) {
			adm.advogados.remove(funcionario);
		}
	}

	@Override
	public void sociotorcedor(SocioTorcedor novo, Adm adm) {
		String plano = teclado.nextLine();
		if(plano.equalsIgnoreCase("Novo Sócio") ||plano.equalsIgnoreCase("Novo Socio") ) {
			System.out.println("Digite os seguintes dados do novo sócio torcedor.");
			System.out.println("Nome:");
			novo.setNome(teclado.nextLine());
			System.out.println("Endereço:");
			novo.setEndereco(teclado.nextLine());
			System.out.println("E-mail:");
			novo.setEmail(teclado.nextLine());
			System.out.println("CPF:");
			novo.setCpf(teclado.nextLine());
			System.out.println("Telefone:");
			novo.setTelefone(teclado.nextDouble());
			teclado.nextLine();
			System.out.println("Plano:");
			plano = teclado.nextLine();
			if(plano.equalsIgnoreCase("Júnior")) {
				novo.setValordecontribuicao(adm.getSociojunior());
				listajunior.add(novo);
			}
			else if(plano.equalsIgnoreCase("Sênior")) {
				novo.setValordecontribuicao(adm.getSociosenior());
				listasenior.add(novo);
			}
			else if(plano.equalsIgnoreCase("Elite")) {
				novo.setValordecontribuicao(adm.getSocioelite());
				listaelite.add(novo);
			}
			else {
				System.out.println("Plano não encotrado");
			}
		}
		else if(plano.equalsIgnoreCase("alterar dados")) {
			System.out.println("Deseja altera que dado:");
			
		}
	}

	@Override
	public void onibus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void estadio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void capacidadeestadio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void qtdbanheiros() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void qtdlanchonete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dormitorios() {
		// TODO Auto-generated method stub
		
	}
}
