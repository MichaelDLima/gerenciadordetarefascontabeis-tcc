package br.com.rosecontabilidade.gerenciadordetarefascontabeis.repository;

import br.com.rosecontabilidade.gerenciadordetarefascontabeis.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TarefasRepository extends JpaRepository<Tarefa, Long> {

    Integer countByStatus(char status);

    @Query("SELECT COUNT(t) FROM Tarefa t WHERE t.prazo = CURRENT_DATE AND t.status IN ('P','A')")
    Integer ContarTarefasVencendoHoje();

    @Query("SELECT COUNT(t) FROM Tarefa t WHERE t.prazo < CURRENT_DATE AND t.status IN ('P','A')")
    Integer ContarTarefasVencidas();
}
