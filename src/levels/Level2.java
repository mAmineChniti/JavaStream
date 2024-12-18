package levels;

import models.Subject;
import models.Teacher;
import utils.Data;
import models.Teacher;

import java.util.List;
import java.util.stream.Collectors;


public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner le nombre des enseignants dont le nom commence avec s */
        long nbr = teachers.stream().filter(teacher -> teacher.getName().toLowerCase().startsWith("s")).count();

        /* TO DO 2: Retourner la somme des salaires de tous les enseignants FLUTTER (hint: mapToInt) */
        long sum = teachers.stream().filter(teacher -> teacher.getSubject() == Subject.FLUTTER).mapToInt(Teacher::getSalary).sum();

        /* TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec a */
        double average = teachers.stream().filter(teacher -> teacher.getName().toLowerCase().startsWith("a")).mapToInt(Teacher::getSalary).average().getAsDouble();


        /* TO DO 4: Retourner la liste des enseignants dont le nom commence par f */
        List<Teacher> teachers1 = teachers.stream().filter(teacher -> teacher.getName().toLowerCase().startsWith("f")).collect(Collectors.toList());

        /* TO DO 5: Retourner la liste des enseignants dont le nom commence par s */
        List<Teacher> teachers2 = teachers.stream().filter(teacher -> teacher.getName().toLowerCase().startsWith("s")).collect(Collectors.toList());


        /* TO DO 5: Retourner true si il y a au min un enseignants dont le salaire > 100000, false si non */
        boolean test = teachers.stream().anyMatch(teacher -> teacher.getSalary() > 100000);

        /* TO DO 6: Afficher le premier enseignant UNITY le nom commence avec g avec 2 manières différentes */
        /*First way*/
        Teacher T = teachers.stream().filter(teacher -> teacher.getSubject() == Subject.UNITY && teacher.getName().toLowerCase().startsWith("g")).findFirst().get();

        /*Second way*/
        Teacher T2 = teachers.stream().filter(teacher -> teacher.getSubject() == Subject.UNITY && teacher.getName().toLowerCase().startsWith("g")).limit(1).collect(Collectors.toList()).get(0);

        /* TO DO 7: Afficher le deuxième enseignant dont le nom commence avec s */
        teachers.stream().filter(teacher -> teacher.getName().toLowerCase().startsWith("s")).skip(1).limit(1).forEach(System.out::println);

    }
}
