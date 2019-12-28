package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comment;
import entities.Post;

public class Main {

	public static void main(String[] args) throws ParseException {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	Post p1 = new Post(
			sdf.parse("21/06/2018 13:05:44"),
			"Traveling to New Zealand",
			"I'm going to visit this wonderful country!",
			12);
	Comment c1 = new Comment("Have a nice trip");
	Comment c2 = new Comment("Wow that's awesome!");
	p1.addComment(c1);
	p1.addComment(c2);
	
	System.out.println(p1);
	
	System.out.println();
	
	Post p2 = new Post(
			sdf.parse("28/07/2018 23:14:19"),
			"Good night guys",
			"See yout tomorrow",
			5);
	p2.addComment(new Comment("Good night"));
	p2.addComment(new Comment("May the Force be with you"));
		
	System.out.println(p2);

	}

}