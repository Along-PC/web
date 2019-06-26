package com.weimo.fighting.shop.model;

import org.springframework.stereotype.Component;

@Component
public class BusinessCardBean {

    private String cardPerson;
    private String cardPhone;
    private String cardPosition;
    private String cardPersonHead;

    public String getCardPerson() {
        return cardPerson;
    }

    public void setCardPerson(String cardPerson) {
        this.cardPerson = cardPerson;
    }

    public String getCardPhone() {
        return cardPhone;
    }

    public void setCardPhone(String cardPhone) {
        this.cardPhone = cardPhone;
    }

    public String getCardPosition() {
        return cardPosition;
    }

    public void setCardPosition(String cardPosition) {
        this.cardPosition = cardPosition;
    }

    public String getCardPersonHead() {
        return cardPersonHead;
    }

    public void setCardPersonHead(String cardPersonHead) {
        this.cardPersonHead = cardPersonHead;
    }

    @Override
    public String toString() {
        return "BusinessCardBean{" +
                "cardPerson='" + cardPerson + '\'' +
                ", cardPhone='" + cardPhone + '\'' +
                ", cardPosition='" + cardPosition + '\'' +
                ", cardPersonHead='" + cardPersonHead + '\'' +
                '}';
    }
}
