package com.example.examen01;

import java.io.Serializable;

public class Rectangulo {

    private float base;
    private float altura;

    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    public Rectangulo(){

    }

    public Rectangulo(Rectangulo rectangulo){

    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float calculoArea(){
        float area = 0.0f;
        area=altura*base;
        return area;
    }

    public float calcularPerimetro(){
        float perimetro = 0.0f;
        perimetro=(altura*2)+(base*2);
        return perimetro;

    }
}
