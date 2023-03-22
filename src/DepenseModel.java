import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class DepenseModel extends AbstractTableModel {

	String[] cols = { "id", "Description", "Categorie", "Montant" };
	ArrayList<Depense> depenses = new ArrayList<Depense>();

	public DepenseModel(ArrayList<Depense> depenses) {
		super();
		this.depenses = depenses;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return depenses.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols.length;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return cols[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Depense p = depenses.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return p.getId();
		case 1:
			return p.getDescription();
		case 2:
			return p.getCategorie();
		case 3:
			return String.format("%.2f DH", p.getMontant());
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;

	}
	
}
