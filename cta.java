
/** 
 * Write a Java program using GUI, to calculate CIE marks. 
 */
/**
 * @author naren
 * USN: 2SD21CS057
 * Submit Date: 03/07/2023
 * Time: 15:30hrs 
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class NumberFormatException extends Exception {
	public NumberFormatException(String n) {
		super(n);
	}

	public String toString() {
		return "Input Error";
	}
}

class seek extends JFrame implements ActionListener {
	JFrame h;
	JButton b;
	Container contpane;
	JPanel x, x1, x2, x3, x4;
	JLabel l, ia1, ia2, ia3;
	JLabel cta, see, ind, a, c;
	JTextField t1, t2, t3, t4, t5;

	seek(String title) {
		super(title);

		b = new JButton("Calculate the Grade");
		b.addActionListener(this);
		ia1 = new JLabel("    Enter the IA1 marks:");
		t1 = new JTextField(5);

		ia2 = new JLabel("    Enter the IA2 marks:");
		t2 = new JTextField(5);

		ia3 = new JLabel("    Enter the IA3 marks:");
		t3 = new JTextField(5);

		cta = new JLabel("    Enter the CTA marks:");
		t4 = new JTextField(5);

		see = new JLabel("    Enter the SEE marks:");
		t5 = new JTextField(5);
		ind = new JLabel("                                                      Grade calculator");
		a = new JLabel("  Total Marks:");
		c = new JLabel("  Grade of the Student:");

		l = new JLabel();
		x = new JPanel();
		x1 = new JPanel();
		x3 = new JPanel();
		x2 = new JPanel();
		x4 = new JPanel();
		x.add(ia1);
		x1.add(t1);
		x.add(ia2);
		x1.add(t2);
		x.add(ia3);
		x1.add(t3);
		x.add(cta);
		x1.add(t4);
		x.add(see);
		x1.add(t5);
		x.add(a);
		x.add(l);
		x1.add(c);
		x4.add(b);
		x.setLayout(new GridLayout(7, 2, 30, 30));
		x1.setLayout(new GridLayout(7, 2, 30, 30));
		contpane = this.getContentPane();
		contpane.add(x, BorderLayout.WEST);
		contpane.add(ind, BorderLayout.NORTH);
		contpane.add(x1, BorderLayout.CENTER);
		contpane.add(x3, BorderLayout.EAST);
		contpane.add(x4, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent r) {
		double sum, cie;

		double ia1 = Double.parseDouble(t1.getText());
		double ia2 = Double.parseDouble(t2.getText());
		double ia3 = Double.parseDouble(t3.getText());
		double cta = Double.parseDouble(t4.getText());
		double see = Double.parseDouble(t5.getText());

		try {
			if (ia1 < 0 || ia1 > 20)
				throw new NumberFormatException("Invalid");
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "IA1 marks out of range", "Marks out of range",
					JOptionPane.ERROR_MESSAGE);
		}

		try {
			if (ia2 < 0 || ia2 > 20)
				throw new NumberFormatException("Invalid");
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "IA2 marks out of range", "Marks out of range",
					JOptionPane.ERROR_MESSAGE);
		}

		try {
			if (ia3 < 0 || ia3 > 20)
				throw new NumberFormatException("Invalid");
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "IA3 marks out of range", "Marks out of range",
					JOptionPane.ERROR_MESSAGE);
		}

		try {
			if (cta < 0 || cta > 10)
				throw new NumberFormatException("Invalid");
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "CTA marks out of range", "Marks out of range",
					JOptionPane.ERROR_MESSAGE);
		}

		try {
			if (see < 0 || see > 100)
				throw new NumberFormatException("Invalid");
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "SEE marks is out of range", "Marks out of range",
					JOptionPane.ERROR_MESSAGE);
		}

		if (ia1 > ia3 && ia2 > ia3)
			cie = ia1 + ia2 + cta;
		else if (ia1 > ia2 && ia3 > ia2)
			cie = ia1 + ia3 + cta;
		else
			cie = ia2 + ia3 + cta;

		try {
			if (cie < 20)
				throw new NumberFormatException("Invalid");
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Student is detained for SEE ", "Detained", JOptionPane.ERROR_MESSAGE);
		}

		see = see / 2;
		if (see % 1 == 0.5) {
			see = see + 1;
			see = see - 0.5;
		}
		sum = see + cie;

		if (sum > 100)
			a.setText("  Total marks:");

		else
			a.setText("  Total marks:" + sum);

		if (cie < 20)
			c.setText("  Grade of the Student is: ");

		else if (sum >= 90 && sum <= 100)
			c.setText("  Grade of the Student is: S");

		else if (sum >= 80 && sum <= 89)
			c.setText("  Grade of the Student is: A");

		else if (sum >= 70 && sum <= 79)
			c.setText("  Grade of the Student is: B");

		else if (sum >= 60 && sum <= 69)
			c.setText("  Grade of the Student is: C");

		else if (sum >= 50 && sum <= 59)
			c.setText("  Grade of the Student is: D");

		else if (sum >= 40 && sum <= 49)
			c.setText("  Grade of the Student is: E");

		else if (see < 38 && sum <= 40)
			c.setText("  Grade of the Student is: F");

		else
			System.out.println("");

	}
}

public class cta {
	public static void main(String[] args) {

		JFrame f = new seek("Grade Calculator");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setBounds(350, 150, 400, 500);
		f.setVisible(true);
	}
}