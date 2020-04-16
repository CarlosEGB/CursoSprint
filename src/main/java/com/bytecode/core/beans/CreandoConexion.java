package com.bytecode.core.beans;

import com.bytecode.core.model.Conexion;
import com.bytecode.core.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class CreandoConexion {

    @Bean(name = "beanUsuarios")
    public Usuario getUsuario() {
        return new Usuario();
    }

    @Bean(name = "beanConexion")
    public Conexion getConexion() {
        Conexion conexion = new Conexion();
        conexion.setDb("mySql");
        conexion.setUrl("localhost");
        return conexion;
    }

    @Bean
    public DataSource getDataSource() {
        String zonaHoraria = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/blog" + zonaHoraria);
        dataSource.setUsername("fausto");
        dataSource.setPassword("fausto");
        return dataSource;
    }
}
