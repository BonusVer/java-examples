package exp.my.n_p_1.repository;


import exp.my.n_p_1.entity.Client;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "client_entity-graph")
    List<Client> findByFullNameContaining(String name);
}
