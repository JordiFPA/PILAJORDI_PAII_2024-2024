package view_packages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controler_class.Controler;
import daos_package.DaoSubject;
import default_package.MethodClass;
import models.Subjects;

public class SubjectWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MethodClass m;

	public SubjectWindow(String title) {
		setTitle(title);
		m = new MethodClass();
		Controler<Subjects> c = new Controler<>(new DaoSubject());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.black);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Agregar materia");
		btnNewButton.setBounds(27, 23, 170, 33);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				m.createSubject();
			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Actualizar materia");
		btnNewButton_1.setBounds(27, 115, 170, 33);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(null, "Ingrese el ID de la materia a actualizar");
				String name = JOptionPane.showInputDialog(null, "Ingrese el nombre");
				String lastName = JOptionPane.showInputDialog(null, "Ingrese la descripcion");
				String age = JOptionPane.showInputDialog(null, "Ingrese el nivel");
				m.UpdateSubject(id, name, lastName, age);

			}
		});
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Imprimir todo");
		btnNewButton_2.setBounds(27, 186, 170, 33);
		JLabel lblNewLabel = new JLabel("");
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Subjects> subjectList = c.readList();
				StringBuilder subjectInfo = new StringBuilder("<html>");
				for (Subjects subject : subjectList) {
					subjectInfo.append(subject.toString()).append("<br>");

				}
				subjectInfo.append("</html>");
				lblNewLabel.setText(subjectInfo.toString());

			}
		});
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Borrar materia");
		btnNewButton_3.setBounds(40, 256, 145, 33);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String ID = JOptionPane.showInputDialog(null, "Ingrese el ID que desea eliminar");
				m.deleteSubject(ID);

			}
		});
		contentPane.add(btnNewButton_3);

		lblNewLabel.setBounds(225, 52, 326, 211);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.white);
		contentPane.add(lblNewLabel);
	}

}
