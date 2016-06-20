package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class DAOScore.
 */
class DAOScore extends DAOEntity<Score> {

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOScore(final Connection connection) throws SQLException {
		super(connection);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#create(model.Entity)
	 */
	@Override
	public boolean create(final Score entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	@Override
	public boolean delete(final Score entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#update(model.Entity)
	 */
	@Override
	public boolean update(final Score entity) {
		try {
			final String sql = "{call setScore(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, entity.getScore());
			call.execute();
			return true;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(int)
	 */
	@Override
	public Score find(final int id) {
		Score score = new Score();
		
		try {
			final String sql = "{call getScore()}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				score = new Score(resultSet.getInt("score"));
			}
			return score;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
