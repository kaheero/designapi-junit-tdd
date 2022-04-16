package service;

import exception.PessoaNotFoundException;
import exception.PessoaSemNomeException;
import model.Pessoa;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoaTest {

  @Test
  public void deveCriarOCadastroDePessoas(){
    // cenário e execução
    CadastroPessoa cadastroPessoa = new CadastroPessoa();

    // verificação
    Assertions.assertThat(cadastroPessoa.getPessoas()).isEmpty();
  }

  @Test
  public void deveAdicionarUmaPessoa(){
    // cenário
    CadastroPessoa cadastroPessoa = new CadastroPessoa();
    Pessoa pessoa = new Pessoa();
    pessoa.setName("John");

    // execução
    cadastroPessoa.adicionar(pessoa);
    Assertions.assertThat(cadastroPessoa.getPessoas())
        .isNotEmpty()
        .hasSize(1)
        .contains(pessoa);
  }

  @Test(expected = PessoaSemNomeException.class)
  public void naoDeveAdicionarPessoaComNomeVazio(){
    // cenário
    CadastroPessoa cadastroPessoa = new CadastroPessoa();
    Pessoa pessoa = new Pessoa();

    // execução
    cadastroPessoa.adicionar(pessoa);
  }

  @Test
  public void deveRemoverUmaPessoa(){
    // cenário
    CadastroPessoa cadastroPessoa = new CadastroPessoa();
    Pessoa pessoa = new Pessoa();
    pessoa.setName("John");
    cadastroPessoa.adicionar(pessoa);

    // execução
    cadastroPessoa.remover(pessoa);

    // verificação
    Assertions.assertThat(cadastroPessoa.getPessoas())
        .isEmpty();
  }

  @Test(expected = PessoaNotFoundException.class)
  public void deveLancarErroAoRemoverUmaPessoaInexistente(){
    // cenário
    CadastroPessoa cadastroPessoa = new CadastroPessoa();
    Pessoa pessoa = new Pessoa();

    // execucao
    cadastroPessoa.remover(pessoa);
  }

}
