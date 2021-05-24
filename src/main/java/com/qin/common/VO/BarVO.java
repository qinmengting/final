package com.qin.common.VO;

import java.util.List;

public class BarVO {
    private List<String> names;
    private List<Integer> values;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "BarVO{" +
                "names=" + names +
                ", values=" + values +
                '}';
    }
}
