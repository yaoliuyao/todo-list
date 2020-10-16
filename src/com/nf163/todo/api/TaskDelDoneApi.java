package com.nf163.todo.api;


import com.nf163.todo.dao.TaskDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task/delDone")
public class TaskDelDoneApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            new TaskDAO().deleteDone(id);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("删除出错");
        }
    }
}
