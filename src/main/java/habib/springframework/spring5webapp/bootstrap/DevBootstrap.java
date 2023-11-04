package habib.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import habib.springframework.spring5webapp.model1.Author;
import habib.springframework.spring5webapp.model1.Book;
import habib.springframework.spring5webapp.model1.Publisher;
import habib.springframework.spring5webapp.repositories.AuthorRepository;
import habib.springframework.spring5webapp.repositories.BookRepository;
import habib.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData() {

		// Eric
		Author eric = new Author("Eric", "Events");
		Publisher p1 = new Publisher("A", "B");
		Book ddd = new Book("Deomain  Driven Design", "1234", p1);
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		publisherRepository.save(p1);
		bookRepository.save(ddd);
		
		// Red
		Author red = new Author("Red", "Hat");
		Publisher p2 = new Publisher("C", "D");
		Book noEJB = new Book("J2EE Development without EJB", "1234", p2);
		red.getBooks().add(noEJB);
		
		authorRepository.save(red);
		publisherRepository.save(p2);
		bookRepository.save(noEJB);

	}

}
