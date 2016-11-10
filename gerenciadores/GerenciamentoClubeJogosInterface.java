package gerenciadores;
import java.io.PrintWriter;
import clube.*;


public class GerenciamentoClubeJogosInterface {
	
	/**
	 * Cria uma inst�ncia do tipo GerenciaUsuarioInterface e exibe as op��es de
	 * gerenciamento.
	 * As op��es s�o escolhidas por meio de entrada do usu�rio.	 * 
	 */
	public void gerenciaUsuario() {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
	
	/**
	 * Cria uma inst�ncia do tipo GerenciaAtividadeInterface e exibe as op��es de
	 * gerenciamento.
	 * As op��es s�o escolhidas por meio de entrada do usu�rio.	 * 
	 */
	public void gerenciaAtividade() {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
	
	/**
	 * Cria uma inst�ncia do tipo GerenciaLocalInterface e exibe as op��es de
	 * gerenciamento.
	 * As op��es s�o escolhidas por meio de entrada do usu�rio.	 * 
	 */
	public void gerenciaLocal() {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
	
	/**
	 * Cria uma inst�ncia do tipo GerenciaCalendarioInterface e exibe as op��es de
	 * gerenciamento.
	 * As op��es s�o escolhidas por meio de entrada do usu�rio.	 * 
	 */
	public void gerenciaCalendario() {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
	
	/**
	 * Exibe registros de intera��o com o sistema. Cada registro e composto por data, hor�rio
	 * e intera��o. As intera��es s�o a descri��o de alguma operacao do sistema (simbolizada por
	 *  cada m�todo presente nas interfaces) e o resultado daquela opera��o. As mensagens podem ser 
	 *  configuradas mas devem conter a data e hor�rio, descri��o e resultado da opera��o. Deve garantir que 
	 *  exista uma inst�ncia �nica de log no sistema.
	 */
	public void exibeLog() {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
		 Prompt.addLogUsr("Pedido para exibir log");
		 Prompt.showLog();
		 
	}
	
	
	/**
	 * Armazena todas as altera��es de turmas, calend�rio, atividades, locais, usu�rios, etc; assim como o log e 
	 * qualquer intera��o realizada, para que o sistema possa ser continuado a cada execu��o. Garante o armazenamento dos 
	 * dados apenas se esta op��o for escolhida. Esta opera��o tamb�m deve ser registrada no log. 
	 */
	public void salvarEstadoSistema() {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
		 Prompt.addLogUsr("Pedido para salvar estado do sistema.");
		System.out.println("Digite o nome do arquivo que deseja salvar:");
		String nome = Gerenciadores.sc.nextLine();
		Prompt.save(nome);
	}

	

		
		
}
