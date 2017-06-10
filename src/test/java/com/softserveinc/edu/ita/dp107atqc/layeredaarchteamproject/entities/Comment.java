package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities;
import java.util.List;
import java.util.Objects;


public final class Comment {
    private String commentId;
    private String commentText;
    private List<Category> categories;
    private boolean active = true;

    public Comment (){}

    public Comment(String commtId, String commText, boolean isCommActive, List<Category> commCat) {
        if (commtId == null) {
            throw new NullPointerException("comment id is null");
        }
        if (commText == null) {
            throw new NullPointerException("comment text is null");
        }
        if (commCat == null) {
            throw new NullPointerException("comment categories is null");
        }
        this.commentId = commtId;
        this.commentText = commText;
        active = isCommActive;
        categories = commCat;

    }

    public String getCommentText() {
        return commentText;
    }

    public String getCommentId() {
        return commentId;
    }

    public boolean isActive() {
        return active;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Comment setCommentId(String commentId) {
        this.commentId = commentId;
        return this;
    }

    public Comment setCommentText(String commentText) {
        this.commentText = commentText;
        return this;
    }

    public Comment setCategories(
            List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Comment setActive(boolean active) {
        this.active = active;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return active == comment.active &&
                Objects.equals(commentId, comment.commentId) &&
                Objects.equals(commentText, comment.commentText) &&
                Objects.equals(categories, comment.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, commentText, categories, active);
    }
}


