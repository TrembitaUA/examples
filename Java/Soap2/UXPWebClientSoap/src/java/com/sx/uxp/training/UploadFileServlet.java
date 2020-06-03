/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sx.uxp.training;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author Koshman
 */
@WebServlet(name = "UploadFileServlet", urlPatterns = {"/UploadFileServlet"})
@MultipartConfig
public class UploadFileServlet extends HttpServlet {

    private static final String PARAM_CLIENT_ID = "clientId";
    private static final String PARAM_DATA = "data";

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
        // Create path components to save the file
        final Part filePart = request.getPart(PARAM_DATA);
        String clientIddStr = request.getParameter(PARAM_CLIENT_ID);
        try (InputStream filecontent = filePart.getInputStream()) {
            final byte[] bytes = new byte[filecontent.available()];
            String fileName = getFileName(filePart);
            IOUtils.readFully(filecontent, bytes);
            UxpTrainingMtomDataService.uploadFile(Integer.valueOf(clientIddStr), bytes,fileName);
        } catch (FileNotFoundException fne) {
            System.err.println(fne);
        }
        response.sendRedirect("index.jsp");
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                String fullName = content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
                return fullName.substring(fullName.lastIndexOf("\\")+1);
            }
        }
        return null;
    }
}
