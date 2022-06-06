package com.example.api_teste.controller.results;

import com.example.api_teste.model.Coin;
import lombok.Data;

@Data
public class CoinResult extends Coin {

    private Boolean is_favorite;
}
