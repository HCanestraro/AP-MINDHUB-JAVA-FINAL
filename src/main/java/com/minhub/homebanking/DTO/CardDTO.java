//╔═══════════════════════════════════════════════════════════╗
//║					CHE - HOMEBANKING						  ║
//╚═══════════════════════════════════════════════════════════╝
package com.mindhub.homebanking.DTO;

import com.mindhub.homebanking.Models.Card;
import com.mindhub.homebanking.Models.CardColor;
import com.mindhub.homebanking.Models.CardType;
import com.mindhub.homebanking.Models.Client;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;

public class CardDTO{
    private long id;
    private String cardHolder;
    private CardType type;
    private CardColor color;
    private String number;
    private int cvv;
    private LocalDate fromDate;
    private LocalDate thruDate;
    private Client client;

    public CardDTO(Card card) {
        this.id = card.getId();
        this.cardHolder = card.getCardHolder();
        this.type = card.getType();
        this.color = card.getColor();
        this.number = card.getNumber();
        this.cvv = card.getCvv();
        this.fromDate = card.getFromDate();
        this.thruDate = card.getThruDate();
    }

    public long getId() {
        return id;
    }
    public String getCardHolder() {
        return cardHolder;
    }
    public CardType getType() {
        return type;
    }
    public CardColor getColor() {
        return color;
    }
    public String getNumber() {
        return number;
    }
    public int getCvv() {
        return cvv;
    }
    public LocalDate getFromDate() {
        return fromDate;
    }
    public LocalDate getThruDate() {
        return thruDate;
    }
}