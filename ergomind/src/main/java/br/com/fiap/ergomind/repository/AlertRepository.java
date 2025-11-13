// Faz conexao com o banco de dados
package br.com.fiap.ergomind.repository;

import br.com.fiap.ergomind.model.AlertModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<AlertModel, Long> {
}
