package me.whiteship.springbootredis.account;

import org.springframework.data.repository.CrudRepository;

//spring data 중 최상위 기본이 되는 repository 타입
public interface AccountRepository extends CrudRepository<Account, String> {


}
