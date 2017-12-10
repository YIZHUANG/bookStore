package fi.haagahelia.course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Book")
public class Book {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long Id;
private String title;
private String author;
private int year;
private String isbn;
private double price;
@ManyToOne
@JsonIgnore
@JoinColumn(name="DepartmentId")
private Department department;
public Book(){}

public Book(String title,String author,int year,String isbn,double price,Department department){
	super();
	this.title=title;
	this.author=author;
	this.year=year;
	this.isbn=isbn;
	this.price=price;
	this.department=department;
}

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

public Department getDepartment() {
	return department;
}

public void setDepartment(Department department) {
	this.department = department;
}

public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getAuthor() {
	return author;
}


public void setAuthor(String author) {
	this.author = author;
}


public int getYear() {
	return year;
}


public void setYear(int year) {
	this.year = year;
}


public String getIsbn() {
	return isbn;
}


public void setIsbn(String isbn) {
	this.isbn = isbn;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}


@Override
public String toString() {
	return "Book [Id=" + Id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
			+ ", price=" + price + ", department=" + department + "]";
}
}
