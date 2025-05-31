package com.beautysalon.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Set<User> getUsers() {return users;}
    public void setUsers(Set<User> users) {this.users = users;}

}
