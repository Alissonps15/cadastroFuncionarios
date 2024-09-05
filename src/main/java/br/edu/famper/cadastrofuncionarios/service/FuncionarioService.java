package br.edu.famper.cadastrofuncionarios.service;

import br.edu.famper.cadastrofuncionarios.model.Funcionario;
import br.edu.famper.cadastrofuncionarios.reposity.FuncionarioReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioReposity funcionarioReposity;

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioReposity.save(funcionario);
    }
    public List<Funcionario> findall() {
        return funcionarioReposity.findAll();
    }
    public Optional<Funcionario> findbyId(Long id) {
        return funcionarioReposity.findById(id);
    }

    public Funcionario update(Funcionario funcionario) {
        Funcionario salvo = funcionarioReposity.findById(funcionario.getCodigo())
                .orElseThrow(() ->
                        new  RuntimeException("funcionario nao encontrado"));

        salvo.setNome(funcionario.getNome());
        salvo.setCargo(funcionario.getCargo());
        salvo.setEmail(funcionario.getEmail());
        salvo.setDepartamento(funcionario.getDepartamento());
        salvo.setTelefone(funcionario.getTelefone());
        salvo.setDataAdmissao(funcionario.getDataAdmissao());

        return funcionarioReposity.save(funcionario);
    }
    public void deleteById(Long id) {
        funcionarioReposity.deleteById(id);
    }
}
