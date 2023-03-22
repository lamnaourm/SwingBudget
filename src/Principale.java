import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Panel;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.junit.experimental.categories.Categories;

import java.awt.FlowLayout;

public class Principale extends JFrame {

	private JPanel contentPane;
	private JTextField txtdes;
	private JTextField txtmnt;
	private JTextField txtbudget;
	private JTable table;
	private static String[] categories = { "Infrastructure", "Vetement", "Nourriture", "Appareil", "Autres depenses" };
	private JComboBox cbcategorie;
	private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
	static ArrayList<Depense> depenses = new ArrayList<>();
	private double budget;
	private JLabel lblBudget;
	private JLabel lbl_depenses;
	private JLabel lblBalance;
	JPanel panel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principale frame = new Principale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principale() {
		setTitle("Gestion Budget");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1315, 564);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 128));
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 225, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 30, 30, 50, 46, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Description Depense :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		txtdes = new JTextField();
		txtdes.setPreferredSize(new Dimension(100, 20));
		txtdes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_txtdes = new GridBagConstraints();
		gbc_txtdes.insets = new Insets(0, 0, 5, 0);
		gbc_txtdes.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdes.gridx = 0;
		gbc_txtdes.gridy = 1;
		panel.add(txtdes, gbc_txtdes);
		txtdes.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Categorie : ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		cbcategorie = new JComboBox();
		GridBagConstraints gbc_cbcategorie = new GridBagConstraints();
		gbc_cbcategorie.insets = new Insets(0, 0, 5, 0);
		gbc_cbcategorie.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbcategorie.gridx = 0;
		gbc_cbcategorie.gridy = 3;
		panel.add(cbcategorie, gbc_cbcategorie);

		model = new DefaultComboBoxModel<String>(categories);
		cbcategorie.setModel(model);
		JLabel lblNewLabel_1 = new JLabel("Montant :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtmnt = new JTextField();
		txtmnt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_txtmnt = new GridBagConstraints();
		gbc_txtmnt.insets = new Insets(0, 0, 5, 0);
		gbc_txtmnt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtmnt.gridx = 0;
		gbc_txtmnt.gridy = 5;
		panel.add(txtmnt, gbc_txtmnt);
		txtmnt.setColumns(10);

		JButton btnNewButton = new JButton("Ajouter depense");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtdes.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Description vide");
					txtdes.requestFocus();
					return;
				}
				if (txtmnt.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Montant vide");
					txtmnt.requestFocus();
					return;
				}

				Depense d = new Depense();
				d.setDescription(txtdes.getText());
				d.setCategorie(cbcategorie.getSelectedItem().toString());
				d.setMontant(Double.valueOf(txtmnt.getText()));

				depenses.add(d);
				((DepenseModel) table.getModel()).fireTableDataChanged();
				;

				calcul_montant();
				panel_4.removeAll();
				panel_4.add(createPanelDepense());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 6;
		panel.add(btnNewButton, gbc_btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("Budget :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 10;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		txtbudget = new JTextField();
		GridBagConstraints gbc_txtbudget = new GridBagConstraints();
		gbc_txtbudget.insets = new Insets(0, 0, 5, 0);
		gbc_txtbudget.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtbudget.gridx = 0;
		gbc_txtbudget.gridy = 11;
		panel.add(txtbudget, gbc_txtbudget);
		txtbudget.setColumns(10);

		JButton btnNewButton_1 = new JButton("Modifier budget");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtbudget.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Valeur de budget vide");
					txtbudget.requestFocus();
					return;
				}

				budget += Double.valueOf(txtbudget.getText());
				calcul_montant();

			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 12;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBackground(new Color(255, 0, 0));
		panel_2.setBounds(36, 25, 218, 105);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Budget");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(77, 6, 63, 25);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_4);

		lblBudget = new JLabel("0.00 DH");
		lblBudget.setForeground(new Color(255, 255, 255));
		lblBudget.setHorizontalAlignment(SwingConstants.CENTER);
		lblBudget.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBudget.setBounds(10, 58, 198, 36);
		panel_2.add(lblBudget);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2_1.setBackground(new Color(128, 128, 255));
		panel_2_1.setBounds(312, 25, 218, 105);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);

		JLabel lblNewLabel_4_1 = new JLabel("Depenses");
		lblNewLabel_4_1.setBounds(65, 6, 87, 25);
		lblNewLabel_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2_1.add(lblNewLabel_4_1);

		lbl_depenses = new JLabel("0.00 DH");
		lbl_depenses.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_depenses.setForeground(Color.WHITE);
		lbl_depenses.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_depenses.setBounds(10, 58, 198, 36);
		panel_2_1.add(lbl_depenses);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2_1_1.setBackground(new Color(0, 128, 0));
		panel_2_1_1.setBounds(590, 25, 218, 105);
		panel_1.add(panel_2_1_1);
		panel_2_1_1.setLayout(null);

		lblBalance = new JLabel("0.00 DH");
		lblBalance.setBounds(10, 57, 198, 37);
		lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_2_1_1.add(lblBalance);

		JLabel lblNewLabel_4_2 = new JLabel("Balance");
		lblNewLabel_4_2.setBounds(72, 11, 70, 25);
		lblNewLabel_4_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2_1_1.add(lblNewLabel_4_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "Liste des depense", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(26, 170, 471, 312);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 452, 253);
		panel_3.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DepenseModel(depenses));

		panel_4 = new JPanel();
		panel_4.setBounds(507, 178, 503, 299);
		panel_1.add(panel_4);
		panel_4.add(createPanelDepense());
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

	void calcul_montant() {
		lblBudget.setText(String.format("%.2f DH", budget));

		double montant = 0;

		for (Depense d : depenses)
			montant += d.getMontant();

		lbl_depenses.setText(String.format("%.2f DH", montant));
		lblBalance.setText(String.format("%.2f DH", (budget - montant)));

	}

	private static PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for(String s : categories) {
			
			double m =0;
			for (Depense d : depenses)
				if(d.getCategorie().equals(s))
				m += d.getMontant();
			
			dataset.setValue(s, m);
		}
		/*dataset.setValue("IPhone 5s", new Double(20));
		dataset.setValue("SamSung Grand", new Double(20));
		dataset.setValue("MotoG", new Double(40));
		dataset.setValue("Nokia Lumia", new Double(10));*/
		return dataset;
	}

	private static JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart("Les depenses", // chart title
				dataset, // data
				true, // include legend
				true, false);

		return chart;
	}

	public static ChartPanel createPanelDepense() {
		JFreeChart chart = createChart(createDataset());
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(500,290));
		return panel;
	}
}
