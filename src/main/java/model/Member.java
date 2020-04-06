package model;

import java.io.Serializable;

public class Member implements Serializable {
  private int id;
  private String membername;
  private String password;
  private String email;
  private double basesalary;
  private double bonus;
  private String employmentgroup;

  public Member() {
  }

  public Member(int id, String membername, String password, String email, double basesalary, double bonus, String employmentgroup) {
    this.id = id;
    this.membername = membername;
    this.password = password;
    this.email = email;
    this.basesalary = basesalary;
    this.bonus = bonus;
    this.employmentgroup = employmentgroup;
  }
  
  public Member(String membername, String password, String email, double basesalary, double bonus, String employmentgroup) {
    this.membername = membername;
    this.password = password;
    this.email = email;
    this.basesalary = basesalary;
    this.bonus = bonus;
    this.employmentgroup = employmentgroup;
  }

  public int getId() {
    return id;
  }

  public String getMembername() {
    return membername;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  public double getBasesalary() {
    return basesalary;
  }

  public double getBonus() {
    return bonus;
  }

  public String getEmploymentgroup() {
    return employmentgroup;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setMembername(String membername) {
    this.membername = membername;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setBasesalary(double basesalary) {
    this.basesalary = basesalary;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }

  public void setEmploymentgroup(String employmentgroup) {
    this.employmentgroup = employmentgroup;
  }

  @Override
  public String toString() {
    return "Member{" + "id=" + id + ", membername=" + membername + ", password=" + password + ", email=" + email + ", basesalary=" + basesalary + ", bonus=" + bonus + ", employmentgroup=" + employmentgroup + '}';
  }
  
  
}
