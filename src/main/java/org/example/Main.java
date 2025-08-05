package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::criarFormulario);
    }

    private static void criarFormulario() {
        JFrame frame = new JFrame("Formulário de Contato");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null); // Centraliza na tela

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre componentes
        gbc.anchor = GridBagConstraints.WEST;

        Font fonte = new Font("SansSerif", Font.PLAIN, 14);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(fonte);
        JTextField nomeField = new JTextField(20);
        nomeField.setFont(fonte);

        JLabel comentarioLabel = new JLabel("Comentário:");
        comentarioLabel.setFont(fonte);
        JTextArea comentarioArea = new JTextArea(4, 20);
        comentarioArea.setFont(fonte);
        comentarioArea.setLineWrap(true);
        comentarioArea.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(comentarioArea);

        JCheckBox interessesAWS = new JCheckBox("Tem interesse em AWS?");
        interessesAWS.setFont(fonte);
        interessesAWS.setBackground(panel.getBackground());

        // Radio Buttons
        JLabel interesseLabel = new JLabel("Deseja receber contato?");
        interesseLabel.setFont(fonte);
        JRadioButton radioSim = new JRadioButton("Sim");
        JRadioButton radioNao = new JRadioButton("Não");
        radioSim.setFont(fonte);
        radioNao.setFont(fonte);
        radioSim.setBackground(panel.getBackground());
        radioNao.setBackground(panel.getBackground());

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioSim);
        grupo.add(radioNao);

        JButton enviarButton = new JButton("Enviar");
        enviarButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        enviarButton.setBackground(new Color(59, 89, 182));
        enviarButton.setForeground(Color.WHITE);
        enviarButton.setFocusPainted(false);

        // Layout do painel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nomeLabel, gbc);

        gbc.gridx = 1;
        panel.add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(comentarioLabel, gbc);

        gbc.gridx = 1;
        panel.add(scroll, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(interessesAWS, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(interesseLabel, gbc);

        gbc.gridx = 1;
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.setBackground(panel.getBackground());
        radioPanel.add(radioSim);
        radioPanel.add(radioNao);
        panel.add(radioPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        panel.add(enviarButton, gbc);

        enviarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String comentario = comentarioArea.getText();
            boolean interesseAWS = interessesAWS.isSelected();
            String contato = radioSim.isSelected() ? "Sim" : radioNao.isSelected() ? "Não" : "Não informado";

            JOptionPane.showMessageDialog(frame,
                    "Nome: " + nome + "\nComentário: " + comentario +
                            "\nInteresse AWS: " + (interesseAWS ? "Sim" : "Não") +
                            "\nDeseja contato: " + contato,
                    "Resumo do Formulário", JOptionPane.INFORMATION_MESSAGE);
        });

        // Efeito hover no botão
        enviarButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                enviarButton.setText("Clique para Enviar");
            }

            public void mouseExited(MouseEvent e) {
                enviarButton.setText("Enviar");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
