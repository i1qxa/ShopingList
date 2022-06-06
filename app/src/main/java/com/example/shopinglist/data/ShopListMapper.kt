package com.example.shopinglist.data

import com.example.shopinglist.domain.ShopItem

class ShopListMapper {

    fun mapEntityToDbModel(shopItem: ShopItem) = ShopItemDBModel(
            id =  shopItem.id,
            name = shopItem.name,
            count = shopItem.count,
            enable = shopItem.enable
         )
    fun mapDbModelToEntity(shopItemDBModel: ShopItemDBModel) = ShopItem(
        id =  shopItemDBModel.id,
        name = shopItemDBModel.name,
        count = shopItemDBModel.count,
        enable = shopItemDBModel.enable
    )
    fun mapListDbModelToListEntity(list: List<ShopItemDBModel>) = list.map{
        mapDbModelToEntity(it)
    }
}