package org.trotro.model.stor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: jack
 * Date: 12/1/12
 * Time: 4:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Driver implements Serializable
{
    private static final long serialVersionUID = -6627284081982644215L;
    private String id;
    private String name;

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
