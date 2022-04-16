package service;

import exception.PessoaNotFoundException;
import exception.PessoaSemNomeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.Pessoa;

public class CadastroPessoa {

  private final List<Pessoa> pessoas = new ArrayList<>();

  public List<Pessoa> getPessoas() {
    return this.pessoas;
  }

  public void adicionar(Pessoa pessoa) {
    if(Objects.isNull(pessoa.getName()) || pessoa.getName().isEmpty()){
      throw new PessoaSemNomeException("Não é possível inserir pessoa sem nome.");
    }
    this.pessoas.add(pessoa);
  }

  public void remover(Pessoa pessoa) {
    if(!this.pessoas.remove(pessoa)){
      throw new PessoaNotFoundException("Pessoa não encontrada");
    }
    this.pessoas.remove(pessoa);
  }

}
