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
        return new LettuceConnectionFactory();
    }


    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
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
