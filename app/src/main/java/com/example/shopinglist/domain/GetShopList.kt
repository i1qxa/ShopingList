package com.example.shopinglist.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class GetShopList(private val shopListRepository: ShopListRepository) {
    fun getShopList(): LiveData<List<ShopItem>> {

        return shopListRepository.getShopList()

    }
}