package com.kaminski.batch.database.configuration.batch.writer;

import com.kaminski.batch.database.domain.Auditoria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuditoriaItemWriter {

    @Bean
    public ItemWriter<Auditoria> jdbcCursorWriter() {
        return clientes -> clientes.forEach(cliente -> {
            log.info(">>> " + cliente.toString());
        });
    }
}
