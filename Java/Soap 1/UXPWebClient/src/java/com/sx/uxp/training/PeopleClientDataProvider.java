package com.sx.uxp.training;

import com.sun.xml.ws.developer.WSBindingProvider;
import java.util.List;

public class PeopleClientDataProvider {

    public List<com.sx.uxp.training.stubs.list_all_data.People> listAllData() {
        com.sx.uxp.training.stubs.list_all_data.UXPTraining_Service service = new com.sx.uxp.training.stubs.list_all_data.UXPTraining_Service();
        com.sx.uxp.training.stubs.list_all_data.UXPTraining training = service.getUXPTrainingPort();
        HeaderUtil.addHeaders((WSBindingProvider) training);
        return training.listAllData();
    }

    public List<com.sx.uxp.training.stubs.find_data_by_inn.People> findDataByInn(String inn) {
        com.sx.uxp.training.stubs.find_data_by_inn.UXPTraining_Service service = new com.sx.uxp.training.stubs.find_data_by_inn.UXPTraining_Service();
        com.sx.uxp.training.stubs.find_data_by_inn.UXPTraining training = service.getUXPTrainingPort();
        HeaderUtil.addHeaders((WSBindingProvider) training);
        return training.findDataByInn(inn);
    }

}
