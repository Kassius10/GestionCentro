package utils;

public class AlumnoPatterns {
    public static String patternName(String name){
        var regex= "([a-záéíóú]{1}[a-zñáéíóú]*)$";
        while(!name.matches(regex)){
            name= Input.readString("Intentelo de nuevo.");
        }
        return name;
    }
    public static String patternDni(String dni){
        var regex= "^([1-9]{1}[0-9]{7}[a-z])$";
        while(!dni.matches(regex)){
            dni= Input.readString("Intentelo de nuevo.");
        }
        return dni;
    }
    public static String patternSurnames(String surNames){
        var regex= "^([a-záéíóú]{1}[a-zñáéíóú]*)\\s([a-záéíóú]{1}[a-zñáéíóú]*)$";
        while(!surNames.matches(regex)){
            surNames= Input.readString("Intentelo de nuevo.");
        }
        return surNames;
    }
    public static String patternEmail(String email){
        var regex= "^[\\w]+@{1}([\\w]+\\.)+[a-z]{2,3}$";
        while(!email.matches(regex)){
            email= Input.readString("Intentelo de nuevo.");
        }
        return email;
    }

    public static String patternPhone(String phone){
        var regex= "^[6-9]{1}[0-9]{2}[-][0-9]{6}$";
        while(!phone.matches(regex)){
            phone= Input.readString("Intentelo de nuevo.");
        }
        return phone;
    }
    public static String patternBoolean(String evaluation){
        var regex= "^(si|no)$";
        while(!evaluation.matches(regex)){
            evaluation= Input.readString("Intentelo de nuevo.");
        }
        return evaluation;
    }

}
