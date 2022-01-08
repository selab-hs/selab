package kr.ac.hs.selab.member.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import kr.ac.hs.selab.error.template.ErrorMessage;
import kr.ac.hs.selab.error.exception.common.InvalidArgumentException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Nickname {

    @Transient
    private static final int MAX_LENGTH = 15;

    @Column(name = "member_nickname", unique = true)
    private String nickname;

    private Nickname(String nickname) {
        validate(nickname);
        this.nickname = nickname;
    }

    public void validate(String nickname) {
        if (!StringUtils.hasText(nickname) || nickname.length() > MAX_LENGTH) {
            throw new InvalidArgumentException(ErrorMessage.MEMBER_NICKNAME_INVALID_ARGUMENT_ERROR);
        }
    }

    public static Nickname of(String nickname) {
        return new Nickname(nickname);
    }
}