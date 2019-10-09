package com.thl.cleaner.model.Bean;

public class OrderGoodsBean {
    private String carriers_id;//携带物品id
    private String carriers_name;//携带物品名称
    private String number;//数量
    private String sum;//总价

    public String getCarriers_id() {
        return carriers_id;
    }

    public void setCarriers_id(String carriers_id) {
        this.carriers_id = carriers_id;
    }

    public String getCarriers_name() {
        return carriers_name;
    }

    public void setCarriers_name(String carriers_name) {
        this.carriers_name = carriers_name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
