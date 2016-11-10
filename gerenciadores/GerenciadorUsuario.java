package gerenciadores;


import java.nio.file.Path;
import java.util.List;
import java.util.*;
import log.*;
import clube.*;
import java.io.*;


public class GerenciadorUsuario <U>{

	
	// metodos de usu�rios
		/**
		 * Cadastra usu�rios baseado no formato do sistema antigo do clube de jogos.
		 * Devem ser incorporados e adaptados os campos de acordo com sua implementa��o 
		 * de usu�rio. Se os usu�rios j� estiverem no sistema n�o devem ser cadastrados
		 * novamente e uma mensagem deve ser emitida. 
		 * @param arquivo - caminho para o aquivo contendo os registros antigos
		 * @return boolean - true se todos os usu�rios forem cadastrados ; false - caso
		 * um ou mais usu�rios n�o tenham sido cadastrados
		 */
		 
		 //Formato arquivo legado: nome0,idade0,sexo0,endereco0,telefone0/nome1,idade1,sexo1,endereco1,telefone1/...
		 //"," sem espaco separa campo e "|" separa registros
		public boolean cadastraUsuariosAntigos(Path arquivo) {
			/**
			 * TODO implementar este m�todo seguindo a descri��o acima
			 */	
			File file = new File(arquivo.getFileName().toString());
			try{
			Scanner input = new Scanner(file);
			String linha = input.nextLine();
			String[] alunos = linha.split("\\|");
			for (String aluno : alunos){
				Prompt.command(String.format("insert into student values(%d, %s)", Prompt.stdC(), aluno.replaceAll(",", ", ")));
			}
			Prompt.addLogUsr("Usuarios antigos adicionados com sucesso!");
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return false;
	}
		
		
		/**
		 * Cria um arquivo contendo todos os usu�rios cadastrados no sistema seguindo
		 * a modelagem e os campos descritos para o arquivo do sistema antigo. Utiliza a mesma formata��o
		 * do arquivo do sistema antigo para escrever o novo arquivo com os dados exportados.
		 * Voc� deve incrementar o arquivo a cada vez que este m�todo for executado.
		 */
		public void exportaUsuariosSistemaAntigo() {
			/**
			 * TODO implementar este m�todo seguindo a descri��o acima
			 */
			 Prompt.usuariosSistemaAntigo();
			 
		}
		
		/**
		 * Cadastra novo usu�rio, informando primeiro os campos que devem ser preenchidos.
		 * Os campos s�o preenchidos por meio de entrada do usu�rio. Se j� houver usu�rio com 
		 * o mesmo nome n�o realiza o cadastro e uma mensagem deve ser exibida.
		 * @return boolean - true se o usu�rio foi cadastrado ; false - caso contr�rio
		 */
		public boolean cadastrarNovoUsuario() {
			/**
			 * TODO implementar este m�todo seguindo a descri��o acima
			 */	
			
            // insert into student values(id[0], nome[1], idade[2], sexo[3], endereco[4], telefone[5])
			ArrayList<String> form = Prompt.genForm("nome, idade, sexo, endereco, telefone");
			String output = "";
			for (int i = 0; i < form.size(); i++){
				String item = form.get(i);
				System.out.printf("Insira campo [%s]:", item);
				String input = Gerenciadores.sc.nextLine();
				if (input.equals("")) {
					return false;
				}
				output = output.concat(input);
				if (i != form.size()-1) output = output.concat(", ");
			}
			Prompt.command(String.format("insert into student values(%d, %s)", Prompt.stdC(), output));
			return true;
		}
		
		/**
		 * Cadastra uma lista de usu�rios.
		 * @param usuarios - lista de usu�rios a serem cadastrados segundo sua implementa��o.
		 * Se j� houver um usu�rio com o mesmo nome n�o realiza o cadastro daquele, os outros s�o
		 * cadastrados se n�o houver conflito.
		 * @return boolean - true se todos os usu�rios forem cadastrados ; false - caso
		 * um ou mais usu�rios n�o tiverem sido cadastrados
		 */
		public boolean cadastrarNovosUsuarios(List<U> usuarios) {
			/**
			 * TODO implementar este m�todo seguindo a descri��o acima
			 */	
			return false;
		}
		
		/***
		 * Exibe todos os campos de usu�rio e as turmas que participa. Tamb�m exibe a atividade
		 * da turma, local que ocorre e hor�rio
		 * @param nomeUsuario - nome do usu�rio a ser visualizado
		 * 
		 */
		public void visualizarUsuario(String nomeUsuario) {
			/**
			 * TODO implementar este m�todo seguindo a descri��o acima
			 */	
		}
		
		/**
		 * Exibe todos os campos de usu�rios e as turmas que participa. Tamb�m exibe a atividade
		 * da turma, local que ocorre e hor�rio
		 * @param nMatricula - n�mero de matr�cula do usu�rio a ser visualizado
		 */
		public void visualizarUsuario(int nMatricula) {
			/**
			 * TODO implementar este m�todo seguindo a descri��o acima
			 */	
		}
		
		/**
		 * Exibe o n�mero total de usu�rios cadastrados e, para cada usu�rio, o nome, as turmas que participa,
		 * os locais que ocorrem as turmas.
		 * @return int - contendo o n�mero de usu�rios cadastrados
		 */
		public int visualizarTodosUsuarios() {
			/**
			 * TODO implementar este m�todo seguindo a descri��o acima
			 */	
			return 0;
		}
		
		/**
		 * Altera um ou mais campos do usu�rio passado como par�metro.
		 * @param nomeUsuario - nome do usu�rio a ser editado
		 *  
		 */
		public void editarUsuario(String nomeUsuario) {
			/**
			 * TODO implementar este m�todo seguindo a descri��o acima
			 */	
		}
		
		/**
		 * Exibe todos os campos do usu�rio passado como par�metro e altera um ou mais campos. 
		 * Os campos s�o preenchidos por meio de entrada do usu�rio. 
		 * @param nMatricula - n�mero de matricula a ser editado
		 * 
		 */
		public void editarUsuario(int nMatricula) {
			/**
			 * TODO implementar este m�todo seguindo a descri��o acima
			 */	
		}
		
		/**
		 * Exibe todos os campos do usu�rio e exige confirma��o para realizar a remo��o.
		 * confirma��o � realizada por entrada do usu�rio.
		 * @param nomeUsuario - nome usu�rio a ser removido
		 * @return true - se confirma remo��o; false - se cancela remo��o
		 */
		public boolean  removerUsuario(String nomeUsuario) {
			/**
			 * TODO implementar este m�todo seguindo a descri��o acima
			 */	
			return false;
		}
		
		/**
		 * Exibe todos os campos do usu�rio e exige confirma��o para realizar a remo��o.
		 * confirma��o � realizada por entrada do usu�rio.
		 * @param nMatricula - n�mero de matr�cula do usu�rio a ser removido
		 * @return true - se confirma remo��o; false - se cancela remo��o
		 */
		public boolean removerUsuario(int nMatricula) {
			/**
			 * TODO implementar este m�todo seguindo a descri��o acima
			 */	
			return false;
		}
	
}
