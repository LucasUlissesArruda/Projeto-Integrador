-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 04/12/2024 às 20:48
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `drop-pace`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `descricao`) VALUES
(1, 'Sneakers'),
(2, 'Dia a Dia');

-- --------------------------------------------------------

--
-- Estrutura para tabela `clientes`
--

CREATE TABLE `clientes` (
  `idclientes` int(11) NOT NULL,
  `email` varchar(70) DEFAULT NULL,
  `endereco` varchar(70) NOT NULL,
  `nomeCliente` varchar(70) NOT NULL,
  `cpf` mediumtext NOT NULL,
  `cep` mediumtext NOT NULL,
  `senha` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `clientes`
--

INSERT INTO `clientes` (`idclientes`, `email`, `endereco`, `nomeCliente`, `cpf`, `cep`, `senha`) VALUES
(1, 'lucasulisses48@gmail.com', 'Quintiliano Diniz', 'Lucas', '87083460', '123123', ''),
(2, 'lu@gmail.com', 'longe', 'lucas', '123', '123', '123'),
(3, 'a@a.a', '1', 'a', '1', '1', '1');

-- --------------------------------------------------------

--
-- Estrutura para tabela `desconto`
--

CREATE TABLE `desconto` (
  `iddesconto` int(11) NOT NULL,
  `porcentagem` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `desconto`
--

INSERT INTO `desconto` (`iddesconto`, `porcentagem`) VALUES
(1, 10.00);

-- --------------------------------------------------------

--
-- Estrutura para tabela `formapagamento`
--

CREATE TABLE `formapagamento` (
  `idformaPagamento` int(11) NOT NULL,
  `descPagamento` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `formapagamento`
--

INSERT INTO `formapagamento` (`idformaPagamento`, `descPagamento`) VALUES
(1, 'Cartão de Credito'),
(2, 'Cartão de Debito'),
(3, 'Pix'),
(4, 'Dinheiro');

-- --------------------------------------------------------

--
-- Estrutura para tabela `marca`
--

CREATE TABLE `marca` (
  `idmarca` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `marca`
--

INSERT INTO `marca` (`idmarca`, `descricao`) VALUES
(1, 'Nike'),
(2, 'Puma'),
(3, 'Adidas'),
(4, 'New Balance');

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtoavali`
--

CREATE TABLE `produtoavali` (
  `idprodutoAvali` int(11) NOT NULL,
  `idproduto` int(11) NOT NULL,
  `nota` int(11) DEFAULT NULL,
  `observacao` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `produtoavali`
--

INSERT INTO `produtoavali` (`idprodutoAvali`, `idproduto`, `nota`, `observacao`) VALUES
(1, 3, 10, 'Confortavel');

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtos`
--

CREATE TABLE `produtos` (
  `idProdutos` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `descricaoProduto` varchar(150) NOT NULL,
  `valor` float NOT NULL,
  `nomeProduto` varchar(70) NOT NULL,
  `qtdeEstoque` int(11) NOT NULL,
  `idmarca` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `produtos`
--

INSERT INTO `produtos` (`idProdutos`, `idCategoria`, `descricaoProduto`, `valor`, `nomeProduto`, `qtdeEstoque`, `idmarca`) VALUES
(2, 1, 'Tamnho 44', 499, 'Janoski', 15, 1),
(3, 1, 'Tamanho 42', 500, 'Suede', 2, 2),
(4, 2, 'Tamanho 44', 460, 'Campus 00s', 2, 3),
(5, 2, 'Tamanho 39', 799.69, 'Puma Suede XL ', 2, 2),
(6, 1, 'Tamanho 41', 750, 'Tiago Lemos Numeric 1010', 1, 4);

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendaproduto`
--

CREATE TABLE `vendaproduto` (
  `idvendaProduto` int(11) NOT NULL,
  `preco` decimal(8,2) NOT NULL,
  `precototal` decimal(10,2) DEFAULT NULL,
  `qtde` int(11) NOT NULL,
  `idVendas` int(11) NOT NULL,
  `idprodutos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `vendaproduto`
--

INSERT INTO `vendaproduto` (`idvendaProduto`, `preco`, `precototal`, `qtde`, `idVendas`, `idprodutos`) VALUES
(1, 699.00, 699.00, 1, 3, 5);

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendas`
--

CREATE TABLE `vendas` (
  `idvendas` int(11) NOT NULL,
  `dataVendas` date NOT NULL,
  `idClientes` int(11) NOT NULL,
  `idDesconto` int(11) NOT NULL,
  `frete` decimal(8,2) NOT NULL,
  `idformaPagamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `vendas`
--

INSERT INTO `vendas` (`idvendas`, `dataVendas`, `idClientes`, `idDesconto`, `frete`, `idformaPagamento`) VALUES
(2, '2024-12-12', 1, 1, 10.00, 3),
(3, '2024-12-12', 1, 1, 12.00, 3),
(4, '2024-12-11', 1, 1, 100.00, 3);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Índices de tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idclientes`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

--
-- Índices de tabela `desconto`
--
ALTER TABLE `desconto`
  ADD PRIMARY KEY (`iddesconto`);

--
-- Índices de tabela `formapagamento`
--
ALTER TABLE `formapagamento`
  ADD PRIMARY KEY (`idformaPagamento`);

--
-- Índices de tabela `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`idmarca`);

--
-- Índices de tabela `produtoavali`
--
ALTER TABLE `produtoavali`
  ADD PRIMARY KEY (`idprodutoAvali`),
  ADD KEY `fk_prodavali_prod_idx` (`idproduto`);

--
-- Índices de tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`idProdutos`),
  ADD KEY `fk_produtos_categoria_idx` (`idCategoria`),
  ADD KEY `fk_produtos_marca_idx` (`idmarca`);

--
-- Índices de tabela `vendaproduto`
--
ALTER TABLE `vendaproduto`
  ADD PRIMARY KEY (`idvendaProduto`),
  ADD KEY `fk_vendaProduto_produto_idx` (`idprodutos`),
  ADD KEY `fk_vendasProduto_vendas_idx` (`idVendas`);

--
-- Índices de tabela `vendas`
--
ALTER TABLE `vendas`
  ADD PRIMARY KEY (`idvendas`),
  ADD KEY `fk_vendas_clientes_idx` (`idClientes`),
  ADD KEY `fk_vendas_desconto_idx` (`idDesconto`),
  ADD KEY `fk_vendas_forma_idx` (`idformaPagamento`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idclientes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `desconto`
--
ALTER TABLE `desconto`
  MODIFY `iddesconto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `formapagamento`
--
ALTER TABLE `formapagamento`
  MODIFY `idformaPagamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `marca`
--
ALTER TABLE `marca`
  MODIFY `idmarca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `produtoavali`
--
ALTER TABLE `produtoavali`
  MODIFY `idprodutoAvali` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `idProdutos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `vendaproduto`
--
ALTER TABLE `vendaproduto`
  MODIFY `idvendaProduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `vendas`
--
ALTER TABLE `vendas`
  MODIFY `idvendas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `produtoavali`
--
ALTER TABLE `produtoavali`
  ADD CONSTRAINT `fk_prodavali_prod` FOREIGN KEY (`idproduto`) REFERENCES `produtos` (`idProdutos`);

--
-- Restrições para tabelas `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `fk_produtos_categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`),
  ADD CONSTRAINT `fk_produtos_marca` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`);

--
-- Restrições para tabelas `vendaproduto`
--
ALTER TABLE `vendaproduto`
  ADD CONSTRAINT `fk_vendaProduto_produto` FOREIGN KEY (`idprodutos`) REFERENCES `produtos` (`idProdutos`),
  ADD CONSTRAINT `fk_vendasProduto_vendas` FOREIGN KEY (`idVendas`) REFERENCES `vendas` (`idvendas`);

--
-- Restrições para tabelas `vendas`
--
ALTER TABLE `vendas`
  ADD CONSTRAINT `fk_vendas_clientes` FOREIGN KEY (`idClientes`) REFERENCES `clientes` (`idclientes`),
  ADD CONSTRAINT `fk_vendas_desconto` FOREIGN KEY (`idDesconto`) REFERENCES `desconto` (`iddesconto`),
  ADD CONSTRAINT `fk_vendas_forma` FOREIGN KEY (`idformaPagamento`) REFERENCES `formapagamento` (`idformaPagamento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
