package com.uoa.di.csr.repository;

import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.model.search.GeneralSearchForm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ServiceRequestCriteriaRepositoryImpl implements ServiceRequestCriteriaRepository {


    @PersistenceContext
    private EntityManager entityManager;

    public List<ServiceRequest> criteriaSearch(GeneralSearchForm searchForm) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<ServiceRequest> query = criteriaBuilder.createQuery(ServiceRequest.class);
        Root<ServiceRequest> root = query.from(ServiceRequest.class);
        query.select(root);

        List<Predicate> predicates = new ArrayList<>();
        if (isNotNullOrEmpty(searchForm.getServiceRequestId())) {
            predicates.add(criteriaBuilder.equal(root.get("srId"), searchForm.getServiceRequestId()));
        } else {
            if (isNotNullOrEmpty(searchForm.getStreetAddress())) {
                predicates.add(criteriaBuilder.like(root.get("streetAddress"), "%" + searchForm.getStreetAddress() + "%"));
            } else {
                predicates.add(criteriaBuilder.equal(root.get("streetAddress"), null));
            }
            if (isNotNullOrEmpty(searchForm.getZipCode())) {
                predicates.add(criteriaBuilder.equal(root.get("zipCode"), searchForm.getZipCode()));
            } else {
                predicates.add(criteriaBuilder.equal(root.get("zipCode"), null));
            }
        }

        Predicate[] predicatesArray = predicates.toArray(new Predicate[0]);
        Predicate orPredicate = criteriaBuilder.or(predicatesArray);
        query.where(orPredicate);
        return entityManager.createQuery(query).getResultList();
    }

    private boolean isNotNullOrEmpty(String string) {
        return string != null && !string.equals("");
    }
}
