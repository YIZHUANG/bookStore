package fi.haagahelia.course.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
public class Department {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long DepartmentId;
private String name;

@OneToMany(cascade =CascadeType.ALL, mappedBy = "department")
private List <Book> book;



public Department(){}
public Department(String name){
	super();
	this.name=name;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Long getDepartmentId() {
	return DepartmentId;
}
public void setDepartmentId(Long departmentId) {
	DepartmentId = departmentId;
}
public List<Book> getBook() {
	return book;
}
public void setBook(List<Book> book) {
	this.book = book;
}
@Override
public String toString() {
	return "Department [Id=" + DepartmentId + ", name=" + name + "]";
}

}
