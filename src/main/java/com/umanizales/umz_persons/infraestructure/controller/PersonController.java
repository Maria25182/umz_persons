package com.umanizales.umz_persons.infraestructure.controller;

import com.umanizales.umz_persons.application.dto.ErrorDTO;
import com.umanizales.umz_persons.application.dto.ResponseDTO;
import com.umanizales.umz_persons.application.dto.personDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path ="/person")
@Validated
public class PersonController {
@GetMapping
    public ResponseEntity <ResponseDTO> hellochampions(){
    return new ResponseEntity<>(new ResponseDTO("success","Hola Campones",null),HttpStatus.OK);
    //return "hola campeones ";
}

@GetMapping("/dto")
    public personDTO getPerson(){
    return new personDTO("Maria", "234234234",(byte)32);
}
@GetMapping("/list")
    public ResponseEntity <ResponseDTO>listpersons(){
    List<personDTO> listPersonDTOS = new ArrayList<>();
/*
    listPersonDTOS.add(new personDTO("Pedro Perez","324324234234",(byte)20));
    listPersonDTOS.add(new personDTO("Juan Juarez","10224545",(byte)30));
    listPersonDTOS.add(new personDTO("Pablo Paez","454545",(byte)45));

    */if(listPersonDTOS.size()>0){
        return new ResponseEntity<>(new ResponseDTO("success",listPersonDTOS,null),HttpStatus.OK);
    }else{
        List<ErrorDTO> errorDTO = new ArrayList<>();
        errorDTO.add(new ErrorDTO(HttpStatus.NOT_FOUND.value(),"la conslta no genero resultado"));
         return new ResponseEntity<>(new ResponseDTO("error",null,errorDTO),HttpStatus.OK);

    }

}
@GetMapping("/{name}")
    public String aleatorio(@PathVariable String name){
    return "hola " +name ;
}

//recibe datos
    //request body para pedir
@PostMapping
    public personDTO savePersonDTO(@RequestBody @Valid personDTO personDTO){
    personDTO.setName(" Bienvenido " + personDTO.getName());
    return personDTO;
}

}
