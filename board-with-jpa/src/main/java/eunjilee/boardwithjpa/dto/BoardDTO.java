package eunjilee.boardwithjpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
public class BoardDTO {
    private String title;
    private String content;
}
