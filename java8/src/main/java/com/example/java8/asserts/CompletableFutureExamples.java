package com.example.java8.asserts;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;

import java.util.HashMap;
import java.util.concurrent.*;

@Slf4j
public class CompletableFutureExamples {

    public static void main(String[] args) throws Exception {
        executeService();
        thenCombine1();
    }

    public static void thenCombine1() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return "abc";
        });

        CompletableFuture<String> f = future.thenCombine(future2, (x, y) -> y + "-" + x);
    }

    public static void executeService() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        long start = System.currentTimeMillis();
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + RandomUtils.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "商品详情+";
        }, executorService);

        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "卖家信息+";
        }, executorService);

        CompletableFuture<String> futureC = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "库存信息+";
        }, executorService);

        CompletableFuture<String> futureD = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "订单信息+";
        }, executorService);


        log.info("第一次时间是【{}】", String.valueOf(System.currentTimeMillis()));
        CompletableFuture.allOf(futureA, futureB).join();
//        System.out.println(futureA.get() + futureB.get());

        CompletableFuture.allOf(futureC, futureD).join();

        log.info("第二次时间是【{}】", String.valueOf(System.currentTimeMillis()));
//        System.out.println(futureC.join() + futureD.join());
        System.out.println("总耗时:" + (System.currentTimeMillis() - start));
    }

    public static void test6() throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        });

        CompletableFuture combinedFuture = CompletableFuture.allOf(future1, future2);
        System.out.println(combinedFuture.get()); // Hello
    }


    public static void allOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }
            return "hello";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);
        System.out.println(combinedFuture.get()); // Hello
    }

    public static void putMap() {
        HashMap<String, Integer> dummyValues = new HashMap<>();
        dummyValues.put("One", 1);
        dummyValues.put("Two", 2);
        dummyValues.put("Three", 3);
        dummyValues.forEach((key, value) -> System.out.println(key + "-" + value));
    }

    public static void doSomeThing() {
        Long startTime = System.currentTimeMillis();
        thenCombine();
        Long endTime = System.currentTimeMillis();
        Long tempTime = (endTime - startTime);
        System.out.println("花费时间：" +
                (((tempTime / 86400000) > 0) ? ((tempTime / 86400000) + "d") : "") +
                ((((tempTime / 86400000) > 0) || ((tempTime % 86400000 / 3600000) > 0)) ? ((tempTime % 86400000 / 3600000) + "h") : ("")) +
                ((((tempTime / 3600000) > 0) || ((tempTime % 3600000 / 60000) > 0)) ? ((tempTime % 3600000 / 60000) + "m") : ("")) +
                ((((tempTime / 60000) > 0) || ((tempTime % 60000 / 1000) > 0)) ? ((tempTime % 60000 / 1000) + "s") : ("")) +
                ((tempTime % 1000) + "ms"));
    }

    public static void thenCombine() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> s1 + " " + s2).join();
        System.out.println(result);
    }
}
