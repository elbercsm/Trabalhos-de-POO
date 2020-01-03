package janela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import principal.Cliente;
import principal.Jogo;

public class JogoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	// Lista de Jogos a serem exibidos na tabela
	private List<Jogo> linhas;

	// Constantes representando o �ndice das colunas
	private static final int NOME = 0;
	private static final int PLATAFORMA = 1;
	private static final int GENERO = 2;
	private static final int DATALANCAMENTO = 3;
	private static final int CLASSIFICACAO = 4;
	private static final int PRECO = 5;

	// Array com os nomes das colunas.
	private String[] colunas = new String[] {"Nome", "Plataforma", "G�nero","Data Lan�amento", "Classifica��o", "Pre�o"};


	// Cria um JogoTableModel sem nenhuma linha
	public JogoTableModel() {
		linhas = new ArrayList<Jogo>();
	}
	// Cria um JogoTableModel contendo a lista recebida por par�metro
	public JogoTableModel(List<Jogo> listaDeJogos) {
		linhas = new ArrayList<Jogo>(listaDeJogos);
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	};

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case NOME:
			return String.class;
		case PLATAFORMA:
			return String.class;
		case GENERO:
			return String.class;
		case DATALANCAMENTO:
			return String.class;
		case CLASSIFICACAO:
			return String.class;
		case PRECO:
			return String.class;
		default:
			// N�o deve ocorrer, pois s� existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Pega o s�cio referente a linha especificada.
		Jogo jogo = linhas.get(rowIndex);

		switch (columnIndex) {
		case NOME:
			return jogo.getNomeJogo();
		case PLATAFORMA:
			return jogo.getPlataforma();
		case GENERO:
			return jogo.getGenero();
		case CLASSIFICACAO:
			return jogo.getClassificacao();
		case DATALANCAMENTO:
			return jogo.getDataLancamento();
		case PRECO:
			return jogo.getPreco();
		default:
			// N�o deve ocorrer, pois s� existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	//Insere linha e coluna na tabela
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Pega o cliente referente a linha especificada.
		Jogo jogo = linhas.get(rowIndex);

		switch (columnIndex) {
		case NOME:
			jogo.setNomeJogo((String) aValue);
			break;
		case PLATAFORMA:
			jogo.setPlataforma((String) aValue);
			break;
		case GENERO:
			jogo.setGenero((String) aValue);
			break;
		case CLASSIFICACAO:
			jogo.setClassificacao((String) aValue);
			break;
		case DATALANCAMENTO:
			jogo.setDataLancamento((String) aValue);
			break;
		case PRECO:
			jogo.setPreco((Float) aValue);
			break;
			
		default:
			// N�o deve ocorrer, pois s� existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualiza��o da c�lula
	}

	//_______________________________________Tratamento da Classe__________________________________________   

	// Retorna o s�cio referente a linha especificada
	public Jogo getJogo(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	// Adiciona o s�cio especificado ao modelo
	public void addJogo(Jogo jogo) {
		// Adiciona o registro.
		linhas.add(jogo);

		// Pega a quantidade de registros e subtrai 1 para
		// achar o �ltimo �ndice. A subtra��o � necess�ria
		// porque os �ndices come�am em zero.
		int ultimoIndice = getRowCount() - 1;

		// Notifica a mudan�a.
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	
	// Remove o s�cio da linha especificada.
	public void removeJogo(int indiceLinha) {
		// Remove o registro.
		linhas.remove(indiceLinha);

		// Notifica a mudan�a.
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	// Adiciona uma lista de s�cios no final da lista.
	public void addListaDeJogos(List<Jogo> jogos) {
		// Pega o tamanho antigo da tabela, que servir�
		// como �ndice para o primeiro dos novos registros
		int indice = getRowCount();

		// Adiciona os registros.
		linhas.addAll(jogos);

		// Notifica a mudan�a.
		fireTableRowsInserted(indice, indice + jogos.size());
	}

	// Remove todos os registros.
	public void limpar() {
		// Remove todos os elementos da lista de s�cios.
		linhas.clear();

		// Notifica a mudan�a.
		fireTableDataChanged();
	}

}
