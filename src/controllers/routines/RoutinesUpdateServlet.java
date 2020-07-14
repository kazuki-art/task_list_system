package controllers.routines;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Routine;
import models.validators.RoutineValidator;
import utils.DBUtil;

/**
 * Servlet implementation class RoutinesUpdateServlet
 */
@WebServlet("/routines/update")
public class RoutinesUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoutinesUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Routine r = em.find(Routine.class, (Integer)(request.getSession().getAttribute("routine_id")));

            r.setRoutine_date(request.getParameter("routine_date"));
            r.setTime_kubun(request.getParameter("time_kubun"));
            r.setTitle(request.getParameter("title"));
            r.setContent(request.getParameter("content"));


            List<String> errors = RoutineValidator.validate(r);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("report", r);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/routines/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");

                request.getSession().removeAttribute("routine_id");

                response.sendRedirect(request.getContextPath() + "/routines/index");
            }
        }
    }

}
