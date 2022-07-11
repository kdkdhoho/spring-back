package kakao.valuetogether.service;

import kakao.valuetogether.domain.Comment;
import kakao.valuetogether.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Long enrollComment(Comment comment) {
        commentRepository.saveComment(comment);
        return comment.getId();
    }

    // 댓글 수정

    // 댓글 삭제

    // 좋아요
    public void clickLike(Comment comment) {
        commentRepository.addLikes(comment);
    }

    // 좋아요 취소
}
