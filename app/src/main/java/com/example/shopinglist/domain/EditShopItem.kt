package com.example.shopinglist.domain

class EditShopItem(private val shopListRepository: ShopListRepository) {
    suspend fun editShopItem(shopItem: ShopItem){
        shopListRepository.editShopItem(shopItem)
    }
}