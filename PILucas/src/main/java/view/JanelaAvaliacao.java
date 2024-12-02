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

public class JanelaAvaliacao implements ActionListener {
    JButton btOk, btCanc;
    JLabel lbNota, lbObservacao,lbProduto;
    JTextField tfNota, tfObservacao;
    String [] Produto;
    JComboBox cbxProduto;

    public JanelaAvaliacao(){
        JFrame janela = new JFrame("Cadastro de Avaliações");
        janela.setSize(310, 200); // tamanho da tela
        janela.setLocationRelativeTo(null); // centraliza na tela
        janela.setLayout(new FlowLayout(1, 10, 10));

        lbProduto = new JLabel("Produto");
        carregarproduto();
        cbxProduto = new JComboBox<>(Produto);

        lbNota = new JLabel("Nota do Produto");
        tfNota = new JTextField(10);

        lbObservacao = new JLabel("Digite uma Observação");
        tfObservacao = new JTextField(10);

        btOk = new JButton("Cadastrar");
        btCanc = new JButton("Cancelar");

        janela.add(lbProduto);
        janela.add(cbxProduto);

        janela.add(lbNota);
        janela.add(tfNota);

        janela.add(lbObservacao);
        janela.add(tfObservacao);

        janela.add(btOk);
        janela.add(btCanc);

        btOk.addActionListener(this);
        btCanc.addActionListener(this);


        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btOk){
            int nota = Integer.parseInt(tfNota.getText());
            String observacao = tfObservacao.getText();

            int idProduto = cbxProduto.getSelectedIndex();

            AvaliacaoProd avaliacao = new AvaliacaoProd(nota,idProduto, observacao);

            EntityManager em = JPAUtil.getEtityManager();
            AvaliacaoProdDao avaliacaoProdDao = new AvaliacaoProdDao(em);
            em.getTransaction().begin();
            avaliacaoProdDao.cadastrar(avaliacao);
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
        } else if (e.getSource() == btCanc) {
            tfNota.setText("");
            tfObservacao.setText("");
            cbxProduto.setSelectedIndex(0);
        }
    }
    public void carregarproduto() {
        EntityManager em = JPAUtil.getEtityManager();
        ProdutosDao produtosDao = new ProdutosDao(em);
        List<Produtos> todos = produtosDao.buscarTodos();
        int numReg = todos.size();
        Produto = new String [numReg + 1]; // criar um vetor
        Produto[0] = "-- Selecione uma opção --";
        for (int i=0; i < numReg; i++) {
            Produto[i+1] = todos.get(i).getNomeProduto();
        }
    }
}
