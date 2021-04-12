package com.mo16.springaop.custom.aopproxy;


public class Test {
    /*
    * the FakeBeanFactory is responsible of initiating a Customer and enveloping it with a LoggingProxy.
    */
    public static void main(String[] args) {
        FakeBeanFactory factory = new FakeBeanFactory();
        Customer customer = factory.getBean(Customer.class);
        customer.pay();
    }
}
