package khushi.oops.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

class Form extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JTextField ia1Field, ia2Field, ia3Field, ctaField, seeField;
	JButton button;

	Form(String message) {
		super(message);

		l1 = new JLabel("Grade Calculator");
		l2 = new JLabel("Enter IA-1 Marks(0-20) : ");
		l3 = new JLabel("Enter IA-2 Marks(0-20) : ");
		l4 = new JLabel("Enter IA-3 Marks(0-20) : ");
		l5 = new JLabel("Enter CTA Marks(0-10) : ");
		l6 = new JLabel("Enter SEE Marks(0-100) : ");
		l7 = new JLabel();
		l8 = new JLabel();
		l9 = new JLabel();
		button = new JButton("Calculate");
		ia1Field = new JTextField(10);
		ia2Field = new JTextField(10);
		ia3Field = new JTextField(10);
		ctaField = new JTextField(10);
		seeField = new JTextField(10);

		add(l1);
		add(l2);
		add(ia1Field);
		add(l3);
		add(ia2Field);
		add(l4);
		add(ia3Field);
		add(l5);
		add(ctaField);
		add(l6);
		add(seeField);
		add(button);
		add(l7);
		add(l8);
		add(l9);

		l1.setBounds(100, 50, 100, 50);
		l2.setBounds(50, 100, 150, 50);
		ia1Field.setBounds(200, 110, 100, 30);
		l3.setBounds(50, 150, 150, 50);
		ia2Field.setBounds(200, 160, 100, 30);
		l4.setBounds(50, 200, 150, 50);
		ia3Field.setBounds(200, 210, 100, 30);
		l5.setBounds(50, 250, 150, 50);
		ctaField.setBounds(200, 260, 100, 30);
		l6.setBounds(50, 300, 150, 50);
		seeField.setBounds(200, 310, 100, 30);
		button.setBounds(100, 350, 100, 50);
		l7.setBounds(35, 420, 500, 50);
		l8.setBounds(180, 420, 100, 50);
		l9.setBounds(35, 420, 500, 50);
		
		button.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			double ia1 = Double.parseDouble(ia1Field.getText());
			double ia2 = Double.parseDouble(ia2Field.getText());
			double ia3 = Double.parseDouble(ia3Field.getText());
			double cta = Double.parseDouble(ctaField.getText());
			double see = Double.parseDouble(seeField.getText());
			double totalMarks, cie = 0;
			char grade;

			if (cta < 0 || cta > 10)
				throw new IllegalArgumentException("Error : Invalid marks entered!");

			if (ia1 < 0 || ia1 > 20 || ia2 < 0 || ia2 > 20 || ia3 < 0 || ia3 > 20)
				throw new IllegalArgumentException("Error : Invalid marks entered!");
			else {
				if (ia1 <= ia2 && ia1 <= ia3)
					cie = ia2 + ia3 + cta;
				else if (ia2 <= ia1 && ia2 <= ia3)
					cie = ia1 + ia3 + cta;
				else
					cie = ia1 + ia2 + cta;
			}
			if (cie < 20)
				throw new IllegalArgumentException("Student is detained from taking SEE");
			else {
				if (see == 38 || see == 39) {
					see = 40;
				}
				double see1 = see / 2;
				int roundedTotalMarks = (int) Math.round(see1);
				totalMarks = cie + see1;
				l7.setText("Total Marks : " + totalMarks);

			}

			if (totalMarks >= 90 && totalMarks <= 100)
				grade = 'S';
			else if (totalMarks >= 80 && totalMarks <= 89)
				grade = 'A';
			else if (totalMarks >= 70 && totalMarks <= 79)
				grade = 'B';
			else if (totalMarks >= 60 && totalMarks <= 69)
				grade = 'C';
			else if (totalMarks >= 50 && totalMarks <= 59)
				grade = 'D';
			else if (totalMarks >= 40 && totalMarks <= 49)
				grade = 'E';
			else
				grade = 'F';

			l8.setText("Grade : " + grade);
		} catch (Exception ex) {
			l7.setText(ex.getMessage());
		}
	}
}

public class StudentGradeSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame f = new Form("Student Grading System");
		// f.setTitle("Grade Calculator");
		// f.setSize(50,50);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 400, 500);
		f.setVisible(true);

	}

}
