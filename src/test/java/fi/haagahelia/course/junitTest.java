package fi.haagahelia.course;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;
import fi.haagahelia.course.domain.Department;
import fi.haagahelia.course.domain.DepartmentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class junitTest {
	@Autowired
	private BookRepository repository;
	@Autowired
	private DepartmentRepository drepository;
	@Test
	public void findByDepartmentName(){
		List<Department> Department = drepository.findByName("IT");
		assertThat(Department).hasSize(1);
		assertThat(Department.get(0).getName()).isEqualTo("IT");
	}

	@Test
	public void findByBookName(){
		List<Book> Book = repository.findByTitle("Who wants to live forever");
		assertThat(Book).hasSize(1);
		assertThat(Book.get(0).getTitle()).isEqualTo("Who wants to live forever");
	}

	@Test
	public void createNewDepartment(){
		Department Department =new Department("Crime");
		drepository.save(Department);
		assertThat(Department.getName()).isNotNull();
}

}
