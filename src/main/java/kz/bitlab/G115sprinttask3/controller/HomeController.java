package kz.bitlab.G115sprinttask3.controller;

import kz.bitlab.G115sprinttask3.db.DBManager;
import kz.bitlab.G115sprinttask3.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(Model model) {
        List<Student> students = DBManager.getStudents();
        model.addAttribute("studenty", students);
        return "home";
    }

    @GetMapping("/add-student")
    public String addStudentPage() {
        return "add-student";
    }

    @PostMapping("/add-student")
    public String addStudent(Student student) {
        DBManager.addStudent(student);
        return "redirect:/";
    }
    @GetMapping("/details/{id}")
    public String detailsPage(@PathVariable Long id, Model model){
        Student student = DBManager.getStudentById(id);
        model.addAttribute("student",student);
        return "details";
    }
    @PostMapping("/edit-student")
    public String editStudent(@RequestParam("student_id") Long id,
                              @RequestParam("student_name") String name,
                              @RequestParam("student_surname") String surname,
                              @RequestParam("student_exam") int exam){
        DBManager.editStudent(id,name,surname,exam);
        return "redirect:/";
    }
    @PostMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id){
        DBManager.deleteById(id);
        return "redirect:/";
    }
}

