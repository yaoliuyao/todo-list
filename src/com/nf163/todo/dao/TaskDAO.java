package com.nf163.todo.dao;

import com.nf163.todo.bean.Task;
import com.nf163.todo.utils.DBHelper;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

public class TaskDAO {

    /**
     * 获取所有任务
     *
     * @return 所有的 tasks，用来显示在页面
     * @throws Exception 所有异常
     */
    public List<Task> getAllTasks() throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select id, body, state, created from task where state in (1, 2) order by id";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<Task>(Task.class));
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 添加任务
     *
     * @param task 要插入的任务
     * @return 带 Id 的任务
     */
    public Task addTask(Task task) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into task (body, state) values (?, 1)";
        try {
            QueryRunner run = new QueryRunner();
            BigDecimal res = run.insert(conn, sql, new ScalarHandler<BigDecimal>(), task.getBody());
            task.setId(res.longValue());
            return task;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    public void archiveTask(String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update task set state = 2 where id = ? and state = 1";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void deleteTodo(String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update task set state = 8 where id = ? and state = 1";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void deleteDone(String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update task set state = 9 where id = ? and state = 2";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public static void main(String[] args) throws Exception {
        final TaskDAO taskDAO = new TaskDAO();
        taskDAO.deleteTodo("2");
    }
}
