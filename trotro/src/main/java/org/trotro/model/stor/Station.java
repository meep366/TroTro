package org.trotro.model.stor;

import java.io.Serializable;
/**
 * Created with IntelliJ IDEA.
 * User: jack
 * Date: 12/1/12
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Station implements Serializable {

    private static final long serialVersionUID = 3397032139224297795L;
    private String id;
    private String name;
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
