//package com.example.demo.thread;
//
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import javax.annotation.Resource;
//
///**
// * todo
// * date：2021/12/18  12:04 下午
// *
// * @author xuyy
// */
//@RestController
//public class ConsumerController {
//
//    @Resource
//    private RestTemplate restTemplate;
//
//    @Resource
//    private LoadBalancerClient loadBalancerClient;
//
//    @GetMapping("index")
//    public String getIndex(){
//        ServiceInstance serviceInstance = loadBalancerClient.choose("");
//        String ip = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//        return restTemplate.getForObject("http://" + ip + ":" + port, String.class,"");
//    }
//
//
//}
