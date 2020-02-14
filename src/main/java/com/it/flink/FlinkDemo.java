package com.it.flink;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkDemo {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<Long> dataStreamSource = env.addSource(new MySource());
        DataStream num= dataStreamSource.rebalance().map(new MapFunction<Long, Object>() {
            @Override
            public Object map(Long aLong) throws Exception {
                System.out.println(Thread.currentThread().getName()+"received data:"+aLong);
                return aLong;
            }
        }).setParallelism(4);
        env.execute("test");
    }

}
