package com.rethinkux.dentistapp.models;

public class ServiceModel {
    private String tvServiceName;
    private String tvServiceCostSymbol;
    private String tvServiceCost;

    public String getTvServiceName() {
        return tvServiceName;
    }

    public void setTvServiceName(String tvServiceName) {
        this.tvServiceName = tvServiceName;
    }

    public String getTvServiceCostSymbol() {
        return tvServiceCostSymbol;
    }

    public void setTvServiceCostSymbol(String tvServiceCostSymbol) {
        this.tvServiceCostSymbol = tvServiceCostSymbol;
    }

    public String getTvServiceCost() {
        return tvServiceCost;
    }

    public void setTvServiceCost(String tvServiceCost) {
        this.tvServiceCost = tvServiceCost;
    }
}
