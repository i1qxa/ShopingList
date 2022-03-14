package com.example.shopinglist.domain

class GetShopList(private val shopListRepository: ShopListRepository) {
    fun getShopList():List<ShopItem>{

        return shopListRepository.getShopList()

    }
}