package com.courses.concurrency_10.forkjoin_15;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by VSulevskiy on 07.12.2015.
 */
public class NodeImpl implements Node {
    private long value;
    private Collection<Node> children;

    public NodeImpl(long value, Collection<Node> children) {
        this.value = value;
        this.children = children;
    }

    public NodeImpl(long value) {
        this(value, new ArrayList<Node>());
    }

    @Override
    public Collection<Node> getChildren() {
        return children;
    }

    @Override
    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NodeImpl{" +
                "value=" + value +
                ",\n children=" + children +
                '}';
    }
}
