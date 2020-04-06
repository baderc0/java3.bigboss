package model;

import java.io.Serializable;

public class EmploymentGroup  implements Serializable{
  private String groupid;
  private String groupname;

  public EmploymentGroup() {
  }

  public EmploymentGroup(String groupid, String groupname) {
    this.groupid = groupid;
    this.groupname = groupname;
  }

  public String getGroupid() {
    return groupid;
  }

  public String getGroupname() {
    return groupname;
  }

  public void setGroupid(String groupid) {
    this.groupid = groupid;
  }

  public void setGroupname(String groupname) {
    this.groupname = groupname;
  }
  
}
