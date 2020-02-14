package com.it.flink;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

public class MySource implements SourceFunction<Long> {
    private boolean isRunning=true;
    private long count =0l;
    @Override
    public void run(SourceContext<Long> sourceContext) throws Exception {
        while(isRunning){
            sourceContext.collect(count);
            count++;
            Thread.sleep(1000);
        }
    }

    @Override
    public void cancel() {
        isRunning=false;
    }
}
