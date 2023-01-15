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
@Entity(name = "series")
@EntityListeners(AuditingEntityListener.class)
public class SeriesEntity {
  @Id
  @GeneratedValue
  private int seriesIndex;
  private String seriesTitle;
  private LocalDateTime seriesRegData;
  private LocalDateTime seriesUpdateDate;
  private int seriesCount;
  private int seriesUserIndex;
}
