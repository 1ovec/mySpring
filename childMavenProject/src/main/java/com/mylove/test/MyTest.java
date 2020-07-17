package com.mylove.test;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MyTest {

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /*public static void main(String[] args) {
        boolean success = Boolean.parseBoolean(("z"));
        System.out.println(success);
    }*/

    public static void test1(List<Object> dataList){
        int pointsDataLimit = 9;
        List<Object> newList = new ArrayList<Object>();
        for(int i=1;i<dataList.size();i++){//分批次处理
            newList.add(dataList.get(i));

            if(pointsDataLimit == newList.size()||i == dataList.size()-1){

                printList(newList);
                newList.clear();
                System.out.println("");
                System.out.println("=====");

            }
        }
    }

   /* public static boolean zsx(float a){
        return (a!=a);
    }*/

    public static void printList(List<Object> dataList){
        for(Object str : dataList){
            System.out.print(str + " -- ");
        }
    }

    /**
     * jdk11版本下的网络连接通信
     * @param args 参数
     * @throws IOException 异常
     * @throws InterruptedException 异常
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // http://127.0.0.1:8011/integralCtr/changeIntegral
        // https://www.qq.com/
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(5))
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest.BodyPublisher requestBody = HttpRequest.BodyPublishers.ofString("{ 我是body }");
        HttpRequest postRequest = HttpRequest.newBuilder().POST(requestBody)
                .uri(URI.create("http://127.0.0.1:8011/integralCtr/changeIntegral"))
                .build();
        HttpResponse<String> response = client.send( postRequest, HttpResponse.BodyHandlers.ofString());
        String respnseBody = response.body();
        System.out.println(respnseBody);


       /* HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://127.0.0.1:8011/integralCtr/changeIntegral")).GET().build();
        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();
        HttpClient client = HttpClient.newHttpClient();
        CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, bodyHandler);
        future.thenApply(HttpResponse::body).thenAccept(System.out::println).join();*/
    }
}
