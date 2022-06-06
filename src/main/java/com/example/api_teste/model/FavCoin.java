package com.example.api_teste.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Document(collection = "favCoins")
public class FavCoin {

        @Transient
        public static final String SEQUENCE_NAME = "favCoins_sequence";

        @Id
        private Long id;
        private String notes;
        private String coin;
        private int user;
        private LocalDate updated_at;
        private LocalDate created_at;


}
