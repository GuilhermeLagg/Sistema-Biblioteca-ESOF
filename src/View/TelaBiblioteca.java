package View;


import Controller.SistemaBiblioteca;
import Model.Livro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaBiblioteca extends JFrame {

    private SistemaBiblioteca sistema;

    public TelaBiblioteca() {
        sistema = new SistemaBiblioteca("Livros.txt");
        sistema.carregarDados();

        setTitle("Sistema de Biblioteca");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.setBackground(new Color(245, 245, 245));

        // Título
        JLabel titulo = new JLabel("Sistema de Biblioteca", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        // Painel dos botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(2, 1, 20, 20));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));
        painelBotoes.setBackground(new Color(245, 245, 245));

        JButton btnCadastrar = new JButton("Adicionar Livro");
        JButton btnListar = new JButton("Visualizar Acervo");

        estilizarBotao(btnCadastrar);
        estilizarBotao(btnListar);

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnListar);

        painel.add(titulo, BorderLayout.NORTH);
        painel.add(painelBotoes, BorderLayout.CENTER);

        add(painel);

        // Ação: cadastrar
        btnCadastrar.addActionListener((ActionEvent e) -> {
            String tituloLivro = JOptionPane.showInputDialog("Digite o título:");
            String autor = JOptionPane.showInputDialog("Digite o autor:");

            if (tituloLivro != null && autor != null &&
                    !tituloLivro.isEmpty() && !autor.isEmpty()) {

                sistema.cadastrarLivro(tituloLivro, autor);
                sistema.salvarDados();
                JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Dados inválidos!");
            }
        });

        // Ação: listar
        btnListar.addActionListener((ActionEvent e) -> {
            List<Livro> livros = sistema.listarAcervo();

            if (livros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Acervo vazio!");
            } else {
                // Nome das colunas
                String[] colunas = {"Título", "Autor"};

                // Dados da tabela
                String[][] dados = new String[livros.size()][2];

                for (int i = 0; i < livros.size(); i++) {
                    dados[i][0] = livros.get(i).getTitulo();
                    dados[i][1] = livros.get(i).getAutor();
                }

                JTable tabela = new JTable(dados, colunas);

                tabela.setEnabled(false); // não editável
                tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
                tabela.setRowHeight(25);
                tabela.setFont(new Font("Arial", Font.PLAIN, 13));

                JScrollPane scroll = new JScrollPane(tabela);

                scroll.setPreferredSize(new Dimension(400, 200));

                JOptionPane.showMessageDialog(
                        null,
                        scroll,
                        "Acervo de Livros",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

    // Estilização dos botões
    private void estilizarBotao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setFocusPainted(false);
        botao.setBackground(new Color(70, 130, 180));
        botao.setForeground(Color.WHITE);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
}