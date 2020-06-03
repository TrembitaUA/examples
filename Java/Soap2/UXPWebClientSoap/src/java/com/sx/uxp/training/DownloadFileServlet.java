/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sx.uxp.training;

import com.sx.uxp.training.stubs.download_file.Documents;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DownloadFileServlet", urlPatterns = {"/DownloadFileServlet"})
public class DownloadFileServlet extends HttpServlet {

    private static final String PARAM_ID = "fileId";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter(PARAM_ID);

        Documents doc = UxpTrainingMtomDataService.downloadFile(Integer.valueOf(id));

        String fileName = doc.getFileName();

        response.setHeader("Content-disposition", "attachment; filename=" + fileName);

        try (OutputStream out = response.getOutputStream()) {
            out.write(doc.getData());
        }
    }

}
