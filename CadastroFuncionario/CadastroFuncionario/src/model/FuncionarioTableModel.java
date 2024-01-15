package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FuncionarioTableModel extends AbstractTableModel {

    private List<Funcionario> dados = new ArrayList<>();
    private String[] colunas = {"Nome", "Email", "Funcao", "Endereco", "cpf", "Rg", "Telefone", "Registro"};

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    // pega quantidade de linhas da tabela
    @Override
    public int getRowCount() {
        return dados.size();
    }

    // pega quantidade de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    // pega o objeto clicado
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getNome();
            case 1:
                return dados.get(linha).getEmail();  
            case 2:
                return dados.get(linha).getFuncao();
            case 3:
                return dados.get(linha).getEndereco();
            case 4:
                return dados.get(linha).getCpf();
            case 5:
                return dados.get(linha).getRg();
            case 6:
                return dados.get(linha).getTelefone();
            case 7:
                return dados.get(linha).getRegistro();
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        
        switch (coluna)
        {
            case 0:
                dados.get(linha).setNome( (String) valor);
                break;
            case 1:
                dados.get(linha).setEmail( ( (String) valor));
                break;
            case 2:
                dados.get(linha).setEndereco( (String) valor);
                break;
            case 3:
                dados.get(linha).setCpf( (String) valor);
            case 4:
                dados.get(linha).setRg( (String) valor);
                break;
            case 5:
                dados.get(linha).setRegistro( Integer.parseInt((String) valor));
                break;
            case 6:
                dados.get(linha).setFuncao( (String) valor);
                break;
             case 7:
                dados.get(linha).setTelefone( (String) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
        
    }

    public void adicionaLinha(Funcionario p) {
        // insere o produto p na coleção dados
        this.dados.add(p);
        // atualiza a tabela quando houver atualização de dados
        this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        // remove o produto p da coleção dados
        this.dados.remove(linha);
        // atualiza a tabela removendo a linha escolhida
        this.fireTableRowsDeleted(linha, linha);
    }
    
    // metodo criado para atulização dos TextFields quando usuario clicar 
    // em uma linha da tabela
    public Funcionario getDados (int linha){
        // retorna do produto que está na linha indicada
        return dados.get(linha);
    }

}
