package repositories;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Doctor;

public class RepositoryDoctor {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new SQLServerDriver());
        String cadena
                = "jdbc:sqlserver://sqlserverjavapgs.database.windows.net:1433;databaseName=SQLAZURE";
        Connection cn = DriverManager.getConnection(cadena, "adminsql", "Admin123");
        return cn;
    }

    //METODO PARA DEVOLVER TODOS LOS DOCTORES
    public List<Doctor> getDoctores() throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from doctor";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Doctor> doctores = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("DOCTOR_NO");
            String ape = rs.getString("APELLIDO");
            String espe = rs.getString("ESPECIALIDAD");
            int sal = rs.getInt("SALARIO");
            int hospital = rs.getInt("HOSPITAL_COD");
            Doctor doctor = new Doctor(id, ape, espe, sal, hospital);
            doctores.add(doctor);
        }
        rs.close();
        cn.close();
        return doctores;
    }

    public Doctor BuscarDoctor(int iddoctor) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from doctor where doctor_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, iddoctor);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("DOCTOR_NO");
            String ape = rs.getString("APELLIDO");
            String espe = rs.getString("ESPECIALIDAD");
            int sal = rs.getInt("SALARIO");
            int hospital = rs.getInt("HOSPITAL_COD");
            Doctor doctor = new Doctor(id, ape, espe, sal, hospital);
            rs.close();
            cn.close();
            return doctor;
        } else {
            rs.close();
            cn.close();
            return null;
        }
    }

    public List<Doctor> getDoctoresSalario(int salario) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from doctor where salario > ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, salario);
        ResultSet rs = pst.executeQuery();
        ArrayList<Doctor> doctores = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("DOCTOR_NO");
            String ape = rs.getString("APELLIDO");
            String espe = rs.getString("ESPECIALIDAD");
            int sal = rs.getInt("SALARIO");
            int hospital = rs.getInt("HOSPITAL_COD");
            Doctor doctor = new Doctor(id, ape, espe, sal, hospital);
            doctores.add(doctor);
        }
        rs.close();
        cn.close();
        if (doctores.isEmpty()) {
            return null;
        } else {
            return doctores;
        }
    }
}
