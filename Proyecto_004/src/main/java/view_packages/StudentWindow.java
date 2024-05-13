package view_packages;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controler_class.Controler;
import daos_package.IDaosStudent;
import default_package.MethodClass;
import models.Student;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;

public class StudentWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MethodClass m;

	public StudentWindow(String title) {
		m = new MethodClass();
		Controler<Student> c = new Controler<>(new IDaosStudent());
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.black);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Agregar un Estudiante");
		btnNewButton.setBounds(27, 23, 170, 33);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				m.crearEstudiante();
			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Actualizar un estudiante");
		btnNewButton_1.setBounds(27, 115, 170, 33);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(null, "Ingrese el ID del estudiante a actualizar");
				String name = JOptionPane.showInputDialog(null, "Ingrese el nombre");
				String lastName = JOptionPane.showInputDialog(null, "Ingrese el apellido");
				String age = JOptionPane.showInputDialog(null, "Ingrese la edad");
				m.UpdateStudent(id, name, lastName, age);

			}
		});

		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Imprimir todo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Student> studentList = c.readList();
				StringBuilder studentInfo = new StringBuilder("<html>");
				for (Student student : studentList) {
					studentInfo.append(student.toString()).append("<br>");

				}
				studentInfo.append("</html>");
				lblNewLabel.setText(studentInfo.toString());
			}
		});
		btnNewButton_2.setBounds(27, 186, 170, 33);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_4 = new JButton("Eliminar estudiante");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = JOptionPane.showInputDialog(null, "Ingrese el ID que desea eliminar");
				m.deleteStudent(ID);
			}
		});
		btnNewButton_4.setBounds(40, 256, 145, 33);
		contentPane.add(btnNewButton_4);

		lblNewLabel.setBounds(280, 33, 260, 211);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.white);
		contentPane.add(lblNewLabel);
	}

}
