package com.drakezzz.internetstore.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummaryData {

    private List<GoodDto> goodList;

    private List<CategoryDto> categories;

}
