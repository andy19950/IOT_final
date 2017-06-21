/*******************************************************************************
 * Copyright (c) 2013-2014 LAAS-CNRS (www.laas.fr)
 * 7 Colonel Roche 31077 Toulouse - France
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thierry Monteil (Project co-founder) - Management and initial specification,
 *      conception and documentation.
 *     Mahdi Ben Alaya (Project co-founder) - Management and initial specification,
 *      conception, implementation, test and documentation.
 *     Christophe Chassot - Management and initial specification.
 *     Khalil Drira - Management and initial specification.
 *     Yassine Banouar - Initial specification, conception, implementation, test
 *      and documentation.
 ******************************************************************************/
package org.eclipse.om2m.ipu.sample;

/**
 *  Provides different Lamps methods.
 *  @author <ul>
 *         <li>Yassine Banouar < ybanouar@laas.fr > < yassine.banouar@gmail.com ></li>
 *         <li>Mahdi Ben Alaya < ben.alaya@laas.fr > < benalaya.mahdi@gmail.com ></li>
 *         </ul>
 */
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.commons.resource.AnyURIList;
import org.eclipse.om2m.commons.resource.Application;
import org.eclipse.om2m.commons.resource.Container;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.eclipse.om2m.commons.resource.Group;
import org.eclipse.om2m.commons.resource.MemberType;
import org.eclipse.om2m.commons.resource.StatusCode;
import org.eclipse.om2m.commons.rest.RequestIndication;
import org.eclipse.om2m.commons.rest.ResponseConfirm;
import org.eclipse.om2m.core.service.SclService;

public class SampleMonitor {
    /** Logger */
    private static Log LOGGER = LogFactory.getLog(SampleMonitor.class);
    /** Sclbase id */
    public final static String SCLID = System.getProperty("org.eclipse.om2m.sclBaseId","");
    /** Admin requesting entity */
    static String REQENTITY = System.getProperty("org.eclipse.om2m.adminRequestingEntity","");
    /** Generic create method name */
    public final static String METHOD_CREATE = "CREATE";
    /** Generic execute method name */
    public final static String METHOD_EXECUTE = "EXECUTE";
    /** State container id */
    public final static String DATA = "DATA";
    /** Descriptor container id */
    public final static String DESC = "DESCRIPTOR";
    /** Discovered SCL service*/
    static SclService SCL;
    static Map<String, Desk> DESKS = new HashMap<String, Desk>();

    /**
     * Constructor
     * @param scl - discovered SCL
     */
    public SampleMonitor(SclService scl) {
        SCL=scl;
    }

    /**
     * Starts monitoring and creating resources on the SCL
     */
    public void start() {
        LOGGER.info("Lamps waiting for attachement..");
        // Create initial resources for the 2 lamps
        for(int i=0; i<5; i++) {
            String deskId = Desk.TYPE+"_"+i;
            DESKS.put(deskId, new Desk());
            Desk curr = DESKS.get(Desk.TYPE+"_"+i);
            if(i%2 == 0){
                curr.setState(false);
                curr.setSocket(true);
            } else {
                curr.setState(true);
                curr.setSocket(false);
            }
            curr.setHeight(i*10);
            curr.setBright(i+10);
            curr.setTemperature(20+i);
            curr.setSeatNumber(4);

            createDeskResources(deskId, false, Desk.APOCPATH);
        }
        // Create an Application to switch all lamps
        // postGroups(Desk.APOCPATH, Desk.TYPE, Desk.LOCATION);
        // GUI.init();
        Sensor1 monitor = new Sensor1();
        monitor.start();
    }

    /**
     * Stops monitoring by closing the IPU GUI
     */
//    public static void stop() {
//        GUI.stop();
//    }

    /**
     * Creates all required resources.
     * @param appId - Application ID
     * @param initValue - initial lamp value
     * @param aPoCPath - lamp aPocPath
     */
    public void createDeskResources(String appId, boolean initValue, String aPoCPath) {
        // Create the Application resource
        ResponseConfirm response = SCL.doRequest(new RequestIndication(METHOD_CREATE,SCLID+"/applications",REQENTITY,new Application(appId,aPoCPath)));
        // Create Application sub-resources only if application not yet created
        if(response.getStatusCode().equals(StatusCode.STATUS_CREATED)) {
            // Create DESCRIPTOR container sub-resource
            SCL.doRequest(new RequestIndication(METHOD_CREATE,SCLID+"/applications/"+appId+"/containers",REQENTITY,new Container(DESC)));
            // Create STATE container sub-resource
            SCL.doRequest(new RequestIndication(METHOD_CREATE,SCLID+"/applications/"+appId+"/containers",REQENTITY,new Container(DATA)));

            String content, targetID;
            // Create DESCRIPTION contentInstance on the DESCRIPTOR container resource
            content = Desk.getDescriptorRep(SCLID, appId, DATA);
            targetID= SCLID+"/applications/"+appId+"/containers/"+DESC+"/contentInstances";
            SCL.doRequest(new RequestIndication(METHOD_CREATE,targetID,REQENTITY,new ContentInstance(content.getBytes())));

            // Create initial contentInstance on the STATE container resource
            content = Desk.getStateRep(appId, initValue, 0, 0, 0, 0, initValue);
            targetID = SCLID+"/applications/"+appId+"/containers/"+DATA+"/contentInstances";
            SCL.doRequest(new RequestIndication(METHOD_CREATE,targetID,REQENTITY,new ContentInstance(content.getBytes())));
        }
    }

    /**
     * Creates a ContentInstance resource on STATE container.
     * @param lampId - Application ID
     * @param value - measured state
     */
    public static void createContentResource(String deskId, boolean state, int temp, int height, int bright, int seatNum, boolean socket) {
        // Creates lampCI with new State
        String content = Desk.getStateRep(deskId, state, temp, height, bright, seatNum, socket);
        String targetID = SCLID+"/applications/"+deskId+"/containers/"+DATA+"/contentInstances";
        SCL.doRequest(new RequestIndication(METHOD_CREATE,targetID,REQENTITY,new ContentInstance(content.getBytes())));
    }

    /**
     * Sets the lamp state.
     * @param appId - Application ID
     * @param value - measured state
     */
    public static void setDeskState(final String appId) {
        Desk curr = DESKS.get(appId);    
        boolean state = curr.getState();
        int temp = curr.getTemperature();
        int height = curr.getHeight();
        int bright = curr.getBright();
        int seatNum = curr.getSeatNumber();
        boolean socket = curr.getSocket();
        createContentResource(appId, state, temp, height, seatNum, bright, socket);
    }

    /**
     * Gets the direct current lamp state
     * @param appId
     * @return the direct current lamp state
     *
    public static boolean getDeskValue(String appId) {
        return DESKS.get(appId).getState();
    }*/

    public static void execute(String localTarget) {
        SCL.doRequest(new RequestIndication(METHOD_EXECUTE,SCLID+"/"+localTarget,REQENTITY, ""));
    }

    /**
     * Creates a {@link Group} resource including
     * the lamps references.
     * @param aPoCPath - The lamps ApOCPath
     * @param location - The lamps location.
     */
    public static void postGroups(String aPoCPath, String type, String location) {
        // Groups
        // GroupON
        Group groupON = new Group();
        groupON.setId(Switchs.GROUP_ON);
        groupON.setMemberType(MemberType.APPLICATION);
        // GroupOFF
        Group groupOFF = new Group();
        groupOFF.setId(Switchs.GROUP_OFF);
        groupOFF.setMemberType(MemberType.APPLICATION);
        // GroupMembers
        AnyURIList membersON = new AnyURIList();
        AnyURIList membersOFF = new AnyURIList();
        for (int i=0; i<DESKS.size(); i++) {
            membersON.getReference().add(SCLID+"/applications/"+DESKS.keySet().toArray()[i].toString()+"/"+aPoCPath+"/true");
            membersOFF.getReference().add(SCLID+"/applications/"+DESKS.keySet().toArray()[i].toString()+"/"+aPoCPath+"/false");
        }
        groupON.setMembers(membersON);
        groupOFF.setMembers(membersOFF);

        // Groups Creation Request
        SCL.doRequest(new RequestIndication(METHOD_CREATE,SCLID+"/groups",REQENTITY,groupON));
        SCL.doRequest(new RequestIndication(METHOD_CREATE,SCLID+"/groups",REQENTITY,groupOFF));

        // Application Creation
        ResponseConfirm response = SCL.doRequest(new RequestIndication("CREATE",SCLID+"/applications",REQENTITY,new Application(Switchs.APP_ID)));
        if (response.getStatusCode().equals(StatusCode.STATUS_CREATED)) {
            // Create DESCRIPTOR container sub-resource
            SCL.doRequest(new RequestIndication(METHOD_CREATE,SCLID+"/applications/"+Switchs.APP_ID+"/containers",REQENTITY,new Container(DESC)));
            // Create DESCRIPTION contentInstance on the DESCRIPTOR container resource
            String content = Switchs.getDescriptorRep(SCLID, Switchs.APP_ID, type, location, DESC);
            String targetID = SCLID+"/applications/"+Switchs.APP_ID+"/containers/"+DESC+"/contentInstances";
            SCL.doRequest(new RequestIndication(METHOD_CREATE,targetID,REQENTITY,new ContentInstance(content.getBytes())));
        }
    }
}
