package com.it.flink;

import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FlinkTes {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        List list = new LinkedList();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        list.add("test6");

        DataStream stream = env.addSource(new RichSource()).setParallelism(1);
        stream.map(new MapFunction() {
            @Override
            public Object map(Object o) throws Exception {
                Student s = new Student(Integer.parseInt(o.toString()),"Name"+Integer.parseInt(o.toString()),"age"+Integer.parseInt(o.toString()));
                return s;
            }
        }).keyBy(1);
        stream.print();
        env.execute("test job");
    }

}
class Student{
    int id;
    String name;
    String age;
    public Student(int id, String name, String age){
        this.id = id;
        this.name = name;
        this.age = age;


    }
}

