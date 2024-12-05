package view;

import dao.DescontoDao;
import dao.VendasDao;
import model.Desconto;
import model.Vendas;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class janelaSelecionarDesconto implements ActionListener {
    JButton btOk, btCanc;
    JLabel lbDesconto;
    String[] desconto;
    JComboBox<String> cbxdesconto;
    int idVendas;

    public janelaSelecionarDesconto(int id) {
        JFrame janela = new JFrame("Selecione o Desconto");
        janela.setSize(270, 200); // tamanho da tela
        janela.setLocationRelativeTo(null); // centraliza na tela
        janela.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        idVendas = id;

        lbDesconto = new JLabel("Selecione o Desconto");
        carregarDesconto(); // Carrega as opções de desconto
        cbxdesconto = new JComboBox<>(desconto);

        btOk = new JButton("Selecionar");
        btCanc = new JButton("Cancelar");

        janela.add(lbDesconto);
        janela.add(cbxdesconto);
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
            int selectedIndex = cbxdesconto.getSelectedIndex();

            if (selectedIndex > 0) { // Verifica se um desconto válido foi selecionado
                EntityManager em = JPAUtil.getEtityManager();
                VendasDao vendasDao = new VendasDao(em);
                DescontoDao descontoDao = new DescontoDao(em);

                em.getTransaction().begin();

                // Busca a venda pelo ID e o desconto correspondente
                Vendas vendas = vendasDao.buscarPorId(idVendas);
                Desconto descontos = descontoDao.buscarPorId(selectedIndex);

                vendasDao.alterar(vendas); // Salva a alteração no banco
                em.getTransaction().commit();
                em.close();

                JOptionPane.showMessageDialog(null, "Desconto alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um desconto válido.");
            }
        } else if (e.getSource() == btCanc) {
            cbxdesconto.setSelectedIndex(0); // Reseta a seleção
        }
    }

    public void carregarDesconto() {
        EntityManager em = JPAUtil.getEtityManager();
        DescontoDao descontoDao = new DescontoDao(em);
        List<Desconto> todos = descontoDao.buscarTodos();

        int numReg = todos.size();
        desconto = new String[numReg + 1]; // Cria o vetor de opções
        desconto[0] = "-- Selecione uma opção --"; // Primeira opção padrão

        for (int i = 0; i < numReg; i++) {
            desconto[i + 1] = todos.get(i).getPorcentagem() + " - " + todos.get(i).getPorcentagem() + "%";
        }
    }
}
