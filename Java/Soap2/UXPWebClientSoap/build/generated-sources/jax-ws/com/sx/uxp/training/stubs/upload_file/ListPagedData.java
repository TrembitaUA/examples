
package com.sx.uxp.training.stubs.upload_file;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listPagedData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listPagedData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fromIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rowsCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listPagedData", propOrder = {
    "fromIndex",
    "rowsCount"
})
public class ListPagedData {

    protected int fromIndex;
    protected int rowsCount;

    /**
     * Gets the value of the fromIndex property.
     * 
     */
    public int getFromIndex() {
        return fromIndex;
    }

    /**
     * Sets the value of the fromIndex property.
     * 
     */
    public void setFromIndex(int value) {
        this.fromIndex = value;
    }

    /**
     * Gets the value of the rowsCount property.
     * 
     */
    public int getRowsCount() {
        return rowsCount;
    }

    /**
     * Sets the value of the rowsCount property.
     * 
     */
    public void setRowsCount(int value) {
        this.rowsCount = value;
    }

}
