package kakao.valuetogether.domain;

import kakao.valuetogether.domain.enums.Target;
import kakao.valuetogether.domain.enums.Topic;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String subTitle;

    @Column(nullable = false,length = 1000)
    private String content;

    @Column(name = "target_amount")
    private Integer targetAmount;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "is_confirm")
    private Boolean isConfirm;

    public Post(Member member, String title, String subTitle, String content, Integer targetAmount, Date startDate, Date endDate, Boolean isConfirm) {
        this.member = member;
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.targetAmount = targetAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isConfirm = isConfirm;
    }

    public Post() {
    }

    public void addLink(Link link) {
        link.setPost(this);
        //this.links.add(link);
    }

    public static Post createPost(Post post, Link... links) {
        for (Link link : links)
            post.addLink(link);
        return post;
    }
}
