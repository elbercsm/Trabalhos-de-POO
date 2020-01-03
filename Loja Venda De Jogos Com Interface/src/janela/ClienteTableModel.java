package janela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import principal.Cliente;

public class ClienteTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	// Lista de Clientes a serem exibidos na tabela
	private List<Cliente> linhas;

	// Constantes representando o �ndice das colunas
	private static final int NOME = 0;
	private static final int IDADE = 1;
	private static final int ENDERECO = 2;
	private static final int BAIRRO = 3;
	private static final int CEP = 4;
	private static final int NUMEROCASA = 5;
	private static final int TELEFONE = 6;
	private static final int EMAIL = 7;

	// Array com os nomes das colunas.
	private String[] colunas = new String[] {"Nome", "Idade", "Endere�o", "Bairro","Cep", "N�", "Telefone", "E-mail" };


	// Cria um ClienteTableModel sem nenhuma linha
	public ClienteTableModel() {
		linhas = new ArrayList<Cliente>();
	}
	// Cria um ClienteTableModel contendo a lista recebida por par�metro
	public ClienteTableModel(List<Cliente> listaDeClientes) {
		linhas = new ArrayList<Cliente>(listaDeClientes);
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
		case EMAIL:
			return String.class;
		case NOME:
			return String.class;
		case ENDERECO:
			return String.class;
		case TELEFONE:
			return String.class;
		case CEP:
			return String.class;
		case NUMEROCASA:
			return String.class;
		case IDADE:
			return String.class;	
		case BAIRRO:
			return String.class;
		default:
			// N�o deve ocorrer, pois s� existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Pega o s�cio referente a linha especificada.
		Cliente cliente = linhas.get(rowIndex);

		switch (columnIndex) {
		case EMAIL:
			return cliente.getEmail();
		case NOME:
			return cliente.getNome();
		case ENDERECO:
			return cliente.getEndereco();
		case TELEFONE:
			return cliente.getTelefone();
		case CEP:
			return cliente.getCep();
		case NUMEROCASA:
			return cliente.getNumeroCasa();
		case IDADE:
			return cliente.getIdade();
		case BAIRRO:
			return cliente.getBairro();
		default:
			// N�o deve ocorrer, pois s� existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	//Insere linha e coluna na tabela
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Pega o cliente referente a linha especificada.
		Cliente cliente = linhas.get(rowIndex);

		switch (columnIndex) {
		case EMAIL:
			cliente.setEmail((String) aValue);
			break;
		case NOME:
			cliente.setNome((String) aValue);
			break;
		case ENDERECO:
			cliente.setEndereco((String) aValue);
			break;
		case TELEFONE:
			cliente.setTelefone((String) aValue);
			break;
		case CEP:
			cliente.setCep((String) aValue);
			break;
		case NUMEROCASA:
			cliente.setNumeroCasa((String) aValue);
			break;
		case IDADE:
			cliente.setIdade((String) aValue);
			break;
		
		case BAIRRO:
			cliente.setBairro((String) aValue);
			break;
			
		default:
			// N�o deve ocorrer, pois s� existem 2 colunas
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualiza��o da c�lula
	}

	//_______________________________________Tratamento da Classe__________________________________________   

	// Retorna o s�cio referente a linha especificada
	public Cliente getCliente(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	// Adiciona o s�cio especificado ao modelo
	public void addCliente(Cliente cliente) {
		// Adiciona o registro.
		linhas.add(cliente);

		// Pega a quantidade de registros e subtrai 1 para
		// achar o �ltimo �ndice. A subtra��o � necess�ria
		// porque os �ndices come�am em zero.
		int ultimoIndice = getRowCount() - 1;

		// Notifica a mudan�a.
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	
	// Remove o s�cio da linha especificada.
	public void removeCliente(int indiceLinha) {
		// Remove o registro.
		linhas.remove(indiceLinha);

		// Notifica a mudan�a.
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	// Adiciona uma lista de s�cios no final da lista.
	public void addListaDeClientes(List<Cliente> clientes) {
		// Pega o tamanho antigo da tabela, que servir�
		// como �ndice para o primeiro dos novos registros
		int indice = getRowCount();

		// Adiciona os registros.
		linhas.addAll(clientes);

		// Notifica a mudan�a.
		fireTableRowsInserted(indice, indice + clientes.size());
	}

	// Remove todos os registros.
	public void limpar() {
		// Remove todos os elementos da lista de s�cios.
		linhas.clear();

		// Notifica a mudan�a.
		fireTableDataChanged();
	}

}
