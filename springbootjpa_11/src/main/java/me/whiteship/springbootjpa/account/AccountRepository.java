package me.whiteship.springbootjpa.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    //save한 값이 들어있는지 확인 가능
    //이거에 대한 실제 구현체를 스프링 데이터 jpa가 다 해줌
    Account findByUsername(String username);
}
