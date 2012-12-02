package org.trotro.model.stor;

import java.io.Serializable;
/**
 * Created with IntelliJ IDEA.
 * User: jack
 * Date: 12/1/12
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class City implements Serializable
{
    private static final long serialVersionUID = 5448969066016576906L;
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
