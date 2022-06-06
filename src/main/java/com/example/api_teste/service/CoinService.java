package com.example.api_teste.service;

import com.example.api_teste.controller.results.CoinResult;
import com.example.api_teste.model.Coin;
import com.example.api_teste.model.FavCoin;
import com.example.api_teste.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CoinService {
    @Autowired
    CoinRepository coinRepository;
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    public List<CoinResult> searchCoins(int user) {
        RestTemplate restTemplate = new RestTemplate();


        Coin[] res = restTemplate.getForObject("https://api.coinpaprika.com/v1/coins", Coin[].class);

        List<CoinResult> results = new ArrayList<>();


        assert res != null;
        for (Coin coins : res){
             var coin =coinRepository.findByUserAndAndCoin(user, coins.getId());
             if (coin != null){
                 CoinResult result = new CoinResult();
                 result.setId(coins.getId());
                 result.setName(coins.getName());
                 result.setType(coins.getType());
                 result.setSymbol(coins.getSymbol());
                 result.setIs_favorite(true);
                 results.add(result);
             }else {
                 CoinResult result = new CoinResult();
                 result.setId(coins.getId());
                 result.setName(coins.getName());
                 result.setType(coins.getType());
                 result.setSymbol(coins.getSymbol());
                 result.setIs_favorite(false);
                 results.add(result);
             }
        }



        return results ;
    }

    public void favCoins(FavCoin coin) {

        coin.setId(sequenceGeneratorService.generateSequence(FavCoin.SEQUENCE_NAME));
        coinRepository.save(coin);
    }
    public void deletCoin(FavCoin coin) {
        var coinFav = coinRepository.findByUserAndAndCoin(coin.getUser(),coin.getCoin());
        coinRepository.delete(coinFav);
    }

    public void updateFavCoins(FavCoin coin) {
       var coinFav = coinRepository.findByUserAndAndCoin(coin.getUser(),coin.getCoin());
       coinFav.setNotes(coin.getNotes());
       coinFav.setUpdated_at(LocalDate.now());
       coinRepository.save(coinFav);
    }



    public List<CoinResult> searchFavCoins(int id) {
        var favCoins = coinRepository.findByUser(id);

        RestTemplate restTemplate = new RestTemplate();
        List<CoinResult> coinResults = new ArrayList<>();

        for (FavCoin favCoin : favCoins) {
            coinResults.add(restTemplate.getForObject("https://api.coinpaprika.com/v1/coins/".concat(favCoin.getCoin()), CoinResult.class));
        }

        return coinResults;
    }


}
