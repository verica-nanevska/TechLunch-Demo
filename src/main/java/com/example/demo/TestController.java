package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class TestController {
	
	private static List<String> books = new ArrayList<>();
	
	@GetMapping("/hello")
	public String getHelloWorld(@RequestParam String name) {
		return "Hello "+ name +"!!";
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/")
	public List<String> getData() {
		return books;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public String getBook(@PathVariable("id") int index) {
		return books.get(index);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/")
	public int createBook(@RequestParam String title) {
		books.add(title);
		return books.size()-1;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public String updateBook(@PathVariable("id") int index, @RequestParam String title) {
		books.set(index, title);
		return books.get(index);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable("id") int index) {
		books.remove(index);
	}
	
}
