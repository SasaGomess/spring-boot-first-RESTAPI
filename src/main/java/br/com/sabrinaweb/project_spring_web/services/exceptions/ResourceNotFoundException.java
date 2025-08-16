package br.com.sabrinaweb.project_spring_web.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }
}
