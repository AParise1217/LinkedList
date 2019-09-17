package com.parisesoftware.model.factory;

import com.parisesoftware.model.INode;

/**
 * Encapsulation of Creational Logic for {@link INode} instances
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.5
 * @since 1.0.5
 */
public interface INodeFactory<T extends Comparable<T>> {

    /**
     * Creates a new {@link INode} based on the given info
     *
     * @param info {@code T} to create the Node with
     * @return {@code INode} constructed with the given info
     */
    INode<T> createNode(final T info);

    /**
     * Creates a new {@link INode} based on the given info
     *
     * @param link {@code Node} to be set as the next in the sequence
     * @param info {@code Comparable} data to create the Node with
     * @return {@code INode} constructed with the given info
     */
    INode<T> createNodeWithLink(INode<T> link, final T info);

}
