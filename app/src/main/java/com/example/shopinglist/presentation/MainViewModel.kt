package com.example.shopinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.shopinglist.data.ShopListRepositoryImpl
import com.example.shopinglist.domain.DeleteShopItem
import com.example.shopinglist.domain.EditShopItem
import com.example.shopinglist.domain.GetShopList
import com.example.shopinglist.domain.ShopItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)
    private val getShopListUseCase = GetShopList(repository)
    private val deleteShopItemUseCase = DeleteShopItem(repository)
    private val editShopItemUseCase = EditShopItem(repository)

    private val scope = CoroutineScope(Dispatchers.IO)
    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem) {
        scope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    fun changeEnableState(shopItem: ShopItem) {
        scope.launch {
            val newItem = shopItem.copy(enable = !shopItem.enable)
            editShopItemUseCase.editShopItem(newItem)
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}