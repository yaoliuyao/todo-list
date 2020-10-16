package com.nf163.todo.api;

import com.google.gson.Gson;
import com.nf163.todo.bean.Task;
import com.nf163.todo.dao.TaskDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task/add")
public class TaskAddApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = req.getParameter("body");
        try {
            Task task = new TaskDAO().addTask(new Task(body));
            String json = new Gson().toJson(task);
            resp.getWriter().write(json);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("有异常");
        }
    }
}
