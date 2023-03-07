package com.crud.dto;

public class StudentDto {
   private String name;
   private String surname;
   private String regNumber;
   
   public String getName(){
    return name;
   }

   public void setName(String name){
    this.name = name;
   }

   public String getSurname(){
    return surname;
   }

   public void setSurname(String surname){
    this.surname = surname;
   }

   public String getRegNumber(){
    return regNumber;
   }

   public void setRegNumber(String regNumber){
   this.regNumber = regNumber;
   }
}
