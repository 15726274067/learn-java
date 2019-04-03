package com.zhutao.algorithm.sort;

import java.util.List;

/**
 * @Author: zhutao
 * @Date: 2019/4/3 11:38
 * @Version 1.0
 */
public interface Sort<T> {
    void sort(List<? extends T> list, int len);
}
