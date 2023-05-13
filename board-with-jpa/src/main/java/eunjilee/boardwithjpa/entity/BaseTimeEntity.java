package eunjilee.boardwithjpa.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
@MappedSuperclass
@Getter
public class BaseTimeEntity {
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime regDate;
    @UpdateTimestamp
    private LocalDateTime modDate;
}
