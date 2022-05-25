package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoUpdateForm {

  @NotEmpty
  @Size(min = 3, max = 50)
  private String nome;

  @NotEmpty
  @Size(min = 3, max = 50)
  private String bairro;

  @NotNull
  @Past
  private LocalDate dataDeNascimento;
}
