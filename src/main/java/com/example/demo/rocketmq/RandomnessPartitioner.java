package com.example.demo.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机策略
 * date：2021/6/17  上午8:50
 *如果要自定义分区策略，你需要显式地配置生产者端的参数partitioner.class= 全名称
 * @author xuyy
 */
@Slf4j
public class RandomnessPartitioner implements Partitioner {

    @Override
    public int partition(String topic, Object key, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        List<PartitionInfo> partitionInfos = cluster.partitionsForTopic(topic);
        int i = ThreadLocalRandom.current().nextInt(partitionInfos.size());
        log.info("一共有{}个分区，这次分配给{},topic :{}",partitionInfos.size(),i,topic);
        return ThreadLocalRandom.current().nextInt(partitionInfos.size());
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
