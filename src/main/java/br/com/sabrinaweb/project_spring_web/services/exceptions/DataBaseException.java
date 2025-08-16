package br.com.sabrinaweb.project_spring_web.services.exceptions;

public class DataBaseException extends RuntimeException{
    public DataBaseException(String msg){
        super(msg);
    }
}
