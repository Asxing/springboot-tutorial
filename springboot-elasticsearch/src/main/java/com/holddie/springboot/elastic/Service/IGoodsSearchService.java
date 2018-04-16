package com.holddie.springboot.elastic.Service;

import com.holddie.springboot.elastic.entity.dto.SearchKeyWords;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/16 20:33
 */
public interface IGoodsSearchService {

     SearchKeyWords searchAutoComplete(String index, String type, String keyword, int entriesCount);

}
