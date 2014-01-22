//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.13 at 09:59:10 AM BRT 
//


package com.sensus.mlc.mlcserver.type;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProtectedStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProtectedStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="0"/>
 *     &lt;enumeration value="1"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProtectedStatus", namespace = "http://www.sensus.com/gateway/mlc/types")
@XmlEnum
public enum ProtectedStatus {

    @XmlEnumValue("0")
    UNPROTECTED("0"),
    @XmlEnumValue("1")
    PROTECTED("1");
    private final String value;

    ProtectedStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProtectedStatus fromValue(String v) {
        for (ProtectedStatus c: ProtectedStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
