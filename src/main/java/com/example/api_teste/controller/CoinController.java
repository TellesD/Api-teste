package com.example.api_teste.controller;

import com.example.api_teste.controller.results.CoinResult;
import com.example.api_teste.dto.CoinDto;
import com.example.api_teste.model.FavCoin;
import com.example.api_teste.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/coin")
public class CoinController {
    @Autowired
    CoinService coinService;

    @GetMapping("/{id}")
    public List<CoinResult> searchCoins(@PathVariable("id") int id){
       return coinService.searchCoins(id);
    }

    @PostMapping("/favoritar")
    public void setFavCoins(@RequestBody CoinDto coinDto){
        var coin = new FavCoin();
       coin.setUser(coinDto.getUser_id());
       coin.setCoin(coinDto.getCoin_id());
       coin.setNotes(coinDto.getNotes());
       coin.setCreated_at(LocalDate.now());
       coin.setUpdated_at(LocalDate.now());

       coinService.favCoins(coin);
    }

    @PostMapping("/atualizar")
    public void attFavCoins(@RequestBody CoinDto coinDto){
        var coin = new FavCoin();
        coin.setUser(coinDto.getUser_id());
        coin.setCoin(coinDto.getCoin_id());
        coin.setNotes(coinDto.getNotes());
        coin.setUpdated_at(LocalDate.now());

        coinService.updateFavCoins(coin);
    }

      @PostMapping("/delete")
        public void deleteFav(@RequestBody CoinDto coinDto){
          var coin = new FavCoin();
          coin.setUser(coinDto.getUser_id());
          coin.setCoin(coinDto.getCoin_id());
        coinService.deletCoin(coin);
        }

    @GetMapping("/favorites/{id}")
    public List<CoinResult> serchFavCoins(@PathVariable("id") int id){
      return  coinService.searchFavCoins(id);
    }

}
