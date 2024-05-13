package view_packages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler_class.Control;
import daos_package.DaoSchedule;
import default_package.MethodClass;
import models.Schedule;

import javax.swing.JButton;

public class ScheduleWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MethodClass m;

	public ScheduleWindow(String title) {
		m = new MethodClass();
		Control<Schedule> c = new Control<>(new DaoSchedule());
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

		JButton btnNewButton = new JButton("Agregar Horario");
		btnNewButton.setBounds(10, 32, 139, 33);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				m.createSchedule();
			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Actualizar Horario");
		btnNewButton_1.setBounds(10, 108, 139, 33);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(null, "Ingrese el ID del horario a actualizar");
				String id_subject = JOptionPane.showInputDialog(null, "Ingrese el id de la clase: ");
				String id_student = JOptionPane.showInputDialog(null, "Ingrese el id del estudiante");
				String id_teacher = JOptionPane.showInputDialog(null, "Ingrese el id del profesor");
				String startTime = JOptionPane.showInputDialog(null, "Ingrese la hora de inicio");
				String endTime = JOptionPane.showInputDialog(null, "Ingrese la hora del final");
				String day = JOptionPane.showInputDialog(null, "Ingrese el dia");
				m.UpdateSchedule(id, id_subject, id_student, id_teacher, startTime, endTime, day);
			}
		});
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Imprimir Horarios");
		btnNewButton_2.setBounds(10, 181, 139, 33);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Schedule> scheduleList = c.readList();
				StringBuilder scheduleInfo = new StringBuilder("<html>");
				for (Schedule schedule : scheduleList) {
					scheduleInfo.append(schedule.toString()).append("<br>");

				}
				scheduleInfo.append("</html>");
				lblNewLabel.setText(scheduleInfo.toString());

			}
		});
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Borrar un Horario");
		btnNewButton_3.setBounds(10, 265, 139, 33);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String ID = JOptionPane.showInputDialog(null, "Ingrese el ID que desea eliminar");
				m.deleteSchedule(ID);
			}
		});
		contentPane.add(btnNewButton_3);

		lblNewLabel.setBounds(187, 32, 368, 245);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.white);
		contentPane.add(lblNewLabel);

	}
}
