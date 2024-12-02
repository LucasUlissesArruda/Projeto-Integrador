package view;

import dao.*;

import model.FormaPagamentos;
import model.Vendas;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JanelaVendas implements ActionListener {
    JButton btOk, btCanc;
    JLabel lbDataVenda, lbCliente, lbFrete, lbFormaPagamento, lbDesconto;
    JTextField tfDataVenda, tfFrete;
    String [] Cliente;
    String [] Desconto;
    String [] FormaPagamento;
    JComboBox cbxCliente, cbxDesconto, cbxFormaPagamento;

    public JanelaVendas(){
        JFrame janela = new JFrame("Cadastro de Vendas");
        janela.setSize(270, 400); // tamanho da tela
        janela.setLocationRelativeTo(null); // centraliza na tela
        janela.setLayout(new FlowLayout(1, 10, 10));

        lbDataVenda = new JLabel("Data Venda");
        tfDataVenda = new JTextField(15);

        lbCliente = new JLabel("Cliente");
        carregarCliente();
        cbxCliente = new JComboBox(Cliente);

        lbFrete = new JLabel("Frete");
        tfFrete = new JTextField(15);

        lbDesconto = new JLabel("Desconto");
        carregarDesconto();
        cbxDesconto = new JComboBox(Desconto);

        lbFormaPagamento = new JLabel("Forma Pagamento");
        carregarFormaPagamento();
        cbxFormaPagamento  = new JComboBox(FormaPagamento);

        btOk = new JButton("Cadastrar");
        btCanc  = new JButton("Cancelar");

        janela.add(lbDataVenda);
        janela.add(tfDataVenda);

        janela.add(lbCliente);
        janela.add(cbxCliente);

        janela.add(lbFrete);
        janela.add(tfFrete);

        janela.add(lbDesconto);
        janela.add(cbxDesconto);

        janela.add(lbFormaPagamento);
        janela.add(cbxFormaPagamento);

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
            String dataString = tfDataVenda.getText();
            LocalDate dataVenda = LocalDate.parse(dataString,
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            float frete = Float.parseFloat(tfFrete.getText());

            int idCliente = cbxCliente.getSelectedIndex();
            int idDesconto = cbxDesconto.getSelectedIndex();
            int idFormaPagamento = cbxFormaPagamento.getSelectedIndex();

            Vendas vendas = new Vendas(frete, dataVenda,idCliente,idDesconto,idFormaPagamento);
            System.out.println(dataVenda);
            EntityManager em = JPAUtil.getEtityManager();
            VendasDao vendasDao = new VendasDao(em);
            em.getTransaction().begin();
            vendasDao.cadastrar(vendas);
            em.getTransaction().commit();
            em.close();
            new JanelaVendasProdutos();
            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
        }
    }
    public void carregarCliente(){
        EntityManager em = JPAUtil.getEtityManager();
        ClienteDao clienteDao = new ClienteDao(em);
        List <model.Cliente> todos = clienteDao.buscarTodos();
        int numReg = todos.size();
        Cliente = new String[numReg + 1];
        Cliente[0] = "-- Selecione uma opção --";
        for(int i=0; i < numReg; i++){
            Cliente[i+1] = todos.get(i).getNomeCliente();
        }
    }
    public void carregarDesconto(){
        EntityManager em = JPAUtil.getEtityManager();
        DescontoDao descontoDao = new DescontoDao(em);
        List <model.Desconto> todos = descontoDao.buscarTodos();
        int numReg = todos.size();
        Desconto = new String[numReg + 1];
        Desconto[0] = "-- Selecione uma opção --";
        for(int i=0; i < numReg; i++){
            Desconto[i+1] =String.valueOf( todos.get(i).getPorcentagem());
        }
    }
    public void carregarFormaPagamento(){
        EntityManager em = JPAUtil.getEtityManager();
        FormaPagamentosDao formaPagamentosDao = new FormaPagamentosDao(em);
        List <FormaPagamentos> todos = formaPagamentosDao.buscarTodos();
        int numReg = todos.size();
        FormaPagamento = new String[numReg + 1];
        FormaPagamento[0] = "-- Selecione uma opção --";
        for(int i=0; i < numReg; i++){
            FormaPagamento[i+1] = todos.get(i).getDescPagamento();
        }
    }
}
