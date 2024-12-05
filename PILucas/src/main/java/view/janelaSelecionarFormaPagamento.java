package view;

import dao.FormaPagamentosDao;
import dao.VendasDao;
import model.FormaPagamentos;
import model.Vendas;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class janelaSelecionarFormaPagamento implements ActionListener {
    JButton btOk, btCanc;
    JLabel lbformaPagamento;
    String[] formapagamento;
    JComboBox<String> cbxformaPagamento;
    int idVendas;

    public janelaSelecionarFormaPagamento(int id) {
        JFrame janela = new JFrame("Selecionar Forma de Pagamento");
        janela.setSize(270, 200); // tamanho da tela
        janela.setLocationRelativeTo(null); // centraliza na tela
        janela.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        idVendas = id;

        lbformaPagamento = new JLabel("Selecione a Forma de Pagamento");
        carregarPagamento(); // Carrega as opções de forma de pagamento
        cbxformaPagamento = new JComboBox<>(formapagamento);

        btOk = new JButton("Selecionar");
        btCanc = new JButton("Cancelar");

        janela.add(lbformaPagamento);
        janela.add(cbxformaPagamento);
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
            int formapagamento = cbxformaPagamento.getSelectedIndex();

            if (formapagamento > 0) { // Verifica se uma forma de pagamento válida foi selecionada
                EntityManager em = JPAUtil.getEtityManager();
                VendasDao vendasDao = new VendasDao(em);
                FormaPagamentosDao formaPagamentosDao = new FormaPagamentosDao(em);

                em.getTransaction().begin();

                // Busca a venda pelo ID e a forma de pagamento correspondente
                Vendas vendas = vendasDao.buscarPorId(idVendas);
                FormaPagamentos formaPagamento = formaPagamentosDao.buscarPorId(formapagamento);

                // Atualiza a forma de pagamento na venda
                vendas.setIdFormaPagamento(idVendas); // Associa o objeto de forma de pagamento à venda

                vendasDao.alterar(vendas); // Salva a alteração no banco
                em.getTransaction().commit();
                em.close();

                JOptionPane.showMessageDialog(null, "Forma de pagamento alterada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecione uma forma de pagamento válida.");
            }
        } else if (e.getSource() == btCanc) {
            cbxformaPagamento.setSelectedIndex(0); // Reseta a seleção
        }
    }

    public void carregarPagamento() {
        EntityManager em = JPAUtil.getEtityManager();
        FormaPagamentosDao formaPagamentosDao = new FormaPagamentosDao(em);
        List<FormaPagamentos> todos = formaPagamentosDao.buscarTodos();

        int numReg = todos.size();
        formapagamento = new String[numReg + 1]; // Cria o vetor de opções
        formapagamento[0] = "-- Selecione uma opção --"; // Primeira opção padrão

        for (int i = 0; i < numReg; i++) {
            formapagamento[i + 1] = todos.get(i).getDescPagamento(); // Descrição da forma de pagamento
        }
    }
}
