package mao;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import mao.tools.RabbitMQ;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * Project name(项目名称)：rabbitMQ交换机之Direct交换机
 * Package(包名): mao
 * Class(类名): Producer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/22
 * Time(创建时间)： 22:00
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Producer
{
    private static final String EXCHANGE_NAME = "direct_exchange";

    public static void main(String[] args) throws IOException, TimeoutException
    {
        Channel channel = RabbitMQ.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        channel.basicPublish(EXCHANGE_NAME, "k1", null, "你好，消费者1".getBytes(StandardCharsets.UTF_8));
        channel.basicPublish(EXCHANGE_NAME, "k2", null, "你好，消费者2".getBytes(StandardCharsets.UTF_8));
        channel.basicPublish(EXCHANGE_NAME, "k3", null, "你好，消费者3".getBytes(StandardCharsets.UTF_8));
        channel.basicPublish(EXCHANGE_NAME, "k1", null, "给消费者1的通知：...".getBytes(StandardCharsets.UTF_8));
        channel.basicPublish(EXCHANGE_NAME, "k3", null, "给消费者3的通知：...".getBytes(StandardCharsets.UTF_8));
    }
}
