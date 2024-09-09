package com.kaminski.batch.database.configuration.mapper;

import com.kaminski.batch.database.domain.Auditoria;
import com.kaminski.batch.database.exception.AuditoriaException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;


@Component
public class AuditoriaMapper {

    public RowMapper<Auditoria> map(){
        return new RowMapper<Auditoria>() {
            @Override
            public Auditoria mapRow(ResultSet rs, int rowNum) throws SQLException {

                if(rs.getInt("id") == 2)
                    throw new AuditoriaException("Falha de processamento.");

                return auditoriaRowMapper(rs);

            }

            private Auditoria auditoriaRowMapper(ResultSet rs) throws SQLException{
                var auditoria = new Auditoria();
                auditoria.setId(rs.getInt("id"));
                auditoria.setNome(rs.getString("nome"));
                auditoria.setDataHora(rs.getObject("dataHora", LocalDateTime.class));
                return auditoria;
            }
        };
    }
}
