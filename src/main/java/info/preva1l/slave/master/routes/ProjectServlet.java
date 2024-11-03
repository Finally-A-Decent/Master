package info.preva1l.slave.master.routes;

import info.preva1l.slave.master.models.projects.Project;
import info.preva1l.slave.master.registries.Projects;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Project", urlPatterns = "/projects/*")
public class ProjectServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String projectShortId = request.getPathInfo().split("/")[1];
        Project project = Projects.get(projectShortId);

        request.setAttribute("projectShortId", projectShortId);
        request.setAttribute("project", project);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/project.jsp");
        dispatcher.include(request, response);
    }
}
