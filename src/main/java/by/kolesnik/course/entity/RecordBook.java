package by.kolesnik.course.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "record_books")
public class RecordBook {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // рейтинг (double)
    @Column(name = "rating", nullable = false)
    private Double rating;

    @OneToOne(mappedBy = "recordBook")
    private Student student;

    //пустой публичный конструктор
    public RecordBook() {

    }

    // alt+insert -> get/set


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
