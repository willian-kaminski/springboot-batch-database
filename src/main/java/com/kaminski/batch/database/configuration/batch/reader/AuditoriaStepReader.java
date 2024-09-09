package com.kaminski.batch.database.configuration.batch.reader;

import com.kaminski.batch.database.domain.Auditoria;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class AuditoriaStepReader {

    /**
     *
     * @param dataSource
     * Realizando o uso o JdbcCursor, funcional porem não
     * recomendado para o processamento de muitos dados.
     */
    @Bean
    public JdbcCursorItemReader<Auditoria> jdbcCursorItemReader(DataSource dataSource){
        return new JdbcCursorItemReaderBuilder()
                .name("jdbcCursorItemReader")
                .dataSource(dataSource)
                .sql("select * from auditoria")
                .rowMapper(new BeanPropertyRowMapper<>(Auditoria.class))
                .build();
    }

}