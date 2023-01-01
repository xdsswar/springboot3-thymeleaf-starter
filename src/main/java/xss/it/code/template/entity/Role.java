package xss.it.code.template.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XDSSWAR
 * Created on 01/01/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @ElementCollection(targetClass = Permits.class,fetch = FetchType.EAGER)
    @CollectionTable(
            name = "permits_link",
            joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "permits")
    private List<Permits> permits=new ArrayList<>();
}
