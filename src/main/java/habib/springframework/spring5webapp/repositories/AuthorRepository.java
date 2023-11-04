package habib.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import habib.springframework.spring5webapp.model1.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
