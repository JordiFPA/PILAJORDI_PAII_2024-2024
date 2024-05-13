package view_packages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controler_class.Controler;
import daos_package.DaoTeacher;
import default_package.MethodClass;
import models.Teacher;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TeacherWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MethodClass m = new MethodClass();
	Controler<Teacher> c = new Controler<>(new DaoTeacher());

	public TeacherWindow(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.black);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Agregar profesor");
		btnNewButton.setBounds(27, 23, 170, 33);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				m.createTeacher();
			}
		});

		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Actualizar Profesor");
		btnNewButton_1.setBounds(27, 115, 170, 33);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(null, "Ingrese el ID del profesor a actualizar");
				String name = JOptionPane.showInputDialog(null, "Ingrese el nombre");
				String lastName = JOptionPane.showInputDialog(null, "Ingrese el apellido");
				String age = JOptionPane.showInputDialog(null, "Ingrese la edad");
				m.UpdateTeacher(id, name, lastName, age);

			}
		});
		contentPane.add(btnNewButton_1);
		JLabel lblNewLabel = new JLabel("");
		JButton btnNewButton_2 = new JButton("Imprimir todo");
		btnNewButton_2.setBounds(27, 186, 170, 33);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Teacher> teacherList = c.readList();
				StringBuilder teacherInfo = new StringBuilder("<html>");
				for (Teacher teacher : teacherList) {
					teacherInfo.append(teacher.toString()).append("<br>");

				}
				teacherInfo.append("</html>");
				lblNewLabel.setText(teacherInfo.toString());

			}
		});
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Borrar Profesor");
		btnNewButton_3.setBounds(40, 256, 145, 33);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(null, "Ingrese el ID del profesor a ser eliminado");
				m.deleteTeacher(id);
			}
		});
		contentPane.add(btnNewButton_3);

		lblNewLabel.setBounds(280, 33, 260, 211);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.white);
		contentPane.add(lblNewLabel);
	}
}
