package examenparcial;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import material.dictionary.Dictionary;
import material.dictionary.OAHashDictionary;
import material.maps.Entry;
import material.utils.Pair;

/**
 *
 * @author mayte
 */
public class Organiser {

    private HashMap<DNI,List<String>> miMapa;
    private HashMap<DNI,Student> estudiantes;
    /**
     * Initializes the organiser
     */
    public Organiser(){
        miMapa=new HashMap<DNI, List<String>>();
        estudiantes= new HashMap<>();
    }
    
    /**
     * Initializes the organiser
     * @param lista 
     */
    public Organiser(List<Pair<String, List<Student>>> lista) {
       this(); 
       Dictionary<DNI,String> aux= new OAHashDictionary<DNI, String>();
       for(Pair<String, List<Student>> par: lista){          
           String asignatura=par.getFirst();
           for(Student estudiante: par.getSecond()){
               aux.put(estudiante.getDni(), asignatura);
               estudiantes.put(estudiante.getDni(),estudiante);
           }
       }
      for(material.dictionary.Entry<DNI,String> entry:aux.entries()){
          miMapa.put(entry.getKey(), (List<String>) aux.getAll(entry.getKey()));
      }
      
    }

    /**
     * Returns the list of subject in which the student is enrolled
     * @param identificador
     * @return 
     */
    public List<String> enrolledSubjects(DNI identificador) {
        return miMapa.get(identificador);
    }

    /**
     * Adds a new student and a their list of subject to the organiser
     * If the student is already in the organiser, it is a change of record
     * @param s
     * @param l 
     */
    public void newStudent(Student s, List<String> l) {
        miMapa.put(s.getDni(),l); 
    }

    /**
     * Recives a student and a new list of subjects. 
     * If the student is not in the organiser throws a exception.
     * @param s
     * @param l 
     */
    public void registrationChange(Student s, List<String> l) {
    
        if(!miMapa.get(s.getDni()).equals(l)){
            System.out.print("No está matriculado en estas asignaturas");
            miMapa.put(s.getDni(), l);
        }
        
    }

    /**
     * Returns a string with the student's personal data.
     * If the student is not in the organiser returns null.
     * @param identificador
     * @return 
     */
    public String studentData(DNI identificador) {
            if(miMapa.containsKey(identificador)){
                return estudiantes.get(identificador).toString();
            }
            return null;
    }
    
    
}
