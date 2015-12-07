package com.courses.concurrency_10.forkjoin_15;

import java.util.Collection;

/**
 * Created by VSulevskiy on 07.12.2015.
 */
public interface Node {
    Collection<Node> getChildren();
    long getValue();
}
