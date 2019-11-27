package ISoccer;

public interface AdmFuncoes {
	void addfuncionario(Object dados);
	void alterardados(Object funcionario);
	void demitir(Adm atual,Object funcionario);
	void sociotorcedor(SocioTorcedor novo,Adm adm);
}
