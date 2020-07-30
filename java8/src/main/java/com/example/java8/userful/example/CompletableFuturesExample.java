package com.example.java8.userful.example;

import java.util.concurrent.CompletableFuture;

public class CompletableFuturesExample {

    public static void main(String[] args) throws InterruptedException {
        thenApply();
//        thenAccept();
//        thenRun();
//        thenCombine();
//        thenAcceptBoth();
//        runAfterBoth();
//        applyToEither();
        anyOf();
    }

//    public static <T> void testCompletableFuture(List<T> list) {
//
//        //  四、CompletableFuture API
//        /*
//         * Returns a new CompletableFuture that is asynchronously completed by a task
//         * running in the given executor with the value obtained by calling the given Supplier.
//         */
//        CompletableFuture.supplyAsync(list.stream().mapToInt(Integer::intValue)::sum, System.out::println);
//
//
//        Optional.of(CompletableFuture.supplyAsync(list.stream().mapToInt(Integer::intValue)::sum)
//                .complete(55)).ifPresent(System.out::println);
//
//        //  thenAccept 无返回值  Consumer<? super T> action
//        CompletableFuture.supplyAsync(list.stream().mapToInt(Integer::intValue)::sum)
//                .thenAccept(System.out::println);
//
//        //  thenApply  有返回值  Function<? super T,? extends U> fn
//        CompletableFuture.supplyAsync(() -> list.stream().mapToInt(Integer::intValue))
//                .thenApply(IntStream::sum).thenAccept(System.out::println);
//
//        //  对元素及异常进行处理  BiFunction<? super T, Throwable, ? extends U> fn
//        CompletableFuture.supplyAsync(() -> list.stream().mapToInt(Integer::intValue))
//                .handle((i, throwable) -> "handle：\t" + i.sum()).thenAccept(System.out::println);
//
//        //  whenCompleteAsync 完成时执行 BiConsumer<? super T, ? super Throwable> action
//        CompletableFuture.supplyAsync(list.stream().mapToInt(Integer::intValue)::sum)
//                .whenCompleteAsync((value, throwable) -> System.out.println("whenCompleteAsync：\t" + value));
//
//        //   组合CompletableFuture 将前一个结果作为后一个输入参数 （参照 组合设计模式）
//        CompletableFuture.supplyAsync(() -> list.stream().mapToInt(Integer::intValue))
//                .thenCompose(i -> CompletableFuture.supplyAsync(i::sum)).thenAccept(System.out::println);
//
//        //   合并CompletableFuture
//        CompletableFuture.supplyAsync(list.stream().mapToInt(Integer::intValue)::sum)
//                .thenCombine(CompletableFuture.supplyAsync(() -> list.stream()
//                        .mapToDouble(Double::valueOf).sum()), Double::sum).thenAccept(System.out::println);
//
//        //   合并CompletableFuture
//        CompletableFuture.supplyAsync(list.stream().mapToInt(Integer::intValue)::sum)
//                .thenAcceptBoth(CompletableFuture.supplyAsync(list.stream()
//                                .mapToDouble(Double::valueOf)::sum),
//                        (r1, r2) -> System.out.println("thenAcceptBoth：\t" + r1 + "\t" + r2));
//
//        //  2个CompletableFuture运行完毕后运行Runnable
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName() + "\tis running");
//            return list.stream().mapToInt(Integer::intValue).sum();
//        })
//                .runAfterBoth(
//                        CompletableFuture.supplyAsync(() -> {
//                            System.out.println(Thread.currentThread().getName() + "\tis running");
//                            return list.stream().mapToDouble(Double::valueOf).sum();
//                        }),
//                        () -> System.out.println("The 2 method have done"));
//
//
//        //  2个CompletableFuture 有一个运行完就执行Runnable
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println(Thread.currentThread().getName() + "\tis running");
//            return list.stream().mapToInt(Integer::intValue).sum();
//        })
//                .runAfterEither(
//                        CompletableFuture.supplyAsync(() -> {
//                            System.out.println(Thread.currentThread().getName() + "\tis running");
//                            return list.stream().mapToDouble(Double::valueOf).sum();
//                        }),
//                        () -> System.out.println("The 2 method have done"));
//
//
//        //  2个CompletableFuture 有一个运行完就执行Function<? super T, U> fn
//        CompletableFuture.supplyAsync(
//                list.stream().mapToInt(Integer::intValue).max()::getAsInt)
//                .applyToEither(
//                        CompletableFuture.supplyAsync(list.stream().mapToInt(Integer::intValue).min()::getAsInt)
//                        , v -> v * 10)
//                .thenAccept(System.out::println);
//
//        //  2个CompletableFuture 有一个运行完就执行Consumer<? super T> action
//        CompletableFuture.supplyAsync(
//                list.stream().mapToInt(Integer::intValue).max()::getAsInt)
//                .acceptEither(
//                        CompletableFuture.supplyAsync(list.stream().mapToInt(Integer::intValue).min()::getAsInt)
//                        , System.out::println);
//
//        //  将集合中每一个元素都映射成为CompletableFuture<Integer>对象
//        List<CompletableFuture<Integer>> collect =
//                list.stream().map(i -> CompletableFuture.supplyAsync(i::intValue))
//                        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        //  集合转数组
//        CompletableFuture[] completableFutures = collect.toArray(CompletableFuture[]::new);
//
//        //  有一个task执行完毕
//        CompletableFuture.anyOf(completableFutures)
//                .thenRun(() -> System.out.println("有一个task执行完毕--->first done"));
//        //  有且仅有所有task执行完毕
//        CompletableFuture.allOf(completableFutures)
//                .thenRun(() -> System.out.println("有且仅有所有task执行完毕--->done"));
//
//    }

    /** hello world */
    public static void thenApply() {
        String result = CompletableFuture.supplyAsync(() -> "hello").thenApply(s -> s + " world").join();
        System.out.println(result);
    }

    /** hello world */
    public static void thenAccept(){
        CompletableFuture.supplyAsync(() -> "hello").thenAccept(s -> System.out.println(s+" world"));
    }

    /** hello world */
    public static void thenRun(){
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenRun(() -> System.out.println("hello world"));
        while (true){}
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

    public static void thenAcceptBoth() {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        }), (s1, s2) -> System.out.println(s1 + " " + s2));
        while (true){}
    }

    /**在两个任务运行完执行*/
    public static void runAfterBoth(){
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).runAfterBothAsync(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s2";
        }), () -> System.out.println("hello world"));
        while (true){}
    }

    /**谁计算的快就用谁*/
    public static void applyToEither() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello world";
        }), s -> s).join();
        System.out.println(result);
    }

    /**谁计算的快就用谁*/
    public void acceptEither() {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).acceptEither(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello world";
        }), System.out::println);
        while (true){}
    }

    /**两个任务 任何一个完成了在执行下一步操作*/
    public void runAfterEither() {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).runAfterEither(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s2";
        }), () -> System.out.println("hello world"));
        while (true) {
        }
    }

    /**任务出错可以解决*/
    public void exceptionally() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "hello world";
        }).join();
        System.out.println(result);
    }

    /**运行完成对结果的记录*/
    public void whenComplete() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).whenComplete((s, t) -> {
            System.out.println(s);
            System.out.println(t.getMessage());
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "hello world";
        }).join();
        System.out.println(result);
    }

    /**运行结束后对结果的处理，一种是正常执行，返回值。另外一种是遇到异常抛出造成程序的中断。*/
    /**出现异常*/
    public void handle1() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //出现异常
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).handle((s, t) -> {
            if (t != null) {
                return "hello world";
            }
            return s;
        }).join();
        System.out.println(result);
    }

    /**未出现异常*/
    public void handle2() {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).handle((s, t) -> {
            if (t != null) {
                return "hello world";
            }
            return s;
        }).join();
        System.out.println(result);
    }

    public static void anyOf() throws InterruptedException {
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://money.163.com/code/");
        });
        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
        });
        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://money.163.com/price/");
        });
        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

        // 最终结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });

        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
