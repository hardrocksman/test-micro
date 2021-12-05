package com.zhl.test.jmh;

import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Benchmark {

    public static void main(String[] args) throws Exception {
        // 使用一个单独进程执行测试，执行5遍warmup，然后执行5遍测试
        Options opt = new OptionsBuilder().include(Benchmark.class.getSimpleName()).forks(1).warmupIterations(5)
                .measurementIterations(5).build();
        new Runner(opt).run();
    }

    @Setup
    public void init() {

    }

    @TearDown
    public void down() {

    }

    @org.openjdk.jmh.annotations.Benchmark
    public void test() {

    }
}
