package br.com.caelum.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.engine.internal.JoinSequence.Join;
import org.springframework.stereotype.Repository;

import br.com.caelum.model.Categoria;
import br.com.caelum.model.Loja;
import br.com.caelum.model.Produto;

@Repository
public class ProdutoDao {

	@PersistenceContext
	private EntityManager em;

	public List<Produto> getProdutos() {
		return em.createQuery("from Produto", Produto.class).getResultList();
	}

	public Produto getProduto(Integer id) {
		Produto produto = em.find(Produto.class, id);
		return produto;
	}

	public List<Produto> getProdutos(String nome, Integer categoriaId, Integer lojaId) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = criteriaBuilder.createQuery(Produto.class);
		Root<Produto> root = query.from(Produto.class);

		Path<String> nomePath = root.<String> get("nome");
		Path<Integer> lojaPath = root.<Loja> get("loja").<Integer> get("id");
		Path<Integer> categoriaPath = root.join("categorias").<Integer> get("id");

		List<Predicate> predicates = new ArrayList<>();

		if (!nome.isEmpty()) {
			Predicate nomeIgual = criteriaBuilder.like(nomePath, nome);
			predicates.add(nomeIgual);
		}
		if (categoriaId != null) {
			Predicate categoriaIgual = criteriaBuilder.equal(categoriaPath, categoriaId);
			predicates.add(categoriaIgual);
		}
		if (lojaId != null) {
			Predicate lojaIgual = criteriaBuilder.equal(lojaPath, lojaId); 
			predicates.add(lojaIgual);
		}

		query.where((Predicate[]) predicates.toArray(new Predicate[0]));

		TypedQuery<Produto> typedQuery = em.createQuery(query);
		typedQuery.setHint("org.hibernate.cacheable", "true");
		
		return typedQuery.getResultList();

	}
	
	public List<Produto> getProdutosAlternativo(String nome, Integer categoriaId, Integer lojaId) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> root = query.from(Produto.class);
		
		Predicate conjuncao = builder.conjunction();

		if (!nome.isEmpty()) {
		    Path<String> nomeProduto = root.<String> get("nome");
		    Predicate nomeIgual = builder.like(nomeProduto, "%" + nome + "%");

		    conjuncao = builder.and(nomeIgual);
		}

		if (categoriaId != null) {
		    Path<Integer> categoriaProduto = root.join("categorias").get("id");

		    conjuncao = builder.and(conjuncao, builder.equal(categoriaProduto, categoriaId));
		}

		if (lojaId != null) {
		    Path<Loja> loja = root.<Loja> get("loja");
		    Path<Integer> id = loja.<Integer> get("id");

		    conjuncao = builder.and(conjuncao, builder.equal(id, lojaId));
		}

		TypedQuery<Produto> typedQuery = em.createQuery(query.where(conjuncao));
		return typedQuery.getResultList();

	}

	public void insere(Produto produto) {
		if (produto.getId() == null)
			em.persist(produto);
		else
			em.merge(produto);
	}

}
