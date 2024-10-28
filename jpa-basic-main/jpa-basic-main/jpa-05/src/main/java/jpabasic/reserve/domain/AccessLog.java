package jpabasic.reserve.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "access_log")
public class AccessLog {

    @Id
    @TableGenerator(
            name = "accessIdGen",
            table = "id"
    )
   private Long id;
}
