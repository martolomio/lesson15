package com.homework.task1Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class ZooClub {
	
	static void menu() {
		
		System.out.println("1 додати учасника");
		System.out.println("2 додати тваринку до учасника клубу");
		System.out.println("3 видалити тваринку з учасника клубу");
		System.out.println("4 видалити учасника клубу");
		System.out.println("5 видалити конкретну таринку зі всіх списків");
		System.out.println("6 вивести на екран зооклуб");
		System.out.println("7 вийти з програми");
	}

	public static void main(String[] args) {
		
		Map<Person, List<Animal>> map = new HashMap<>();
		
		map.put(new Person("Lo", 34), new ArrayList<Animal>());
		map.put(new Person("Lori", 23), new ArrayList<Animal>());
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(map);
		 		 
		while(true) {
			menu();
			
			switch(sc.next()) {
			
			case"1":{
				System.out.println("Додати person");
				sc = new Scanner (System.in);
				System.out.println("Name :" );
				String name = sc.next();
				System.out.println("Age : ");
				int age = sc.nextInt();
				Person p = new Person(name,age);
				map.put(p, new ArrayList<>());	
				
				System.out.println(map);	
				break;
				}
			
			case"2":{
				Set<Person> pt = map.keySet();
				System.out.println(pt);
				
				System.out.println();
				
				System.out.println("Введіть ім,я та вік учасника клубу зі списку");
				sc = new Scanner (System.in);
				System.out.println("Name :" );
				String name = sc.next();
				System.out.println("Age : ");
				int age = sc.nextInt();
				
				System.out.println("Додати pet");
				sc = new Scanner (System.in);
				System.out.println("Type :" );
				String type = sc.next();
				System.out.println("Name : ");
				String nameP = sc.next();
				
				Animal an = new Animal(type, nameP);
			
				Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
				while(iterator.hasNext()) {
					Entry<Person, List<Animal>> next = iterator.next();
					Person p = new Person(name, age);
					if(next.getKey().equals(p)) {
						List<Animal> valeu = next.getValue();
						valeu.add(an);
						next.setValue(valeu);
					}
				}
				System.out.println(map);
				break;
				}
			
			case"3":{
				Set<Person> pt = map.keySet();
				System.out.println(pt);
				
				System.out.println();
				
				System.out.println("Введіть ім,я та вік учасника клубу зі списку");
				sc = new Scanner (System.in);
				System.out.println("Name :" );
				String name = sc.next();
				System.out.println("Age : ");
				int age = sc.nextInt();
				
				System.out.println("Додати pet");
				sc = new Scanner (System.in);
				System.out.println("Type :" );
				String type = sc.next();
				System.out.println("Name : ");
				String nameP = sc.next();
			
				Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
				while(iterator.hasNext()) {
					Entry<Person, List<Animal>> next = iterator.next();
					Person p = new Person(name, age);
					if(next.getKey().equals(p)) {
						List<Animal> petRemove = next.getValue();
						Iterator<Animal> iterator2 = petRemove.iterator();
							while(iterator2.hasNext()) {
								Animal next2 = iterator2.next();
								if(next2.getName().equalsIgnoreCase(nameP) && next2.getType().equalsIgnoreCase(type)) {
									iterator2.remove();
								}
							}
						}
					}
				
				System.out.println(map);
				break;
				}
			
			case"4":{
				System.out.println("Додати person");
				sc = new Scanner (System.in);
				System.out.println("Name :" );
				String name = sc.next();
				System.out.println("Age : ");
				int age = sc.nextInt();
				Person p = new Person(name,age);
				map.remove(p, new ArrayList<>());	
				
				System.out.println(map);
				
				break;
				}
			
			case"5":{
				System.out.println("Видалити pet");
				sc = new Scanner (System.in);
				System.out.println("Type :" );
				String type = sc.next();
			
				 for(List<Animal> entry : map.values()) {
						Iterator<Animal> iterator2 =entry.iterator();
							while(iterator2.hasNext()) {
								Animal next2 = iterator2.next();
								if(next2.getType().equalsIgnoreCase(type)) {
									iterator2.remove();
							}
						}
					 }
				System.out.println(map);
				break;
				}
			
			case"6":{
				 for(Entry<Person,List<Animal>> entry : map.entrySet()) {
					 System.out.println(entry.getKey()+"...."+entry.getValue());
				 }
				break;
				}
			
			case"7":{
				System.out.println("Ви вийшли з системи");
				System.exit(7);
				break;
				}
			}
		}	
	}
}
