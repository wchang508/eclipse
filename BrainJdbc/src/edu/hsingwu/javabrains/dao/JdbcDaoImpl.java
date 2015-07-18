package edu.hsingwu.javabrains.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import edu.hsingwu.javabrains.model.Circle;

/* ij program
  connect 'jdbc:derby://localhost:1527/db;create=true';
 */
@Component
public class JdbcDaoImpl {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate; //tutorial 39 jdbc template
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; //tutorial 43 named parameter jdbc template
	private SimpleJdbcTemplate simplejdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDatasource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(dataSource);
	}
	
	/* Tutorial 38: Spring and DataSource Configuration
	public Circle getCircle(int circleId)
	{ 
		Connection conn=null;
		
		try{
			
			conn =dataSource.getConnection();
			
			PreparedStatement ps=conn.prepareStatement("select * from circle  where id=? ");
			ps.setInt(1, circleId);
			
			Circle circle=null;
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{
				circle = new Circle(circleId, rs.getString("name"));
			}
			rs.close();
			ps.close();
			return circle;
			}
			catch (Exception ex)
			{
				throw new RuntimeException(ex);
			}
			finally
			{
				try{
				conn.close();
				}
				catch(SQLException ex)
				{}
			} 
		
	}
	*/
	
	/*Tutorial 39 jdbc Template */
	public int getCircleCount()
	{
		String sql= "Select count(*) from circle";
		/*data source was autowired set in [public void setDatasource(DataSource dataSource)]
		  therefore, next line of code can be deleted*/ 
		//jdbcTemplate.setDataSource(getDataSource());  
		
		return jdbcTemplate.queryForInt(sql);
	}
	
	/*Tutorial 40 returning other datatypes from JdbcTemplate */
	public String getCircleName(int circleId)
	{
		String sql ="select name from circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, String.class);
	}
	
	/*Tutorial 41 implementing rowmapper*/
	public Circle getCircleforId(int circleId)
	{
		String sql ="select * from circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, new CircleMapper());
	}
	
	public List<Circle> getAllCircles()
	{
		String sql="Select * from circle";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	private static final class CircleMapper implements RowMapper<Circle>
	{

		@Override
		public Circle mapRow(ResultSet resultSet, int arg1) throws SQLException {
			Circle circle= new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}
		
	}
	
	/* Tutorial 42: Performing Write Operation*/
	public void insertCircle(Circle circle)
	{
		String sql ="insert into circle(id, name) values (?,?)";
		jdbcTemplate.update(sql, new Object[]{circle.getId(),  circle.getName()});
		
	}
	
	public void createTriangleTable()
	{
		String sql="CREATE TABLE TRIANGLE(ID INTEGER, NAME VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}
	
	/*Tutorial 43: Named Parameter JDBC Template*/
	public void insertCircleParameter(Circle circle)
	{
		String sql ="insert into circle(ID, NAME) values (:id,:name)";
		
		//SqlParameterSource is an interface; MapSqlParameterSource is class that implements SqlParameterSource
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId())
													.addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, namedParameters);
	}
	
	
	/* Tutorial 37: for jdbc code
	public Circle getCircle(int circleId)
	{ 
		Connection conn=null;
		try{
		String driver="org.apache.derby.jdbc.ClientDriver";
		Class.forName(driver).newInstance(); 
		conn =DriverManager.getConnection("jdbc:derby://localhost:1527/db");
		
		PreparedStatement ps=conn.prepareStatement("select * from circle  where id=? ");
		ps.setInt(1, circleId);
		
		Circle circle=null;
		ResultSet rs=ps.executeQuery();
		while (rs.next())
		{
			circle = new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return circle;
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
		finally
		{
			try{
			conn.close();
			}
			catch(SQLException ex)
			{}
		} 
	}
		*/
		
}	

