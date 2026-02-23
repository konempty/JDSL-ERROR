package kr.konempty.demo

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.orm.jpa.SharedEntityManagerCreator

@SpringBootApplication
class JdslErrorApplication {
    @Bean
    fun entityManager(entityManagerFactory: EntityManagerFactory): EntityManager =
        SharedEntityManagerCreator.createSharedEntityManager(entityManagerFactory)
}

fun main(args: Array<String>) {
    runApplication<JdslErrorApplication>(*args)
}
