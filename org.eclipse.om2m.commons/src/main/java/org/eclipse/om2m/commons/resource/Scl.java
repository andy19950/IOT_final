/*******************************************************************************
 * Copyright (c) 2013-2015 LAAS-CNRS (www.laas.fr)
 * 7 Colonel Roche 31077 Toulouse - France
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Thierry Monteil (Project co-founder) - Management and initial specification,
 *         conception and documentation.
 *     Mahdi Ben Alaya (Project co-founder) - Management and initial specification,
 *         conception, implementation, test and documentation.
 *     Christophe Chassot - Management and initial specification.
 *     Khalil Drira - Management and initial specification.
 *     Yassine Banouar - Initial specification, conception, implementation, test
 *         and documentation.
 *     Guillaume Garzone - Conception, implementation, test and documentation.
 *     Francois Aissaoui - Conception, implementation, test and documentation.
 ******************************************************************************/

// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2013.06.24 at 03:13:28 AM CEST
//

package org.eclipse.om2m.commons.resource;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;



/**
 * <p>Java Class for Scl complex type.
 *
 * <p>Scl resource represents a remote SCL that is registered to the containing {@link SclBase}.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Scl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://uri.etsi.org/m2m}pocs" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}remTriggerAddr" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}onlineStatus" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}serverCapability" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}link" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}schedule" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}expirationTime" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}accessRightID" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}searchStrings" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}creationTime" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}lastModifiedTime" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}locTargetDevice" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}mgmtProtocolType" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}integrityValResults" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}aPocHandling" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}containersReference" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}groupsReference" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}applicationsReference" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}accessRightsReference" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}subscriptionsReference" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}mgmtObjsReference" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}notificationChannelsReference" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}m2mPocsReference" minOccurs="0"/>
 *         &lt;element ref="{http://uri.etsi.org/m2m}attachedDevicesReference" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="sclId" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name=DBEntities.SCL_ENTITY)
public class Scl extends Resource {

	@Lob
    protected AnyURIList pocs;
    @XmlSchemaType(name = "anyURI")
    protected String remTriggerAddr;
    @Enumerated(EnumType.STRING)
    protected OnlineStatus onlineStatus;
    protected Boolean serverCapability;
    @XmlSchemaType(name = "anyURI")
    protected String link;
    @Embedded
    protected Schedule schedule;
    @XmlSchemaType(name = "dateTime")
    protected String expirationTime;
    @XmlSchemaType(name = "dateTime")
    protected String creationTime;
    @XmlSchemaType(name = "dateTime")
    protected String lastModifiedTime;
    @XmlSchemaType(name = "anySimpleType")
    @Transient
    protected Object locTargetDevice;
    @Enumerated(EnumType.STRING)
    protected MgmtProtocolType mgmtProtocolType;
    @Embedded
    protected IntegrityValResults integrityValResults;
    @Enumerated(EnumType.STRING)
    protected APocHandling aPocHandling;
    @XmlSchemaType(name = "anyURI")
    @Transient
    protected String containersReference;
    @XmlSchemaType(name = "anyURI")
    @Transient
    protected String groupsReference;
    @XmlSchemaType(name = "anyURI")
    @Transient
    protected String applicationsReference;
    @XmlSchemaType(name = "anyURI")
    @Transient
    protected String accessRightsReference;
    @XmlSchemaType(name = "anyURI")
    @Transient
    protected String subscriptionsReference;
    @XmlSchemaType(name = "anyURI")
    @Transient
    protected String mgmtObjsReference;
    @XmlSchemaType(name = "anyURI")
    @Transient
    protected String notificationChannelsReference;
    @XmlElement(name = "m2mPocsReference")
    @XmlSchemaType(name = "anyURI")
    @Transient
    protected String m2MPocsReference;
    @XmlSchemaType(name = "anyURI")
    @Transient
    protected String attachedDevicesReference;
    @XmlAttribute(name = "sclId")
    @XmlSchemaType(name = "anyURI")
    protected String sclId;

    /**
     * Gets the value of the property pocs.
     *
     * @return
     *     possible object is
     *     {@link AnyURIList }
     *
     */
    public AnyURIList getPocs() {
        return pocs;
    }

    /**
     * Sets the value of the property pocs.
     *
     * @param value
     *     allowed object is
     *     {@link AnyURIList }
     *
     */
    public void setPocs(AnyURIList value) {
        this.pocs = value;
    }

    /**
     * Gets the value of the property remTriggerAddr.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRemTriggerAddr() {
        return remTriggerAddr;
    }

    /**
     * Sets the value of the property remTriggerAddr.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRemTriggerAddr(String value) {
        this.remTriggerAddr = value;
    }

    /**
     * Gets the value of the property onlineStatus.
     *
     * @return
     *     possible object is
     *     {@link OnlineStatus }
     *
     */
    public OnlineStatus getOnlineStatus() {
        return onlineStatus;
    }

    /**
     * Sets the value of the property onlineStatus.
     *
     * @param value
     *     allowed object is
     *     {@link OnlineStatus }
     *
     */
    public void setOnlineStatus(OnlineStatus value) {
        this.onlineStatus = value;
    }

    /**
     * Gets the value of the property serverCapability.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isServerCapability() {
        return serverCapability;
    }

    /**
     * Sets the value of the property serverCapability.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setServerCapability(Boolean value) {
        this.serverCapability = value;
    }

    /**
     * Gets the value of the property link.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the value of the property link.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLink(String value) {
        this.link = value;
    }

    /**
     * Gets the value of the property schedule.
     *
     * @return
     *     possible object is
     *     {@link Schedule }
     *
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Sets the value of the property schedule.
     *
     * @param value
     *     allowed object is
     *     {@link Schedule }
     *
     */
    public void setSchedule(Schedule value) {
        this.schedule = value;
    }

    /**
     * Gets the value of the property expirationTime.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExpirationTime() {
        return expirationTime;
    }

    /**
     * Sets the value of the property expirationTime.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExpirationTime(String value) {
        this.expirationTime = value;
    }

    /**
     * Gets the value of the property searchStrings.
     *
     * @return
     *     possible object is
     *     {@link SearchStrings }
     *
     */

    public String getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the property creationTime.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */

    public void setCreationTime(String value) {
        this.creationTime = value;
    }

    /**
     * Gets the value of the property lastModifiedTime.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * Sets the value of the property lastModifiedTime.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */

    public void setLastModifiedTime(String value) {
        this.lastModifiedTime = value;
    }

    /**
     * Gets the value of the property locTargetDevice.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getLocTargetDevice() {
        return locTargetDevice;
    }

    /**
     * Sets the value of the property locTargetDevice.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setLocTargetDevice(Object value) {
        this.locTargetDevice = value;
    }

    /**
     * Gets the value of the property mgmtProtocolType.
     *
     * @return
     *     possible object is
     *     {@link MgmtProtocolType }
     *
     */
    public MgmtProtocolType getMgmtProtocolType() {
        return mgmtProtocolType;
    }

    /**
     * Sets the value of the property mgmtProtocolType.
     *
     * @param value
     *     allowed object is
     *     {@link MgmtProtocolType }
     *
     */
    public void setMgmtProtocolType(MgmtProtocolType value) {
        this.mgmtProtocolType = value;
    }

    /**
     * Gets the value of the property integrityValResults.
     *
     * @return
     *     possible object is
     *     {@link IntegrityValResults }
     *
     */
    public IntegrityValResults getIntegrityValResults() {
        return integrityValResults;
    }

    /**
     * Sets the value of the property integrityValResults.
     *
     * @param value
     *     allowed object is
     *     {@link IntegrityValResults }
     *
     */
    public void setIntegrityValResults(IntegrityValResults value) {
        this.integrityValResults = value;
    }

    /**
     * Gets the value of the property aPocHandling.
     *
     * @return
     *     possible object is
     *     {@link APocHandling }
     *
     */
    public APocHandling getAPocHandling() {
        return aPocHandling;
    }

    /**
     * Sets the value of the property aPocHandling.
     *
     * @param value
     *     allowed object is
     *     {@link APocHandling }
     *
     */
    public void setAPocHandling(APocHandling value) {
        this.aPocHandling = value;
    }

    /**
     * Gets the value of the property containersReference.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContainersReference() {
    	if (containersReference == null && uri != null) {
    		return uri+Refs.CONTAINERS_REF;
    	} else {
			return containersReference;
    	}
    }

    /**
     * Sets the value of the property containersReference.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContainersReference(String value) {
        this.containersReference = value;
    }

    /**
     * Gets the value of the property groupsReference.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGroupsReference() {
    	if (groupsReference == null && uri != null) {
    		return uri+Refs.GROUPS_REF;
    	} else {
			return groupsReference;
    	}
    }

    /**
     * Sets the value of the property groupsReference.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGroupsReference(String value) {
        this.groupsReference = value;
    }

    /**
     * Gets the value of the property applicationsReference.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getApplicationsReference() {
    	if (applicationsReference == null && uri != null) {
    		return uri+Refs.APPLICATIONS_REF;
    	} else {
			return applicationsReference;
    	}
    }

    /**
     * Sets the value of the property applicationsReference.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setApplicationsReference(String value) {
        this.applicationsReference = value;
    }

    /**
     * Gets the value of the property accessRightsReference.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAccessRightsReference() {
    	if (accessRightsReference == null && uri != null) {
    		return uri+Refs.ACCESSRIGHTS_REF;
    	} else {
			return accessRightsReference;
    	}
    }

    /**
     * Sets the value of the property accessRightsReference.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAccessRightsReference(String value) {
        this.accessRightsReference = value;
    }

    /**
     * Gets the value of the property subscriptionsReference.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSubscriptionsReference() {
    	if (subscriptionsReference == null && uri != null) {
    		return uri+Refs.SUBSCRIPTIONS_REF;
    	} else {
			return subscriptionsReference;
    	}
    }

    /**
     * Sets the value of the property subscriptionsReference.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSubscriptionsReference(String value) {
        this.subscriptionsReference = value;
    }

    /**
     * Gets the value of the property mgmtObjsReference.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMgmtObjsReference() {
    	if (mgmtObjsReference == null && uri != null) {
    		return uri+Refs.MGMTOBJS_REF;
    	} else {
			return mgmtObjsReference;
    	}
    }

    /**
     * Sets the value of the property mgmtObjsReference.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMgmtObjsReference(String value) {
        this.mgmtObjsReference = value;
    }

    /**
     * Gets the value of the property notificationChannelsReference.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNotificationChannelsReference() {
    	if (notificationChannelsReference == null && uri != null) {
    		return uri+Refs.NOTIFICATIONCHANNELS_REF;
    	} else {
			return notificationChannelsReference;
    	}
    }

    /**
     * Sets the value of the property notificationChannelsReference.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNotificationChannelsReference(String value) {
        this.notificationChannelsReference = value;
    }

    /**
     * Gets the value of the property m2MPocsReference.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getM2MPocsReference() {
    	if (m2MPocsReference == null && uri != null) {
    		return uri+Refs.M2MPOCS_REF;
    	} else {
			return m2MPocsReference;
    	}
    }

    /**
     * Sets the value of the property m2MPocsReference.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setM2MPocsReference(String value) {
        this.m2MPocsReference = value;
    }

    /**
     * Gets the value of the property attachedDevicesReference.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAttachedDevicesReference() {
    	if (attachedDevicesReference == null && uri != null) {
    		return uri+Refs.ATTACHEDDEVICES_REF;
    	} else {
			return attachedDevicesReference;
    	}
    }

    /**
     * Sets the value of the property attachedDevicesReference.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAttachedDevicesReference(String value) {
        this.attachedDevicesReference = value;
    }

    /**
     * Gets the value of the property sclId.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSclId() {
        return sclId;
    }

    /**
     * Sets the value of the property sclId.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSclId(String value) {
        this.sclId = value;
    }

    @Override
    public String toString() {
        return "Scl [pocs=" + pocs + ", remTriggerAddr=" + remTriggerAddr
                + ", onlineStatus=" + onlineStatus + ", serverCapability="
                + serverCapability + ", link=" + link + ", schedule="
                + schedule + ", expirationTime=" + expirationTime
                + ", accessRightID=" + accessRightID + ", searchStrings="
                + searchStrings + ", creationTime=" + creationTime
                + ", lastModifiedTime=" + lastModifiedTime
                + ", locTargetDevice=" + locTargetDevice
                + ", mgmtProtocolType=" + mgmtProtocolType
                + ", integrityValResults=" + integrityValResults
                + ", aPocHandling=" + aPocHandling + ", containersReference="
                + containersReference + ", groupsReference=" + groupsReference
                + ", applicationsReference=" + applicationsReference
                + ", accessRightsReference=" + accessRightsReference
                + ", subscriptionsReference=" + subscriptionsReference
                + ", mgmtObjsReference=" + mgmtObjsReference
                + ", notificationChannelsReference="
                + notificationChannelsReference + ", m2MPocsReference="
                + m2MPocsReference + ", attachedDevicesReference="
                + attachedDevicesReference + ", sclId=" + sclId + ", uri="
                + uri + "]";
    }
}
