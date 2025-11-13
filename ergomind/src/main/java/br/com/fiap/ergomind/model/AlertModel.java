package br.com.fiap.ergomind.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import java.time.LocalDateTime;

@Entity // Essa classe representa uma entidade no banco de dados
@Table(name = "alertas")
@Getter @Setter
@NoArgsConstructor  //Cria um construtor vazio para a criacao de um novo objeto dessa classe
@AllArgsConstructor // Cria um construtor com todos os atributos dessa classe.

public class AlertModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id será gerado automaticamente pelo banco de dados
    private Long id;

    @NotNull
    private AlertType alertType;

    @NotEmpty(message = "A mensagem do alerta não pode estar vazia")
    private String message;  //Por exemplo: Muito tempo no computador, faca uma pausa

    @PositiveOrZero
    private double alertLevel ;// Se o alert é algo simples, ou se o trabalhador já se encontra a 4 horas em frente ao computador sem nenhuma pausa com postura torta, prejudicando sua saúde.

    private LocalDateTime dateTime;

    @PrePersist
    public void PrePersist(){
        if(dateTime == null ){
            dateTime = LocalDateTime.now();
        }
    }


}
