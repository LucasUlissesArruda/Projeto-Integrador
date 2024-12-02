package view;

import dao.CategoriaDao;
import dao.MarcaDao;
import dao.ProdutosDao;

import model.Produtos;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class JanelaProdutos implements ActionListener {
    JButton btOk, btCanc;
    JLabel lbnomeProduto, lbValor, lbdescProduto, lbqtdEstoque, lbMarca, lbCategoria;
    JTextField tfNomeProduto, tfValor, tfdescProduto, tfqtdEstoque;
    String [] Marca;
    String [] Categoria;
    JComboBox cbxMarca, cbxCategoria;

    public JanelaProdutos(){
        JFrame janela = new JFrame("Cadastro de Produtos");
        janela.setSize(270, 400); // tamanho da tela
        janela.setLocationRelativeTo(null); // centraliza na tela
        janela.setLayout(new FlowLayout(1, 10, 10));

        lbnomeProduto = new JLabel("Nome Produto");
        tfNomeProduto = new JTextField(20);

        lbValor = new JLabel("Valor");
        tfValor = new JTextField(20);

        lbdescProduto = new JLabel("Descrição Produto");
        tfdescProduto = new JTextField(20);

        lbqtdEstoque = new JLabel("Qtd Estoque");
        tfqtdEstoque = new JTextField(20);

        lbMarca = new JLabel("Marca");
        carregarmarcas();
        cbxMarca = new JComboBox<>(Marca);

        lbCategoria = new JLabel("Categoria");
        carregarCategoria();
        cbxCategoria = new JComboBox<>(Categoria);

        btOk = new JButton("Cadastrar");
        btCanc = new JButton("Cancelar");

        janela.add(lbnomeProduto);
        janela.add(tfNomeProduto);

        janela.add(lbValor);
        janela.add(tfValor);

        janela.add(lbdescProduto);
        janela.add(tfdescProduto);

        janela.add(lbqtdEstoque);
        janela.add(tfqtdEstoque);

        janela.add(lbMarca);
        janela.add(cbxMarca);

        janela.add(lbCategoria);
        janela.add(cbxCategoria);

        janela.add(btOk);
        janela.add(btCanc);

        btOk.addActionListener(this);
        btCanc.addActionListener(this);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btOk){
            String nomeProduto = tfNomeProduto.getText();
            float valor = Float.parseFloat(tfValor.getText());
            String descricaoProduto = tfdescProduto.getText();
            int qtdEstoque = Integer.parseInt(tfqtdEstoque.getText());

            int idMarca = cbxMarca.getSelectedIndex();
            int idCategoria = cbxCategoria.getSelectedIndex();
            Produtos produto = new Produtos( descricaoProduto, nomeProduto,valor,  qtdEstoque, idMarca,idCategoria);

            EntityManager em = JPAUtil.getEtityManager();
            ProdutosDao produtosDao = new ProdutosDao(em);
            em.getTransaction().begin();
            produtosDao.cadastrar(produto);
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");

        }else if (e.getSource() == btCanc) {
            tfNomeProduto.setText("");
            tfValor.setText("");
            tfdescProduto.setText("");
            tfqtdEstoque.setText("");
            cbxMarca.setSelectedIndex(0);
            cbxCategoria.setSelectedIndex(0);
        }
    }
    public void carregarmarcas() {
        EntityManager em = JPAUtil.getEtityManager();
        MarcaDao marcaDao = new MarcaDao(em);
        List<model.Marca> todos = marcaDao.buscarTodos();
        int numReg = todos.size();
        Marca = new String [numReg + 1]; // criar um vetor
        Marca[0] = "-- Selecione uma opção --";
        for (int i=0; i < numReg; i++) {
            Marca[i+1] = todos.get(i).getDescricao();
        }
    }
    public void carregarCategoria() {
        EntityManager em = JPAUtil.getEtityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);
        List<model.Categoria> todos = categoriaDao.buscarTodos();
        int numReg = todos.size();
        Categoria = new String [numReg + 1]; // criar um vetor
        Categoria[0] = "-- Selecione uma opção --";
        for (int i=0; i < numReg; i++) {
            Categoria[i+1] = todos.get(i).getDescricao();
        }
    }
}
