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

	// Constantes representando o índice das colunas
	private static final int NOME = 0;
	private static final int PLATAFORMA = 1;
	private static final int GENERO = 2;
	private static final int DATALANCAMENTO = 3;
	private static final int CLASSIFICACAO = 4;
	private static final int PRECO = 5;

	// Array com os nomes das colunas.
	private String[] colunas = new String[] {"Nome", "Plataforma", "Gênero","Data Lançamento", "Classificação", "Preço"};


	// Cria um JogoTableModel sem nenhuma linha
	public JogoTableModel() {
		linhas = new ArrayList<Jogo>();
	}
	// Cria um JogoTableModel contendo a lista recebida por parâmetro
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
			// Não deve ocorrer, pois só existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Pega o sócio referente a linha especificada.
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
			// Não deve ocorrer, pois só existem 2 colunas
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
			// Não deve ocorrer, pois só existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
	}

	//_______________________________________Tratamento da Classe__________________________________________   

	// Retorna o sócio referente a linha especificada
	public Jogo getJogo(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	// Adiciona o sócio especificado ao modelo
	public void addJogo(Jogo jogo) {
		// Adiciona o registro.
		linhas.add(jogo);

		// Pega a quantidade de registros e subtrai 1 para
		// achar o último índice. A subtração é necessária
		// porque os índices começam em zero.
		int ultimoIndice = getRowCount() - 1;

		// Notifica a mudança.
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	
	// Remove o sócio da linha especificada.
	public void removeJogo(int indiceLinha) {
		// Remove o registro.
		linhas.remove(indiceLinha);

		// Notifica a mudança.
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	// Adiciona uma lista de sócios no final da lista.
	public void addListaDeJogos(List<Jogo> jogos) {
		// Pega o tamanho antigo da tabela, que servirá
		// como índice para o primeiro dos novos registros
		int indice = getRowCount();

		// Adiciona os registros.
		linhas.addAll(jogos);

		// Notifica a mudança.
		fireTableRowsInserted(indice, indice + jogos.size());
	}

	// Remove todos os registros.
	public void limpar() {
		// Remove todos os elementos da lista de sócios.
		linhas.clear();

		// Notifica a mudança.
		fireTableDataChanged();
	}

}
