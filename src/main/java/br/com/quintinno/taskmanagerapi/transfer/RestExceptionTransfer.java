package br.com.quintinno.taskmanagerapi.transfer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RestExceptionTransfer {

    private String mensagem;

    private String status;

    private String data;

    private List<String> errorList = new ArrayList<>();

    public RestExceptionTransfer() {
        this.data = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now());
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> erroList) {
        this.errorList = erroList;
    }

}
