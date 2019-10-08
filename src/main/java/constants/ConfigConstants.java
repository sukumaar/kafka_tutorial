package constants;

public final class ConfigConstants {
    public static String BOOTSTRAP_SERVERS = "192.168.56.102:32772";
    public static String KEY_SER = "org.apache.kafka.common.serialization.StringSerializer";
    public static String VAL_SER = "org.apache.kafka.common.serialization.StringSerializer";
    public static String KEY_DESER = "org.apache.kafka.common.serialization.StringDeserializer";
    public static String VAL_DESER = "org.apache.kafka.common.serialization.StringDeserializer";
    public static String TOPIC = "test-topic";

    private ConfigConstants() {
    }
}
