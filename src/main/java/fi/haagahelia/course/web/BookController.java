package fi.haagahelia.course.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;
import fi.haagahelia.course.domain.DepartmentRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository; 
	@Autowired
	private DepartmentRepository drepository;
    @RequestMapping(value="/BookList")
    public String BookList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "BookList";
    }
  
   
    @RequestMapping(value="/login")
    public String login(){
    	return "login";
    }
   
    @RequestMapping(value="/add")
    public String addBook(Model model){

		model.addAttribute("book",new Book());
		model.addAttribute("departments",drepository.findAll());
    	return "AddBook";
    	
    }
    
    @RequestMapping(value="/save",method=RequestMethod.POST)
    public String Save(Book book){
    repository.save(book);
    	return "redirect:BookList";
    }
    
    @RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
    public String delete(@PathVariable("id") Long bookid,Model model){
    	repository.delete(bookid);
    	return "redirect:/BookList";
    }
@RequestMapping(value="/edit/{id}")
public String edit(@PathVariable("id") Long bookid,Model model){
	model.addAttribute("book",repository.findOne(bookid));
	model.addAttribute("departments",drepository.findAll());
	return "editBook";
}
    
@RequestMapping(value="/books",method=RequestMethod.GET)
public @ResponseBody List<Book> BookRest(){
	return (List<Book>) repository.findAll();
	
}
@RequestMapping(value="/books/{id}",method=RequestMethod.GET)
	public @ResponseBody Book BookIdRest(@PathVariable("id") Long bookid){
	return repository.findOne(bookid);
}

    
    }   

