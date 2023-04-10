package com.dal.lambda;
import java.util.*;

public class LambdaEg {

	public static void main(String[] args) {
	// Without Thread
		Task t = new Task();
		t.connect();
		
		//Polymorphishm with Thread..
		Runnable r = new MyTaskThread();
		Thread th = new Thread(r);
		th.start();

		//Java 7 Anonymous class Invocation
		Runnable r2 = new Runnable() {
			public void run() {
				 Task t = new Task();
				  t.connect();		
			}
		};
		
		Thread anonymousinvthread = new Thread(r2);
		anonymousinvthread.start();
		
		Runnable rlambda = () -> {
			Task f89 = new Task();
			f89.connect();
		};
		
		Thread tlambd = new Thread(rlambda);
		tlambd.start();
		
		User u1 = new User(11,"kkk","ee");
		User u2 = new User(22,"ggg","ee");
		
		List<User> li = new ArrayList<User>();
		li.add(u1);
		li.add(u2);
		
		Iterator<User> i = li.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		li.forEach(lis->System.out.println(lis));
		li.forEach(System.out::println);
		
//		Thread thy = new Thread(() -> {			
//			Task tj = new Task();
//			tj.connect();			
//		}).start();
	}

}
