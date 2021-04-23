package com.test.micro.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.MQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.consumer.PullStatus;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;
import java.util.Set;

public class PullThread implements Runnable{

    private String topic;
    private MQPullConsumer consumer;
    private String tag;

    public PullThread(String topic, MQPullConsumer consumer, String tag) {
        this.consumer = consumer;
        this.topic = topic;
        this.tag = tag;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Set<MessageQueue> messageQueues = consumer.fetchSubscribeMessageQueues(topic);
                System.out.println("拉取到的队列数量" + messageQueues.size());
                for (MessageQueue queue : messageQueues) {
                    System.out.println("拉取到的队列:" + queue.getQueueId());
                }

                for (MessageQueue queue : messageQueues) {
                    System.out.println("遍历队列queue" + queue);

                    long offset = consumer.fetchConsumeOffset(queue, true);
                    System.out.println("consumer from the queue:" + queue + ":" + offset);

                    while (true) {
                        // 在队列中拉取不到消息会一直阻塞等待着，直到能拉取到消息
//                PullResult pullResult = consumer.pullBlockIfNotFound(queue, null, consumer.fetchConsumeOffset(queue, false), 1);

                        // 在队列中拉取不到消息就结束
                        PullResult pullResult = consumer.pull(queue, "*", consumer.fetchConsumeOffset(queue, false), 1);

                        consumer.updateConsumeOffset(queue, pullResult.getNextBeginOffset());

                        if (pullResult.getPullStatus().equals(PullStatus.FOUND)) {
                            List<MessageExt> messageExtList = pullResult.getMsgFoundList();
                            for (MessageExt m : messageExtList) {
                                System.out.println("拉取到数据====" + new String(m.getBody()));
                            }
                        } else if (pullResult.getPullStatus().equals(PullStatus.NO_MATCHED_MSG)) {
                            break;
                        } else if (pullResult.getPullStatus().equals(PullStatus.NO_NEW_MSG)) {
                            break;
                        } else if (pullResult.getPullStatus().equals(PullStatus.OFFSET_ILLEGAL)) {
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
