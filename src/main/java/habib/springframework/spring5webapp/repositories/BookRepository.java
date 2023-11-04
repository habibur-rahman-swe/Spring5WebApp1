package habib.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import habib.springframework.spring5webapp.model1.Book;

public interface BookRepository extends  CrudRepository<Book, Long>{

}
