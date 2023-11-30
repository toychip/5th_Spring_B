package week7.api.domain.member.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import week7.api.domain.base.BaseEntity;
import week7.api.domain.food.domain.Food;
import week7.api.domain.domain.Gender;
import week7.api.domain.domain.Review;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    // private String provider
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDateTime birthday;

//    @Embedded
    private String address;

    private boolean isOwner;

    @OneToMany(mappedBy = "member")
    private List<Food> foodList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Review> reviewList = new ArrayList<>();

}
