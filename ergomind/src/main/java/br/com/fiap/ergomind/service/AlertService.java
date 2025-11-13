package br.com.fiap.ergomind.service;

import br.com.fiap.ergomind.model.AlertModel;
import br.com.fiap.ergomind.repository.AlertRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Essa classe é um componente de servico, que contem a lógica da aplicacao
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public AlertModel createAlert(AlertModel alert){
        return alertRepository.save(alert);
    }
    public List<AlertModel> readAllAlerts(){
        return alertRepository.findAll();
    }
    public AlertModel readAlertById(Long id){
        return alertRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Alerta não encontrado"));
    }
    public AlertModel updateAlert(Long id, AlertModel alert){
        return alertRepository.findById(id).map(existingAlert -> {
            existingAlert.setAlertType(alert.getAlertType());
            existingAlert.setMessage(alert.getMessage());
            existingAlert.setAlertLevel(alert.getAlertLevel());
            return alertRepository.save(existingAlert);
        }).orElseThrow(()-> new EntityNotFoundException("Alerta não encontrado"));
    }
    public void deleteAlertById(Long id){
        try{
            alertRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("Alerta não encontrado");
        }
    }
}
