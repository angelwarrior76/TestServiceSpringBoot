package com.homework.spring.service.test;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;

import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V9_6;

/**
 * Created by Alex on 04.05.2018.
 */
@Configuration
@SpringBootApplication
public class TestServiceSpringBootApplication {

    public static void main(String[] args) throws IOException, SQLException {
        // starting Postgres
        final EmbeddedPostgres postgres = new EmbeddedPostgres(V9_6);
        // predefined data directory
        // final EmbeddedPostgres postgres = new EmbeddedPostgres(V9_6, "/path/to/predefined/data/directory");
        final String url = postgres.start("127.0.0.1", 5432, "rates", "pguser", "pguser");
        // connecting to a running Postgres and feeding up the database
        final Connection con = DriverManager.getConnection(url);
        con.createStatement().execute("create table currencies (\n" +
                "  code                 INT4                 not null,\n" +
                "  mnemonics            CHAR(3)              not null,\n" +
                "  description          VARCHAR(35)          null,\n" +
                "  constraint PK_CURRENCIES primary key (code)\n" +
                ");");
        con.createStatement().execute("create  index MNEMONICS_IND on currencies (\n" +
                "  mnemonics\n" +
                ");");
        con.createStatement().execute("create table rates (\n" +
                "  cdate                INT8                 not null,\n" +
                "  code                 INT4                 not null,\n" +
                "  buy                  DECIMAL(15,5)        not null,\n" +
                "  sell                 DECIMAL(15,5)        not null,\n" +
                "  constraint PK_RATES primary key (cdate, code)\n" +
                ");");
        con.createStatement().execute("alter table rates\n" +
                "  add constraint FK_RATES_FK_RATES__CURRENCI foreign key (code)\n" +
                "references currencies (code)\n" +
                "on delete restrict on update restrict;");
        con.createStatement().execute("insert into currencies (code, mnemonics, description) values (840, 'USD', 'Доллар');");
        con.createStatement().execute("insert into currencies (code, mnemonics, description) values (978, 'EUR', 'Евро');");
        SpringApplication.run(TestServiceSpringBootApplication.class, args);
    }

}
