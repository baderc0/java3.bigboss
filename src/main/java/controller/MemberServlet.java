package controller;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EmploymentGroup;
import model.EmploymentGroupDAO;
import model.Member;
import model.MemberDAO;

public class MemberServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            login(request, response); //handle login user 
            String action = request.getServletPath();
            switch (action) {
                case "/new": //action from memberlist.jsp, add a new member
                    showNewForm(request, response);
                    break;
                case "/edit": //action from memberlist.jsp, can be edit or delete
                    editMember(request, response);
                    break;
                case "/logout": //action from member.jsp
                    logout(request, response);
                    break;
                case "/insert": //action from member.jsp
                    insertMember(request, response);
                    break;
                case "/update": //action from member.jsp
                    updateMember(request, response);
                    break;
                case "/list": //action from member.jsp on clicking "Cancel"
                case "":
                default:
                    listMember(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void editMember(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        if (request.getParameter("id") == null) {  //when no row is selected
            listMember(request, response);
        } else {
            String button = request.getParameter("button");
            if (button == null) {
                listMember(request, response);
            } else if (button.equals("Edit")) {  //when "Edit" button is clicked
                showEditForm(request, response);
            } else if (button.equals("Delete")) { //when "Delete" button is clicked
                deleteMember(request, response);
            }
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        log("id: " + request.getParameter("id"));

        request.setAttribute("member", MemberDAO.selectMember(Integer.parseInt(request.getParameter("id"))));
        //TODO: show edit form with existing member data
        getServletContext().getRequestDispatcher("/member.jsp").forward(request, response);
    }

    private void insertMember(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        try {
            String membername = request.getParameter("name");
            if (membername.length() < 2) {
                throw new Exception("name too short");
            } else if (membername.length() > 40) {
                throw new Exception("name too long");
            }

            String password = request.getParameter("password");
            if (password.length() < 2) {
                throw new Exception("password too short");
            } else if (password.length() > 20) {
                throw new Exception("password too long");
            }

            String email = request.getParameter("email");
            double basesalary = Double.parseDouble(request.getParameter("basesalary"));
            if (basesalary < 0 || basesalary > 1000000000) {
                throw new Exception("base salary out of range");
            }
            double bonus = Double.parseDouble(request.getParameter("bonus"));
            if (bonus < 0 || bonus > 1000000000) {
                throw new Exception("bonus out of range");
            }
            String group = request.getParameter("employmentgroup");
            Member member = new Member(membername, password, email, basesalary, bonus, group);
            MemberDAO.insertMember(member);

        } catch (Exception e) {
            e.printStackTrace();
        }

        listMember(request, response);
    }

    private void updateMember(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        
        try {
            String membername = request.getParameter("name");
            if (membername.length() < 2) {
                throw new Exception("name too short");
            } else if (membername.length() > 40) {
                throw new Exception("name too long");
            }

            String password = request.getParameter("password");
            if (password.length() < 2) {
                throw new Exception("password too short");
            } else if (password.length() > 20) {
                throw new Exception("password too long");
            }

            String email = request.getParameter("email");
            double basesalary = Double.parseDouble(request.getParameter("basesalary"));
            if (basesalary < 0 || basesalary > 1000000000) {
                throw new Exception("base salary out of range");
            }
            double bonus = Double.parseDouble(request.getParameter("bonus"));
            if (bonus < 0 || bonus > 1000000000) {
                throw new Exception("bonus out of range");
            }
            
            int id = Integer.parseInt(request.getParameter("id"));

            String group = request.getParameter("employmentgroup");
            Member member = new Member(id, membername, password, email, basesalary, bonus, group);
            log(member.toString());
            MemberDAO.updateMember(member);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        listMember(request, response);
    }

    private void deleteMember(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        MemberDAO.deleteMember(Integer.parseInt(request.getParameter("id")));
        //TODO: delete a member
        listMember(request, response);
    }

    private void listMember(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        ArrayList<Member> listMember = MemberDAO.selectAllMembers();
        request.setAttribute("listMember", listMember);
        getServletContext().getRequestDispatcher("/memberlist.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/member.jsp").forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        Member member = (Member) request.getSession().getAttribute("logInMember");
        if (member == null) {
            Principal principal = request.getUserPrincipal();
            String name = principal == null ? "" : principal.getName();
            member = MemberDAO.selectMember(name);
            if (member != null) {
                request.getSession().setAttribute("logInMember", member);
            }
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.getSession().removeAttribute("logInMember");
        request.getSession().invalidate();
        response.sendRedirect("memberlist.jsp");
    }

    @Override
    public void init() throws ServletException {
        ArrayList<EmploymentGroup> employmentgroupList = EmploymentGroupDAO.selectAllEmploymentGroups();
        getServletContext().setAttribute("employmentgroupList", employmentgroupList);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
