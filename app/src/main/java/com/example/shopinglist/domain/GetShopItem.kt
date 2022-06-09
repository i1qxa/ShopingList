package com.example.shopinglist.domain

class GetShopItem(private val shopListRepository: ShopListRepository) {
    suspend fun getShopItem(shopItemId:Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId)

    }
}