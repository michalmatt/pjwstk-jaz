package jerseyclientdemo;

public class Program {
	
	//test2:
	//static void printPerson(Person p){
	//	System.out.println("id: " + p.getId());
	//	System.out.println("imie: " + p.getName());
	//	System.out.println("nazwisko: " + p.getSurname());
	//	System.out.println("==================================");
	//}
	
	//test3:
	static void printPerson(Person p){
		if(p == null) {
			System.out.println(404);
			return;
		}
		System.out.println("id: " + p.getId());
		System.out.println("imie: " + p.getName());
		System.out.println("nazwisko: " + p.getSurname());
		System.out.println("==================================");
	}

	public static void main(String[] args) {
		
		//test1:
		//Person p = new Person();
		//p.setName("jan");
		//p.setSurname("kowalski");
		//PersonClient client = new PersonClient();
		//System.out.println(client.postPerson(p));
		
		//test2:
		//PersonClient client = new PersonClient();
		//for(Person p: client.getAll()) {
		//	printPerson(p);
		//}
		
		//test3:
		//PersonClient client = new PersonClient();
		//printPerson(client.getById(2));
		//printPerson(client.getById(100));
		
		//test update & delete:
		//PersonClient client = new PersonClient();
		//printPerson(client.getById(2));
		//Person p = new Person();
		//p.setName("jerzy");
		//p.setSurname("nowak");
		//client.update(p, 2);
		//printPerson(client.getById(2));
		//client.delete(2);
		//printPerson(client.getById(2));
		
		//dodanie znow osoby:
		PersonClient client = new PersonClient();
		Person p = new Person();
		p.setName("jan");
		p.setSurname("swiezak");
		client.postPerson(p);
		
	}
}
