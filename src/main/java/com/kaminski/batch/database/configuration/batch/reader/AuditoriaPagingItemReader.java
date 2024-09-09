package com.kaminski.batch.database.configuration.batch.reader;

import com.kaminski.batch.database.configuration.mapper.AuditoriaMapper;
import com.kaminski.batch.database.domain.Auditoria;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@RequiredArgsConstructor
public class AuditoriaPagingItemReader {

    private final AuditoriaMapper mapper;

    /**
     *
     * @param dataSource
     * Realizando o uso o JdbcPaging, ideial para
     * consulta de grandes volumes.
     *
     * Perca de performance porem economiza o uso de memória.
     */
    @Bean
    public JdbcPagingItemReader<Auditoria> jdbcPagingItemReader(DataSource dataSource, PagingQueryProvider queryProvider){
        return new JdbcPagingItemReaderBuilder<Auditoria>()
                .name("jdbcPagingItemReader")
                .dataSource(dataSource)
                .queryProvider(queryProvider)
                .pageSize(2)
                .rowMapper(mapper.map())
                .build();
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider(DataSource dataSource){
        var queryProvider = new SqlPagingQueryProviderFactoryBean();
        queryProvider.setDataSource(dataSource);
        queryProvider.setSelectClause("select *");
        queryProvider.setFromClause("from auditoria");
        queryProvider.setSortKey("id");
        return queryProvider;
    }

}