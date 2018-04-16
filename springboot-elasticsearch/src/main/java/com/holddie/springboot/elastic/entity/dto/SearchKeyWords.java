package com.holddie.springboot.elastic.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/16 20:51
 */
@Data
public class SearchKeyWords implements Serializable {

    private static final long serialVersionUID = -6134423902925057723L;

    private List<String> keywords;
}
