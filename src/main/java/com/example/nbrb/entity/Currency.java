package com.example.nbrb.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Currency {
    @Id
    @JsonProperty("Cur_ID")
    private int curId;
    @JsonProperty("Date")
    private Date date;
    @JsonProperty("Cur_Abbreviation")
    private String curAbbrevation ;
    @JsonProperty("Cur_Scale")
    private int CurScale;
    @JsonProperty("Cur_Name")
    private String curName;
    @JsonProperty("Cur_OfficialRate")
    private double curOficialRate;
}
