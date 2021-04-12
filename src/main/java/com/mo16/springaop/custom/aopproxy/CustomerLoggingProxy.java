package com.mo16.springaop.custom.aopproxy;


public class CustomerLoggingProxy extends Customer implements LoggingProxy {
    private Before before = () -> {};
    private After after = () -> {};

    @Override
    public void pay() {
        before.doBefore();
        super.pay();
        after.doAfter();
    }

    public void setBefore(Before before) {
        this.before = before;
    }

    public void setAfter(After after) {
        this.after = after;
    }
}
