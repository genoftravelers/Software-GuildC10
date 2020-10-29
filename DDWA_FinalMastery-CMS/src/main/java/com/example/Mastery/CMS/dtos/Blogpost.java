/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.dtos;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Blogpost {

    private int id;

    @NotBlank(message = "Title must not be empty.")
    @Size(max = 45, message = "Title must be less than 45 characters.")
    private String title;

    private boolean isStatic;
    private LocalDateTime blogDate;

//    @NotBlank(message = "expiration date must not be empty.")
    private LocalDateTime expiration;
    private boolean isVerified;

    @NotBlank(message = "Content must not be empty.")
    private String blogContent;

    private int userId;
    private Set<Hashtag> hashtags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isIsStatic() {
        return isStatic;
    }

    public void setIsStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }

    public LocalDateTime getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(LocalDateTime blogDate) {
        this.blogDate = blogDate;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Set<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(Set<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.title);
        hash = 73 * hash + (this.isStatic ? 1 : 0);
        hash = 73 * hash + Objects.hashCode(this.blogDate);
        hash = 73 * hash + Objects.hashCode(this.expiration);
        hash = 73 * hash + (this.isVerified ? 1 : 0);
        hash = 73 * hash + Objects.hashCode(this.blogContent);
        hash = 73 * hash + this.userId;
        hash = 73 * hash + Objects.hashCode(this.hashtags);
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
        final Blogpost other = (Blogpost) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.isStatic != other.isStatic) {
            return false;
        }
        if (this.isVerified != other.isVerified) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.blogContent, other.blogContent)) {
            return false;
        }
        if (!Objects.equals(this.blogDate, other.blogDate)) {
            return false;
        }
        if (!Objects.equals(this.expiration, other.expiration)) {
            return false;
        }
        if (!Objects.equals(this.hashtags, other.hashtags)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Blogpost{" + "id=" + id + ", title=" + title + ", isStatic=" + isStatic + ", blogDate=" + blogDate + ", expiration=" + expiration + ", isVerified=" + isVerified + ", blogContent=" + blogContent + ", userId=" + userId + ", hashtags=" + hashtags + '}';
    }

}
