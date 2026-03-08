package org.example;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private Owner owner;
    private List<String> cards;
    private int totalMoney;

    public Wallet() {
        this.cards = new ArrayList<>();
        this.totalMoney = 0;
    }

    // set & get owner
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    // kartu
    public void addCard(String card) {
        cards.add(card);
    }

    public String takeCard(String card) {
        if (cards.contains(card)) {
            cards.remove(card);
            return card;
        }
        return null;
    }

    public List<String> getCards() {
        return cards;
    }

    // uang
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        totalMoney += amount;
    }

    public boolean withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid Amount");
        }
        if (amount > totalMoney) {
            throw new InsufficientFundsException();
        }
        totalMoney -= amount;
        return true;
    }

    public boolean validBalance(int amount) {
        if (amount < 0) {
            return false;
        }
        return true;
    }

    public int getTotalMoney() {
        return totalMoney;
    }
}
