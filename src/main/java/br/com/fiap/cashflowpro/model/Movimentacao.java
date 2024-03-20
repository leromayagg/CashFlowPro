package br.com.fiap.cashflowpro.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.cashflowpro.validation.TipoMovimentacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data 
@Entity
public class Movimentacao {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{movimentacao.descricao.notblank}") 
    @Size(min = 3, max = 255)
    private String descricao;

    @Positive
    private BigDecimal valor;

    private LocalDate data;

    @TipoMovimentacao
    private String tipo; // RECEITA | DESPESA

}
