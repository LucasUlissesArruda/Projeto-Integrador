package view;

import dao.*;
import model.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class JanelaPrincipal implements ActionListener {

     static String resultado;
    // Categoria
    JMenuItem cadCategoria, conCategoria, altCategoria, excCategoria,

    // Clientes
    cadClientes, conClientes, altClientes, excClientes,

    // Desconto
    cadDesconto, conDesconto, altDesconto, excDesconto,

    // Forma Pagamento
    conFormaPagamento,

    // Marcas
    cadMarcas, conMarcas, altMarcas, excMarcas,

    // Avaliação
    cadAvaliacao, conAvaliacao, altAvaliacao, excAvaliacao,

    // Produtos
    cadProdutos, conProdutos, altProdutos, excProdutos,

    // Produtos
    cadVendas, conVendas, altVendas, excVendas,

    // Sair
     sair;

    public JanelaPrincipal (){

        JFrame janela = new JFrame("Drop-Pace");
        janela.setSize(450,250);
        janela.setLayout(new FlowLayout(1,10,10));
        janela.setLocationRelativeTo(null);


        // criar barra de menu

        JMenuBar jmBarra = new JMenuBar();
        janela.setJMenuBar(jmBarra);

        // instanciar as opções do menu

        JMenu cadastro = new JMenu("Cadastro");
        JMenu consulta = new JMenu("Consulta");
        JMenu alteracao = new JMenu("Alteração");
        JMenu exclusao = new JMenu("Excluir");
        JMenu finalizar = new JMenu("Finalizar");

        // incluir na Barra de Menu

        jmBarra.add(cadastro);
        jmBarra.add(consulta);
        jmBarra.add(alteracao);
        jmBarra.add(exclusao);
        jmBarra.add(finalizar);


        // Categoria
        cadCategoria = new JMenuItem("Categoria");
        cadastro.add(cadCategoria);

        conCategoria = new JMenuItem("Categoria");
        consulta.add(conCategoria);

        altCategoria = new JMenuItem("Categoria");
        alteracao.add(altCategoria);

        excCategoria = new JMenuItem("Categoria");
        exclusao.add(excCategoria);


        // Clientes
        cadClientes = new JMenuItem("Clientes");
        cadastro.add(cadClientes);

        conClientes = new JMenuItem("Clientes");
        consulta.add(conClientes);

        altClientes = new JMenuItem("Clientes");
        alteracao.add(altClientes);

        excClientes = new JMenuItem("Clientes");
        exclusao.add(excClientes);

        // Desconto
        cadDesconto = new JMenuItem("Desconto");
        cadastro.add(cadDesconto);

        conDesconto = new JMenuItem("Desconto");
        consulta.add(conDesconto);

        altDesconto = new JMenuItem("Desconto");
        alteracao.add(altDesconto);

        excDesconto = new JMenuItem("Desconto");
        exclusao.add(excDesconto);

        //Forma Pagamento
        conFormaPagamento = new JMenuItem("Formas Pagamento");
        consulta.add(conFormaPagamento);

        // Marcas
        cadMarcas = new JMenuItem("Marcas");
        cadastro.add(cadMarcas);

        conMarcas = new JMenuItem("Marcas");
        consulta.add(conMarcas);

        altMarcas = new JMenuItem("Marcas");
        alteracao.add(altMarcas);

        excMarcas = new JMenuItem("Marcas");
        exclusao.add(excMarcas);

        // Avaliação
        cadAvaliacao = new JMenuItem("Avalição");
        cadastro.add(cadAvaliacao);

        conAvaliacao = new JMenuItem("Avaliação");
        consulta.add(conAvaliacao);

        altAvaliacao = new JMenuItem("Avaliação");
        alteracao.add(altAvaliacao);

        excAvaliacao = new JMenuItem("Avaliação");
        exclusao.add(excAvaliacao);

        // Produtos
        cadProdutos = new JMenuItem("Produtos");
        cadastro.add(cadProdutos);

        conProdutos = new JMenuItem("Produtos");
        consulta.add(conProdutos);

        altProdutos = new JMenuItem("Produtos");
        alteracao.add(altProdutos);

        excProdutos = new JMenuItem("Produtos");
        exclusao.add(excProdutos);


        // Vendas
        cadVendas = new JMenuItem("Vendas");
        cadastro.add(cadVendas);

        conVendas = new JMenuItem("Vendas");
        consulta.add(conVendas);

        altVendas = new JMenuItem("Vendas");
        alteracao.add(altVendas);

        excVendas = new JMenuItem("Vendas");
        exclusao.add(excVendas);


        sair = new JMenuItem("  Sair  ");
        finalizar.add(sair);

        //ações dos itens de menu

        // Categorias
        cadCategoria.addActionListener(this);
        conCategoria.addActionListener(this);
        altCategoria.addActionListener(this);
        excCategoria.addActionListener(this);

        //Clientes
        cadClientes.addActionListener(this);
        conClientes.addActionListener(this);
        altClientes.addActionListener(this);
        excClientes.addActionListener(this);

        //Desconto
        cadDesconto.addActionListener(this);
        conDesconto.addActionListener(this);
        altDesconto.addActionListener(this);
        excDesconto.addActionListener(this);

        //Forma Pagamento
        conFormaPagamento.addActionListener(this);

        //Marcas
        cadMarcas.addActionListener(this);
        conMarcas.addActionListener(this);
        altMarcas.addActionListener(this);
        excMarcas.addActionListener(this);

        //Avaliação
        cadAvaliacao.addActionListener(this);
        conAvaliacao.addActionListener(this);
        altAvaliacao.addActionListener(this);
        excAvaliacao.addActionListener(this);

        //Produtos
        cadProdutos.addActionListener(this);
        conProdutos.addActionListener(this);
        altProdutos.addActionListener(this);
        excProdutos.addActionListener(this);

        //Vendas
        cadVendas.addActionListener(this);
        conVendas.addActionListener(this);
        altVendas.addActionListener(this);
        excVendas.addActionListener(this);


        sair.addActionListener(this);

        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sair) {
            JOptionPane.showMessageDialog(null, "Obrigado por Utilizar :)");
            System.exit(0);
        } else if (e.getSource() == cadCategoria) {
            cadastrarCategoria();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com Sucesso");
        } else if (e.getSource() == conCategoria) {
            resultado = consultarCategoria();
            JOptionPane.showMessageDialog(null, resultado);
        } else if (e.getSource() == altCategoria) {
            resultado = consultarCategoria();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual id deseja Alterar"));
            alterarCategoria(id);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
        } else if (e.getSource() == excCategoria) {
            resultado = consultarCategoria();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual id deseja Excluir"));
            excluirCategoria(id);
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
        } else if (e.getSource() == cadMarcas) {
            cadastrarMarcas();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
        } else if (e.getSource() == conMarcas) {
            resultado = consultarMarca();
            JOptionPane.showMessageDialog(null, resultado);
        } else if (e.getSource() == altMarcas) {
            resultado = consultarMarca();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual ID deseja Alterar"));
            alterarMarca(id);
            JOptionPane.showMessageDialog(null, "Alteração Realizada com Sucesso");
        } else if (e.getSource() == excMarcas) {
            resultado = consultarMarca();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual id deseja Excluir"));
            excluirMarca(id);
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
        } else if (e.getSource() == cadDesconto) {
            cadastrarDesconto();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
        } else if (e.getSource() == conDesconto) {
            resultado = consultarDesconto();
            JOptionPane.showMessageDialog(null, resultado);
        } else if (e.getSource() == altDesconto) {
            resultado = consultarDesconto();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual ID deseja Alterar"));
            alterarDesconto(id);
            JOptionPane.showMessageDialog(null, "Alteração Realizada com Sucesso");
        } else if (e.getSource() == excDesconto) {
            resultado = consultarDesconto();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual id deseja Excluir"));
            excluirDesconto(id);
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
        }else if (e.getSource() == cadClientes) {
            new JanelaCliente();
        } else if (e.getSource() == conClientes) {
            resultado = consultarClientes();
            JOptionPane.showMessageDialog(null, resultado);
        }else if (e.getSource() == altClientes) {
            resultado = consultarClientes();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual ID deseja Alterar"));
            alterarClientes(id);
            JOptionPane.showMessageDialog(null, "Alteração Realizada com Sucesso");
        }else if (e.getSource() == excClientes) {
            resultado = consultarClientes();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual id deseja Excluir"));
            excluirClientes(id);
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
        } else if (e.getSource() == cadProdutos) {
            new JanelaProdutos();
        } else if (e.getSource() == conProdutos) {
            resultado = consultarProdutos();
            JOptionPane.showMessageDialog(null, resultado);
        }else if (e.getSource() == altProdutos) {
            resultado = consultarProdutos();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual ID deseja Alterar"));
            alterarProdutos(id);
            JOptionPane.showMessageDialog(null, "Alteração Realizada com Sucesso");
        }else if (e.getSource() == excProdutos) {
            resultado = consultarProdutos();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual id deseja Excluir"));
            excluirProduto(id);
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
        } else if (e.getSource() == conFormaPagamento) {
            resultado = consultaFormaPagamento();
            JOptionPane.showMessageDialog(null, resultado);
        } else if (e.getSource() == cadAvaliacao) {
            new JanelaAvaliacao();
        }else if (e.getSource() == conAvaliacao) {
            resultado = consultarAvaliacao();
            JOptionPane.showMessageDialog(null, resultado);
        }else if (e.getSource() == altAvaliacao) {
            resultado = consultarAvaliacao();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual ID deseja Alterar"));
            alterarAvaliacao(id);
            JOptionPane.showMessageDialog(null, "Alteração Realizada com Sucesso");
        }else if (e.getSource() == excAvaliacao) {
            resultado = consultarAvaliacao();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual id deseja Excluir"));
            excluirAvaliacao(id);
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
        } else if (e.getSource() == cadVendas) {
            new JanelaVendas();
        }else if (e.getSource() == conVendas) {
            resultado = consultarVendas();
            JOptionPane.showMessageDialog(null, resultado);
        }else if (e.getSource() == altVendas) {
            resultado = consultarVendas();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual ID deseja Alterar"));
            alterarVendas(id);
            JOptionPane.showMessageDialog(null, "Alteração Realizada com Sucesso");
        }else if (e.getSource() == excVendas) {
            resultado = consultarVendas();
            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\nEscolha qual id deseja Excluir"));
            excluirVendas(id);
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
        }

        }
    // ActionPerformed

    public static void cadastrarCategoria(){
        String descricao = JOptionPane.showInputDialog(null,"Informe a Categoria");
        // instanciar a classe
        Categoria categoria = new Categoria(descricao);
        // conectar com o banco de dados
        EntityManager em = JPAUtil.getEtityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);
        em.getTransaction().begin();
        categoriaDao.cadastrar(categoria);
        em.getTransaction().commit();
        em.close();
    }
    public static String consultarCategoria(){
        // Conexão com Banco de Dados
        EntityManager em = JPAUtil.getEtityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);

        List<Categoria> todosRegistros = categoriaDao.buscarTodos();
        resultado = "ID - DESCRIÇÃO\n";

        int numReg = todosRegistros.size();
        for (int i=0; i<numReg; i++){
            resultado += todosRegistros.get(i).getIdCategorias() + " - " +
                    todosRegistros.get(i).getDescricao() + "\n";
        }
        return resultado;
    }

    public static void alterarCategoria(int id){
        EntityManager em = JPAUtil.getEtityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);

        String descricao = JOptionPane.showInputDialog("Digite a Descrição");
        //carrega o registro na memoria
        Categoria categoria = categoriaDao.buscarPorId(id);
        em.getTransaction().begin();
        categoriaDao.alterar(categoria);
        categoria.setDescricao(descricao);
        em.getTransaction().commit();
        em.close();
    }

    public static void excluirCategoria(int id){
        EntityManager em = JPAUtil.getEtityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);

        Categoria categoria = categoriaDao.buscarPorId(id);
        em.getTransaction().begin();

        categoriaDao.excluir(categoria);
        em.getTransaction().commit();
        em.close();
    }

    public static void cadastrarMarcas(){
        String descricao = JOptionPane.showInputDialog(null,"Informe a Marca");
        // instanciar a classe
        Marca marca = new Marca(descricao);
        // conectar com o banco de dados
        EntityManager em = JPAUtil.getEtityManager();
        MarcaDao marcaDao = new MarcaDao(em);
        em.getTransaction().begin();
        marcaDao.cadastrar(marca);
        em.getTransaction().commit();
        em.close();
    }

    public static String consultarMarca(){
        // Conexão com Banco de Dados
        EntityManager em = JPAUtil.getEtityManager();
        MarcaDao marcaDao = new MarcaDao(em);

        List<Marca> todosRegistros = marcaDao.buscarTodos();
        resultado = "ID - DESCRIÇÃO\n";

        int numReg = todosRegistros.size();
        for (int i=0; i<numReg; i++){
            resultado += todosRegistros.get(i).getIdMarca() + " - " +
                    todosRegistros.get(i).getDescricao() + "\n";
        }
        return resultado;
    }
    public static void alterarMarca(int id){
        EntityManager em = JPAUtil.getEtityManager();
        MarcaDao marcaDao = new MarcaDao(em);

        String descricao = JOptionPane.showInputDialog("Digite a Descrição");
        //carrega o registro na memoria
        Marca marca = marcaDao.buscarPorId(id);
        em.getTransaction().begin();
        marcaDao.alterar(marca);
        marca.setDescricao(descricao);
        em.getTransaction().commit();
        em.close();
    }

    public static void excluirMarca(int id){
        EntityManager em = JPAUtil.getEtityManager();
        MarcaDao marcaDao = new MarcaDao(em);

        Marca marca = marcaDao.buscarPorId(id);
        em.getTransaction().begin();

        marcaDao.excluir(marca);
        em.getTransaction().commit();
        em.close();
    }

    public static void cadastrarDesconto(){
        float porcentagem = Float.parseFloat(JOptionPane.showInputDialog(null,"Digite o Valor do desconto"));
        // instanciar a classe
        Desconto desconto = new Desconto(porcentagem);
        // conectar com o banco de dados
        EntityManager em = JPAUtil.getEtityManager();
        DescontoDao descontoDao = new DescontoDao(em);
        em.getTransaction().begin();
        descontoDao.cadastrar(desconto);
        em.getTransaction().commit();
        em.close();
    }

    public static String consultarDesconto(){
        // Conexão com Banco de Dados
        EntityManager em = JPAUtil.getEtityManager();
        DescontoDao descontoDao = new DescontoDao(em);

        List<Desconto> todosRegistros = descontoDao.buscarTodos();
        resultado = "ID - Valor Desconto\n";

        int numReg = todosRegistros.size();
        for (int i=0; i<numReg; i++){
            resultado += todosRegistros.get(i).getIdDesconto() + " - " +
                    todosRegistros.get(i).getPorcentagem() + "\n";
        }
        return resultado;
    }

    public static void alterarDesconto(int id){
        EntityManager em = JPAUtil.getEtityManager();
        DescontoDao descontoDao = new DescontoDao(em);

        int desconto = Integer.parseInt(JOptionPane.showInputDialog("Digite o Valor do Desconto"));
        //carrega o registro na memoria
        Desconto desc = descontoDao.buscarPorId(id);
        em.getTransaction().begin();
        descontoDao.alterar(desc);
        desc.setPorcentagem(desconto);
        em.getTransaction().commit();
        em.close();
    }

    public static void excluirDesconto(int id){
        EntityManager em = JPAUtil.getEtityManager();
        DescontoDao descontoDao = new DescontoDao(em);

        Desconto desconto = descontoDao.buscarPorId(id);
        em.getTransaction().begin();

        descontoDao.excluir(desconto);
        em.getTransaction().commit();
        em.close();
    }


    public static String consultarProdutos(){
        // Conexão com Banco de Dados
        EntityManager em = JPAUtil.getEtityManager();
        ProdutosDao produtosDao = new ProdutosDao(em);

        MarcaDao marcaDao = new MarcaDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        List<Produtos> todosRegistros = produtosDao.buscarTodos();
        resultado = "ID - nome - Descrição - Valor - QtdEstoque - Marca - Categoria \n";

        int numReg = todosRegistros.size();
        for (int i=0; i<numReg; i++){
            Marca marca = MarcaDao.buscarPorId(todosRegistros.get(i).getIdMarca());
            Categoria categoria = CategoriaDao.buscarPorId(todosRegistros.get(i).getIdCategoria());
            System.out.println(todosRegistros.get(i).getIdCategoria());
            resultado += todosRegistros.get(i).getIdProdutos() + " - " +
                    todosRegistros.get(i).getNomeProduto() + " - " +
                    todosRegistros.get(i).getDescricaoProduto() + " - " +
                    todosRegistros.get(i).getValor() + " - " +
                    todosRegistros.get(i).getQtdeEstoque() + " - " +
                    marca.getDescricao()+ " - " +
                    categoria.getDescricao() + "\n";
        }
        return resultado;
    }

    public static void alterarProdutos(int id){
        EntityManager em = JPAUtil.getEtityManager();
        ProdutosDao produtosDao = new ProdutosDao(em);

        Produtos produtos = produtosDao.buscarPorId(id);
        em.getTransaction().begin();
        produtosDao.alterar(produtos);

        String botoes [] = {"Nome Produto", "Descrição Produto" ,"Valor", "Qtd Estoque", "Marca", "Categoria" };

        int  opcao = JOptionPane.showOptionDialog(null,"Qual Deseja Alterar" , "Modificação" , 0, 3,null,botoes, 0 );

        switch (opcao){
            case 0:
                String nome = JOptionPane.showInputDialog("Digite o Nome");
                produtos.setNomeProduto(nome);
                break;
            case 1:
                String descricao = JOptionPane.showInputDialog("Digite o Email");
                produtos.setDescricaoProduto(descricao);
                break;
            case 2:
                float valor = Float.parseFloat( JOptionPane.showInputDialog("Digite o Valor"));
                produtos.setValor(valor);
                break;
            case 3:
                int qtdEstoque = Integer.parseInt(JOptionPane.showInputDialog("Digite a Quantidade"));
                produtos.setQtdeEstoque(qtdEstoque);
                break;
            case 4:
                int marca = Integer.parseInt( JOptionPane.showInputDialog("Selecione a Marca"));
                produtos.setIdMarca(marca);
                break;

            case 5:
                int categoria = Integer.parseInt( JOptionPane.showInputDialog("Selecione a Categoria"));
                produtos.setIdCategoria(categoria);
                break;
        }

        em.getTransaction().commit();
        em.close();
    }

    public static void excluirClientes(int id){
        EntityManager em = JPAUtil.getEtityManager();
        ClienteDao clienteDao = new ClienteDao(em);

        Cliente cliente = clienteDao.buscarPorId(id);
        em.getTransaction().begin();

        clienteDao.excluir(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static String consultarClientes(){
        // Conexão com Banco de Dados
        EntityManager em = JPAUtil.getEtityManager();
        ClienteDao clienteDao = new ClienteDao(em);

        List<Cliente> todosRegistros = clienteDao.buscarTodos();
        resultado = "ID - nome - Endereço - Email - CPF - CEP \n";

        int numReg = todosRegistros.size();
        for (int i=0; i<numReg; i++){
            resultado += todosRegistros.get(i).getIdclientes() + " - " +
                    todosRegistros.get(i).getNomeCliente() + " - " +
                    todosRegistros.get(i).getEmail() + " - " +
                    todosRegistros.get(i).getEndereco() + " - " +
                    todosRegistros.get(i).getCpf() + " - " +
                    todosRegistros.get(i).getCep() + "\n";
        }
        return resultado;
    }

    public static void alterarClientes(int id){
        EntityManager em = JPAUtil.getEtityManager();
        ClienteDao clienteDao = new ClienteDao(em);

        Cliente cliente = clienteDao.buscarPorId(id);
        em.getTransaction().begin();
        clienteDao.alterar(cliente);

        String botoes [] = {"Nome", "Endereço" ,"Email", "CPF", "CEP" };

        int  opcao = JOptionPane.showOptionDialog(null,"Qual Deseja Alterar" , "Modificação" , 0, 3,null,botoes, 0 );

        switch (opcao){
            case 0:
                String nome = JOptionPane.showInputDialog("Digite o Nome");
                cliente.setNomeCliente(nome);
                break;
            case 1:
                String email = JOptionPane.showInputDialog("Digite o Email");
                cliente.setEmail(email);
                break;
            case 2:
                String endereco = JOptionPane.showInputDialog("Digite o Endereço");
                cliente.setEndereco(endereco);
                break;
            case 3:
                Long cpf = Long.parseLong(JOptionPane.showInputDialog("Digite o CPF"));
                cliente.setCpf(cpf);
                break;
            case 4:
                Long cep = Long.parseLong(JOptionPane.showInputDialog("Digite o CEP"));
                cliente.setCep(cep);
                break;
        }

        em.getTransaction().commit();
        em.close();
    }

    public static void excluirProduto(int id){
        EntityManager em = JPAUtil.getEtityManager();
        ProdutosDao produtosDao = new ProdutosDao(em);

        Produtos produtos = produtosDao.buscarPorId(id);
        em.getTransaction().begin();

        produtosDao.excluir(produtos);
        em.getTransaction().commit();
        em.close();
    }

    public static String consultaFormaPagamento(){
        // Conexão com Banco de Dados
        EntityManager em = JPAUtil.getEtityManager();
        FormaPagamentosDao formaPagamentosDao = new FormaPagamentosDao(em);

        List<FormaPagamentos> todosRegistros = formaPagamentosDao.buscarTodos();
        resultado = "ID - DESCRIÇÃO\n";

        int numReg = todosRegistros.size();
        for (int i=0; i<numReg; i++){
            resultado += todosRegistros.get(i).getIdFormaPagamento() + " - " +
                    todosRegistros.get(i).getDescPagamento() + "\n";
        }
        return resultado;
    }

    public static String consultarAvaliacao(){
        // Conexão com Banco de Dados
        EntityManager em = JPAUtil.getEtityManager();
        AvaliacaoProdDao avaliacaoProdDao = new AvaliacaoProdDao(em);

        ProdutosDao produtosDao = new ProdutosDao(em);

        List<AvaliacaoProd> todosRegistros = avaliacaoProdDao.buscarTodos();
        resultado = "ID - Observação - Nota - Produto\n";

        int numReg = todosRegistros.size();
        for (int i=0; i<numReg; i++){
            Produtos produtos = ProdutosDao.buscarPorId(todosRegistros.get(i).getIdproduto());
            resultado += todosRegistros.get(i).getIdprodutoAvali() + " - " +
                    todosRegistros.get(i).getObservacao() + " - " +
                    todosRegistros.get(i).getNota() + " - " +
                    produtos.getNomeProduto() + "\n";
        }
        return resultado;
    }

    public static void alterarAvaliacao(int id){
        EntityManager em = JPAUtil.getEtityManager();
        AvaliacaoProdDao avaliacaoProdDao = new AvaliacaoProdDao(em);

        AvaliacaoProd avaliacao = avaliacaoProdDao.buscarPorId(id);
        em.getTransaction().begin();
        avaliacaoProdDao.alterar(avaliacao);

        String botoes [] = {"Observação", "Nota" ,"Produto" };

        int  opcao = JOptionPane.showOptionDialog(null,"Qual Deseja Alterar" , "Modificação" , 0, 3,null,botoes, 0 );

        switch (opcao){
            case 0:
                String observacao = JOptionPane.showInputDialog("Digite a Avaliação");
                avaliacao.setObservacao(observacao);
                break;
            case 1:
                int nota = Integer.parseInt(JOptionPane.showInputDialog("Digite a Nota"));
                avaliacao.setNota(nota);
                break;
            case 2:
                int Produto = Integer.parseInt( JOptionPane.showInputDialog("Selecione o Produto"));
                avaliacao.setIdproduto(Produto);
                break;
        }

        em.getTransaction().commit();
        em.close();
    }

    public static void excluirAvaliacao(int id){
        EntityManager em = JPAUtil.getEtityManager();
        AvaliacaoProdDao avaliacaoProdDao = new AvaliacaoProdDao(em);

        AvaliacaoProd avaliacaoProd = avaliacaoProdDao.buscarPorId(id);
        em.getTransaction().begin();

        avaliacaoProdDao.excluir(avaliacaoProd);
        em.getTransaction().commit();
        em.close();
    }

    public static String consultarVendas(){
        // Conexão com Banco de Dados
        EntityManager em = JPAUtil.getEtityManager();
        VendasDao vendasDao = new VendasDao(em);

        ClienteDao clienteDao = new ClienteDao(em);
        DescontoDao descontoDao = new DescontoDao(em);
        FormaPagamentosDao formaPagamentosDao = new FormaPagamentosDao(em);

        List<Vendas> todosRegistros = vendasDao.buscarTodos();
        resultado = "ID - Data Venda - Cliente - Frete - Desconto - Forma Pagamento\n";

        int numReg = todosRegistros.size();
        for (int i=0; i<numReg; i++){
            Cliente cliente = ClienteDao.buscarPorId(todosRegistros.get(i).getIdClientes());
            Desconto desconto = DescontoDao.buscarPorId(todosRegistros.get(i).getIdDesconto());
            FormaPagamentos formaPagamentos = FormaPagamentosDao.buscarPorId(todosRegistros.get(i).getIdFormaPagamento());
            resultado += todosRegistros.get(i).getIdvendas() + " - " +
                    todosRegistros.get(i).getDataVenda() + " - " +
                    cliente.getNomeCliente() + "\n" +
                    todosRegistros.get(i).getFrete() + " - " +
                    desconto.getPorcentagem() +"-" +
                    formaPagamentos.getDescPagamento() + " - " ;
        }
        return resultado;
    }

    public static void alterarVendas(int id){
        EntityManager em = JPAUtil.getEtityManager();
        VendasDao vendasDao = new VendasDao(em);

        Vendas vendas = vendasDao.buscarPorId(id);
        em.getTransaction().begin();
        vendasDao.alterar(vendas);

        String botoes [] = {"Data Venda", "Cliente" ,"Frete", "Desconto", "Forma Pagamento" };

        int  opcao = JOptionPane.showOptionDialog(null,"Qual Deseja Alterar" , "Modificação" , 0, 3,null,botoes, 0 );

        switch (opcao){
            case 0:
                String dataVenda = JOptionPane.showInputDialog("Data Venda");
                vendas.setDataVenda(LocalDate.parse(dataVenda));
                break;
            case 1:
                String cliente = JOptionPane.showInputDialog("Cliente");
                vendas.setIdClientes(Integer.parseInt(cliente));
                break;
            case 2:
                String frete = JOptionPane.showInputDialog("Frete");
                vendas.getFrete();
                break;
            case 3:
                int desconto = Integer.parseInt(JOptionPane.showInputDialog("Desconto"));
                vendas.getIdDesconto();
                break;
            case 4:
                int cep = Integer.parseInt(JOptionPane.showInputDialog("Forma Pagamento"));
                vendas.setIdFormaPagamento(id);
                break;
        }

        em.getTransaction().commit();
        em.close();
    }

    public static void excluirVendas(int id){
        EntityManager em = JPAUtil.getEtityManager();
        VendasDao vendasDao = new VendasDao(em);

        Vendas vendas = vendasDao.buscarPorId(id);
        em.getTransaction().begin();

        vendasDao.excluir(vendas);
        em.getTransaction().commit();
        em.close();
    }



}
