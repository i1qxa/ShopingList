package com.example.shopinglist.presentation

import androidx.lifecycle.ViewModel
import com.example.shopinglist.domain.DeleteShopItem
import com.example.shopinglist.domain.EditShopItem
import com.example.shopinglist.domain.GetShopList
import com.example.shopinglist.domain.ShopListRepository

class MainViewModel: ViewModel() {

    private val repository = ShopListRepository

    private val getShopListUseCase = GetShopList(repository)
    private val deleteShopItemUseCase = DeleteShopItem(repository)
    private val editShopItemUseCase = EditShopItem(repository)

}