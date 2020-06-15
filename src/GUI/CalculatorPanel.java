package GUI;

import Controller.CalculatorController;

import javax.swing.*;
import java.awt.*;

public class CalculatorPanel {
    private CalculatorController calculatorPanelController = new CalculatorController();
    private JRadioButton rbAdditionalFunctions = new JRadioButton("Show advanced functions");
    private JTextField calculationLine = new JTextField();

    public JPanel createCalculatorPanel(JFrame mainFrame, CalculatorFrame calculatorFrame) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setLocation(0, 5);
        panel.setSize(355, 325);

        calculationLine.setFont(new Font("Dialog", Font.PLAIN, 25));
        JScrollPane calculationLineScroll = new JScrollPane(calculationLine);
        calculationLineScroll.setBounds(0, 5, 355, 55);

        rbAdditionalFunctions.setBounds(15, 65, 345, 20);

        JButton b0 = new JButton("0");
        b0.setBounds(0, 270, 55, 55);
        panel.add(b0);

        JButton b1 = new JButton("1");
        b1.setBounds(0, 210, 55, 55);
        panel.add(b1);

        JButton b2 = new JButton("2");
        b2.setBounds(60, 210, 55, 55);
        panel.add(b2);

        JButton b3 = new JButton("3");
        b3.setBounds(120, 210, 55, 55);
        panel.add(b3);

        JButton b4 = new JButton("4");
        b4.setBounds(0, 150, 55, 55);
        panel.add(b4);

        JButton b5 = new JButton("5");
        b5.setBounds(60, 150, 55, 55);
        panel.add(b5);

        JButton b6 = new JButton("6");
        b6.setBounds(120, 150, 55, 55);
        panel.add(b6);

        JButton b7 = new JButton("7");
        b7.setBounds(0, 90, 55, 55);
        panel.add(b7);

        JButton b8 = new JButton("8");
        b8.setBounds(60, 90, 55, 55);
        panel.add(b8);

        JButton b9 = new JButton("9");
        b9.setBounds(120, 90, 55, 55);
        panel.add(b9);

        JButton bRes = new JButton("=");
        bRes.setBounds(120, 270, 55, 55);
        panel.add(bRes);

        JButton bPlus = new JButton("+");
        bPlus.setBounds(180, 270, 55, 55);
        panel.add(bPlus);

        JButton bMinus = new JButton("-");
        bMinus.setBounds(180, 210, 55, 55);
        panel.add(bMinus);

        JButton bMultiply = new JButton("*");
        bMultiply.setBounds(180, 150, 55, 55);
        panel.add(bMultiply);

        JButton bPoint = new JButton(".");
        bPoint.setBounds(60, 270, 55, 55);
        panel.add(bPoint);

        JButton bSqrt = new JButton("\u221A");
        bSqrt.setBounds(240, 270, 55, 55);
        panel.add(bSqrt);

        JButton bClear = new JButton("AC");
        bClear.setBounds(300, 270, 55, 55);
        panel.add(bClear);

        JButton bPercent = new JButton("%");
        bPercent.setBounds(300, 210, 55, 55);
        panel.add(bPercent);

        JButton bDivision = new JButton("/");
        bDivision.setBounds(180, 90, 55, 55);
        panel.add(bDivision);

        JButton bInverse = new JButton("1/x");
        bInverse.setBounds(240, 210, 55, 55);
        panel.add(bInverse);

        JButton bLeftBracket = new JButton("(");
        bLeftBracket.setBounds(240, 150, 55, 55);
        panel.add(bLeftBracket);

        JButton bRightBracket = new JButton(")");
        bRightBracket.setBounds(300, 150, 55, 55);
        panel.add(bRightBracket);

        JButton bLeftArrow = new JButton("<");
        bLeftArrow.setBounds(240, 90, 55, 55);
        panel.add(bLeftArrow);

        JButton bRightArrow = new JButton(">");
        bRightArrow.setBounds(300, 90, 55, 55);
        panel.add(bRightArrow);


        panel.add(calculationLineScroll);
        panel.add(rbAdditionalFunctions);

        calculatorPanelController.actionRB(rbAdditionalFunctions, createAdditionalFunctionsPanel(), mainFrame);

        calculatorPanelController.actionBasicButtons(
                calculatorFrame, mainFrame, calculationLine, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bClear, bDivision,
                bInverse, bLeftBracket, bMinus, bPercent, bMultiply, bPlus, bPoint, bRes, bRightBracket, bSqrt, bLeftArrow, bRightArrow);
        return panel;
    }

    private JPanel createAdditionalFunctionsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setLocation(0, 335);
        panel.setSize(355, 55);

        JButton bLog = new JButton("log(y,x)");
        bLog.setBounds(0, 0, 175, 55);
        JButton bFact = new JButton("x!");
        bFact.setBounds(180, 0, 175, 55);

        panel.add(bLog);
        panel.add(bFact);
        calculatorPanelController.actionAdditionalButtons(calculationLine, bLog, bFact);
        return panel;
    }
}