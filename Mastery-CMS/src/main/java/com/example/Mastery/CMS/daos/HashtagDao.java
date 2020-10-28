/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.daos;

import com.example.Mastery.CMS.dtos.Hashtag;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface HashtagDao {

    Hashtag getHashTagById(int id);

    Hashtag getHashtagByName(String name);

    List<Hashtag> getAllHashtags();

    void deleteHashtag(int id);

    void updateHashtag(Hashtag hashtag);

    Hashtag createHashTag(Hashtag hashtag);
}
