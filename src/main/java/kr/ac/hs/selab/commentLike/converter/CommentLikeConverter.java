package kr.ac.hs.selab.commentLike.converter;

import kr.ac.hs.selab.commentLike.domain.CommentLike;
import kr.ac.hs.selab.commentLike.dto.response.CommentLikeFindResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CommentLikeConverter {
    public CommentLikeFindResponse toCommentLikeFindResponse(Long commentId, Long totalCount, List<CommentLike> likes) {
        return CommentLikeFindResponse.builder()
                .commentId(commentId)
                .totalCount(totalCount)
                .commentLikes(
                        likes.stream()
                                .map(like -> new CommentLikeFindResponse.CommentLikeInnerResponse(like.getId(), like.getMember().getEmail()))
                                .collect(Collectors.toList())
                )
                .build();
    }
}
