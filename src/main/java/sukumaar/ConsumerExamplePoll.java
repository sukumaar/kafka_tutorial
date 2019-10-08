package sukumaar;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

import static constants.ConfigConstants.*;

public class ConsumerExamplePoll {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", KEY_DESER);
        props.put("value.deserializer", VAL_DESER);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(TOPIC));
        oneTimePoll(consumer, 10000l);
        //continuousPoll(consumer, 100l);
    }

    private static void continuousPoll(KafkaConsumer<String, String> consumer, Long time) {
        while (true) {
            oneTimePoll(consumer, time);
        }
    }

    private static void oneTimePoll(KafkaConsumer<String, String> consumer, Long time) {
        ConsumerRecords<String, String> records = consumer.poll(time);
        for (ConsumerRecord<String, String> record : records)
            System.out.printf("offset = %d, key = %s, value = %s %n", record.offset(), record.key(), record.value());
    }
}
