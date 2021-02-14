package expert.springframework.spring5webfluxrest.repositories;

import expert.springframework.spring5webfluxrest.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, Long> {
}
