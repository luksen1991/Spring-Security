package pl.learningspring.carservice.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalLong;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import pl.learningspring.carservice.dto.Issue;

@Component
public class IssuesRepository {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;

	public Issue getIssue(Long id) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Issue> query = entityManager.createQuery("select i from Issue i where i.id=" + id, Issue.class);
		Issue issue = query.getSingleResult();
		entityManager.close();
		entityManagerFactory.close();
		return issue;
	}

	public void addIssue(Issue issue) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(issue);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public List<Issue> getAllIssue(){
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Issue> query = entityManager.createQuery("select i from Issue i", Issue.class);
		List<Issue> issues = query.getResultList();
		entityManager.close();
		entityManagerFactory.close();
		return issues;
	}
	
	public List<Issue> upadateApprove(Long id, boolean approved) {
		System.out.println("dostalem: "+id);
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Issue issue = entityManager.find(Issue.class, id);
		issue.setApproved(approved);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return getAllIssue();
	}
}
