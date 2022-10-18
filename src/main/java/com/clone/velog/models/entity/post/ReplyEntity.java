package com.clone.velog.models.entity.post;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name ="reply")
@EntityListeners(AuditingEntityListener.class)
public class ReplyEntity {
    @Id
    @GeneratedValue
    private int replyIndex;
    private String replyDescription;
    private LocalDateTime replyRegdate;
    private LocalDateTime replyUpdatedate;
    private int replyPostIndex;
    private int replyUserIndex;
}
