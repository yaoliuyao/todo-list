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
import java.util.List;

@WebServlet("/task/list")
public class TaskListApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Task> tasks = new TaskDAO().getAllTasks();
            String json = new Gson().toJson(tasks);
            resp.getWriter().write(json);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("出错了");
        }
    }
}
