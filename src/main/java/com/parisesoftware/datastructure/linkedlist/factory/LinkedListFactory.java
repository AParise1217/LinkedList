package com.parisesoftware.datastructure.linkedlist.factory;

import com.google.inject.Inject;
import com.parisesoftware.datastructure.linkedlist.ILinkedList;
import com.parisesoftware.datastructure.linkedlist.LinkedListImpl;
import com.parisesoftware.model.factory.INodeFactory;

/**
 * Default implementation of {@link ILinkedListFactory}
 *
 * @author <a href="mailto:andrewparise1994@gmail.com">Andrew Parise</a>
 * @version 1.0.6
 * @since 1.0.6
 */
public class LinkedListFactory<T extends Comparable<T>> implements ILinkedListFactory<T> {

    private final INodeFactory<T> nodeFactory;

    @Inject
    public LinkedListFactory(INodeFactory<T> nodeFactory) {
        this.nodeFactory = nodeFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ILinkedList<T> createLinkedList() {
        return new LinkedListImpl<>(this.nodeFactory);
    }

}
