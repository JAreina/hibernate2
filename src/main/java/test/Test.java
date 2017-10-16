package test;

import java.util.List;


import org.hibernate.Session;

import model.People;
import sesionFactory.HibernateUtil;

public class Test {
	 static Session session = HibernateUtil.getSessionFactory().openSession();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 People person = new People(106,"María");
		 People person2 = new People(1,"Maríaaaaaaaaaaaaaaaaaaaa");
		 
		 
		//listPeople();
	   // guardar(person);
	    //seleccionarPersona(100);
	    //actualizar(person2);
		 //borrar(person2);
		 guardarOActualizar(person2);
		session.close();
	}
	/**
	 * TRAER DATOS DE UNA PERSONA DE LA BD
	 * @param id
	 * @return
	 */
	private static People seleccionarPersona(int id){
		
		People p = session.get(People.class, id);
		System.out.println("UNA PERSONA SELECCIONADA "+p);
		return p;
	}
	
	
	/**
	 * Listar todas las personas
	 * @return
	 */
	 @SuppressWarnings("unchecked")
	private static List<People> listPeople() {
	      
	        session.beginTransaction();
	        List<People> result = (List<People>)session.createQuery("from People").list();
	        session.getTransaction().commit();
	        for (People persona : result) {
	            System.out.println("Leido: "+persona);
	        }
	        return result;
	    }
	 
	 /**
	  * GUARDAR UNA PERSONA
	  * @param person
	  */
	 private static void guardar(People person){
		 
		
		 session.getTransaction().begin();
		 session.save(person);
		 
		 session.getTransaction().commit();
		 System.out.println("GUARDADO: "+person);
		 
	 }
	 
	 
	 /**
	  * ACTUALIZAR 
	  */
	 private static void actualizar(People person){
		 person.setName("NOMBRE ACTUALIZADO");
		 
		 session.getTransaction().begin();
		 
		
		 session.update(person);
		 
		 session.getTransaction().commit();
		 System.out.println("actualizado: "+person);
		 
	 }
	 /**
	  * BORRAR
	  * 
	  * 
	  */
	 
	 
	 private static void borrar(People person){
		 session.getTransaction().begin();
		 
			
		 session.delete(person);
		 
		 session.getTransaction().commit();
		 System.out.println("BORRADO: "+person);
	 }
	 
	 
	 
	 
	 private static void guardarOActualizar(People person){
		 session.getTransaction().begin();
		 
			
		 session.saveOrUpdate(person);
		 
		 session.getTransaction().commit();
		 System.out.println("guardado o actualizado: "+person);
	 }
}
