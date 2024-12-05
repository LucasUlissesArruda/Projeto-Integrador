package view;
import dao.AvaliacaoProdDao;
import dao.ProdutosDao;
import model.AvaliacaoProd;
import model.Produtos;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class janelaSelecionarProduto implements ActionListener {
    JButton btOk, btCanc;
    JLabel lbProduto;
    String [] produtos;
    JComboBox cbxProdutos;
    int idAvaliacao;

    public janelaSelecionarProduto(int id){
        JFrame janela = new JFrame("Cadastro de Produtos");
        janela.setSize(270, 200); // tamanho da tela
        janela.setLocationRelativeTo(null); // centraliza na tela
        janela.setLayout(new FlowLayout(1, 10, 10));

        idAvaliacao = id;


        lbProduto = new JLabel("Selecione o Produto");
        carregarProdutos();
        cbxProdutos = new JComboBox<>(produtos);

        btOk = new JButton("Selecionar");
        btCanc = new JButton("Cancelar");


        janela.add(lbProduto);
        janela.add(cbxProdutos);

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
            int idprodutos = cbxProdutos.getSelectedIndex();

            EntityManager em = JPAUtil.getEtityManager();
            AvaliacaoProdDao avaliacaoProdDao = new AvaliacaoProdDao(em);
            em.getTransaction().begin();
            AvaliacaoProd avaliacaoProd = avaliacaoProdDao.buscarPorId(idAvaliacao);
            avaliacaoProdDao.alterar(avaliacaoProd);
            avaliacaoProd.setIdproduto(idprodutos);

            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");

        } else if (e.getSource() == btCanc) {
            cbxProdutos.setSelectedIndex(0);
        }
    }

    public void carregarProdutos() {
        EntityManager em = JPAUtil.getEtityManager();
        ProdutosDao produtosDao = new ProdutosDao(em);
        List<Produtos> todos = produtosDao.buscarTodos();
        int numReg = todos.size();
        produtos = new String [numReg + 1]; // criar um vetor
        produtos[0] = "-- Selecione uma opção --";
        for (int i=0; i < numReg; i++) {
            produtos[i+1] = todos.get(i).getNomeProduto();
        }
    }

}
