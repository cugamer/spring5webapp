package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Jones");
        Book ddd = new Book("Domain Driven Design", "1234567");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        
        Author rob = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "2134564");
        rob.getBooks().add(noEJB);
        noEJB.getAuthors().add(rob);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        authorRepository.save(rob);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Humber of books: " + bookRepository.count());
    }

}