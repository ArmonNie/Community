package webservice;

public class CommunityServiceProxy implements webservice.CommunityService {
  private String _endpoint = null;
  private webservice.CommunityService communityService = null;
  
  public CommunityServiceProxy() {
    _initCommunityServiceProxy();
  }
  
  public CommunityServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCommunityServiceProxy();
  }
  
  private void _initCommunityServiceProxy() {
    try {
      communityService = (new webservice.CommunityServiceServiceLocator()).getCommunityService();
      if (communityService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)communityService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)communityService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (communityService != null)
      ((javax.xml.rpc.Stub)communityService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webservice.CommunityService getCommunityService() {
    if (communityService == null)
      _initCommunityServiceProxy();
    return communityService;
  }
  
  public java.lang.String say() throws java.rmi.RemoteException{
    if (communityService == null)
      _initCommunityServiceProxy();
    return communityService.say();
  }
  
  
}