package com.maincas.maincasapi.catalogs.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.maincas.maincasapi.model.Attachment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class TariffScheduleAttachment extends Attachment {
  @ManyToOne(optional = false)
  @JoinColumn(name = "tariff_schedule_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private TariffSchedule tariffSchedule;
}
