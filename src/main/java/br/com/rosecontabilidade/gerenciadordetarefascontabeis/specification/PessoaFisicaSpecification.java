package br.com.rosecontabilidade.gerenciadordetarefascontabeis.specification;

import br.com.rosecontabilidade.gerenciadordetarefascontabeis.model.PessoaFisica;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class PessoaFisicaSpecification {

    public static Specification<PessoaFisica> withFilters(String nome, String rg, String cpf, Character status) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (StringUtils.hasText(nome)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("nome"), "%" + nome + "%"));
            }

            if (StringUtils.hasText(rg)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("rg"), "%" + rg + "%"));
            }

            if (StringUtils.hasText(cpf)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("cpf"), "%" + cpf + "%"));
            }

            if (status != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), status));
            }

            return predicate;
        };
    }
}
