/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sx.uxp.training;

import com.sun.xml.ws.developer.WSBindingProvider;

/**
 *
 * @author Koshman
 */
public class UxpTrainingMtomDataService {

    public static void uploadFile(int clientId, byte[] data, String fileName) {
        com.sx.uxp.training.stubs.upload_file.UXPTraining_Service service = new com.sx.uxp.training.stubs.upload_file.UXPTraining_Service();
        com.sx.uxp.training.stubs.upload_file.UXPTraining port = service.getUXPTrainingPort();
        HeaderUtil.addHeaders((WSBindingProvider) port);
        HeaderUtil.enableMTOM((WSBindingProvider) port);
        port.uploadFile(clientId, data,fileName);
    }

    public static com.sx.uxp.training.stubs.download_file.Documents downloadFile(int id) {
        com.sx.uxp.training.stubs.download_file.UXPTraining_Service service = new com.sx.uxp.training.stubs.download_file.UXPTraining_Service();
        com.sx.uxp.training.stubs.download_file.UXPTraining port = service.getUXPTrainingPort();
        HeaderUtil.addHeaders((WSBindingProvider) port);
        HeaderUtil.enableMTOM((WSBindingProvider) port);
        return port.downloadFile(id);
    }
}
