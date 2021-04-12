package com.mo16.springaop.custom.aopproxy;

public interface LoggingProxy {

    void setBefore(Before before);
    void setAfter(After after);
}
