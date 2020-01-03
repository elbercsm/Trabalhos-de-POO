package janela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import principal.Cliente;
import principal.Jogo;

public class TelaComprasTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	// Lista de Jogos a serem exibidos na tabela
	private List<Compra> linhas;

	// Constantes representando o �ndice das colunas
	private static final int NOMECLIENTE = 0;
	private static final int TELEFONECLIENTE = 1;
	private static final int CEPCLIENTE = 2;
	private static final int NOMEJOGO = 3;
	private static final int PRECOJOGO = 4;
	private static final int QTDJOGO = 5;

	// Array com os nomes das colunas.
	private String[] colunas = new String[] {"Nome Cliente", "Telefone", "Cep","Nome Jogo", "Pre�o", "Quantidade"};


	// Cria um JogoTableModel sem nenhuma linha
	public TelaComprasTableModel() {
		linhas = new ArrayList<Compra>();
	}
	// Cria um JogoTableModel contendo a lista recebida por par�metro
	public TelaComprasTableModel(List<Compra> listaDeCompras) {
		linhas = new ArrayList<Compra>(listaDeCompras);
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
		case NOMECLIENTE:
			return String.class;
		case TELEFONECLIENTE:
			return String.class;
		case CEPCLIENTE:
			return String.class;
		case NOMEJOGO:
			return String.class;
		case PRECOJOGO:
			return Float.class;
		case QTDJOGO:
			return int.class;
		default:
			// N�o deve ocorrer, pois s� existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Pega o s�cio referente a linha especificada.
		Compra compra = linhas.get(rowIndex);

		switch (columnIndex) {
		case NOMECLIENTE:
			return compra.getNomeCliente();
		case TELEFONECLIENTE:
			return compra.getTelefoneCliente();
		case CEPCLIENTE:
			return compra.getCepCliente();
		case NOMEJOGO:
			return compra.getNomeJogo();
		case QTDJOGO:
			return compra.getQtdJogo();
		case PRECOJOGO:
			return compra.getPrecoJogo();
		default:
			// N�o deve ocorrer, pois s� existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	//Insere linha e coluna na tabela
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Pega o cliente referente a linha especificada.
		Compra compra = linhas.get(rowIndex);

		switch (columnIndex) {
		case NOMECLIENTE:
			compra.setNomeCliente((String) aValue);
			break;
		case TELEFONECLIENTE:
			compra.setTelefoneCliente((String) aValue);
			break;
		case CEPCLIENTE:
			compra.setCepCliente((String) aValue);
			break;
		case NOMEJOGO:
			compra.setNomeJogo((String) aValue);
			break;
		case PRECOJOGO:
			compra.setPrecoJogo((Float) aValue);
			break;
		case QTDJOGO:
			compra.setQtdJogo((int) aValue);
			break;
			
		default:
			// N�o deve ocorrer, pois s� existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualiza��o da c�lula
	}

	//_______________________________________Tratamento da Classe__________________________________________   

	// Retorna o s�cio referente a linha especificada
	public Compra getCompra(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	// Adiciona o s�cio especificado ao modelo
	public void addCompra(Compra compra) {
		// Adiciona o registro.
		linhas.add(compra);

		// Pega a quantidade de registros e subtrai 1 para
		// achar o �ltimo �ndice. A subtra��o � necess�ria
		// porque os �ndices come�am em zero.
		int ultimoIndice = getRowCount() - 1;

		// Notifica a mudan�a.
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	
	// Remove o s�cio da linha especificada.
	public void removeCompra(int indiceLinha) {
		// Remove o registro.
		linhas.remove(indiceLinha);

		// Notifica a mudan�a.
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	// Adiciona uma lista de s�cios no final da lista.
	public void addListaDeCompras(List<Compra> compras) {
		// Pega o tamanho antigo da tabela, que servir�
		// como �ndice para o primeiro dos novos registros
		int indice = getRowCount();

		// Adiciona os registros.
		linhas.addAll(compras);

		// Notifica a mudan�a.
		fireTableRowsInserted(indice, indice + compras.size());
	}

	// Remove todos os registros.
	public void limpar() {
		// Remove todos os elementos da lista de s�cios.
		linhas.clear();

		// Notifica a mudan�a.
		fireTableDataChanged();
	}

}
