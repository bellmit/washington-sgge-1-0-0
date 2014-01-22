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
 * <p>Java class for LightLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LightLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="0"/>
 *     &lt;enumeration value="1"/>
 *     &lt;enumeration value="2"/>
 *     &lt;enumeration value="3"/>
 *     &lt;enumeration value="4"/>
 *     &lt;enumeration value="5"/>
 *     &lt;enumeration value="6"/>
 *     &lt;enumeration value="7"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LightLevel", namespace = "http://www.sensus.com/gateway/mlc/types")
@XmlEnum
public enum LightLevel {

    @XmlEnumValue("0")
    LEVEL_0("0"),
    @XmlEnumValue("1")
    LEVEL_1("1"),
    @XmlEnumValue("2")
    LEVEL_2("2"),
    @XmlEnumValue("3")
    LEVEL_3("3"),
    @XmlEnumValue("4")
    LEVEL_4("4"),
    @XmlEnumValue("5")
    LEVEL_5("5"),
    @XmlEnumValue("6")
    LEVEL_6("6"),
    @XmlEnumValue("7")
    LEVEL_7("7");
    private final String value;

    LightLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LightLevel fromValue(String v) {
        for (LightLevel c: LightLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
