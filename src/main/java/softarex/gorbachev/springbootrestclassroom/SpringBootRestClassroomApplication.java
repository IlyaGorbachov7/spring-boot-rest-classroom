package softarex.gorbachev.springbootrestclassroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import static softarex.gorbachev.springbootrestclassroom.controllers.constants.UrlPath.*;

/**
 * Application entry point. Contains the main project configurations
 *
 * @author Gorabachev I. D.
 * @version 14.07.2022
 */
@SpringBootApplication
@EnableWebSocketMessageBroker
public class SpringBootRestClassroomApplication implements WebSocketMessageBrokerConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestClassroomApplication.class, args);
    }

    // Config Redis DB ------------------------------------------------------------------------------------------------

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // обекът этого класса будет создан первым
        RedisConnectionFactory redisConnectionFactory = new LettuceConnectionFactory();
        System.out.println("---------------------> S1" + redisConnectionFactory);
        return redisConnectionFactory;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactor() {
        // этот объект он создает,но не будет использовать так как обект такого класса уже создан
        RedisConnectionFactory redisConnectionFactory = new LettuceConnectionFactory();
        System.out.println("---------------------> S2" + redisConnectionFactory);
        return redisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        System.out.println("----------------------> result : " + redisConnectionFactory);
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate1(RedisConnectionFactory redisConnectionFactory) {
        System.out.println("----------------------> result : " + redisConnectionFactory);
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    //------------------------------------------------------------------------------------------------------------------
    // если убрать бин, тогда метод printStringBean выдаст ошибку,
    // так как окржение Spring ничего не знает об параметре метода : String s
    // Но если данный Bean есть, тогда Spring созадаст данный обеъкт и в любой теперь метод-bean или конструктор
    // может заабростить обеъкт
    @Bean
    public String toString() {
        return "Hi my friends";
    }

    // мы полуим строку Hi my friends
    @Bean
    public void printStringBean(String s) {
        System.out.println(s);
    }
    // Config WebSocket ------------------------------------------------------------------------------------------------

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(END_POINT).setAllowedOrigins(CROSS_ORIGIN).withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes(APPLICATION_DES_PREFIXES);
        registry.enableSimpleBroker(BROKER_DES_PREFIXES);
        registry.setUserDestinationPrefix(USER_DES_PREFIX);
    }
}
