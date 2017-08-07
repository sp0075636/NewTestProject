package entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VD00344479
 */
@XmlRootElement(name="prod")
public class Product implements Serializable {
    private String id;
    private String pname;
    private int price;
    private String createDate;
 

@XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
@XmlElement
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
@XmlElement
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @XmlElement
    public String getCreateDate() {
    		return createDate;
    	}

    	public void setCreateDate(String createDate) {
    		this.createDate = createDate;
    	} 
    
}
