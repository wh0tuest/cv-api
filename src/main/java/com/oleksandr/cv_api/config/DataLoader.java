package com.oleksandr.cv_api.config;

import com.oleksandr.cv_api.model.Project;
import com.oleksandr.cv_api.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

import javax.swing.Spring;
import javax.xml.crypto.Data;

@Component 
public class DataLoader implements CommandLineRunner {
    private final ProjectRepository projectRepository;

    public DataLoader(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) {
        Project nba = new Project("https://github.com/wh0tuest/nba-team-players-management", 1, List.of("Java", "Spring Boot", "Hibernate", "JPA", "Oracle", "REST API"));
 
        nba.addTranslation("en", "NBA Team & Players Management System", "Backend application for managing NBA teams and players, built with Java, Spring Boot, Hibernate/JPA and Oracle. The system provides a REST API for creating, updating, retrieving and deleting teams and players, with relational database mapping and persistent data storage. The project demonstrates practical experience with backend architecture, REST API design, ORM, SQL and database relationships.");
        nba.addTranslation("pl", "NBA Team & Players Management System", "Aplikacja backendowa do zarządzania drużynami i zawodnikami NBA, stworzona w oparciu o Java, Spring Boot, Hibernate/JPA oraz Oracle. System udostępnia REST API umożliwiające tworzenie, aktualizowanie, pobieranie i usuwanie drużyn oraz zawodników. Projekt wykorzystuje mapowanie relacyjnych danych i zapewnia ich trwałe przechowywanie w bazie danych. Demonstruje praktyczne umiejętności w zakresie architektury backendowej, projektowania REST API, ORM, SQL oraz relacji między tabelami w bazie danych.");
        nba.addTranslation("uk", "NBA Team & Players Management System", "Backend-застосунок для управління командами та гравцями NBA, створений за допомогою Java, Spring Boot, Hibernate/JPA та Oracle. Система надає REST API для створення, оновлення, отримання та видалення команд і гравців. Проєкт використовує реляційне відображення даних і забезпечує їх постійне зберігання в базі даних. Він демонструє практичні навички в розробці backend-архітектури, проєктуванні REST API, роботі з ORM, SQL і зв’язками між таблицями бази даних.");
    
        projectRepository.save(nba);
    
        Project cvSAP = new Project("https://github.com/wh0tuest/cv-api", 2, List.of("Java", "Spring Boot", "Spring Data JPA", "Hibernate", "PostgreSQL", "Docker", "JUnit", "Mockito", "REST API", "JavaScript", "HTML", "CSS"));
        cvSAP.addTranslation("en", "Portfolio Website & CV API", "A full-stack portfolio project combining a personal website with a custom backend service. The website is built with HTML, CSS and JavaScript and hosted on GitHub Pages, while the Spring Boot REST API serves CV content in three languages (English, Polish and Ukrainian) and handles messages from a validated contact form. The backend follows a layered architecture (controller, service, repository, DTO), stores multilingual content in PostgreSQL using JPA entities with one-to-many relationships, and is covered by unit and integration tests. The application is containerized with Docker and deployed to the cloud. The project demonstrates practical experience with REST API design, ORM, data modeling, testing and end-to-end development from database to user interface.");
        cvSAP.addTranslation("pl", "Portfolio Website & CV API",  "Pełnostackowy projekt portfolio łączący stronę internetową z własnym serwisem backendowym. Strona została zbudowana przy użyciu HTML, CSS i JavaScript oraz opublikowana na GitHub Pages. Backend oparty na Spring Boot udostępnia REST API, które dostarcza treści CV w trzech językach (angielskim, polskim i ukraińskim) oraz obsługuje wiadomości z formularza kontaktowego z walidacją danych. Backend wykorzystuje architekturę warstwową (controller, service, repository, DTO). Wielojęzyczne treści są przechowywane w bazie PostgreSQL z wykorzystaniem encji JPA i relacji jeden-do-wielu. Projekt obejmuje testy jednostkowe i integracyjne. Aplikacja została skonteneryzowana przy użyciu Dockera i wdrożona w chmurze. Projekt demonstruje praktyczne umiejętności w zakresie projektowania REST API, ORM, modelowania danych, testowania oraz kompleksowego tworzenia aplikacji — od bazy danych po interfejs użytkownika.");
        cvSAP.addTranslation("uk", "Portfolio Website & CV API", "Full-stack проєкт портфоліо, що поєднує персональний вебсайт із власним backend-сервісом. Сайт створений за допомогою HTML, CSS і JavaScript та розміщений на GitHub Pages. Backend на базі Spring Boot надає REST API, який забезпечує доступ до вмісту CV трьома мовами (англійською, польською та українською), а також обробляє повідомлення з контактної форми з валідацією даних. Backend використовує багаторівневу архітектуру (controller, service, repository, DTO). Багатомовний контент зберігається в базі даних PostgreSQL із використанням JPA-сутностей і зв’язків «один до багатьох». Проєкт охоплює модульні та інтеграційні тести. Застосунок контейнеризовано за допомогою Docker і розгорнуто в хмарі. Проєкт демонструє практичні навички проєктування REST API, роботи з ORM, моделювання даних, тестування та повного циклу розробки застосунку — від бази даних до користувацького інтерфейсу.");

        projectRepository.save(cvSAP);

        Project cvReact = new Project("https://github.com/wh0tuest/BasketHub", 3, List.of("Node.js", "Express.js", "JavaScript", "JWT", "REST API", "HTML", "CSS"));

        cvReact.addTranslation("en", "PJATK Sports Hub", "A basketball-focused web application designed to combine backend services, user authentication and interactive functionality in one platform. Built with a focus on clean application structure, API communication and secure authentication using Node.js, Express and JWT. The project demonstrates experience with backend development, REST APIs, authentication and full-stack application architecture.");
        cvReact.addTranslation("pl", "PJATK Sports Hub", "Aplikacja internetowa poświęcona koszykówce, łącząca usługi backendowe, uwierzytelnianie użytkowników i interaktywne funkcjonalności w jednej platformie. Projekt został zbudowany z wykorzystaniem Node.js i Express, ze szczególnym naciskiem na przejrzystą strukturę aplikacji, komunikację za pośrednictwem API oraz bezpieczne uwierzytelnianie z użyciem JWT. Projekt demonstruje praktyczne umiejętności w zakresie tworzenia backendu, projektowania REST API, uwierzytelniania użytkowników oraz architektury aplikacji full-stack.");
        cvReact.addTranslation("uk", "PJATK Sports Hub", "Вебзастосунок, присвячений баскетболу, який поєднує backend-сервіси, автентифікацію користувачів та інтерактивний функціонал в одній платформі. Проєкт створений за допомогою Node.js і Express з акцентом на чітку структуру застосунку, взаємодію через API та безпечну автентифікацію з використанням JWT. Проєкт демонструє практичні навички розробки backend-сервісів, проєктування REST API, автентифікації користувачів та побудови архітектури full-stack застосунків.");
        projectRepository.save(cvReact);

    }
}