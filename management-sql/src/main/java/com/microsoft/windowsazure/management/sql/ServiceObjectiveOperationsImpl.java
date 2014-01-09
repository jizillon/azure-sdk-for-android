/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.sql;

import com.microsoft.windowsazure.core.ServiceOperations;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.sql.models.ServiceObjectiveGetResponse;
import com.microsoft.windowsazure.management.sql.models.ServiceObjectiveListResponse;
import com.microsoft.windowsazure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
* The SQL Database Management API includes operations for getting Service
* Objective for a subscription.
*/
public class ServiceObjectiveOperationsImpl implements ServiceOperations<SqlManagementClientImpl>, ServiceObjectiveOperations
{
    /**
    * Initializes a new instance of the ServiceObjectiveOperationsImpl class.
    *
    * @param client Reference to the service client.
    */
    ServiceObjectiveOperationsImpl(SqlManagementClientImpl client)
    {
        this.client = client;
    }
    
    private SqlManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.sql.SqlManagementClientImpl.
    */
    public SqlManagementClientImpl getClient() { return this.client; }
    
    /**
    * Returns information about a certain Service Objective on a given Id.
    *
    * @param serverName The name of the SQL Server to be queried.
    * @param serviceObjectiveId The Id of the Service Objective to be obtained.
    * @return Response containing the service objective for a given server and
    * service objective Id.
    */
    @Override
    public Future<ServiceObjectiveGetResponse> getAsync(final String serverName, final String serviceObjectiveId)
    {
        return this.getClient().getExecutorService().submit(new Callable<ServiceObjectiveGetResponse>() { 
            @Override
            public ServiceObjectiveGetResponse call() throws Exception
            {
                return get(serverName, serviceObjectiveId);
            }
         });
    }
    
    /**
    * Returns information about a certain Service Objective on a given Id.
    *
    * @param serverName The name of the SQL Server to be queried.
    * @param serviceObjectiveId The Id of the Service Objective to be obtained.
    * @return Response containing the service objective for a given server and
    * service objective Id.
    */
    @Override
    public ServiceObjectiveGetResponse get(String serverName, String serviceObjectiveId) throws IOException, ServiceException, ParserConfigurationException, SAXException, ParseException
    {
        // Validate
        if (serverName == null)
        {
            throw new NullPointerException("serverName");
        }
        if (serviceObjectiveId == null)
        {
            throw new NullPointerException("serviceObjectiveId");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace)
        {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("serverName", serverName);
            tracingParameters.put("serviceObjectiveId", serviceObjectiveId);
            CloudTracing.enter(invocationId, this, "getAsync", tracingParameters);
        }
        
        // Construct URL
        String url = this.getClient().getBaseUri() + this.getClient().getCredentials().getSubscriptionId() + "/services/sqlservers/servers/" + serverName + "/serviceobjectives/" + serviceObjectiveId;
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2012-03-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        if (shouldTrace)
        {
            CloudTracing.sendRequest(invocationId, httpRequest);
        }
        httpResponse = this.getClient().getHttpClient().execute(httpRequest);
        if (shouldTrace)
        {
            CloudTracing.receiveResponse(invocationId, httpResponse);
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200)
        {
            ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
            if (shouldTrace)
            {
                CloudTracing.error(invocationId, ex);
            }
            throw ex;
        }
        
        // Create Result
        ServiceObjectiveGetResponse result = null;
        // Deserialize Response
        InputStream responseContent = httpResponse.getEntity().getContent();
        result = new ServiceObjectiveGetResponse();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document responseDoc = documentBuilder.parse(responseContent);
        
        NodeList elements = responseDoc.getElementsByTagName("ServiceResource");
        Element serviceResourceElement = elements.getLength() > 0 ? ((Element)elements.item(0)) : null;
        if (serviceResourceElement != null)
        {
            NodeList elements2 = serviceResourceElement.getElementsByTagName("Name");
            Element nameElement = elements2.getLength() > 0 ? ((Element)elements2.item(0)) : null;
            if (nameElement != null)
            {
                String nameInstance;
                nameInstance = nameElement.getTextContent();
                result.setName(nameInstance);
            }
            
            NodeList elements3 = serviceResourceElement.getElementsByTagName("Type");
            Element typeElement = elements3.getLength() > 0 ? ((Element)elements3.item(0)) : null;
            if (typeElement != null)
            {
                String typeInstance;
                typeInstance = typeElement.getTextContent();
                result.setType(typeInstance);
            }
            
            NodeList elements4 = serviceResourceElement.getElementsByTagName("State");
            Element stateElement = elements4.getLength() > 0 ? ((Element)elements4.item(0)) : null;
            if (stateElement != null)
            {
                String stateInstance;
                stateInstance = stateElement.getTextContent();
                result.setState(stateInstance);
            }
            
            NodeList elements5 = serviceResourceElement.getElementsByTagName("SelfLink");
            Element selfLinkElement = elements5.getLength() > 0 ? ((Element)elements5.item(0)) : null;
            if (selfLinkElement != null)
            {
                String selfLinkInstance;
                selfLinkInstance = selfLinkElement.getTextContent();
                result.setSelfLink(selfLinkInstance);
            }
            
            NodeList elements6 = serviceResourceElement.getElementsByTagName("ParentLink");
            Element parentLinkElement = elements6.getLength() > 0 ? ((Element)elements6.item(0)) : null;
            if (parentLinkElement != null)
            {
                String parentLinkInstance;
                parentLinkInstance = parentLinkElement.getTextContent();
                result.setParentLink(parentLinkInstance);
            }
            
            NodeList elements7 = serviceResourceElement.getElementsByTagName("Id");
            Element idElement = elements7.getLength() > 0 ? ((Element)elements7.item(0)) : null;
            if (idElement != null)
            {
                String idInstance;
                idInstance = idElement.getTextContent();
                result.setId(idInstance);
            }
            
            NodeList elements8 = serviceResourceElement.getElementsByTagName("IsDefault");
            Element isDefaultElement = elements8.getLength() > 0 ? ((Element)elements8.item(0)) : null;
            if (isDefaultElement != null)
            {
                boolean isDefaultInstance;
                isDefaultInstance = Boolean.parseBoolean(isDefaultElement.getTextContent());
                result.setIsDefault(isDefaultInstance);
            }
            
            NodeList elements9 = serviceResourceElement.getElementsByTagName("IsSystem");
            Element isSystemElement = elements9.getLength() > 0 ? ((Element)elements9.item(0)) : null;
            if (isSystemElement != null)
            {
                boolean isSystemInstance;
                isSystemInstance = Boolean.parseBoolean(isSystemElement.getTextContent());
                result.setIsSystem(isSystemInstance);
            }
            
            NodeList elements10 = serviceResourceElement.getElementsByTagName("Description");
            Element descriptionElement = elements10.getLength() > 0 ? ((Element)elements10.item(0)) : null;
            if (descriptionElement != null)
            {
                String descriptionInstance;
                descriptionInstance = descriptionElement.getTextContent();
                result.setDescription(descriptionInstance);
            }
            
            NodeList elements11 = serviceResourceElement.getElementsByTagName("Enabled");
            Element enabledElement = elements11.getLength() > 0 ? ((Element)elements11.item(0)) : null;
            if (enabledElement != null)
            {
                boolean enabledInstance;
                enabledInstance = Boolean.parseBoolean(enabledElement.getTextContent());
                result.setEnabled(enabledInstance);
            }
            
            NodeList elements12 = serviceResourceElement.getElementsByTagName("DimensionSettings");
            Element dimensionSettingsSequenceElement = elements12.getLength() > 0 ? ((Element)elements12.item(0)) : null;
            if (dimensionSettingsSequenceElement != null)
            {
                for (int i1 = 0; i1 < dimensionSettingsSequenceElement.getElementsByTagName("ServiceResource").getLength(); i1 = i1 + 1)
                {
                    org.w3c.dom.Element dimensionSettingsElement = ((org.w3c.dom.Element)dimensionSettingsSequenceElement.getElementsByTagName("ServiceResource").item(i1));
                    ServiceObjectiveGetResponse.DimensionSettingResponse serviceResourceInstance = new ServiceObjectiveGetResponse.DimensionSettingResponse();
                    result.getDimensionSettings().add(serviceResourceInstance);
                    
                    NodeList elements13 = dimensionSettingsElement.getElementsByTagName("Name");
                    Element nameElement2 = elements13.getLength() > 0 ? ((Element)elements13.item(0)) : null;
                    if (nameElement2 != null)
                    {
                        String nameInstance2;
                        nameInstance2 = nameElement2.getTextContent();
                        serviceResourceInstance.setName(nameInstance2);
                    }
                    
                    NodeList elements14 = dimensionSettingsElement.getElementsByTagName("Type");
                    Element typeElement2 = elements14.getLength() > 0 ? ((Element)elements14.item(0)) : null;
                    if (typeElement2 != null)
                    {
                        String typeInstance2;
                        typeInstance2 = typeElement2.getTextContent();
                        serviceResourceInstance.setType(typeInstance2);
                    }
                    
                    NodeList elements15 = dimensionSettingsElement.getElementsByTagName("State");
                    Element stateElement2 = elements15.getLength() > 0 ? ((Element)elements15.item(0)) : null;
                    if (stateElement2 != null)
                    {
                        String stateInstance2;
                        stateInstance2 = stateElement2.getTextContent();
                        serviceResourceInstance.setState(stateInstance2);
                    }
                    
                    NodeList elements16 = dimensionSettingsElement.getElementsByTagName("SelfLink");
                    Element selfLinkElement2 = elements16.getLength() > 0 ? ((Element)elements16.item(0)) : null;
                    if (selfLinkElement2 != null)
                    {
                        String selfLinkInstance2;
                        selfLinkInstance2 = selfLinkElement2.getTextContent();
                        serviceResourceInstance.setSelfLink(selfLinkInstance2);
                    }
                    
                    NodeList elements17 = dimensionSettingsElement.getElementsByTagName("ParentLink");
                    Element parentLinkElement2 = elements17.getLength() > 0 ? ((Element)elements17.item(0)) : null;
                    if (parentLinkElement2 != null)
                    {
                        String parentLinkInstance2;
                        parentLinkInstance2 = parentLinkElement2.getTextContent();
                        serviceResourceInstance.setParentLink(parentLinkInstance2);
                    }
                    
                    NodeList elements18 = dimensionSettingsElement.getElementsByTagName("Id");
                    Element idElement2 = elements18.getLength() > 0 ? ((Element)elements18.item(0)) : null;
                    if (idElement2 != null)
                    {
                        String idInstance2;
                        idInstance2 = idElement2.getTextContent();
                        serviceResourceInstance.setId(idInstance2);
                    }
                    
                    NodeList elements19 = dimensionSettingsElement.getElementsByTagName("Description");
                    Element descriptionElement2 = elements19.getLength() > 0 ? ((Element)elements19.item(0)) : null;
                    if (descriptionElement2 != null)
                    {
                        String descriptionInstance2;
                        descriptionInstance2 = descriptionElement2.getTextContent();
                        serviceResourceInstance.setDescription(descriptionInstance2);
                    }
                    
                    NodeList elements20 = dimensionSettingsElement.getElementsByTagName("Ordinal");
                    Element ordinalElement = elements20.getLength() > 0 ? ((Element)elements20.item(0)) : null;
                    if (ordinalElement != null)
                    {
                        byte ordinalInstance;
                        ordinalInstance = Byte.valueOf(ordinalElement.getTextContent());
                        serviceResourceInstance.setOrdinal(ordinalInstance);
                    }
                    
                    NodeList elements21 = dimensionSettingsElement.getElementsByTagName("IsDefault");
                    Element isDefaultElement2 = elements21.getLength() > 0 ? ((Element)elements21.item(0)) : null;
                    if (isDefaultElement2 != null)
                    {
                        boolean isDefaultInstance2;
                        isDefaultInstance2 = Boolean.parseBoolean(isDefaultElement2.getTextContent());
                        serviceResourceInstance.setIsDefault(isDefaultInstance2);
                    }
                }
            }
        }
        
        result.setStatusCode(statusCode);
        if (httpResponse.getHeaders("x-ms-request-id").length > 0)
        {
            result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
        }
        
        if (shouldTrace)
        {
            CloudTracing.exit(invocationId, result);
        }
        return result;
    }
    
    /**
    * Returns information about all Service Objectives on a database server.
    *
    * @param serverName The name of the database server to be queried.
    * @return Response containing the list of service objective for a given
    * server.
    */
    @Override
    public Future<ServiceObjectiveListResponse> listAsync(final String serverName)
    {
        return this.getClient().getExecutorService().submit(new Callable<ServiceObjectiveListResponse>() { 
            @Override
            public ServiceObjectiveListResponse call() throws Exception
            {
                return list(serverName);
            }
         });
    }
    
    /**
    * Returns information about all Service Objectives on a database server.
    *
    * @param serverName The name of the database server to be queried.
    * @return Response containing the list of service objective for a given
    * server.
    */
    @Override
    public ServiceObjectiveListResponse list(String serverName) throws IOException, ServiceException, ParserConfigurationException, SAXException, ParseException
    {
        // Validate
        if (serverName == null)
        {
            throw new NullPointerException("serverName");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace)
        {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("serverName", serverName);
            CloudTracing.enter(invocationId, this, "listAsync", tracingParameters);
        }
        
        // Construct URL
        String url = this.getClient().getBaseUri() + this.getClient().getCredentials().getSubscriptionId() + "/services/sqlservers/servers/" + serverName + "/serviceobjectives";
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2012-03-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        if (shouldTrace)
        {
            CloudTracing.sendRequest(invocationId, httpRequest);
        }
        httpResponse = this.getClient().getHttpClient().execute(httpRequest);
        if (shouldTrace)
        {
            CloudTracing.receiveResponse(invocationId, httpResponse);
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200)
        {
            ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
            if (shouldTrace)
            {
                CloudTracing.error(invocationId, ex);
            }
            throw ex;
        }
        
        // Create Result
        ServiceObjectiveListResponse result = null;
        // Deserialize Response
        InputStream responseContent = httpResponse.getEntity().getContent();
        result = new ServiceObjectiveListResponse();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document responseDoc = documentBuilder.parse(responseContent);
        
        NodeList elements = responseDoc.getElementsByTagName("ServiceResources");
        Element serviceResourcesSequenceElement = elements.getLength() > 0 ? ((Element)elements.item(0)) : null;
        if (serviceResourcesSequenceElement != null)
        {
            for (int i1 = 0; i1 < serviceResourcesSequenceElement.getElementsByTagName("ServiceResource").getLength(); i1 = i1 + 1)
            {
                org.w3c.dom.Element serviceResourcesElement = ((org.w3c.dom.Element)serviceResourcesSequenceElement.getElementsByTagName("ServiceResource").item(i1));
                ServiceObjectiveListResponse.ServiceObjective serviceResourceInstance = new ServiceObjectiveListResponse.ServiceObjective();
                result.getServiceObjectives().add(serviceResourceInstance);
                
                NodeList elements2 = serviceResourcesElement.getElementsByTagName("Name");
                Element nameElement = elements2.getLength() > 0 ? ((Element)elements2.item(0)) : null;
                if (nameElement != null)
                {
                    String nameInstance;
                    nameInstance = nameElement.getTextContent();
                    serviceResourceInstance.setName(nameInstance);
                }
                
                NodeList elements3 = serviceResourcesElement.getElementsByTagName("Type");
                Element typeElement = elements3.getLength() > 0 ? ((Element)elements3.item(0)) : null;
                if (typeElement != null)
                {
                    String typeInstance;
                    typeInstance = typeElement.getTextContent();
                    serviceResourceInstance.setType(typeInstance);
                }
                
                NodeList elements4 = serviceResourcesElement.getElementsByTagName("State");
                Element stateElement = elements4.getLength() > 0 ? ((Element)elements4.item(0)) : null;
                if (stateElement != null)
                {
                    String stateInstance;
                    stateInstance = stateElement.getTextContent();
                    serviceResourceInstance.setState(stateInstance);
                }
                
                NodeList elements5 = serviceResourcesElement.getElementsByTagName("SelfLink");
                Element selfLinkElement = elements5.getLength() > 0 ? ((Element)elements5.item(0)) : null;
                if (selfLinkElement != null)
                {
                    String selfLinkInstance;
                    selfLinkInstance = selfLinkElement.getTextContent();
                    serviceResourceInstance.setSelfLink(selfLinkInstance);
                }
                
                NodeList elements6 = serviceResourcesElement.getElementsByTagName("ParentLink");
                Element parentLinkElement = elements6.getLength() > 0 ? ((Element)elements6.item(0)) : null;
                if (parentLinkElement != null)
                {
                    String parentLinkInstance;
                    parentLinkInstance = parentLinkElement.getTextContent();
                    serviceResourceInstance.setParentLink(parentLinkInstance);
                }
                
                NodeList elements7 = serviceResourcesElement.getElementsByTagName("Id");
                Element idElement = elements7.getLength() > 0 ? ((Element)elements7.item(0)) : null;
                if (idElement != null)
                {
                    String idInstance;
                    idInstance = idElement.getTextContent();
                    serviceResourceInstance.setId(idInstance);
                }
                
                NodeList elements8 = serviceResourcesElement.getElementsByTagName("IsDefault");
                Element isDefaultElement = elements8.getLength() > 0 ? ((Element)elements8.item(0)) : null;
                if (isDefaultElement != null)
                {
                    boolean isDefaultInstance;
                    isDefaultInstance = Boolean.parseBoolean(isDefaultElement.getTextContent());
                    serviceResourceInstance.setIsDefault(isDefaultInstance);
                }
                
                NodeList elements9 = serviceResourcesElement.getElementsByTagName("IsSystem");
                Element isSystemElement = elements9.getLength() > 0 ? ((Element)elements9.item(0)) : null;
                if (isSystemElement != null)
                {
                    boolean isSystemInstance;
                    isSystemInstance = Boolean.parseBoolean(isSystemElement.getTextContent());
                    serviceResourceInstance.setIsSystem(isSystemInstance);
                }
                
                NodeList elements10 = serviceResourcesElement.getElementsByTagName("Description");
                Element descriptionElement = elements10.getLength() > 0 ? ((Element)elements10.item(0)) : null;
                if (descriptionElement != null)
                {
                    String descriptionInstance;
                    descriptionInstance = descriptionElement.getTextContent();
                    serviceResourceInstance.setDescription(descriptionInstance);
                }
                
                NodeList elements11 = serviceResourcesElement.getElementsByTagName("Enabled");
                Element enabledElement = elements11.getLength() > 0 ? ((Element)elements11.item(0)) : null;
                if (enabledElement != null)
                {
                    boolean enabledInstance;
                    enabledInstance = Boolean.parseBoolean(enabledElement.getTextContent());
                    serviceResourceInstance.setEnabled(enabledInstance);
                }
                
                NodeList elements12 = serviceResourcesElement.getElementsByTagName("DimensionSettings");
                Element dimensionSettingsSequenceElement = elements12.getLength() > 0 ? ((Element)elements12.item(0)) : null;
                if (dimensionSettingsSequenceElement != null)
                {
                    for (int i2 = 0; i2 < dimensionSettingsSequenceElement.getElementsByTagName("ServiceResource").getLength(); i2 = i2 + 1)
                    {
                        org.w3c.dom.Element dimensionSettingsElement = ((org.w3c.dom.Element)dimensionSettingsSequenceElement.getElementsByTagName("ServiceResource").item(i2));
                        ServiceObjectiveListResponse.ServiceObjective.DimensionSettingResponse serviceResourceInstance2 = new ServiceObjectiveListResponse.ServiceObjective.DimensionSettingResponse();
                        serviceResourceInstance.getDimensionSettings().add(serviceResourceInstance2);
                        
                        NodeList elements13 = dimensionSettingsElement.getElementsByTagName("Name");
                        Element nameElement2 = elements13.getLength() > 0 ? ((Element)elements13.item(0)) : null;
                        if (nameElement2 != null)
                        {
                            String nameInstance2;
                            nameInstance2 = nameElement2.getTextContent();
                            serviceResourceInstance2.setName(nameInstance2);
                        }
                        
                        NodeList elements14 = dimensionSettingsElement.getElementsByTagName("Type");
                        Element typeElement2 = elements14.getLength() > 0 ? ((Element)elements14.item(0)) : null;
                        if (typeElement2 != null)
                        {
                            String typeInstance2;
                            typeInstance2 = typeElement2.getTextContent();
                            serviceResourceInstance2.setType(typeInstance2);
                        }
                        
                        NodeList elements15 = dimensionSettingsElement.getElementsByTagName("State");
                        Element stateElement2 = elements15.getLength() > 0 ? ((Element)elements15.item(0)) : null;
                        if (stateElement2 != null)
                        {
                            String stateInstance2;
                            stateInstance2 = stateElement2.getTextContent();
                            serviceResourceInstance2.setState(stateInstance2);
                        }
                        
                        NodeList elements16 = dimensionSettingsElement.getElementsByTagName("SelfLink");
                        Element selfLinkElement2 = elements16.getLength() > 0 ? ((Element)elements16.item(0)) : null;
                        if (selfLinkElement2 != null)
                        {
                            String selfLinkInstance2;
                            selfLinkInstance2 = selfLinkElement2.getTextContent();
                            serviceResourceInstance2.setSelfLink(selfLinkInstance2);
                        }
                        
                        NodeList elements17 = dimensionSettingsElement.getElementsByTagName("ParentLink");
                        Element parentLinkElement2 = elements17.getLength() > 0 ? ((Element)elements17.item(0)) : null;
                        if (parentLinkElement2 != null)
                        {
                            String parentLinkInstance2;
                            parentLinkInstance2 = parentLinkElement2.getTextContent();
                            serviceResourceInstance2.setParentLink(parentLinkInstance2);
                        }
                        
                        NodeList elements18 = dimensionSettingsElement.getElementsByTagName("Id");
                        Element idElement2 = elements18.getLength() > 0 ? ((Element)elements18.item(0)) : null;
                        if (idElement2 != null)
                        {
                            String idInstance2;
                            idInstance2 = idElement2.getTextContent();
                            serviceResourceInstance2.setId(idInstance2);
                        }
                        
                        NodeList elements19 = dimensionSettingsElement.getElementsByTagName("Description");
                        Element descriptionElement2 = elements19.getLength() > 0 ? ((Element)elements19.item(0)) : null;
                        if (descriptionElement2 != null)
                        {
                            String descriptionInstance2;
                            descriptionInstance2 = descriptionElement2.getTextContent();
                            serviceResourceInstance2.setDescription(descriptionInstance2);
                        }
                        
                        NodeList elements20 = dimensionSettingsElement.getElementsByTagName("Ordinal");
                        Element ordinalElement = elements20.getLength() > 0 ? ((Element)elements20.item(0)) : null;
                        if (ordinalElement != null)
                        {
                            byte ordinalInstance;
                            ordinalInstance = Byte.valueOf(ordinalElement.getTextContent());
                            serviceResourceInstance2.setOrdinal(ordinalInstance);
                        }
                        
                        NodeList elements21 = dimensionSettingsElement.getElementsByTagName("IsDefault");
                        Element isDefaultElement2 = elements21.getLength() > 0 ? ((Element)elements21.item(0)) : null;
                        if (isDefaultElement2 != null)
                        {
                            boolean isDefaultInstance2;
                            isDefaultInstance2 = Boolean.parseBoolean(isDefaultElement2.getTextContent());
                            serviceResourceInstance2.setIsDefault(isDefaultInstance2);
                        }
                    }
                }
            }
        }
        
        result.setStatusCode(statusCode);
        if (httpResponse.getHeaders("x-ms-request-id").length > 0)
        {
            result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
        }
        
        if (shouldTrace)
        {
            CloudTracing.exit(invocationId, result);
        }
        return result;
    }
}