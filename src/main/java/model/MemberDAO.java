package model;

import java.sql.*;
import java.util.ArrayList;
import util.ConnectionPool;

public class MemberDAO {

  private static final String INSERT_MEMBERS_SQL
    = "insert into members" + " (membername, password, email, basesalary, bonus, employmentgroup) values " + " (?, ?, ?, ?, ?, ?);";
  private static final String UPDATE_MEMBERS_SQL
    = "update members set membername = ?, password = ?, email = ?, basesalary =?, bonus = ?, employmentgroup = ? where id = ?;";
  private static final String DELETE_MEMBERS_SQL
    = "delete from members where id = ?;";
  private static final String SELECT_MEMBER_BY_ID
    = "select id,membername,password,email,basesalary,bonus,employmentgroup from members where id =?";
  private static final String SELECT_MEMBER_BY_NAME
    = "select id,membername,password,email,basesalary,bonus,employmentgroup from members where membername =?";
  private static final String SELECT_ALL_MEMBERS
    = "select * from members;";

  public static void insertMember(Member member) throws SQLException {
    
    //TODO: prepare and execute statement to insert a new member
  
  }

  public static boolean updateMember(Member member) throws SQLException {
    boolean rowUpdated = false;
    
    //TODO: prepare and execute statement to update a member    
    
    return rowUpdated;
  }

  public static boolean deleteMember(int id) throws SQLException {
    boolean rowDeleted = false;
    
    //TODO: prepare and execute statement to delete a member
    
    return rowDeleted;
  }
  
  public static Member selectMember(int id) {
    Member member = null;
    
    //TODO: prepare and execute query to retrive a member by id
    
    return member;
  }

  
  //This method is used by login() method in MemberServlet
  public static Member selectMember(String name) {
    Member member = null;
    try (
      Connection connection = ConnectionPool.getInstance().getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MEMBER_BY_NAME);) {
      preparedStatement.setString(1, name);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("id");
        String membername = rs.getString("membername");
        String password = rs.getString("password");
        String email = rs.getString("email");
        double basesalary = rs.getDouble("basesalary");
        double bonus = rs.getDouble("bonus");
        String employmentgroup = rs.getString("employmentgroup");
        member = new Member(id, membername, password, email, basesalary, bonus, employmentgroup);
      }
    } catch (SQLException e) {
      printSQLException(e);
    }
    return member;
  }

  public static ArrayList<Member> selectAllMembers() {
    ArrayList<Member> members = new ArrayList<>();
    try (
      Connection connection = ConnectionPool.getInstance().getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MEMBERS);) {
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("id");
        String membername = rs.getString("membername");
        String password = rs.getString("password");
        String email = rs.getString("email");
        double basesalary = rs.getDouble("basesalary");
        double bonus = rs.getDouble("bonus");
        String employmentgroup = rs.getString("employmentgroup");
        members.add(new Member(id, membername, password, email, basesalary, bonus, employmentgroup));
      }
    } catch (SQLException e) {
      printSQLException(e);
    }
    return members;
  }
  
  private static void printSQLException(SQLException ex) {
    for (Throwable e : ex) {
      if (e instanceof SQLException) {
        e.printStackTrace(System.err);
        System.err.println("SQLState: " + ((SQLException) e).getSQLState());
        System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
        System.err.println("Message: " + e.getMessage());
        Throwable t = ex.getCause();
        while (t != null) {
          System.out.println("Cause: " + t);
          t = t.getCause();
        }
      }
    }
  }
}
