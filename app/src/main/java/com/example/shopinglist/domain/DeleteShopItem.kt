package com.example.shopinglist.domain

class DeleteShopItem(private val shopListRepository: ShopListRepository) {
    suspend fun deleteShopItem(shopItem: ShopItem){
        shopListRepository.deleteShopItem(shopItem)
    }
}