package br.com.locar.app.userType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;

import br.com.locar.app.model.types.Renavan;


public class RenavamUserType extends ImmutableUserType {

	private static final long serialVersionUID = 1L;

	@Override
	public Renavan nullSafeGet(ResultSet rs, String[] names, Object owner)
			throws HibernateException, SQLException {
		String value = rs.getString(names[0]);
		if (rs.wasNull()) {
			return null;
		}
		return Renavan.fromString(value);
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.VARCHAR);
		}
		else {
			Renavan renavam = (Renavan) value;
			st.setString(index, renavam.toString());
		}
	}

	@Override
	public Class<?> returnedClass() {
		return Renavan.class;
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.VARCHAR };
	}
	
}
