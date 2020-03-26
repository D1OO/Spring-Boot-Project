package net.shvdy.sbproject.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

/**
 * 21.03.2020
 *
 * @author Dmitriy Storozhenko
 * @version 1.0
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodDTO {
    private Long food_id;
    private Long userId;
    private String name;
    private int calories;
    private int proteins;
    private int fats;
    private int carbohydrates;

    @Override
    public String toString() {
        //Jackson (Java object to JSON String mapping)
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}