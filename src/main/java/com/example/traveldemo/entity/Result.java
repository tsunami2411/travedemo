package com.example.traveldemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: Maozh
 * @Date: 2021 07 19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class Result {
    private Boolean state = true;
    private String msg;

}
