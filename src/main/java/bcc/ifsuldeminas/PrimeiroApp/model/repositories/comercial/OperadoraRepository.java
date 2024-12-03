package bcc.ifsuldeminas.PrimeiroApp.model.repositories.comercial;

import bcc.ifsuldeminas.PrimeiroApp.model.entities.telefonia.Operadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperadoraRepository extends JpaRepository<Operadora, Long> {
}
