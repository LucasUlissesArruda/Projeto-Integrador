package view;

import dao.ClienteDao;
import model.Cliente;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCliente implements ActionListener {
    JButton btOk, btLimp;
    JLabel lbNomeCliente, lbEndereco, lbEmail, lbCPF, lbCEP, lbSenha;
    JTextField tfNomeCliente, tfEndereco, tfEmail, tfCPF, tfCEP, tfSenha;

    public JanelaCliente() {
        JFrame janela = new JFrame("Cadastro de Cliente");
        janela.setSize(340, 290); // tamanho da tela
        janela.setLocationRelativeTo(null); // centraliza na tela
        janela.setLayout(new FlowLayout(1, 2, 5));

        lbNomeCliente = new JLabel("Nome Cliente");
        tfNomeCliente = new JTextField(20);

        lbEndereco = new JLabel("Endereço");
        tfEndereco = new JTextField(20);

        lbEmail = new JLabel("Email      ");
        tfEmail = new JTextField(20);

        lbSenha = new JLabel("Senha");
        tfSenha = new JPasswordField(20);

        lbCPF = new JLabel("CPF         ");
        tfCPF = new JTextField(20);

        lbCEP = new JLabel(" CEP           ");
        tfCEP = new JTextField(20);

        btOk = new JButton("Cadastrar");
        btLimp = new JButton("Limpar");

        // adicionar ao frame
        janela.add(lbNomeCliente);
        janela.add(tfNomeCliente);
        janela.add(lbEndereco);
        janela.add(tfEndereco);
        janela.add(lbEmail);
        janela.add(tfEmail);
        janela.add(lbSenha);
        janela.add(tfSenha);
        janela.add(lbCPF);
        janela.add(tfCPF);
        janela.add(lbCEP);
        janela.add(tfCEP);
        janela.add(btOk);
        janela.add(btLimp);

        // adicionando ação para os botões
        btOk.addActionListener(this);
        btLimp.addActionListener(this);

        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btOk) {
            String nomeCliente = tfNomeCliente.getText();
            String endereco = tfEndereco.getText();
            String email = tfEmail.getText();
            String senha = tfSenha.getText();
            Long cpf = Long.parseLong(tfCPF.getText());
            Long cep = Long.parseLong(tfCEP.getText());

            Cliente cliente = new Cliente(email, endereco, nomeCliente, cpf, cep, senha);

            EntityManager em = JPAUtil.getEtityManager();
            ClienteDao clienteDao = new ClienteDao(em);
            em.getTransaction().begin();
            clienteDao.cadastrar(cliente);
            em.getTransaction().commit();
            em.close();


            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        }
        tfNomeCliente.setText("");
        tfCEP.setText("");
        tfCPF.setText("");
        tfEmail.setText("");
        tfSenha.setText("");
        tfEndereco.setText("");
    }
}
