package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author : root
 * @created : 22/07/2023, Saturday
 * @Description:
 **/
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        UUID uuid = UUID.randomUUID();
        Book book = new Book();
        book.setId(uuid.getLeastSignificantBits());
        book.setTitle("Domain Driven Design");
        book.setIsbn("001");
        book.setPublisher(new Date().toString());

        bookRepository.save(book);

        bookRepository.findAll().forEach(book1 -> {
            System.out.println("Book Id:" + book1.getId());
            System.out.println("Book Title: " + book1.getTitle());
        });
    }
}