package com.bytecode.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class CursoSprintApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${cursospring.jdbc.import.ruta}")
    private String ruta;

    @Value("${cursospring.jdbc.import}")
    private String importar;

    Log log = LogFactory.getLog(getClass());

    public CursoSprintApplication() {

    }

    public static void main(String[] args) {
        SpringApplication.run(CursoSprintApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //video 25 crea una ejecucion
        // jdbcTemplate.execute("insert into permiso (Nombre) values ('ejemplo')");

        if (importar.equalsIgnoreCase("true")) {
            //video 26 - Nos permite convertir un sql en un string validandolo para su ejecucion
            Path path = Paths.get(ruta);

            try (BufferedReader bufferedReader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) { //lee linea por linea del String
                    //log.info(line);
                    jdbcTemplate.execute(line);
                }
            } catch (IOException ex) {

            }
            log.info("////"+jdbcTemplate.queryForObject("select count(*) FROM blog.permiso;",Integer.class));
        }
    }
}
