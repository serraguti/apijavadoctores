package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Doctor {

    private int idDoctor;
    private String apellido;
    private String especialidad;
    private int salario;
    private int hospital;

    public Doctor() {
    }

    public Doctor(int idDoctor, String apellido, String especialidad, int salario, int hospital) {
        this.idDoctor = idDoctor;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.salario = salario;
        this.hospital = hospital;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getHospital() {
        return hospital;
    }

    public void setHospital(int hospital) {
        this.hospital = hospital;
    }
}
