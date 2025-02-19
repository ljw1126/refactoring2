package com.example.refactoring2.ch04;

public class Producer {
    private Province province;
    private int cost;
    private String name;
    private int production;

    public Producer(Province province, ProducerDto producerDto) {
        this(province, producerDto.cost(), producerDto.name(), Math.max(producerDto.production(), 0));
    }

    public Producer(Province province, int cost, String name, int production) {
        this.province = province;
        this.cost = cost;
        this.name = name;
        this.production = production;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public int getProduction() {
        return production;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setProduction(int amount) {
        int newProduction = Math.max(amount, 0);
        this.province.addTotalProduction(newProduction - this.production);
        this.production = newProduction;
    }
}
