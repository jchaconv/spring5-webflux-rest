package expert.springframework.spring5webfluxrest.bootstrap;

import expert.springframework.spring5webfluxrest.domain.Category;
import expert.springframework.spring5webfluxrest.domain.Vendor;
import expert.springframework.spring5webfluxrest.repositories.CategoryRepository;
import expert.springframework.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count().block() == 0) {
            System.out.println(" ### Loading data on Bootstrap ####");

            categoryRepository.save(Category.builder().description("Fruits").build()).block();
            categoryRepository.save(Category.builder().description("Nuts").build()).block();
            categoryRepository.save(Category.builder().description("Breads").build()).block();
            categoryRepository.save(Category.builder().description("Meats").build()).block();
            categoryRepository.save(Category.builder().description("Eggs").build()).block();
            System.out.println("Loaded Categories: " + categoryRepository.count().block());

            vendorRepository.save(Vendor.builder().firstName("Julio").lastName("Chacón").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Rut").lastName("Ludeña").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Carolin").lastName("Vilela").build()).block();
            vendorRepository.save(Vendor.builder().firstName("César").lastName("Chacón").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Nayeli").lastName("Diaz").build()).block();

            System.out.println("Loaded Vendors: " + vendorRepository.count().block());

        }

    }
}
