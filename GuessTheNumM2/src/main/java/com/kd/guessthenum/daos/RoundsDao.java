/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.daos;

import com.kd.guessthenum.dtos.Game;
import com.kd.guessthenum.dtos.Rounds;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface RoundsDao {
    
    List<Rounds> getAllRounds(Game game);
    Rounds getRoundsById(int id);
    Rounds addRounds(Rounds round);
    void updateRounds(Rounds round);
    void deleteRoundsById(int id);
}
