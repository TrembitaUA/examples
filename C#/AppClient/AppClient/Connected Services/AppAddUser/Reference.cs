﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Этот код создан программой.
//     Исполняемая версия:4.0.30319.42000
//
//     Изменения в этом файле могут привести к неправильной работе и будут потеряны в случае
//     повторной генерации кода.
// </auto-generated>
//------------------------------------------------------------------------------

namespace AppClient.AppAddUser {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="AppAddUser.IAppService")]
    public interface IAppService {
        
        // CODEGEN: Контракт генерации сообщений с сообщением AddUserRequest имеет заголовки.
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IAppService/AddUser", ReplyAction="http://tempuri.org/IAppService/AddUserResponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [System.ServiceModel.ServiceKnownTypeAttribute(typeof(XRoadIdentifierType))]
        AppClient.AppAddUser.AddUserResponse AddUser(AppClient.AppAddUser.AddUserRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IAppService/AddUser", ReplyAction="http://tempuri.org/IAppService/AddUserResponse")]
        System.Threading.Tasks.Task<AppClient.AppAddUser.AddUserResponse> AddUserAsync(AppClient.AppAddUser.AddUserRequest request);
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.8.3752.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://x-road.eu/xsd/identifiers")]
    public partial class XRoadServiceIdentifierType : XRoadIdentifierType {
    }
    
    /// <remarks/>
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(XRoadServiceIdentifierType))]
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(XRoadClientIdentifierType))]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.8.3752.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://x-road.eu/xsd/identifiers")]
    public partial class XRoadIdentifierType : object, System.ComponentModel.INotifyPropertyChanged {
        
        private string xRoadInstanceField;
        
        private string memberClassField;
        
        private string memberCodeField;
        
        private string subsystemCodeField;
        
        private string serviceCodeField;
        
        private string serviceVersionField;
        
        private XRoadObjectType objectTypeField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Order=0)]
        public string xRoadInstance {
            get {
                return this.xRoadInstanceField;
            }
            set {
                this.xRoadInstanceField = value;
                this.RaisePropertyChanged("xRoadInstance");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Order=1)]
        public string memberClass {
            get {
                return this.memberClassField;
            }
            set {
                this.memberClassField = value;
                this.RaisePropertyChanged("memberClass");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Order=2)]
        public string memberCode {
            get {
                return this.memberCodeField;
            }
            set {
                this.memberCodeField = value;
                this.RaisePropertyChanged("memberCode");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Order=3)]
        public string subsystemCode {
            get {
                return this.subsystemCodeField;
            }
            set {
                this.subsystemCodeField = value;
                this.RaisePropertyChanged("subsystemCode");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Order=4)]
        public string serviceCode {
            get {
                return this.serviceCodeField;
            }
            set {
                this.serviceCodeField = value;
                this.RaisePropertyChanged("serviceCode");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Order=5)]
        public string serviceVersion {
            get {
                return this.serviceVersionField;
            }
            set {
                this.serviceVersionField = value;
                this.RaisePropertyChanged("serviceVersion");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Form=System.Xml.Schema.XmlSchemaForm.Qualified)]
        public XRoadObjectType objectType {
            get {
                return this.objectTypeField;
            }
            set {
                this.objectTypeField = value;
                this.RaisePropertyChanged("objectType");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.8.3752.0")]
    [System.SerializableAttribute()]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://x-road.eu/xsd/identifiers")]
    public enum XRoadObjectType {
        
        /// <remarks/>
        MEMBER,
        
        /// <remarks/>
        SUBSYSTEM,
        
        /// <remarks/>
        SERVICE,
        
        /// <remarks/>
        CENTRALSERVICE,
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.8.3752.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://schemas.datacontract.org/2004/07/AppService")]
    public partial class AppUser : object, System.ComponentModel.INotifyPropertyChanged {
        
        private string addressField;
        
        private System.Nullable<System.DateTime> birthdateField;
        
        private bool birthdateFieldSpecified;
        
        private string firstnameField;
        
        private string innField;
        
        private string passport_numField;
        
        private string passport_serField;
        
        private string patronymicField;
        
        private string surnameField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(IsNullable=true, Order=0)]
        public string Address {
            get {
                return this.addressField;
            }
            set {
                this.addressField = value;
                this.RaisePropertyChanged("Address");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(IsNullable=true, Order=1)]
        public System.Nullable<System.DateTime> Birthdate {
            get {
                return this.birthdateField;
            }
            set {
                this.birthdateField = value;
                this.RaisePropertyChanged("Birthdate");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool BirthdateSpecified {
            get {
                return this.birthdateFieldSpecified;
            }
            set {
                this.birthdateFieldSpecified = value;
                this.RaisePropertyChanged("BirthdateSpecified");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(IsNullable=true, Order=2)]
        public string Firstname {
            get {
                return this.firstnameField;
            }
            set {
                this.firstnameField = value;
                this.RaisePropertyChanged("Firstname");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(IsNullable=true, Order=3)]
        public string Inn {
            get {
                return this.innField;
            }
            set {
                this.innField = value;
                this.RaisePropertyChanged("Inn");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(IsNullable=true, Order=4)]
        public string Passport_num {
            get {
                return this.passport_numField;
            }
            set {
                this.passport_numField = value;
                this.RaisePropertyChanged("Passport_num");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(IsNullable=true, Order=5)]
        public string Passport_ser {
            get {
                return this.passport_serField;
            }
            set {
                this.passport_serField = value;
                this.RaisePropertyChanged("Passport_ser");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(IsNullable=true, Order=6)]
        public string Patronymic {
            get {
                return this.patronymicField;
            }
            set {
                this.patronymicField = value;
                this.RaisePropertyChanged("Patronymic");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(IsNullable=true, Order=7)]
        public string Surname {
            get {
                return this.surnameField;
            }
            set {
                this.surnameField = value;
                this.RaisePropertyChanged("Surname");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.8.3752.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://x-road.eu/xsd/identifiers")]
    public partial class XRoadClientIdentifierType : XRoadIdentifierType {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="AddUser", WrapperNamespace="http://tempuri.org/", IsWrapped=true)]
    public partial class AddUserRequest {
        
        [System.ServiceModel.MessageHeaderAttribute(Namespace="http://x-road.eu/xsd/xroad.xsd")]
        public string protocolVersion;
        
        [System.ServiceModel.MessageHeaderAttribute(Namespace="http://x-road.eu/xsd/xroad.xsd")]
        public string id;
        
        [System.ServiceModel.MessageHeaderAttribute(Namespace="http://x-road.eu/xsd/xroad.xsd")]
        public string userId;
        
        [System.ServiceModel.MessageHeaderAttribute(Namespace="http://x-road.eu/xsd/xroad.xsd")]
        public AppClient.AppAddUser.XRoadServiceIdentifierType service;
        
        [System.ServiceModel.MessageHeaderAttribute(Namespace="http://x-road.eu/xsd/xroad.xsd")]
        public AppClient.AppAddUser.XRoadClientIdentifierType client;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://tempuri.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(IsNullable=true)]
        public AppClient.AppAddUser.AppUser User;
        
        public AddUserRequest() {
        }
        
        public AddUserRequest(string protocolVersion, string id, string userId, AppClient.AppAddUser.XRoadServiceIdentifierType service, AppClient.AppAddUser.XRoadClientIdentifierType client, AppClient.AppAddUser.AppUser User) {
            this.protocolVersion = protocolVersion;
            this.id = id;
            this.userId = userId;
            this.service = service;
            this.client = client;
            this.User = User;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="AddUserResponse", WrapperNamespace="http://tempuri.org/", IsWrapped=true)]
    public partial class AddUserResponse {
        
        [System.ServiceModel.MessageHeaderAttribute(Namespace="http://x-road.eu/xsd/xroad.xsd")]
        public string protocolVersion;
        
        [System.ServiceModel.MessageHeaderAttribute(Namespace="http://x-road.eu/xsd/xroad.xsd")]
        public string id;
        
        [System.ServiceModel.MessageHeaderAttribute(Namespace="http://x-road.eu/xsd/xroad.xsd")]
        public string userId;
        
        [System.ServiceModel.MessageHeaderAttribute(Namespace="http://x-road.eu/xsd/xroad.xsd")]
        public AppClient.AppAddUser.XRoadServiceIdentifierType service;
        
        [System.ServiceModel.MessageHeaderAttribute(Namespace="http://x-road.eu/xsd/xroad.xsd")]
        public AppClient.AppAddUser.XRoadClientIdentifierType client;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://tempuri.org/", Order=0)]
        public bool AddUserResult;
        
        public AddUserResponse() {
        }
        
        public AddUserResponse(string protocolVersion, string id, string userId, AppClient.AppAddUser.XRoadServiceIdentifierType service, AppClient.AppAddUser.XRoadClientIdentifierType client, bool AddUserResult) {
            this.protocolVersion = protocolVersion;
            this.id = id;
            this.userId = userId;
            this.service = service;
            this.client = client;
            this.AddUserResult = AddUserResult;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface IAppServiceChannel : AppClient.AppAddUser.IAppService, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class AppServiceClient : System.ServiceModel.ClientBase<AppClient.AppAddUser.IAppService>, AppClient.AppAddUser.IAppService {
        
        public AppServiceClient() {
        }
        
        public AppServiceClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public AppServiceClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public AppServiceClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public AppServiceClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        AppClient.AppAddUser.AddUserResponse AppClient.AppAddUser.IAppService.AddUser(AppClient.AppAddUser.AddUserRequest request) {
            return base.Channel.AddUser(request);
        }
        
        public bool AddUser(ref string protocolVersion, ref string id, ref string userId, ref AppClient.AppAddUser.XRoadServiceIdentifierType service, ref AppClient.AppAddUser.XRoadClientIdentifierType client, AppClient.AppAddUser.AppUser User) {
            AppClient.AppAddUser.AddUserRequest inValue = new AppClient.AppAddUser.AddUserRequest();
            inValue.protocolVersion = protocolVersion;
            inValue.id = id;
            inValue.userId = userId;
            inValue.service = service;
            inValue.client = client;
            inValue.User = User;
            AppClient.AppAddUser.AddUserResponse retVal = ((AppClient.AppAddUser.IAppService)(this)).AddUser(inValue);
            protocolVersion = retVal.protocolVersion;
            id = retVal.id;
            userId = retVal.userId;
            service = retVal.service;
            client = retVal.client;
            return retVal.AddUserResult;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<AppClient.AppAddUser.AddUserResponse> AppClient.AppAddUser.IAppService.AddUserAsync(AppClient.AppAddUser.AddUserRequest request) {
            return base.Channel.AddUserAsync(request);
        }
        
        public System.Threading.Tasks.Task<AppClient.AppAddUser.AddUserResponse> AddUserAsync(string protocolVersion, string id, string userId, AppClient.AppAddUser.XRoadServiceIdentifierType service, AppClient.AppAddUser.XRoadClientIdentifierType client, AppClient.AppAddUser.AppUser User) {
            AppClient.AppAddUser.AddUserRequest inValue = new AppClient.AppAddUser.AddUserRequest();
            inValue.protocolVersion = protocolVersion;
            inValue.id = id;
            inValue.userId = userId;
            inValue.service = service;
            inValue.client = client;
            inValue.User = User;
            return ((AppClient.AppAddUser.IAppService)(this)).AddUserAsync(inValue);
        }
    }
}
