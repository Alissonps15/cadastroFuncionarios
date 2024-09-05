package br.edu.famper.cadastrofuncionarios.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.famper.cadastrofuncionarios.model.Funcionario;

public interface FuncionarioReposity extends JpaRepository<Funcionario, Long>{

}
