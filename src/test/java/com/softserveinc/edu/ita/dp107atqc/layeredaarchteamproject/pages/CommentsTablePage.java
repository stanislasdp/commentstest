package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;


import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Category;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Comment;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Link;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by stas on 2/14/17.
 */
public final class CommentsTablePage {

    private CommentTablePageUIMap map;

    public CommentsTablePage() {
        map = new CommentTablePageUIMap();
    }

    public MainPage getMainPage() {
        return new MainPage();
    }

    public CommentsTablePage setNextPage() {
        findPage(link -> link.getText().contains(">")).click();
        return this;
    }

    public boolean isNextPagePresent() {
        return map.getPages()
                .stream()
                .anyMatch(link -> link.getText().equals(">"));
    }

    public CommentsTablePage setPreviousPage() {
        findPage(link -> link.getText().contains("<")).click();
        return this;
    }


    public CommentsTablePage setPageNumber(String pageNumber) {
        findPage(link -> link.getText().equals(pageNumber)).click();
        return this;
    }

    public boolean isPageExists(String pageNumber) {
        return map.getPages()
                .stream()
                .anyMatch(link -> link.getText().equals(pageNumber));
    }

    public int getPageNumber() {
        Iterator<Link> pages = map.getPages().iterator();
        int prevPageNumber = 0;
        while (pages.hasNext()) {
            String nextPage = pages.next().getText();
            if (nextPage.equals("")) {
                return 1;
            }
            if (nextPage.equals("<")) {
                continue;
            }

            int nextPageNumber = Integer.parseInt(nextPage);
            if ((nextPageNumber - prevPageNumber) > 1) {
                return ++prevPageNumber;
            }
            prevPageNumber = nextPageNumber;
        }
        return ++prevPageNumber;
    }

    public Comment getCommentFromTableByNumber(String number) {
      return getComments(row -> row.getCommentNumber().getValue().equals(number)).get(0);
    }

    public List<Comment> getAllComments() {
        return getComments(row -> true);
    }

    public List<Comment> getAllCommentsWithActiveStatus(boolean isCommentActive) {
        return getComments(row -> row.getActiveStatus().getValue().isEmpty() == isCommentActive);
    }

    public List<Comment> getAllCommentsWithSpecCat(Category category) {
        return getComments(row -> row.getCommentCategories().getValue()
                .contains(category.getCategory()));
    }

    public boolean isAllCommentsWithStatus(boolean status) {
        return getAllComments().stream().allMatch(comment -> comment.isActive() == status);
    }

    public boolean isAllCommentsWithCategory(Category category) {
        return getAllComments().stream()
                .allMatch(comment -> comment.getCategories().contains(category));
    }

    public CommentsTablePage selectCommentWithCommentNumber(Comment comment) {
        if (getPageNumber() != 1) {
            setPageNumber("1");
        }
        while (true) {
            try {
               CommentTablePageRow comm = findCommentsRowsOnPage(row -> row.getCommentNumber().getValue()
                        .equals(comment.getCommentId())).stream().findFirst().orElseThrow(() ->
                       new NoSuchElementException("No such comment"));
                CheckBox checkBox = comm.getCheckBox();
                if (!checkBox.isSelected()) {
                    checkBox.check();
                    return this;
                }
            } catch (NoSuchElementException e) {
                setNextPage();
                continue;
            }
            setNextPage();
        }
    }

    public CommentsTablePage selectAllCommentsOnPage() {
        map.getCommentRows().stream().filter(row -> !row.getCheckBox().isSelected())
                .forEach(row ->row.getCheckBox().check());
        return this;
    }

    public CommentsTablePage deselectAllCommentsOnPage() {
        map.getCommentRows().stream().filter(row -> row.getCheckBox()
                        .isSelected()).forEach(row -> row.getCheckBox().check());
        return this;
    }

    public boolean isCommentSelected(Comment comment) {
      return findCommentsRowsOnPage(row -> row.getCommentNumber()
              .getValue().equals(comment.getCommentId())
              && !row.getCheckBox().isSelected()).isEmpty();
    }

    public boolean isAllCommAreUnchecked() {
       return map.getCommentRows().stream().
               noneMatch(row -> row.getCheckBox().isSelected());
    }

    private List<CommentTablePageRow> findCommentsRowsOnPage(
            Predicate<CommentTablePageRow> predicate) {
       return map.getCommentRows()
               .stream()
               .filter(predicate)
               .collect(Collectors.toList());
    }

    private List<Comment> getCommentsOnPage(Predicate <CommentTablePageRow> predicate) {
        return findCommentsRowsOnPage(predicate)
                .stream()
                .map(this::retrieveCommentFromRow)
                .collect(Collectors.toList());
    }

    private List<Comment> getComments(Predicate <CommentTablePageRow> predicate) {
        if (getPageNumber() != 1) {
            setPageNumber("1");
        }
        List<Comment> comments = new ArrayList<>();
        boolean isLastPage = false;
        while (true) {
            comments.addAll(getCommentsOnPage(predicate));
            if (isLastPage || map.getPages().size() == 1) {
                break;
            }
            setNextPage();
            if (!isNextPagePresent()) {
                isLastPage = true;
            }
        }
        return comments;
    }

    private Comment retrieveCommentFromRow(CommentTablePageRow row) {
        String commNumber = row.getCommentNumber().getValue();
        String commText = row.getCommentText().getValue();
        String commActiveString = row.getActiveStatus().getValue();
        boolean isCommentActive = !commActiveString.equals("V");
        String catText = row.getCommentCategories().getValue();
        List<Category> categoryList = Arrays.stream(catText.replaceAll(" ","")
                .split(";")).map(Category::new)
                .collect(Collectors.toList());
        return new Comment(commNumber, commText, isCommentActive, categoryList);
    }

    private Link findPage(Predicate<Link> predicate) {
        return map
                .getPages()
                .stream().filter(predicate)
                .findFirst().orElseThrow(NoSuchElementException::new);
    }

    public CommentsTablePage changeSortingByNumber() {
        map.getSortByNumberLink().click();
        return this;
    }

    public CommentsTablePage changeSortingByText() {
        map.getSortByCommentTextLink().click();
        return this;
    }

    public CommentsTablePage changeSortingByActiveStatus() {
        map.getSortByActiveStatusLink().click();
        return this;
    }

    private boolean isSortedInOrder(Comparator<Comment> comparator) {
        Iterator<Comment> comments = getAllComments().iterator();
        Comment previous = comments.next();
        while (comments.hasNext()) {
            Comment current = comments.next();
            if (comparator.compare(previous, current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    private boolean isCommSortByOrderForActive(Comparator<Comment> comparator) {
        Iterator<Comment> comments = getAllComments().iterator();
        Comment previous = comments.next();
        /*last active marker is true when subsequent comments in the list
         after last active comm are inactive, false otherwise*/
        boolean lastActiveCommentMarker = false;
        while (comments.hasNext()) {
            Comment current = comments.next();
            if (comparator.compare(previous, current) > 0) {
                /*switch flag when inactive comment after active is found*/
                lastActiveCommentMarker = !lastActiveCommentMarker;
                /*if flag has been switched more than once return false*/
                if (!lastActiveCommentMarker) {
                    return false;
                }
            }
            previous = current;
        }
        return true;
    }

    public boolean isCommSortByNumbInAscOrder() {
        return isSortedInOrder(Comparator.comparing(Comment::getCommentId));
    }

    public boolean isCommSortByNumbInDescOrder() {
        return isSortedInOrder(Comparator.comparing(Comment::getCommentId));
    }

    public boolean isCommSortByCommTextInAscOrder() {
        return isSortedInOrder(Comparator.comparing(Comment::getCommentText));
    }

    public boolean isCommSortByCommTextInDescOrder() {
        return isSortedInOrder((comm1, comm2)
                -> comm2.getCommentText().compareTo(comm1.getCommentText()));
    }

    public boolean isCommSortByActInAscOrder() {
        return isCommSortByOrderForActive((comm1, comm2)
                -> Boolean.compare(comm1.isActive(), comm2.isActive()));
    }

    public boolean isCommSortByActInDescOrder() {
        return isCommSortByOrderForActive((comm1, comm2)
                -> Boolean.compare(comm2.isActive(), comm1.isActive()));
    }
}
