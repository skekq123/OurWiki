package com.one.ourwiki.responsedto;

import com.one.ourwiki.domain.Contributor;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContributorResponseDto {
    private String name;

    public ContributorResponseDto(Contributor contributor) {
        this.name = contributor.getName();
    }
}
