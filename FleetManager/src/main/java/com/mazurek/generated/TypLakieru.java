//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.07 at 11:03:41 AM CEST 
//


package com.mazurek.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypLakieru complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypLakieru">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kolor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="czy_metalik" default="N">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;length value="1"/>
 *             &lt;enumeration value="T"/>
 *             &lt;enumeration value="N"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypLakieru", propOrder = {
    "kolor"
})
public class TypLakieru {

    @XmlElement(required = true)
    protected String kolor;
    @XmlAttribute(name = "czy_metalik")
    protected String czyMetalik;

    /**
     * Gets the value of the kolor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKolor() {
        return kolor;
    }

    /**
     * Sets the value of the kolor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKolor(String value) {
        this.kolor = value;
    }

    /**
     * Gets the value of the czyMetalik property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCzyMetalik() {
        if (czyMetalik == null) {
            return "N";
        } else {
            return czyMetalik;
        }
    }

    /**
     * Sets the value of the czyMetalik property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCzyMetalik(String value) {
        this.czyMetalik = value;
    }

}
