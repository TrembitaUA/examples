package com.sx.uxp.training;

import com.sun.xml.ws.api.message.Header;
import com.sun.xml.ws.api.message.Headers;
import com.sun.xml.ws.developer.WSBindingProvider;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import com.sx.uxp.training.stubs.find_data_by_inn.ObjectFactory;
import com.sx.uxp.training.stubs.find_data_by_inn.XRoadClientIdentifierType;
import com.sx.uxp.training.stubs.find_data_by_inn.XRoadObjectType;
import com.sx.uxp.training.stubs.find_data_by_inn.XRoadServiceIdentifierType;
import javax.xml.ws.soap.SOAPBinding;

public class HeaderUtil {

    public static void addHeaders(WSBindingProvider bindingProvider) {
        ObjectFactory xRoadObjectFactory = new ObjectFactory();

        XRoadClientIdentifierType client = new XRoadClientIdentifierType();
        client.setObjectType(XRoadObjectType.SUBSYSTEM);
        client.setXRoadInstance(Config.getInstance().getRoadInstance());
        client.setMemberClass("GOV");
        client.setMemberCode(Config.getInstance().getMember());
        client.setSubsystemCode("SUB1");

        XRoadServiceIdentifierType xRoadService = new XRoadServiceIdentifierType();
        xRoadService.setObjectType(XRoadObjectType.SERVICE);
        xRoadService.setXRoadInstance(Config.getInstance().getRoadInstance());
        xRoadService.setMemberClass("GOV");
        xRoadService.setMemberCode(Config.getInstance().getMember());
        xRoadService.setSubsystemCode("SUB1");
        xRoadService.setServiceCode("listAllData");

        List<Header> headers = new ArrayList<>();
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(xRoadObjectFactory.getClass());
            headers.add(Headers.create(jAXBContext, xRoadObjectFactory.createClient(client)));
            headers.add(Headers.create(jAXBContext, xRoadObjectFactory.createService(xRoadService)));
            headers.add(Headers.create(jAXBContext, xRoadObjectFactory.createUserId("1")));
            headers.add(Headers.create(jAXBContext, xRoadObjectFactory.createId("1")));
            headers.add(Headers.create(jAXBContext, xRoadObjectFactory.createProtocolVersion("4.0")));
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

        bindingProvider.setOutboundHeaders(headers);
    }

    public static void enableMTOM(WSBindingProvider bindingProvider) {
        SOAPBinding binding = (SOAPBinding) bindingProvider.getBinding();
        binding.setMTOMEnabled(true);
    }

}
