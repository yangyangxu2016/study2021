package com.example.demo.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * todo
 * date：2021/4/13  11:36 上午
 *
 * @author xuyy
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("please_rename_unique_group_name");
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        producer.start();
        producer.createTopic(null,"topic_2",8);
        //for (int i = 0; i < 100; i++) {
        //    Message message = new Message("topic_2","tag_2",
        //            ("Hello,World"+i).getBytes(RemotingHelper.DEFAULT_CHARSET));
        //    SendResult sendResult = producer.send(message);
        //    System.out.printf("%s%n",sendResult);
        //
        //}

        //Shut down once the producer instance is not longer in use.
        producer.shutdown();


    }
}
