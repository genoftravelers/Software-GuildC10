/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.dao;

import com.sg.KarmaSuperHero.dto.Hero;
import com.sg.KarmaSuperHero.dto.Organization;
import com.sg.KarmaSuperHero.dto.Superpower;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface HeroDao {
    
     Hero getHeroById(int id);

    List<Hero> getAllHeroes();

    Hero addHero(Hero hero);

    void updateHero(Hero hero);

    void deleteHeroById(int id);

    List<Hero> getHeroesBySuperpower(Superpower superPower);

    public void insertHeroOrganization(Hero hero, List<Integer> organizationIds);

    public List<Hero> getHeroesByOrganization(Organization organization);

    
}
