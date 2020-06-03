/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sx.uxp.training.ws;

import com.sx.uxp.training.DocumentsJpaController;
import com.sx.uxp.training.PeopleJpaController;
import com.sx.uxp.training.dao.Documents;
import com.sx.uxp.training.dao.People;
import com.sx.uxp.training.exceptions.NonexistentEntityException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Koshman
 */
@WebService(serviceName = "UXPTraining")
public class UXPTraining {

    @WebMethod(operationName = "listPagedData")
    public List<People> listData(@WebParam(name = "fromIndex") int fromIndex, @WebParam(name = "rowsCount") int rowsCount) {
        return PeopleJpaController.getInstance().findPeopleEntities(rowsCount, fromIndex);
    }

    @WebMethod(operationName = "listAllData")
    public List<People> listAllData() {
        return PeopleJpaController.getInstance().findPeopleEntities();
    }

    @WebMethod(operationName = "findDataByInn")
    public List<People> findDataByInn(@WebParam(name = "inn") String inn) {
        return PeopleJpaController.getInstance().findPeopleByInn(inn);
    }

    @WebMethod(operationName = "create")
    public void createData(@WebParam(name = "data") People uxpJavaTraining) {
        PeopleJpaController.getInstance().create(uxpJavaTraining);
    }

    @WebMethod(operationName = "destroy")
    public void destroy(@WebParam(name = "destroyId") Integer destroyId) {
        try {
            PeopleJpaController.getInstance().destroy(destroyId);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(UXPTraining.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "downloadFile")
    public Documents downloadFile(@WebParam(name = "fileId") Integer fileId) {
        try {
            return DocumentsJpaController.getInstance().findDocuments(fileId);
        } catch (Exception e) {
            Logger.getLogger(UXPTraining.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @WebMethod(operationName = "uploadFile")
    public void uploadFile(@WebParam(name = "clientId") Integer clientId, @WebParam(name = "data") byte[] data, @WebParam(name = "fileName") String fileName) {
        try {
            People client = PeopleJpaController.getInstance().findPeople(clientId);
            Documents doc = new Documents();
            doc.setData(data);
            doc.setFileName(fileName);
            doc.setPId(client);
            DocumentsJpaController.getInstance().create(doc);
        } catch (Exception e) {
            Logger.getLogger(UXPTraining.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
