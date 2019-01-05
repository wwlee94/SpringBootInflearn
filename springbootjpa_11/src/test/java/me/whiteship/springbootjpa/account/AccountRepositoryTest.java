package me.whiteship.springbootjpa.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest //-> 자동으로 h2를 인메모리 데이터베이스로 설정이됨 현재 설정된 DB postgresql이 아니라!!
//@SpringbootTest도 가능한데 얘는 슬라이싱 테스트가 아니라서 테스트가 오래걸림
public class AccountRepositoryTest {

    //모두 DataJpaTest 덕분에 빈으로 받을 수 있음
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() throws SQLException {
        //DB 정보 가져오기
        try(Connection connection = dataSource.getConnection()){
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            System.out.println(databaseMetaData.getURL());
            System.out.println(databaseMetaData.getDriverName());
            System.out.println(databaseMetaData.getUserName());
        }
        //TEST
        Account account = new Account();
        account.setUsername("keesun");
        account.setPassword("pass");

        //keesun,pass값을 넣은 객체를 저장해서 객체로 다시 받아옴
        Account newAccount = accountRepository.save(account);
        assertThat(newAccount).isNotNull();

        Account existingAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(existingAccount).isNotNull();

        Account nonExistingAccount = accountRepository.findByUsername("whiteship");
        assertThat(nonExistingAccount).isNull();

    }

}