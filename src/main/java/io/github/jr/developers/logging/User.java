package io.github.jr.developers.logging;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "USER")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class User{
    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "NAME")
    private String name;
}
