import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame implements ActionListener {

	Font myFont = new Font("Noto Sans", Font.PLAIN, 20);
	Font resultFont = new Font("Noto Sans", Font.PLAIN, 35);
	JButton[] numberButton = new JButton[10];
	JTextField resultField;
	JButton buttonAdd;
	JButton buttonMinus;
	JButton buttonDivide;
	JButton buttonMultiply;
	JButton buttonEqualTo;
	JButton buttonDot;
	JButton buttonClear;
	double num1;
	double num2;
	double result;
	char operator;

	public CalculatorFrame() {
		setSize(550, 500);
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// container to hold all components
		JPanel Container = new JPanel();
		Container.setLayout(new BoxLayout(Container, BoxLayout.Y_AXIS));
		Container.setBackground(Color.black);

		// upperPanel with text field to display result
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 30));
		upperPanel.setBackground(Color.black);

		resultField = new JTextField("");
		resultField.setFont(resultFont);
		resultField.setHorizontalAlignment(JTextField.CENTER);
		resultField.setBackground(Color.black);
		resultField.setOpaque(true);
		resultField.setForeground(Color.white);
		resultField.setPreferredSize(new Dimension(200, 50));
		upperPanel.add(resultField);

		// creating a centerPanel and clear button

		JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		middlePanel.setBackground(Color.black);
		middlePanel.setPreferredSize(new Dimension(400, 50));

		buttonClear = new JButton("Clear");
		buttonClear.setBackground(Color.gray);
		buttonClear.setOpaque(true);
		buttonClear.setBorderPainted(false);
		buttonClear.setPreferredSize(new Dimension(80, 50));
		buttonClear.addActionListener(this);
		middlePanel.add(buttonClear);

		// numberPanel for all the numbers and operators
		JPanel numberPanel = new JPanel(new GridLayout(4, 4, 3, 3));
		numberPanel.setBackground(Color.black);

		for (int i = 0; i < 10; i++) {
			numberButton[i] = new JButton(String.valueOf(i));
			numberButton[i].setBackground(Color.gray);
			numberButton[i].setOpaque(true);
			numberButton[i].setBorderPainted(false);
			numberButton[i].setFont(myFont);
			numberButton[i].addActionListener(this);

		}

		buttonAdd = new JButton("+");
		buttonAdd.setBackground(Color.orange);
		buttonAdd.setOpaque(true);
		buttonAdd.setBorderPainted(false);
		buttonAdd.setFont(myFont);
		buttonAdd.addActionListener(this);

		buttonMinus = new JButton("-");
		buttonMinus.setBackground(Color.orange);
		buttonMinus.setOpaque(true);
		buttonMinus.setBorderPainted(false);
		buttonMinus.setFont(myFont);
		buttonMinus.addActionListener(this);

		buttonDivide = new JButton("/");
		buttonDivide.setBackground(Color.orange);
		buttonDivide.setOpaque(true);
		buttonDivide.setBorderPainted(false);
		buttonDivide.setFont(myFont);
		buttonDivide.addActionListener(this);

		buttonMultiply = new JButton("x");
		buttonMultiply.setBackground(Color.orange);
		buttonMultiply.setOpaque(true);
		buttonMultiply.setBorderPainted(false);
		buttonMultiply.setFont(myFont);
		buttonMultiply.addActionListener(this);

		buttonEqualTo = new JButton("=");
		buttonEqualTo.setBackground(Color.orange);
		buttonEqualTo.setOpaque(true);
		buttonEqualTo.setBorderPainted(false);
		buttonEqualTo.setFont(myFont);
		buttonEqualTo.addActionListener(this);

		buttonDot = new JButton(".");
		buttonDot.setBackground(Color.orange);
		buttonDot.setOpaque(true);
		buttonDot.setBorderPainted(false);
		buttonDot.setFont(myFont);
		buttonDot.addActionListener(this);

		numberPanel.add(numberButton[7]);
		numberPanel.add(numberButton[8]);
		numberPanel.add(numberButton[9]);
		numberPanel.add(buttonMultiply);
		numberPanel.add(numberButton[4]);
		numberPanel.add(numberButton[5]);
		numberPanel.add(numberButton[6]);
		numberPanel.add(buttonMinus);
		numberPanel.add(numberButton[1]);
		numberPanel.add(numberButton[2]);
		numberPanel.add(numberButton[3]);
		numberPanel.add(buttonAdd);
		numberPanel.add(numberButton[0]);
		numberPanel.add(buttonDot);
		numberPanel.add(buttonDivide);
		numberPanel.add(buttonEqualTo);

		// add all three panels to the container & container to the Jframe
		Container.add(upperPanel);
		Container.add(middlePanel);
		Container.add(numberPanel);
		this.add(Container);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (e.getSource().equals(numberButton[i])) {
				resultField.setText(resultField.getText().concat(String.valueOf(numberButton[i].getText())));
			}
		}

		if (e.getSource() == buttonAdd) {
			if (!resultField.getText().isEmpty()) {
				num1 = Double.parseDouble(resultField.getText());
				operator = '+';
				resultField.setText("");
			}
		}

		if (e.getSource() == buttonMinus) {
			if (!resultField.getText().isEmpty()) {
				num1 = Double.parseDouble(resultField.getText());
				operator = '-';
				resultField.setText("");
			}
		}

		if (e.getSource() == buttonMultiply) {
			if (!resultField.getText().isEmpty()) {
				num1 = Double.parseDouble(resultField.getText());
				operator = 'x';
				resultField.setText("");
			}
		}

		if (e.getSource() == buttonDivide) {
			if (!resultField.getText().isEmpty()) {
				num1 = Double.parseDouble(resultField.getText());
				operator = '/';
				resultField.setText("");
			}
		}

		if (e.getSource() == buttonEqualTo) {
			num2 = Double.parseDouble(resultField.getText());

			switch (operator) {

			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case 'x':
				result = num1 * num2;
				break;
			case '/':
				if (num2 != 0) {
					result = num1 / num2;
				} else {
					resultField.setText("Error");
					num1 = num2 = result = 0;
					operator = '\0';
					return;
				}
				break;

			}
			resultField.setText(String.valueOf(result));
			resetCalculator();
		}

		if (e.getSource() == buttonDot) {
			if (!resultField.getText().contains(".")) {
				resultField.setText(resultField.getText().concat("."));
			}
		}

		if (e.getSource() == buttonClear) {
			resultField.setText("");
			resetCalculator();
		}

	}

	private void resetCalculator() {
		num1 = 0;
		num2 = 0;
		result = 0;
		operator = '\0'; // '\0' represents a null character, meaning no operator
	}

	public static void main(String[] args) {
		CalculatorFrame frame = new CalculatorFrame();
		frame.setVisible(true);
	}
}
