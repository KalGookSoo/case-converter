package com.kalgooksoo;

import javax.swing.*;
import java.awt.*;

class CaseConverter {

    private static JTextArea inputArea;

    private static JTextArea outputArea;

    private static JCheckBox isUpperCheckBox;

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Case Converter");
        jFrame.setSize(600, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;

        // 좌측 입력 JTextArea
        inputArea = new JTextArea();
        JScrollPane inputScrollPane = new JScrollPane(inputArea);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        jFrame.add(inputScrollPane, gbc);

        // 가운데 옵션 및 버튼
        JPanel optionsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints optionsGbc = new GridBagConstraints();
        optionsGbc.insets = new Insets(5, 5, 5, 5);
        optionsGbc.fill = GridBagConstraints.HORIZONTAL;

        isUpperCheckBox = new JCheckBox("isUpperCase");
        optionsGbc.gridx = 0;
        optionsGbc.gridy = 0;
        optionsPanel.add(isUpperCheckBox, optionsGbc);

        JButton convertButton = new JButton("Convert");
        optionsGbc.gridy = 1;
        optionsPanel.add(convertButton, optionsGbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 0;
        jFrame.add(optionsPanel, gbc);

        // 우측 출력 JTextArea
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 0.5;
        jFrame.add(outputScrollPane, gbc);

        convertButton.addActionListener(e -> {
            String input = inputArea.getText();
            boolean isUpper = isUpperCheckBox.isSelected();
            StringBuilder sb = new StringBuilder();
            for (String line : input.split("\n")) {
                sb.append(camelToSnake(line, isUpper)).append("\n");
            }
            outputArea.setText(sb.toString());
        });

        jFrame.setVisible(true);

    }

    private static String camelToSnake(String camelCase, boolean isUpper) {
        if (camelCase == null || camelCase.isEmpty()) {
            return camelCase;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = camelCase.toCharArray();

        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                if (sb.length() > 0) {
                    sb.append('_');
                }
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return isUpper ? sb.toString().toUpperCase() : sb.toString();
    }

}
