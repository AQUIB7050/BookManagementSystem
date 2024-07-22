package com.bootrestbook.bootrestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootrestbook.bootrestbook.dao.BookRepository;
import com.bootrestbook.bootrestbook.entities.Book;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
    /* 
    static List<Book> list = new ArrayList<>();

    static{
        list.add(new Book(111,"Java For Beginners", "Unknown"));
        list.add(new Book(179,"Daffodils","William Shakespeare"));
        list.add(new Book(219, "Literature And Art", "Ruskin Bond"));
    }

    */

    public List<Book> getBooks(){
        //return list;
        return (List<Book>) this.bookRepository.findAll();
    }

    public Book getBook(int b_id){
        Book b = null;
        try{
            //b = list.stream().filter(item->item.getId() == b_id).findFirst().get();
            b = this.bookRepository.findById(b_id);
        } catch(Exception e){
            e.printStackTrace();
        }
        return b;
        
    }

    public void addBook(Book b){
        //list.add(b);
        this.bookRepository.save(b);
    }

    public void updateBook(Book b, int bookId){
        /*

        list = list.stream().map(item->{
            if(item.getId() == bookId){
                item.setName(b.getName());
                item.setAuthor(b.getAuthor());
            }
            return item;
        }).collect(Collectors.toList());

        */

        b.setId(bookId);
        this.bookRepository.save(b);
    }

    public void deleteBook(int bookId){
        //list = list.stream().filter(elements->elements.getId() != bookId).collect(Collectors.toList());
        this.bookRepository.deleteById(bookId);
    }


}
