package view;

import dao.ProdutosDao;
import dao.VendaProdutoDao;
import dao.VendasDao;
import model.Produtos;
import model.VendaProduto;
import model.Vendas;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JanelaVendasProdutos implements ActionListener {
    JLabel lbProduto, lbqtde, lbPreco, lbPrecoTotal;
    JTextField tfQtde, tfPreco;
    String [] produtos;
    JComboBox cbxProduto;
    JButton btOk, btCanc;

    public JanelaVendasProdutos(){
        JFrame janela = new JFrame("Vendas Produtos");
        janela.setSize(290, 250); // tamanho da tela
        janela.setLocationRelativeTo(null); // centraliza na tela
        janela.setLayout(new FlowLayout(1, 10, 10));

        lbProduto = new JLabel("Produto: ");
        lbqtde = new JLabel("Quantidade:");
        lbPreco = new JLabel("Preço:");
        tfQtde = new JTextField(15);
        tfPreco = new JTextField(15);
        carregarProduto();
        cbxProduto = new JComboBox(produtos);

        btOk = new JButton("Cadastrar");
        btCanc = new JButton("Cancelar");

        janela.add(lbProduto);
        janela.add(cbxProduto);
        janela.add(lbqtde);
        janela.add(tfQtde);
        janela.add(lbPreco);
        janela.add(tfPreco);

        janela.add(btOk);
        janela.add(btCanc);


        btOk.addActionListener(this);
        btCanc.addActionListener(this);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btOk){
            int idProduto = cbxProduto.getSelectedIndex();
            int qtde = Integer.parseInt(tfQtde.getText());
            float preco = Float.parseFloat(tfPreco.getText());
            float precoTotal = qtde*preco;

            EntityManager em = JPAUtil.getEtityManager();

            VendasDao vendasDao = new VendasDao(em);
            List<Vendas> todos = vendasDao.buscarTodos();
            int numReg = todos.size();
            System.out.println(numReg);
            int idVendas = todos.get(numReg - 1).getIdvendas();
            VendaProdutoDao vendaProdutoDao = new VendaProdutoDao(em);
            em.getTransaction().begin();

            VendaProduto vendaProduto = new VendaProduto(preco,precoTotal,  qtde,  idVendas, idProduto);
            vendaProdutoDao.cadastrar(vendaProduto);
            em.getTransaction().commit();
            em.close();
            new JanelaVendasProdutos();
        }
    }
    public void carregarProduto() {
        EntityManager em = JPAUtil.getEtityManager();
        ProdutosDao produtoDao = new ProdutosDao(em);
        List<Produtos> todos = produtoDao.buscarTodos();
        int numReg = todos.size();
        produtos = new String [numReg + 1]; // criar um vetor
        produtos[0] = "-- Selecione uma opção --";
        for (int i=0; i < numReg; i++) {
            produtos[i+1] = todos.get(i).getNomeProduto();
        }
    }
}
