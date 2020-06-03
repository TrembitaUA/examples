
package com.sx.uxp.training.stubs.list_all_data;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sx.uxp.training.stubs.list_all_data package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _People_QNAME = new QName("http://ws.training.uxp.sx.com/", "people");
    private final static QName _ServiceVersion_QNAME = new QName("http://x-road.eu/xsd/identifiers", "serviceVersion");
    private final static QName _FindDataByInnResponse_QNAME = new QName("http://ws.training.uxp.sx.com/", "findDataByInnResponse");
    private final static QName _Id_QNAME = new QName("http://x-road.eu/xsd/xroad.xsd", "id");
    private final static QName _CreateResponse_QNAME = new QName("http://ws.training.uxp.sx.com/", "createResponse");
    private final static QName _Destroy_QNAME = new QName("http://ws.training.uxp.sx.com/", "destroy");
    private final static QName _ProtocolVersion_QNAME = new QName("http://x-road.eu/xsd/xroad.xsd", "protocolVersion");
    private final static QName _Client_QNAME = new QName("http://x-road.eu/xsd/xroad.xsd", "client");
    private final static QName _XRoadInstance_QNAME = new QName("http://x-road.eu/xsd/identifiers", "xRoadInstance");
    private final static QName _UploadFile_QNAME = new QName("http://ws.training.uxp.sx.com/", "uploadFile");
    private final static QName _SubsystemCode_QNAME = new QName("http://x-road.eu/xsd/identifiers", "subsystemCode");
    private final static QName _ServiceCode_QNAME = new QName("http://x-road.eu/xsd/identifiers", "serviceCode");
    private final static QName _ListPagedData_QNAME = new QName("http://ws.training.uxp.sx.com/", "listPagedData");
    private final static QName _FindDataByInn_QNAME = new QName("http://ws.training.uxp.sx.com/", "findDataByInn");
    private final static QName _DestroyResponse_QNAME = new QName("http://ws.training.uxp.sx.com/", "destroyResponse");
    private final static QName _UploadFileResponse_QNAME = new QName("http://ws.training.uxp.sx.com/", "uploadFileResponse");
    private final static QName _DownloadFile_QNAME = new QName("http://ws.training.uxp.sx.com/", "downloadFile");
    private final static QName _MemberClass_QNAME = new QName("http://x-road.eu/xsd/identifiers", "memberClass");
    private final static QName _DownloadFileResponse_QNAME = new QName("http://ws.training.uxp.sx.com/", "downloadFileResponse");
    private final static QName _Documents_QNAME = new QName("http://ws.training.uxp.sx.com/", "documents");
    private final static QName _Service_QNAME = new QName("http://x-road.eu/xsd/xroad.xsd", "service");
    private final static QName _ListAllDataResponse_QNAME = new QName("http://ws.training.uxp.sx.com/", "listAllDataResponse");
    private final static QName _MemberCode_QNAME = new QName("http://x-road.eu/xsd/identifiers", "memberCode");
    private final static QName _Version_QNAME = new QName("http://x-road.eu/xsd/xroad.xsd", "version");
    private final static QName _UserId_QNAME = new QName("http://x-road.eu/xsd/xroad.xsd", "userId");
    private final static QName _ListAllData_QNAME = new QName("http://ws.training.uxp.sx.com/", "listAllData");
    private final static QName _ListPagedDataResponse_QNAME = new QName("http://ws.training.uxp.sx.com/", "listPagedDataResponse");
    private final static QName _Create_QNAME = new QName("http://ws.training.uxp.sx.com/", "create");
    private final static QName _UploadFileData_QNAME = new QName("", "data");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sx.uxp.training.stubs.list_all_data
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Notes }
     * 
     */
    public Notes createNotes() {
        return new Notes();
    }

    /**
     * Create an instance of {@link XRoadServiceIdentifierType }
     * 
     */
    public XRoadServiceIdentifierType createXRoadServiceIdentifierType() {
        return new XRoadServiceIdentifierType();
    }

    /**
     * Create an instance of {@link XRoadClientIdentifierType }
     * 
     */
    public XRoadClientIdentifierType createXRoadClientIdentifierType() {
        return new XRoadClientIdentifierType();
    }

    /**
     * Create an instance of {@link Title }
     * 
     */
    public Title createTitle() {
        return new Title();
    }

    /**
     * Create an instance of {@link XRoadIdentifierType }
     * 
     */
    public XRoadIdentifierType createXRoadIdentifierType() {
        return new XRoadIdentifierType();
    }

    /**
     * Create an instance of {@link UploadFile }
     * 
     */
    public UploadFile createUploadFile() {
        return new UploadFile();
    }

    /**
     * Create an instance of {@link ListAllDataResponse }
     * 
     */
    public ListAllDataResponse createListAllDataResponse() {
        return new ListAllDataResponse();
    }

    /**
     * Create an instance of {@link Documents }
     * 
     */
    public Documents createDocuments() {
        return new Documents();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link Destroy }
     * 
     */
    public Destroy createDestroy() {
        return new Destroy();
    }

    /**
     * Create an instance of {@link FindDataByInnResponse }
     * 
     */
    public FindDataByInnResponse createFindDataByInnResponse() {
        return new FindDataByInnResponse();
    }

    /**
     * Create an instance of {@link People }
     * 
     */
    public People createPeople() {
        return new People();
    }

    /**
     * Create an instance of {@link DownloadFile }
     * 
     */
    public DownloadFile createDownloadFile() {
        return new DownloadFile();
    }

    /**
     * Create an instance of {@link DestroyResponse }
     * 
     */
    public DestroyResponse createDestroyResponse() {
        return new DestroyResponse();
    }

    /**
     * Create an instance of {@link UploadFileResponse }
     * 
     */
    public UploadFileResponse createUploadFileResponse() {
        return new UploadFileResponse();
    }

    /**
     * Create an instance of {@link DownloadFileResponse }
     * 
     */
    public DownloadFileResponse createDownloadFileResponse() {
        return new DownloadFileResponse();
    }

    /**
     * Create an instance of {@link FindDataByInn }
     * 
     */
    public FindDataByInn createFindDataByInn() {
        return new FindDataByInn();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link ListPagedData }
     * 
     */
    public ListPagedData createListPagedData() {
        return new ListPagedData();
    }

    /**
     * Create an instance of {@link ListAllData }
     * 
     */
    public ListAllData createListAllData() {
        return new ListAllData();
    }

    /**
     * Create an instance of {@link ListPagedDataResponse }
     * 
     */
    public ListPagedDataResponse createListPagedDataResponse() {
        return new ListPagedDataResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link People }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "people")
    public JAXBElement<People> createPeople(People value) {
        return new JAXBElement<People>(_People_QNAME, People.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/identifiers", name = "serviceVersion")
    public JAXBElement<String> createServiceVersion(String value) {
        return new JAXBElement<String>(_ServiceVersion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindDataByInnResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "findDataByInnResponse")
    public JAXBElement<FindDataByInnResponse> createFindDataByInnResponse(FindDataByInnResponse value) {
        return new JAXBElement<FindDataByInnResponse>(_FindDataByInnResponse_QNAME, FindDataByInnResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/xroad.xsd", name = "id")
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "createResponse")
    public JAXBElement<CreateResponse> createCreateResponse(CreateResponse value) {
        return new JAXBElement<CreateResponse>(_CreateResponse_QNAME, CreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Destroy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "destroy")
    public JAXBElement<Destroy> createDestroy(Destroy value) {
        return new JAXBElement<Destroy>(_Destroy_QNAME, Destroy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/xroad.xsd", name = "protocolVersion")
    public JAXBElement<String> createProtocolVersion(String value) {
        return new JAXBElement<String>(_ProtocolVersion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XRoadClientIdentifierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/xroad.xsd", name = "client")
    public JAXBElement<XRoadClientIdentifierType> createClient(XRoadClientIdentifierType value) {
        return new JAXBElement<XRoadClientIdentifierType>(_Client_QNAME, XRoadClientIdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/identifiers", name = "xRoadInstance")
    public JAXBElement<String> createXRoadInstance(String value) {
        return new JAXBElement<String>(_XRoadInstance_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "uploadFile")
    public JAXBElement<UploadFile> createUploadFile(UploadFile value) {
        return new JAXBElement<UploadFile>(_UploadFile_QNAME, UploadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/identifiers", name = "subsystemCode")
    public JAXBElement<String> createSubsystemCode(String value) {
        return new JAXBElement<String>(_SubsystemCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/identifiers", name = "serviceCode")
    public JAXBElement<String> createServiceCode(String value) {
        return new JAXBElement<String>(_ServiceCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPagedData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "listPagedData")
    public JAXBElement<ListPagedData> createListPagedData(ListPagedData value) {
        return new JAXBElement<ListPagedData>(_ListPagedData_QNAME, ListPagedData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindDataByInn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "findDataByInn")
    public JAXBElement<FindDataByInn> createFindDataByInn(FindDataByInn value) {
        return new JAXBElement<FindDataByInn>(_FindDataByInn_QNAME, FindDataByInn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DestroyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "destroyResponse")
    public JAXBElement<DestroyResponse> createDestroyResponse(DestroyResponse value) {
        return new JAXBElement<DestroyResponse>(_DestroyResponse_QNAME, DestroyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "uploadFileResponse")
    public JAXBElement<UploadFileResponse> createUploadFileResponse(UploadFileResponse value) {
        return new JAXBElement<UploadFileResponse>(_UploadFileResponse_QNAME, UploadFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "downloadFile")
    public JAXBElement<DownloadFile> createDownloadFile(DownloadFile value) {
        return new JAXBElement<DownloadFile>(_DownloadFile_QNAME, DownloadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/identifiers", name = "memberClass")
    public JAXBElement<String> createMemberClass(String value) {
        return new JAXBElement<String>(_MemberClass_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "downloadFileResponse")
    public JAXBElement<DownloadFileResponse> createDownloadFileResponse(DownloadFileResponse value) {
        return new JAXBElement<DownloadFileResponse>(_DownloadFileResponse_QNAME, DownloadFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Documents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "documents")
    public JAXBElement<Documents> createDocuments(Documents value) {
        return new JAXBElement<Documents>(_Documents_QNAME, Documents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XRoadServiceIdentifierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/xroad.xsd", name = "service")
    public JAXBElement<XRoadServiceIdentifierType> createService(XRoadServiceIdentifierType value) {
        return new JAXBElement<XRoadServiceIdentifierType>(_Service_QNAME, XRoadServiceIdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "listAllDataResponse")
    public JAXBElement<ListAllDataResponse> createListAllDataResponse(ListAllDataResponse value) {
        return new JAXBElement<ListAllDataResponse>(_ListAllDataResponse_QNAME, ListAllDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/identifiers", name = "memberCode")
    public JAXBElement<String> createMemberCode(String value) {
        return new JAXBElement<String>(_MemberCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/xroad.xsd", name = "version")
    public JAXBElement<String> createVersion(String value) {
        return new JAXBElement<String>(_Version_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://x-road.eu/xsd/xroad.xsd", name = "userId")
    public JAXBElement<String> createUserId(String value) {
        return new JAXBElement<String>(_UserId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "listAllData")
    public JAXBElement<ListAllData> createListAllData(ListAllData value) {
        return new JAXBElement<ListAllData>(_ListAllData_QNAME, ListAllData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListPagedDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "listPagedDataResponse")
    public JAXBElement<ListPagedDataResponse> createListPagedDataResponse(ListPagedDataResponse value) {
        return new JAXBElement<ListPagedDataResponse>(_ListPagedDataResponse_QNAME, ListPagedDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.training.uxp.sx.com/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "data", scope = UploadFile.class)
    public JAXBElement<byte[]> createUploadFileData(byte[] value) {
        return new JAXBElement<byte[]>(_UploadFileData_QNAME, byte[].class, UploadFile.class, ((byte[]) value));
    }

}
