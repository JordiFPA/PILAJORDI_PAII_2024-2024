package view_packages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PrincipalWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PrincipalWindow(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.black);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

		JLabel lbl1 = new JLabel();
		lbl1.setForeground(Color.white);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setText("Escoja la opción con la que quiere trabajar");
		lbl1.setFont(lbl1.getFont().deriveFont(Font.PLAIN, 20)); // Ajustar tamaño de fuente

		contentPane.add(lbl1, BorderLayout.CENTER);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8)); // Botones uno al lado del otro, centrados
		JButton btn1 = new JButton("ESTUDIANTE");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentWindow ventana2 = new StudentWindow("Estudiante");
				ventana2.setVisible(true);
			}
		});
		buttonsPanel.add(btn1);
		JButton btn2 = new JButton("PROFESOR");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TeacherWindow window2 = new TeacherWindow("Profesor");
				window2.setVisible(true);
			}
		});
		buttonsPanel.add(btn2);
		JButton btn3 = new JButton("MATERIA");
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SubjectWindow window3 = new SubjectWindow("Materias");
				window3.setVisible(true);

			}
		});
		buttonsPanel.add(btn3);
		JButton btn4 = new JButton("HORARIO"); 
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ScheduleWindow window4 = new ScheduleWindow("Horario"); 
				window4.setVisible(true);
				
			}
		});
		buttonsPanel.add(btn4);

		contentPane.add(buttonsPanel, BorderLayout.SOUTH);
	}

}
