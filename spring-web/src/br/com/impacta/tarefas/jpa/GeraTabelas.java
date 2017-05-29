package br.com.impacta.tarefas.jpa;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {

	public static void main(String[] args) throws SQLException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");

		factory.close();

	}
}
