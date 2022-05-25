package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

  @NotEmpty
  @Size(min = 3, max = 50)
  private String nome;

  @NotEmpty
  //@CPF
  private String cpf;

  @NotEmpty
  @Size(min = 3, max = 50)
  private String bairro;

  @NotNull
  @Past
  private LocalDate dataDeNascimento;
}
