package com.company;

import enumerations.HandScoreValue;
import models.Card;
import models.PlayerHand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VideoPokerStart extends PokerMainDeckRandomizer {

    private Scanner scan = new Scanner(System.in);
    private PlayerHand playerHand = new PlayerHand();
    private List<Card> deck = new ArrayList<>();

    public static void main(String[] args) {
        VideoPokerStart videoPokerStart = new VideoPokerStart();
        videoPokerStart.playVideoPoker();
    }

    private void playVideoPoker() {
        HandScoreValue handScoreValue;
        System.out.println("Welcome to the \"Video Poker\"!");
        this.deck = buildPokerDeck();
        dragCardsFromDeck();
        showPlayerHandCards();
        redrawingCards();
        handScoreValue = evaluateHand(this.playerHand.cards);
        System.out.println("Your result is: " + handScoreValue);
        System.out.println("Your score: " + handScoreValue.label);
        replayVideoPoker();
    }

    public void replayVideoPoker() {
        String replayAgreement = "init";
        while (!replayAgreement.equals("N")) {
            System.out.println("Do you want to replay game? Input (Y/N)");
            replayAgreement = scan.next();
            if (replayAgreement.equals("Y")) {
                this.playerHand.setPlayerHandSize(0);
                resetInGameData();
                playVideoPoker();
            } else if (replayAgreement.equals("N")) {
                System.out.println("Sadly... Then wait for results!");
            } else System.out.println("Enter logical input!");
        }
    }

    public void dragCardsFromDeck() {
        while (this.playerHand.playerHandSize < 5) {
            this.playerHand.cards.add(this.deck.get(this.deck.size() - 1));
            this.deck.remove(this.deck.size() - 1);
            this.playerHand.setPlayerHandSize(this.playerHand.playerHandSize++);
        }
    }

    public void redrawCardsFromDeck() {
        List<String> redrawCardIndexes = new ArrayList<>();
        System.out.println("How many cards you want to redraw?");
        String redrawCount = scan.next();
        if (Integer.parseInt(redrawCount) > 0 && Integer.parseInt(redrawCount) < 6) {
            System.out.println("Enter, which cards you want to redraw (enter card indexes).");
            for (int iterator = 0; iterator < Integer.parseInt(redrawCount); iterator++) {
                String redrawIndex = scan.next();
                redrawCardIndexes.add(redrawIndex);
            }
            for (int iterator = 0; iterator < redrawCardIndexes.size(); iterator++) {
                this.playerHand.cards.set(Integer.parseInt(redrawCardIndexes.get(iterator)), null);
            }
            for (int iterator = 4; iterator >= 0; iterator--) {
                if (this.playerHand.cards.get(iterator) == null) {
                    this.playerHand.cards.remove(iterator);
                }
            }
            System.out.println("Not wanted cards were removed! Please take a look at your new cards! \n");
            this.playerHand.setPlayerHandSize(this.playerHand.cards.size());
            dragCardsFromDeck();
            showPlayerHandCards();
        } else System.out.println("You entered incorrect value!");
    }

    public void showPlayerHandCards() {
        System.out.println("Your cards: \n");
        for (int iterator = 0; iterator < 5; iterator++) {
            System.out.println(iterator + ")" + this.playerHand.cards.get(iterator).suitType + " " + this.playerHand.cards.get(iterator).ranking);
        }
        System.out.println("\n");
    }

    public void redrawingCards() {
        String redrawingAgreement = "init";
        while (!redrawingAgreement.equals("N")) {
            System.out.println("Do you want to redraw cards? Input (Y/N)");
            redrawingAgreement = scan.next();
            if (redrawingAgreement.equals("Y")) {
                if (this.deck.size() != 0) {
                    redrawCardsFromDeck();
                }
            } else if (redrawingAgreement.equals("N")) {
                System.out.println("Sadly... Then wait for results!");
            } else System.out.println("Enter logical input!");
        }
    }

    public void resetInGameData() {
        this.playerHand = new PlayerHand();
        this.deck = new ArrayList<>();
    }
}
