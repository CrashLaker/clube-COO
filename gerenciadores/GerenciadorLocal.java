package gerenciadores;

import java.util.List;
import clube.*;

public class GerenciadorLocal<L> {
	
	//metodos de Locais
	
	/**
	 * Cadastra novo Local, informando primeiro os campos que devem ser preenchidos.
	 * Os campos s�o preenchidos por meio de entrada do usu�rio. Se j� houver Local com 
	 * o mesmo nome n�o realiza o cadastro e uma mensagem deve ser exibida.
	 * @return boolean - true se o local foi cadastrado ; false - caso contr�rio
	 */
	public boolean cadastrarNovoLocal() {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
		 String input = "";
		 String output = "";
		 System.out.print("Nome Loca: ");
		 input = Gerenciadores.sc.nextLine();
		 if (input.equals("")){
		 	return false;
		 }
		 output = output.concat(input);
		 output = output.concat(", ");
		 System.out.print("0 -> Fora 1 -> Interno: ");
		 input = Gerenciadores.sc.nextLine();
		 if (input.equals("")){
		 	return false;
		 }
		 output = output.concat(input);
		 Prompt.command(String.format("insert into room values(%d, %s)", Prompt.rC(), output));
		 return true;
	}
	
	
	/**
	 * Cadastra uma lista de locais.
	 * @param locais - lista de locais a serem cadastrados segundo sua implementa��o.
	 * Se j� houver um local com o mesmo nome n�o realiza o cadastro daquele, os outros s�o
	 * cadastrados se n�o houver conflito.
	 * @return boolean - true se todos os locais forem cadastrados ; false - caso
	 * um ou mais locais n�o tiverem sido cadastrados
	 */
	public void cadastrarNovosLocais(List<L> locais) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
	
	/***
	 * Exibe todos os campos do local.
	 * @param nomeLocal - nome do local a ser visualizado
	 * 
	 */
	public void visualizarLocal(String nomeLocal) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
	
	/***
	 * Exibe todos os campos do local.
	 * @param id - identificador do local a ser visualizado
	 * 
	 */
	public void visualizarLocal(int id) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
			
	/**
	 * Exibe o n�mero total de locais cadastradas e todos os campos de cada um
	 * @return int - contendo o n�mero de locais cadastrados. 
	 */
	public int visualizarTodosLocais() {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
		return 0;
	}
			
	/**
	 * Altera um ou mais campos do local passado como par�metro.
	 * @param nomeLocal - nome do local a ser editado
	 *  
	 */		
	public void editarLocal(String nomeLocal) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
	
	/**
	 * Exibe todos os campos do local passado como par�metro e altera um ou mais campos. 
	 * Os campos s�o preenchidos por meio de entrada do usu�rio. 
	 * @param id - identificador do local a ser editado
	 * 
	 */
	public void editarLocal(int id) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
	}
			
	/**
	 * Exibe todos os campos do local e exige confirma��o para realizar a remo��o.
	 * confirma��o � realizada por entrada do usu�rio.
	 * @param nomeLocal - nome local a ser removido
	 * @return true - se confirma remo��o; false - se cancela remo��o
	 */
	public boolean removerLocal(String nomeLocal) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
		return false;
	}
			
	/**
	 * Exibe todos os campos do local e exige confirma��o para realizar a remo��o.
	 * confirma��o � realizada por entrada do usu�rio.
	 * @param id - identificador do local a ser removido
	 * @return true - se confirma remo��o; false - se cancela remo��o
	 */
	public boolean removerLocal(int id) {
		/**
		 * TODO implementar este m�todo seguindo a descri��o acima
		 */	
		return false;
	}

}
