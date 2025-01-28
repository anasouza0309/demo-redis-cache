package com.example.redis.cache.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.time.Duration;

@Configuration
public class RedisConfiguration {

    public RedisConnectionFactory letuceConnectionFactory() {
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration
                ("server", 6379));
    }

    RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        RedisCacheConfiguration defaults = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(3));
     
        return RedisCacheManager.builder(connectionFactory).cacheDefaults(defaults).build();

    }

}
