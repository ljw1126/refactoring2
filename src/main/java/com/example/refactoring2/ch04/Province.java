package com.example.refactoring2.ch04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Province {
    private String name;
    private List<Producer> producers;
    private int totalProduction;
    private int demand;
    private int price;

    private Province(String name, List<Producer> producers, int totalProduction, int demand, int price) {
        this.name = name;
        this.producers = producers;
        this.totalProduction = totalProduction;
        this.demand = demand;
        this.price = price;
    }

    public static Province from(ProvinceData doc) {
        Province province = new Province(doc.name(), new ArrayList<>(), 0, doc.demand(), doc.price());
        for(ProducerDto producerDto: doc.producers()) {
            province.addProducer(new Producer(province, producerDto));
        }
        return province;
    }

    public void addProducer(Producer producer) {
        this.producers.add(producer);
        this.totalProduction += producer.getProduction();
    }

    public int shortFall() {
        return this.demand - this.totalProduction;
    }

    public int profit() {
        return this.demandValue() - this.demandCost();
    }

    private int demandValue() {
        return this.satisfiedDemand() * this.price;
    }

    private int satisfiedDemand() {
        return Math.min(this.demand, this.totalProduction);
    }

    private int demandCost() {
        int remainingDemand = this.demand;
        int result = 0;

        this.producers.sort(Comparator.comparingInt(Producer::getCost));

        for(Producer producer : this.producers) {
            int contribution = Math.min(remainingDemand, producer.getProduction());
            remainingDemand -= contribution;
            result += contribution * producer.getCost();
        }

        return result;
    }

    public String getName() {
        return name;
    }

    public List<Producer> getProducers() {
        return new ArrayList<>(producers);
    }

    public int getTotalProduction() {
        return totalProduction;
    }

    public int getDemand() {
        return demand;
    }

    public int getPrice() {
        return price;
    }

    public void setTotalProduction(int totalProduction) {
        this.totalProduction = totalProduction;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addTotalProduction(int value) {
        this.totalProduction += value;
    }
}
