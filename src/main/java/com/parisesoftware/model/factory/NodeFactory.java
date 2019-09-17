package com.parisesoftware.model.factory;

import com.parisesoftware.model.INode;
import com.parisesoftware.model.Node;

/**
 * Default implementation of {@link INodeFactory}
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.5
 * @since 1.0.5
 */
public class NodeFactory<T extends Comparable<T>> implements INodeFactory<T> {

    /**
     * {@inheritDoc}
     */
    @Override
    public INode<T> createNode(T info) {
        return new Node<>(null, info);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public INode<T> createNodeWithLink(INode<T> link, T info) {
        return new Node<>(link, info);
    }

}
