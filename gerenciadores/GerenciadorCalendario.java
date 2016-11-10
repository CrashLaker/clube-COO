package gerenciadores;

import java.sql.Date;
import java.util.List;

 /*
 * A = Atividade
 * T = Turma
 * L = Local
 * U = usuario
 */

public class GerenciadorCalendario <A,T,L,U>{
	
	
	
	/**
	 * Cria uma turma no calend�rio em determinado hor�rio, com uma atividade,
	 * capacidade e um local. A turma no momento de sua cria��o tem de estar com capacidade vazia (nenhum usu�rio).
	 * Os usu�rios s�o adicionados posteriormente. Verifica se a atividade pode 
	 * pertencer a sala, e se o hor�rio � compat�vel (conflito com outras atividades e hor�rio
	 * de funcionamento).
	 * @return true - se a turma pode ser alocada com determinada atividade
	 * no local e hor�rio desejados  
	 * false - se a turma n�o puder ser alocada 
	 */
	public boolean adicionaTurma(T turma) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */
		 
		
		 
		return false;
	}
	
	/**
	 * Cria uma turma para cada item em uma lista de turmas no calend�rio para um mesmo local. Cada qual com seu determinado hor�rio, com uma atividade,
	 * capacidade. As turmas no momento de sua cria��o tem de estar com capacidade vazias (nenhum usu�rio).
	 * Os usu�rios s�o adicionados posteriormente. Verifica se as atividades podem 
	 * pertencer �s salas, e se os hor�rios s�o compativeis (conflito com outras atividades e hor�rio
	 * de funcionamento).
	 * @return true - se todas as turmas podem ser alocadas com determinada atividade,
	 * no local e hor�rio desejados  
	 * false - se as turmas n�o puderem ser alocadas 
	 */
	public boolean adicionaTurmasLocal(List<T> turmas, L local) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */
		return false;
	}
	
	/**
	 * Exibe as informa��es de todas as turmas pertencentes a um local. Exibe tamb�m
	 * os hor�rios e ocorr�ncias no calend�rio, como dura��o, ocorr�ncia, quando termina, etc.
	 */
	public void exibeTurmasLocal(L local) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */
	}
	
	/**
	 * Exibe todas as informa��es de todas turmas de determinada atividade. 
	 * @param atividade - atividade para exibi��o de turmas
	 */
	public void exibeTurmasAtividade(A atividade) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */
	}
	
	/**
	 * Exibe todas as informa��es de todas as turmas criadas, incluindo os locais,
	 *  atividades, n�mero de participantes, hor�rios, etc.
	 */
	public void exibeTodasTurmas() {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */
	}
	
	
		
	/**
	 * Altera o dia, a hora de in�cio e a hora de fim que uma turma ocorre 
	 * e verifica conflitos entre os usu�rios que participam de uma outra turma no
	 * novo dia e hor�rio. Os usu�rios em conflito s�o removidos. N�o � obrigat�rio
	 * que dia, hora inicio e hora fim sejam alterados ao mesmo tempo.
	 * @param turma - turma a ser reagendada
	 * @param dia - novo dia da semana para a atividade ocorrer
	 * @param inicio - nova hora de inicio
	 * @param fim - nova hora de fim 
	 * @return List<U> - contendo os usu�rios removidos por conflito de hor�rios. Uma 
	 * mensagem indicando a opera��o pode ser configurada no log, mas deve conter o n�mero
	 * de usu�rios removidos
	 *  
	 */
	public List<U> reagendaTurma(T turma, Date dia, Date inicio, Date fim) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
		return null;
	}
	
	
	/**
	 * Remove a turma do calendario deixando a sala, os hor�rios e os usu�rios
	 * livres. Primeiro exibe todos os campos da turma e exige confirma��o por entrada
	 * do usu�rio para completar a opera��o.
	 * @param turma - turma a ser removida
	 * @return true - se confirma remo��o; false - se cancela remo��o
	 * 
	 */
	public boolean removeTurma(T turma) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
		return false;
	}
	
	
	/**
	 * Altera o local (sala) que a turma ocorre verificando se h� disponibilidade
	 * no mesmo hor�rio no local novo, e se o local novo pode receber atividades do
	 * tipo da atividade da turma. Se houver qualquer conflito n�o altera o local.
	 * @param turma - turma que ter� local alterado
	 * @param local - novo local
	 * @return true - se alterou local, false - caso contr�rio
	 */
	public boolean alteraLocal(T turma, L local){
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
		return false;
	};
	
	
	/**
	 * Adiciona um usu�rio a uma turma verificando se a turma possui capacidade livre
	 *  (n�o est� cheia), se o usu�rio n�o participa de uma outra turma no mesmo hor�rio, e
	 *  se o usu�rio ja participa de duas turmas em um mesmo dia. Em caso de conflitos o usu�rio n�o � adicionado.  
	 * @param usuario - usu�rio a ser adicionado
	 * @param turma - turma a incluir o usu�rio
	 * @return true - se usu�rio foi incluido; false - caso o contr�rio
	 */
	public boolean adicionaUsuarioTurma(U usuario, T turma) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
		return false;
	}
	
	/**
	 * Remove o usu�rio da turma permitindo que ele possa estar eleito para ingressar em outra 
	 * turma naquele hor�rio e libera a capacidade da turma para um novo usu�rio. Primeiro exibe todas as informa��es
	 * principais de usu�rio, incluindo outras turmas, atividades, hor�rios e locais que ele frequenta e exige confirma��o
	 * por entrada do usu�rio para completar opera��o.
	 * @param usuario - usu�rio a ser removido
	 * @param turma - turma da qual o usu�rio ser� removido
	 * @return true - se confirma remo��o; false - se cancela remo��o
	 */
	public boolean removeUsuarioAtividade(U usuario, T turma) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
		return false;
	}
	
	
	
	
	
	
	
	

}
