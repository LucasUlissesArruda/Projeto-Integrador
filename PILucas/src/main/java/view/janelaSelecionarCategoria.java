package view;

import dao.CategoriaDao;
import dao.ProdutosDao;
import model.Categoria;
import model.Produtos;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class janelaSelecionarCategoria implements ActionListener {
    JButton btOk, btCanc;
    JLabel lbCategoria;
    String[] categoria;
    JComboBox cbxCategoria;
    int idProduto;

    public janelaSelecionarCategoria(int id) {
        JFrame janela = new JFrame("Selecionar Categoria");
        janela.setSize(270, 200); // tamanho da tela
        janela.setLocationRelativeTo(null); // centraliza na tela
        janela.setLayout(new FlowLayout(1, 10, 10));

        idProduto = id;

        lbCategoria = new JLabel("Selecione a Categoria"); // Corrigido o texto da label
        carregarCategoria();
        cbxCategoria = new JComboBox<>(categoria);

        btOk = new JButton("Selecionar");
        btCanc = new JButton("Cancelar");

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
        if (e.getSource() == btOk) {
            int idCategoria = cbxCategoria.getSelectedIndex();

                EntityManager em = JPAUtil.getEtityManager();
                ProdutosDao produtosDao = new ProdutosDao(em);
                em.getTransaction().begin();

                Produtos produto = produtosDao.buscarPorId(idProduto); // Busca o produto correto
                produto.setIdCategoria(idCategoria); // Atualiza a categoria do produto

                produtosDao.alterar(produto); // Salva as alterações no banco

                em.getTransaction().commit();
                em.close();
                JOptionPane.showMessageDialog(null, "Categoria alterada com sucesso!");

        } else if (e.getSource() == btCanc) {
            cbxCategoria.setSelectedIndex(0);
        }
    }

    public void carregarCategoria() {
        EntityManager em = JPAUtil.getEtityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);
        List<Categoria> todos = categoriaDao.buscarTodos();
        int numReg = todos.size();
        categoria = new String[numReg + 1]; // criar um vetor
        categoria[0] = "-- Selecione uma opção --";
        for (int i = 0; i < numReg; i++) {
            categoria[i + 1] = todos.get(i).getDescricao();
        }
    }
}
