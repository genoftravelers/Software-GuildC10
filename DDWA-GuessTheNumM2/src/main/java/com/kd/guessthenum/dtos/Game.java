/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.tree.RowMapper;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
//LOL//
public class Game {

    int gameId;
    boolean status;
    String answer;

    List<Rounds> rounds = new ArrayList<>();

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.gameId;
        hash = 19 * hash + (this.status ? 1 : 0);
        hash = 19 * hash + Objects.hashCode(this.answer);
        hash = 19 * hash + Objects.hashCode(this.rounds);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        if (!Objects.equals(this.rounds, other.rounds)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", status=" + status + ", answer=" + answer + ", rounds=" + rounds + '}';
    }

}
