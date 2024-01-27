package com.example.picpaysimplificado.Services;

import com.example.picpaysimplificado.domain.TransactionDTO;
import com.example.picpaysimplificado.domain.Transfer;
import com.example.picpaysimplificado.domain.User;
import com.example.picpaysimplificado.repository.TransactionRepository;
import com.example.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.function.BiConsumer;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private Notification not;



    public Transfer createTransfer(TransactionDTO trasactiondto) throws Exception {
        var payer = userService.findById(trasactiondto.idPayer());
        var payee = userService.findById(trasactiondto.idPeyee());

        userService.validateUser(payer, trasactiondto.value());

        Boolean isValidate = validate();

        if(!isValidate){
            throw new Exception("NAO AUTORIZADO");
        }

        Transfer trasaction = new Transfer();
        trasaction.setPayee(payee);
        trasaction.setPayer(payer);
        trasaction.setAmount(trasactiondto.value());
        trasaction.setDatetransfer(LocalDateTime.now());

        payer.setBalance(payer.getBalance().subtract(trasactiondto.value()));
        payee.setBalance(payee.getBalance().add(trasactiondto.value()));

        transactionRepository.save(trasaction);
        userService.saveUser(payer);
        userService.saveUser(payee);

        not.sendNot(payer,"transaçao realizada");
        not.sendNot(payee, "transaçao recebida");
        return trasaction;



    }

    public Boolean validate(){
    var response = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);
    if(response.getStatusCode() == HttpStatus.OK){
        String message = (String) response.getBody().get("message");
        return "Autorizado".equalsIgnoreCase(message);
    }else return false;
    }
}
