package br.com.ifsp.PayNow.pagante;

import br.com.ifsp.PayNow.dao.PaganteDao;
import br.com.ifsp.PayNow.entities.PaganteEntity;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cadastroPagante")
public class PaganteServlet extends HttpServlet {

    PaganteDao paganteDao = new PaganteDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("web/cadastro_pagante.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PaganteEntity paganteEntity = new PaganteEntity();
        paganteEntity.setNome(req.getParameter("name"));
        paganteEntity.setCpf(req.getParameter("cpf"));
        paganteDao.create(paganteEntity);
        RequestDispatcher dispatcher = req.getRequestDispatcher("web/resumo_pagante.jsp");
        req.setAttribute("pagante", paganteEntity);
        dispatcher.forward(req, resp);

    }
}
