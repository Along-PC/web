package com.weimo.fighting.shop.mapper;

import com.weimo.fighting.shop.model.BusinessCardBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BusinessCardMapper {

    @Select("select * from business_card")
    @Results({
            @Result(column = "card_person",property = "cardPerson"),
            @Result(column = "card_phone",property = "cardPhone"),
            @Result(column = "card_position",property = "cardPosition"),
            @Result(column = "card_person_head",property = "cardPersonHead")
    })
    public List<BusinessCardBean> getAllBusinessCard();

    @Update("update business_card set card_phone =#{cardPhone},card_position=#{cardPosition} where card_person=#{cardPerson}")
    public void updateBusinessCard(BusinessCardBean businessCardBean);

    @Insert("insert into business_card(card_person,card_phone,card_position) values(#{cardPerson},#{cardPhone},#{cardPosition})")
    public void addBusinessCard(BusinessCardBean businessCardBean);

}
