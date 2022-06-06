package com.example.api_teste.repository;

import com.example.api_teste.controller.results.CoinResult;
import com.example.api_teste.model.Coin;
import com.example.api_teste.model.FavCoin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinRepository extends MongoRepository<FavCoin, String> {
    List<FavCoin> findByUser(int id);
    FavCoin findByUserAndAndCoin (int user, String coin);

}
