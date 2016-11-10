package gerenciadores;
import clube.*;
import java.util.*;


public class GerenciadorAtividade <A>{
	
	// metodos de Atividades
						
			
	/**
	 * Cadastra nova atividade, informando primeiro os campos que devem ser preenchidos.
	 * Deve especificar o tipo de local que ocorre.
	 * Os campos s�o preenchidos por meio de entrada do usu�rio. Se j� houver atividade com 
	 * o mesmo nome n�o realiza o cadastro e uma mensagem deve ser exibida.
	 * @return boolean - true se a atividade foi cadastrada ; false - caso contr�rio
	 */
	public boolean cadastrarAtividade() {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
		 
		 ArrayList<String> form = Prompt.genForm("Nome Atividade, Duração Atividade, Data Realização [dia:mes:hora], Quantidade inscritos, Espaço ocupado, grupo ou individual, Pontos ganhos");
		 String output = "";
		 for (int i = 0; i < form.size(); i++){
		 	System.out.print(form.get(i)+": ");
		 	String input = Gerenciadores.sc.nextLine();
		 	if (input.equals("")) return false;
		 	output = output.concat(input);
		 	if (i != form.size()-1) output = output.concat(", ");
		 }
		 
		 Prompt.command(String.format("insert into activity values(%d, %s", Prompt.aC(), output));
		return true;
	}
	
	/**
	 * Cadastra uma lista de atividades. Se j� houver uma atividade com o mesmo nome n�o realiza o cadastro daquela, as outras s�o
	 * cadastradas se n�o houver conflito.
	 * @param atividades - lista de atividades a serem cadastradas segundo sua implementa��o
	 * @return boolean - true se todas as atividades forem cadastradas ; false - caso
	 * uma ou mais atividades n�o tiverem sido cadastradas
	 */
	public boolean cadastrarNovasAtividade(List<A> atividades) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
		return false;
	}
			
	/***
	 * Exibe todos os campos da atividade.
	 * @param nomeAtividade - nome da atividade a ser visualizada
	 * 
	 */		
	public void visualizarAtividade(String nomeAtividade) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
	
	
	/***
	 * Exibe todos os campos da atividade.
	 * @param id - identificador da atividade a ser visualizada
	 * 
	 */
	public void visualizarAtividade(int id) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
	
	/**
	 * Exibe o numero total de atividades cadastradas e todos os campos de cada uma.
	 * @return int - contendo o numero de atividades cadastradas 
	 */
	public int visualizarTodasAtividades() {
		return 0;
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
	
	
	/**
	 * Altera um ou mais campos da atividade passada como par�metro.
	 * @param nomeAtividade - nome da atividade a ser editada
	 *  
	 */
	public void editarAtividade(String nomeAtividade) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
			
	/**
	 * Exibe todos os campos da atividade passado como par�metro e altera um ou mais campos. 
	 * Os campos s�o preenchidos por meio de entrada do usu�rio. 
	 * @param id - identificador da atividade a ser editada
	 * 
	 */		
	public void editarAtividade(int id) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
	
	/**
	 * Exibe todos os campos da atividade e exige confirma��o para realizar a remo��o.
	 * confirma��o � realizada por entrada do usu�rio.
	 * @param nomeAtividade - nome atividade a ser removida
	 * @return true - se confirma remo��o; false - se cancela remo��o
	 */
	public void removerAtividade(String nomeAtividade) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
	
	/**
	 * Exibe todos os campos da atividade e exige confirma��o para realizar a remo��o.
	 * confirma��o � realizada por entrada do usu�rio.
	 * @param id - identificador da atividade a ser removida
	 * @return true - se confirma remo��o; false - se cancela remo��o
	 */
	public void removerAtividade(int id) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}

}
