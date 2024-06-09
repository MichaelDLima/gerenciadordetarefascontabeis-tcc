package br.com.rosecontabilidade.gerenciadordetarefascontabeis.specification;

import br.com.rosecontabilidade.gerenciadordetarefascontabeis.model.Usuario;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class UsuarioSpecification {

    public static Specification<Usuario> withFilters(String nome, String login, Integer nivel, Character status) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (StringUtils.hasText(nome)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("nome"), "%" + nome + "%"));
            }

            if (StringUtils.hasText(login)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("login"), "%" + login + "%"));
            }

            if (nivel != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("nivel"), nivel));
            }

            if (status != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), status));
            }

            return predicate;
        };
    }
}
