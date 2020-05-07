package entities;

import java.io.Serializable;

/**
 * @author wsq
 * @version 1.0
 * @date 2020/5/6 9:03
 */
public class Product implements Serializable {
private  Long pid;

private  String productName;
private  String dbSource;
 public Product(String productName) { this.productName = productName;   }

    public Product(Long pid, String productName, String dbSource) {
        this.pid = pid;
        this.productName = productName;
        this.dbSource = dbSource;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}
