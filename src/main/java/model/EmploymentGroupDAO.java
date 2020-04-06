package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConnectionPool;

public class EmploymentGroupDAO {
  private static final String SELECT_ALL_EMPLOYMENT_GROUPS = "select * from employmentgroups";
  
  public static ArrayList<EmploymentGroup> selectAllEmploymentGroups() {
    ArrayList<EmploymentGroup> employmentgroups = new ArrayList<>();
    try {
      Connection connection = ConnectionPool.getInstance().getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYMENT_GROUPS);
      
      ResultSet rs = preparedStatement.executeQuery();
      while ( rs.next()) {
        String id = rs.getString("groupid");
        String name = rs.getString("groupname");
        employmentgroups.add(new EmploymentGroup(id, name));
      }
    } catch (SQLException e) {
      System.err.println(e);
    }
    return employmentgroups;    
  }
}
