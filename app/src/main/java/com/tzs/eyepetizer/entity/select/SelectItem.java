package com.tzs.eyepetizer.entity.select;

import java.io.Serializable;

/**
 * Created by h on 2016/12/29.
 */

public class SelectItem implements Serializable {
    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SelcteItem{" +
                "type='" + type + '\'' +
                '}';
    }
}
