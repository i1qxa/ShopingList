package com.example.shopinglist.presentation

import androidx.lifecycle.ViewModel
import com.example.shopinglist.data.ShopListRepositoryImpl
import com.example.shopinglist.domain.AddShopItem
import com.example.shopinglist.domain.EditShopItem
import com.example.shopinglist.domain.GetShopItem
import com.example.shopinglist.domain.ShopItem
import java.lang.Exception

class ShopItemViewModel:ViewModel() {
    private val repository = ShopListRepositoryImpl

    private val addShopItemUseCase = AddShopItem(repository)
    private val editShopItemUseCase = EditShopItem(repository)
    private val getShopItemUseCase = GetShopItem(repository)

    fun addShopItem(inputName:String?, inputCount:String?){
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid) {
            val shopItem = ShopItem(name,count,true)
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

    fun getShopItem(shopItemId:Int) {
        val shopItem =  getShopItemUseCase.getShopItem(shopItemId)
    }

    fun editShopItem(inputName:String?, inputCount:String?){
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid) {
            val shopItem = ShopItem(name,count,true)
            editShopItemUseCase.editShopItem(shopItem)
        }
    }

    private fun parseName(inputName:String?):String{
        return inputName?.trim() ?: ""
    }
    private fun parseCount(inputCount:String?):Int{
        return try {
            inputCount?.trim()?.toInt() ?: 0
        }
        catch (e:Exception){
            0
        }
    }
    private fun validateInput(name: String, count: Int):Boolean{
        var result = true
        if (name.isBlank()){
            //TODO("Show error input name")
            result = false
        }
        if (count<=0){
            //TODO("Show error input count")
            result = false
        }
        return result
    }

}