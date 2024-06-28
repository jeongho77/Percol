package Umc.Percol.web.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class IncenseDTO {

    private Long id;
    private String name;
    private String image;
    private String type;
    private String content;


}
