package br.com.locar.app.userType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;

import br.com.locar.app.model.types.Placa;

public class PlacaUserType extends ImmutableUserType {

	private static final long serialVersionUID = 1L;

	@Override
	public Placa nullSafeGet(ResultSet rs, String[] names, Object owner)
			throws HibernateException, SQLException {
		String value = rs.getString(names[0]);
		if (rs.wasNull()) {
			return null;
		}
		return Placa.fromString(value);
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.VARCHAR);
		}
		else {
			Placa placa = (Placa) value;
			st.setString(index, placa.toString());
		}
	}

	@Override
	public Class<?> returnedClass() {
		return Placa.class;
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.VARCHAR };
	}
	
}
