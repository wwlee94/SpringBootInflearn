package me.whiteship.springboothdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

//H2SQL + MYSQL
/*
    MYSQL으로 사용하려면 해당 설정 해야함
    spring.datasource.url=jdbc:mysql://localhost:3306/springboot?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=gjlee7257
 */
/*
    POSTGRES으로 사용하려면 해당 설정 (docker로 만듬)
    spring.datasource.url=jdbc:postgresql://localhost:5432/springboot
    spring.datasource.username=wwlee94
    spring.datasource.password=wwlee94
 */
@Component
public class H2Runner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try(Connection connection = dataSource.getConnection()) {

            System.out.println(dataSource.getConnection());
            System.out.println(connection.getMetaData().getDriverName());
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE account(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (ID))";
            statement.executeUpdate(sql);
        }

        jdbcTemplate.execute("INSERT INTO account VALUES (2,'woowon')");
    }
}
