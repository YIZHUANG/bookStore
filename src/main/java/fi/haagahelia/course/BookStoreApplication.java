package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;
import fi.haagahelia.course.domain.Department;
import fi.haagahelia.course.domain.DepartmentRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository,DepartmentRepository drepository) {
		return (args) -> {
			log.info("save a couple of students");
			drepository.save(new Department("IT"));
			drepository.save(new Department("Law"));
			drepository.save(new Department("Music"));
			
			
			repository.save(new Book("Who wants to live forever","Danial",2012,"78945-78",250,drepository.findByName("IT").get(0)));
			repository.save(new Book("My Life","John",2015,"12345-12",180,drepository.findByName("Law").get(0)));
			
			log.info("fetch all students");
			for (Book books : repository.findAll()) {
				log.info(books.toString());
			}

		};
	}
}
