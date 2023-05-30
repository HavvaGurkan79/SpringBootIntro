package com.tpe.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @JsonProperty("bookName") // sadece JSON .ciktidaki key degerini degistirmis olduk
    //sadece client tarafina giden gelen datalarda isim bookName oldu!
    private String name ;
     @JsonIgnore//GetAll methodu cagirdigimizda syudenta gidip book'a gelir Book'tan tekrar student'a gitmemesi icin
     // (iki classdaki fieldlarin surekli yazilip sonsuz donguye girmemek) ve stackoverflow exception almmamak icin
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    // Getter
    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public Student getStudent() {
        return student;
    }
}