//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.13 at 09:59:10 AM BRT 
//


package com.sensus.mlc.mlcserver.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for AppCode85Info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppCode85Info">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sunriseOffset" type="{http://www.sensus.com/gateway/mlc/types}Integer"/>
 *         &lt;element name="sunsetOffset" type="{http://www.sensus.com/gateway/mlc/types}Integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppCode85Info", namespace = "http://www.sensus.com/gateway/mlc/types", propOrder = {
    "sunriseOffset",
    "sunsetOffset"
})
public class AppCode85Info {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    protected Integer sunriseOffset;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    protected Integer sunsetOffset;

    /**
     * Gets the value of the sunriseOffset property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getSunriseOffset() {
        return sunriseOffset;
    }

    /**
     * Sets the value of the sunriseOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSunriseOffset(Integer value) {
        this.sunriseOffset = value;
    }

    /**
     * Gets the value of the sunsetOffset property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getSunsetOffset() {
        return sunsetOffset;
    }

    /**
     * Sets the value of the sunsetOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSunsetOffset(Integer value) {
        this.sunsetOffset = value;
    }

}