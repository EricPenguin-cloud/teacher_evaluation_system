package com.cqgcxy.client.bean;

import java.util.List;

public class EvaluateTable {
    private int id;
    private String name;
    private List<EvaluateCell> evaluate_item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EvaluateCell> getEvaluate_item() {
        return evaluate_item;
    }

    public void setEvaluate_item(List<EvaluateCell> evaluate_item) {
        this.evaluate_item = evaluate_item;
    }

    @Override
    public String toString() {
        return "EvaluateTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", evaluate_item=" + evaluate_item +
                '}';
    }
}
