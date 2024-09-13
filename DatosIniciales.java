package TP1_Paradigmas;

import TP1_Paradigmas.usuarios.Alumno;
import TP1_Paradigmas.usuarios.Coordinador;
import TP1_Paradigmas.usuarios.Profesor;
import TP1_Paradigmas.clases.Universidad;

public class DatosIniciales {
    public static void iniciarDatos(Universidad universidad){

        //creación de carreras y materias de la universidad
        universidad.crearCarrera(1, "Ingeniería en Sistemas", 5, 60000, 25000);
            Coordinador cordinador1 = new Coordinador(123, "Juan", "Romero", "juancito@universidad.com", "Hombre", "355556", 5555);
            universidad.asignarCoordinador(cordinador1, 1);
                universidad.getCarreraByID(1).crearMateria(1, "Algebra", 1, 1);
                universidad.getCarreraByID(1).crearMateria(2, "Paradigmas I", 2, 1);
                universidad.getCarreraByID(1).crearMateria(3, "Paradigmas II", 2, 2);
                universidad.getCarreraByID(1).crearMateria(4, "Analisis Numérico", 3, 1);
                universidad.getCarreraByID(1).crearMateria(5, "Ingeniería de Software III", 4, 1);
        
        universidad.crearCarrera(2, "Licenciatura en Nutrición", 4, 50000, 25000);
            Coordinador cordinador2 = new Coordinador(321, "María", "Rosano", "marirosa@universidad.com", "Mujer", "11111", 12345678);
            universidad.asignarCoordinador(cordinador2, 2);
                universidad.getCarreraByID(2).crearMateria(1, "Cocina I", 1, 1);
                universidad.getCarreraByID(2).crearMateria(2, "Anatomía", 2, 1);
                universidad.getCarreraByID(2).crearMateria(3, "Panadería II", 3, 2);
                universidad.getCarreraByID(2).crearMateria(4, "Metabolismo", 4, 1);
                universidad.getCarreraByID(2).crearMateria(5, "Práctica Profesional", 4, 2);

        
        universidad.crearCarrera(3, "Licenciatura en Criminalística", 6, 75000, 35000);
            Coordinador cordinador3 = new Coordinador(132, "Rosalía", "Lisa", "rosalisa@universidad.com", "Mujer", "66666", 87654321);
            universidad.asignarCoordinador(cordinador3, 3);
                universidad.getCarreraByID(3).crearMateria(1, "Fisica I", 1, 1);
                universidad.getCarreraByID(3).crearMateria(2, "Matemáticas", 2, 1);
                universidad.getCarreraByID(3).crearMateria(3, "Psicología Criminal", 3, 1);
                universidad.getCarreraByID(3).crearMateria(4, "Balística", 4, 2);
                universidad.getCarreraByID(3).crearMateria(5, "Práctica Profesional", 4, 2);

        //creación y asignacion de profesores a materias 
        Profesor profesor6 = new Profesor(678, "Ana", "García", "ana.garcia@universidad.com", "Mujer", "379123456", 12346789, universidad);
        universidad.getCarreraByID(1).getCoordinador().asignarProfesor(2, profesor6);
        
        Profesor profesor7 = new Profesor(679, "Carlos", "Méndez", "carlos.mendez@universidad.com", "Hombre", "379223456", 22346789, universidad);
        universidad.getCarreraByID(2).getCoordinador().asignarProfesor(1, profesor7);
        
        Profesor profesor8 = new Profesor(680, "Elena", "Martínez", "elena.martinez@universidad.com", "Mujer", "379323456", 32346789, universidad);
        universidad.getCarreraByID(3).getCoordinador().asignarProfesor(3, profesor8);
        
        Profesor profesor9 = new Profesor(681, "José", "Rodríguez", "jose.rodriguez@universidad.com", "Hombre", "379423456", 42346789, universidad);
        universidad.getCarreraByID(1).getCoordinador().asignarProfesor(3, profesor9);
        
        Profesor profesor10 = new Profesor(682, "Laura", "Fernández", "laura.fernandez@universidad.com", "Mujer", "379523456", 52346789, universidad);
        universidad.getCarreraByID(2).getCoordinador().asignarProfesor(2, profesor10);
        
        Profesor profesor11 = new Profesor(683, "Miguel", "Sánchez", "miguel.sanchez@universidad.com", "Hombre", "379623456", 62346789, universidad);
        universidad.getCarreraByID(3).getCoordinador().asignarProfesor(4, profesor11);
        
        Profesor profesor12 = new Profesor(684, "María", "López", "maria.lopez@universidad.com", "Mujer", "379723456", 72346789, universidad);
        universidad.getCarreraByID(1).getCoordinador().asignarProfesor(4, profesor12);
        
        Profesor profesor13 = new Profesor(685, "Fernando", "Pérez", "fernando.perez@universidad.com", "Hombre", "379823456", 82346789, universidad);
        universidad.getCarreraByID(2).getCoordinador().asignarProfesor(3, profesor13);
        
        Profesor profesor14 = new Profesor(686, "Patricia", "Suárez", "patricia.suarez@universidad.com", "Mujer", "379923456", 92346789, universidad);
        universidad.getCarreraByID(3).getCoordinador().asignarProfesor(5, profesor14);
        
        Profesor profesor15 = new Profesor(687, "Alberto", "Giménez", "alberto.gimenez@universidad.com", "Hombre", "379133456", 13346789, universidad);
        universidad.getCarreraByID(1).getCoordinador().asignarProfesor(5, profesor15);


        //creación de instancias de alumnos
        Alumno alumno1 = new Alumno(101, "Lucas", "Fernández", "lucasf@gmail.com", "Hombre", "3764001", 1234, universidad);
        Alumno alumno2 = new Alumno(102, "María", "González", "mariag@gmail.com", "Mujer", "3764002", 2345, universidad);
        Alumno alumno3 = new Alumno(103, "Joaquín", "Pérez", "joaquinp@gmail.com", "Hombre", "3764003", 3456, universidad);
        Alumno alumno4 = new Alumno(104, "Sofía", "López", "sofial@gmail.com", "Mujer", "3764004", 4567, universidad);
        Alumno alumno5 = new Alumno(105, "Matías", "Rodríguez", "matiasr@gmail.com", "Hombre", "3764005", 5678, universidad);

        Alumno alumno6 = new Alumno(106, "Valentina", "Martínez", "valentinam@gmail.com", "Mujer", "3764006", 6789, universidad);
        Alumno alumno7 = new Alumno(107, "Agustín", "Gutiérrez", "agusting@gmail.com", "Hombre", "3764007", 7890, universidad);
        Alumno alumno8 = new Alumno(108, "Camila", "Silva", "camilas@gmail.com", "Mujer", "3764008", 8901, universidad);
        Alumno alumno9 = new Alumno(109, "Santiago", "Díaz", "santiagod@gmail.com", "Hombre", "3764009", 9012, universidad);
        Alumno alumno10 = new Alumno(110, "Julieta", "Molina", "julietam@gmail.com", "Mujer", "3764010", 1123, universidad);

        Alumno alumno11 = new Alumno(111, "Tomás", "Vega", "tomasv@gmail.com", "Hombre", "3764011", 2234, universidad);
        Alumno alumno12 = new Alumno(112, "Antonella", "Ortiz", "antonellao@gmail.com", "Mujer", "3764012", 3345, universidad);
        Alumno alumno13 = new Alumno(113, "Franco", "Sosa", "francos@gmail.com", "Hombre", "3764013", 4456, universidad);
        Alumno alumno14 = new Alumno(114, "Lucía", "Romero", "luciar@gmail.com", "Mujer", "3764014", 5567, universidad);
        Alumno alumno15 = new Alumno(115, "Martín", "Castro", "martinc@gmail.com", "Hombre", "3764015", 6678, universidad);

        Alumno alumno16 = new Alumno(116, "Ana", "Paredes", "anap@gmail.com", "Mujer", "3764016", 7789, universidad);
        Alumno alumno17 = new Alumno(117, "Pablo", "Herrera", "pabloh@gmail.com", "Hombre", "3764017", 8890, universidad);
        Alumno alumno18 = new Alumno(118, "Carla", "Flores", "carla@gmail.com", "Mujer", "3764018", 9901, universidad);
        Alumno alumno19 = new Alumno(119, "Facundo", "Navarro", "facundon@gmail.com", "Hombre", "3764019", 1112, universidad);
        Alumno alumno20 = new Alumno(120, "Alicia", "Rojas", "aliciar@gmail.com", "Mujer", "3764020", 2223, universidad);

        Alumno alumno21 = new Alumno(121, "Gabriel", "Arias", "gabriela@gmail.com", "Hombre", "3764021", 3334, universidad);
        Alumno alumno22 = new Alumno(122, "Florencia", "Reyes", "florenciar@gmail.com", "Mujer", "3764022", 4445, universidad);
        Alumno alumno23 = new Alumno(123, "Iván", "Medina", "ivanm@gmail.com", "Hombre", "3764023", 5556, universidad);
        Alumno alumno24 = new Alumno(124, "Verónica", "Blanco", "veronicab@gmail.com", "Mujer", "3764024", 6667, universidad);
        Alumno alumno25 = new Alumno(125, "Leandro", "Ruiz", "leandror@gmail.com", "Hombre", "3764025", 7778, universidad);

        //inscripciones a la Carrera de Ingeniería en Sistemas
        alumno1.inscribirCarrera(1);
        alumno1.inscribirMateria(2);

        alumno2.inscribirCarrera(1);
        alumno2.inscribirMateria(4);

        alumno3.inscribirCarrera(1);
        alumno3.inscribirMateria(5);

        alumno4.inscribirCarrera(1);
        alumno4.inscribirMateria(1);

        alumno5.inscribirCarrera(1);
        alumno5.inscribirMateria(3);

        alumno6.inscribirCarrera(1);
        alumno6.inscribirMateria(4);

        alumno7.inscribirCarrera(1);
        alumno7.inscribirMateria(2);

        alumno8.inscribirCarrera(1);
        alumno8.inscribirMateria(5);

        alumno9.inscribirCarrera(1);
        alumno9.inscribirMateria(3);

        alumno10.inscribirCarrera(1);
        alumno10.inscribirMateria(1);

        //inscripciones a la Carrera de Licenciatura en Nutrición
        alumno11.inscribirCarrera(2);
        alumno11.inscribirMateria(1);

        alumno12.inscribirCarrera(2);
        alumno12.inscribirMateria(2);

        alumno13.inscribirCarrera(2);
        alumno13.inscribirMateria(3);

        alumno14.inscribirCarrera(2);
        alumno14.inscribirMateria(4);

        alumno15.inscribirCarrera(2);
        alumno15.inscribirMateria(5);

        //inscripciones a la Carrera de Licenciatura en Criminalística
        alumno16.inscribirCarrera(3);
        alumno16.inscribirMateria(1);

        alumno17.inscribirCarrera(3);
        alumno17.inscribirMateria(2);

        alumno18.inscribirCarrera(3);
        alumno18.inscribirMateria(3);

        alumno19.inscribirCarrera(3);
        alumno19.inscribirMateria(4);

        alumno20.inscribirCarrera(3);
        alumno20.inscribirMateria(5);

        alumno21.inscribirCarrera(3);
        alumno21.inscribirMateria(1);

        alumno22.inscribirCarrera(3);
        alumno22.inscribirMateria(2);

        alumno23.inscribirCarrera(3);
        alumno23.inscribirMateria(3);

        alumno24.inscribirCarrera(3);
        alumno24.inscribirMateria(4);

        alumno25.inscribirCarrera(3);
        alumno25.inscribirMateria(5);

    }
}
