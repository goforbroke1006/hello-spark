package me.goforbroke.helloSpark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        String logFile = "/opt/spark/README.md"; // Should be some file on your system

        SparkConf conf = new SparkConf().setAppName("Hello Spark Application")
                .setJars(new String[]{
                        "target/hello-spark-1.0-jar-with-dependencies.jar",
                })
                .setMaster("spark://127.0.0.1:7077")
                .set("spark.executor.memory", "512m")
                .set("spark.driver.memory", "512m")
                .set("spark.default.parallelism", "10")
                .set("spark.network.timeout", "600s");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> logData = sc.textFile(logFile).cache();

        JavaPairRDD countData = logData
                .flatMap(content -> Arrays.asList(content.split(" ")).iterator())
                .mapToPair(p -> new Tuple2<>(p, 1))
                .reduceByKey(Integer::sum);

        countData.foreach(data -> {
            System.out.println(data.toString());
        });

        sc.stop();
    }
}
