package com.ty.manytomanybi_dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomanybi.Course;
import com.ty.manytomanybi.Student;

public class StudentDao {

	public static void main(String[] args) {
        Student student1=new Student(); 
        student1.setId(1);
        student1.setName("sasi");
        student1.setPhone(123);
        
        Student student2=new Student();
        student2.setId(2);
        student2.setName("gowsi");
        student2.setPhone(456);
        
        Student student3=new Student();
        student3.setId(3);
        student3.setName("subash");
        student3.setPhone(789);
        
        Course course1=new Course();
        course1.setId(101);
        course1.setCourse("java");
        
        Course course2=new Course();
        course2.setId(102);
        course2.setCourse("adv-java");
        
        Course course3=new Course();
        course3.setId(103);
        course3.setCourse("java script");
        
        List<Course>ls1=new ArrayList<Course>();
        ls1.add(course1);
        ls1.add(course3);
        student1.setCourse(ls1);
        
        List<Course>ls2=new ArrayList<Course>();
        ls2.add(course2);
        ls2.add(course3);
        student2.setCourse(ls2);
        
        List<Course>ls3=new ArrayList<Course>();
        ls3.add(course1);
        ls3.add(course2);
        student3.setCourse(ls3);
        
        List<Student>l1=new ArrayList<Student>();
        l1.add(student1);
        l1.add(student3);
        course1.setStudent(l1);
        
        List<Student>l2=new ArrayList<Student>();
        l2.add(student2);
        l2.add(student3);
        course2.setStudent(l2);
        
        List<Student>l3=new ArrayList<Student>();
        l3.add(student1);
        l3.add(student2);
        course3.setStudent(l3);
        
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("umsgs");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        
        et.begin();
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        
        em.persist(course1);
        em.persist(course2);
        em.persist(course3);
        
        
        et.commit();
        
        
        
		
	}

}
