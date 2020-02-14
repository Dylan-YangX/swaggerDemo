package com.it.flink;

import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

import java.util.Random;

public class RichSource extends RichParallelSourceFunction<Double> {
    private boolean isRunning = true;
    @Override
    public void run(SourceContext<Double> sourceContext) throws Exception {
        int i = 10;
        while(isRunning){
            Random rand = new Random();
            double d = rand.nextGaussian();
            sourceContext.collect(i+d);
            Thread.sleep(1000);
        }
    }

    @Override
    public void cancel() {
        isRunning = false;
    }
}
