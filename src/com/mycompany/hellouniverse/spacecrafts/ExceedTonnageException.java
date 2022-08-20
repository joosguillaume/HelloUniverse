package com.mycompany.hellouniverse.spacecrafts;

public class ExceedTonnageException extends Exception{
    public int ExceedTonnage;
    public ExceedTonnageException(int ExceedTonnage) {
        super("La cargaison ne peut être chargée car elle présente un excès de "+ExceedTonnage);
        this.ExceedTonnage=ExceedTonnage;
    }
}
