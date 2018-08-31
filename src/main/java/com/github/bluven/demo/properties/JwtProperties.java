package com.github.bluven.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * 类 <code>JwtProperties</code>
 *
 * @author bluven
 * @since 5/16/18
 */

@ConfigurationProperties("app.jwt")
public class JwtProperties {
    private String secret;

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration expiration = Duration.ofHours(12);

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Duration getExpiration() {
        return expiration;
    }

    public void setExpiration(Duration expiration) {
        this.expiration = expiration;
    }
}
