package com.example.shopinglist.domain

class AddShopItem(private val shopListRepository: ShopListRepository) {
    fun addShopItem(shopItem: ShopItem){
        shopListRepository.addShopItem(shopItem)
    }
}