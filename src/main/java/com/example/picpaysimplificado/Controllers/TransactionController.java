package com.example.picpaysimplificado.Controllers;

import com.example.picpaysimplificado.Services.TransactionService;
import com.example.picpaysimplificado.Services.UserService;
import com.example.picpaysimplificado.domain.TransactionDTO;
import com.example.picpaysimplificado.domain.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @PostMapping //metodo que recebe os dados do DTO como parametro e envia para o service
    public ResponseEntity<Transfer> createTransaction(@RequestBody TransactionDTO trasactiondto) throws Exception {
        var transf = transactionService.createTransfer(trasactiondto);
        return new ResponseEntity<>(transf, HttpStatus.CREATED);
    }
}
