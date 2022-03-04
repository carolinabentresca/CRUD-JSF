package bean;

import controller.AlumnoJpaController;
import controller.exceptions.NonexistentEntityException;
import entity.Alumno;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AlumnoBean implements Serializable {

    private Alumno alumno;
    private static List<Alumno> alumnos = new ArrayList();

    public AlumnoBean() {
        alumno = new Alumno();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        AlumnoBean.alumnos = alumnos;
    }

    //Métodos para el CRUD
    public List<Alumno> mostrar() {
        AlumnoJpaController ctrl = new AlumnoJpaController();
        alumnos = ctrl.findAlumnoEntities();
        return alumnos;
    }

    public void registrar() {
        try {
            AlumnoJpaController ctrl = new AlumnoJpaController();
            ctrl.create(alumno);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void editar() {
        try {
            AlumnoJpaController ctrl = new AlumnoJpaController();
            ctrl.edit(alumno);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void eliminar(int id) {
        try {
            AlumnoJpaController ctrl = new AlumnoJpaController();
            ctrl.destroy(id);
        } catch (NonexistentEntityException e) {
            e.getMessage();
        }
    }

}
