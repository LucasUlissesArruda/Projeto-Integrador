package view;
import dao.MarcaDao;
import dao.ProdutosDao;
import model.Marca;
import model.Produtos;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class janelaSelecionarMarca implements ActionListener {
    JButton btOk, btCanc;
    JLabel lbMarca;
    String [] marca;
    JComboBox cbxMarca;
    int idProduto;

    public janelaSelecionarMarca(int id){
        JFrame janela = new JFrame("Cadastro de Produtos");
        janela.setSize(270, 200); // tamanho da tela
        janela.setLocationRelativeTo(null); // centraliza na tela
        janela.setLayout(new FlowLayout(1, 10, 10));

        idProduto = id;


        lbMarca = new JLabel("Selecione a Marca");
        carregarProdutos();
        cbxMarca = new JComboBox<>(marca);

        btOk = new JButton("Selecionar");
        btCanc = new JButton("Cancelar");


        janela.add(lbMarca);
        janela.add(cbxMarca);

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
            int idmarca = cbxMarca.getSelectedIndex();

            EntityManager em = JPAUtil.getEtityManager();
            ProdutosDao produtosDao = new ProdutosDao(em);
            em.getTransaction().begin();
            Produtos produtos = ProdutosDao.buscarPorId(idProduto);
            ProdutosDao.alterar(produtos);
            produtos.setIdMarca(idmarca);

            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");

        } else if (e.getSource() == btCanc) {
            cbxMarca.setSelectedIndex(0);
        }
    }

    public void carregarProdutos() {
        EntityManager em = JPAUtil.getEtityManager();
        MarcaDao marcaDao = new MarcaDao(em);
        List<Marca> todos = marcaDao.buscarTodos();
        int numReg = todos.size();
        marca = new String [numReg + 1]; // criar um vetor
        marca[0] = "-- Selecione uma opção --";
        for (int i=0; i < numReg; i++) {
            marca[i+1] = todos.get(i).getDescricao();
        }
    }

}
