// Importando as bibliotecas necessárias
// Aqui estou puxando o Swing que me ajuda a criar a interface gráfica da calculadora
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Criando a classe principal da calculadora
public class Calculadora extends JFrame implements ActionListener {
    // Aqui estou criando os componentes que vou precisar: 
    // campo de texto para mostrar os números e botões para as operações
    private JTextField campoTexto;
    private JButton[] botoesNumero = new JButton[10]; // botões de 0 a 9
    private JButton[] botoesOperacao = new JButton[4]; // +, -, *, /
    private JButton botaoIgual, botaoClear;

    // Variáveis para armazenar os números e operações
    private double num1 = 0, num2 = 0, resultado = 0;
    private char operador;

    // Construtor da calculadora (aqui monto a interface)
    public Calculadora() {
        // Definindo o título da janela
        setTitle("Calculadora Básica");
        // Definindo o tamanho da janela
        setSize(400, 500);
        // Definindo que a aplicação fecha quando clico no X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Centralizando a janela na tela
        setLocationRelativeTo(null);
        // Não deixar o usuário redimensionar (mantém a responsividade simples)
        setResizable(false);

        // Criando o campo de texto (onde aparece o resultado e os números digitados)
        campoTexto = new JTextField();
        campoTexto.setFont(new Font("Arial", Font.BOLD, 24));
        campoTexto.setHorizontalAlignment(SwingConstants.RIGHT);
        campoTexto.setEditable(false);

        // Criando os botões de número
        for (int i = 0; i < 10; i++) {
            botoesNumero[i] = new JButton(String.valueOf(i));
            botoesNumero[i].setFont(new Font("Arial", Font.BOLD, 20));
            botoesNumero[i].addActionListener(this);
        }

        // Criando os botões de operação
        String[] operacoes = {"+", "-", "*", "/"};
        for (int i = 0; i < 4; i++) {
            botoesOperacao[i] = new JButton(operacoes[i]);
            botoesOperacao[i].setFont(new Font("Arial", Font.BOLD, 20));
            botoesOperacao[i].addActionListener(this);
        }

        // Criando botão de igual
        botaoIgual = new JButton("=");
        botaoIgual.setFont(new Font("Arial", Font.BOLD, 20));
        botaoIgual.addActionListener(this);

        // Criando botão de limpar
        botaoClear = new JButton("C");
        botaoClear.setFont(new Font("Arial", Font.BOLD, 20));
        botaoClear.addActionListener(this);

        // Criando o layout da calculadora (usando GridLayout)
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 4, 10, 10));

        // Adicionando os botões na ordem para parecer uma calculadora real
        painel.add(botoesNumero[7]);
        painel.add(botoesNumero[8]);
        painel.add(botoesNumero[9]);
        painel.add(botoesOperacao[0]); // +

        painel.add(botoesNumero[4]);
        painel.add(botoesNumero[5]);
        painel.add(botoesNumero[6]);
        painel.add(botoesOperacao[1]); // -

        painel.add(botoesNumero[1]);
        painel.add(botoesNumero[2]);
        painel.add(botoesNumero[3]);
        painel.add(botoesOperacao[2]); // *

        painel.add(botaoClear);
        painel.add(botoesNumero[0]);
        painel.add(botaoIgual);
        painel.add(botoesOperacao[3]); // /

        // Organizando os elementos na janela
        setLayout(new BorderLayout(10, 10));
        add(campoTexto, BorderLayout.NORTH);
        add(painel, BorderLayout.CENTER);
    }

    // Método que é chamado quando algum botão é clicado
    @Override
    public void actionPerformed(ActionEvent e) {
        // Se clicou em número
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == botoesNumero[i]) {
                campoTexto.setText(campoTexto.getText() + i);
            }
        }

        // Se clicou em operação
        for (int i = 0; i < 4; i++) {
            if (e.getSource() == botoesOperacao[i]) {
                try {
                    num1 = Double.parseDouble(campoTexto.getText());
                    operador = botoesOperacao[i].getText().charAt(0);
                    campoTexto.setText("");
                } catch (Exception ex) {
                    campoTexto.setText("Erro");
                }
            }
        }

        // Se clicou em igual
        if (e.getSource() == botaoIgual) {
            try {
                num2 = Double.parseDouble(campoTexto.getText());
                switch (operador) {
                    case '+':
                        resultado = num1 + num2;
                        break;
                    case '-':
                        resultado = num1 - num2;
                        break;
                    case '*':
                        resultado = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            campoTexto.setText("Divisão por zero!");
                            return;
                        }
                        resultado = num1 / num2;
                        break;
                }
                campoTexto.setText(String.valueOf(resultado));
            } catch (Exception ex) {
                campoTexto.setText("Erro");
            }
        }

        // Se clicou em limpar
        if (e.getSource() == botaoClear) {
            campoTexto.setText("");
            num1 = num2 = resultado = 0;
        }
    }

    // Método principal que inicia a aplicação
    public static void main(String[] args) {
        // Aqui estou garantindo que a interface seja criada na thread correta (boa prática em Java)
        SwingUtilities.invokeLater(() -> {
            new Calculadora().setVisible(true);
        });
    }
}
