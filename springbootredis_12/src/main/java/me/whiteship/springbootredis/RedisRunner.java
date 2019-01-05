package me.whiteship.springbootredis;

import me.whiteship.springbootredis.account.Account;
import me.whiteship.springbootredis.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String,String> values= stringRedisTemplate.opsForValue();
        values.set("keesun","whiteship");
        values.set("springboot","2.0");
        values.set("hello","world");

        Account account = new Account();
        account.setUsername("woowon");
        account.setEmail("wwlee94@naver.com");

        accountRepository.save(account);

        Optional<Account> findAccount = accountRepository.findById(account.getId());
        System.out.println(findAccount.get().getUsername());
        System.out.println(findAccount.get().getEmail());
    }
}
