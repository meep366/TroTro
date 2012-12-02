package org.trotro.model.stor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: jack
 * Date: 12/1/12
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Trip implements Serializable {

    private static final long serialVersionUID = -5910012719647715764L;
    private String id;
    private Driver driver;
    private City city;
    private Station station;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

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
}
