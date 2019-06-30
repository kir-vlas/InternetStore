package com.drakezzz.internetstore.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusResult {

    private String status;

    public static StatusResult ok() {
        return new StatusResult("ok");
    }
}
