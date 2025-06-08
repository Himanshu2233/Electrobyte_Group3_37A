package dao;

import model.Review;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReviewDaoTest {

    @Test
    public void testAddReview() {
        ReviewDao dao = new ReviewDao();
        Review review = new Review();
        review.setUserId(9);
        review.setProductId(21);
        review.setReviewText("Great product!");
        boolean result = dao.addReview(review);
        assertTrue("Review should be added successfully", result);
    }
}