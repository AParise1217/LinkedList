package com.parisesoftware.model;

import com.google.inject.AbstractModule;
import com.parisesoftware.model.factory.INodeFactory;
import com.parisesoftware.model.factory.NodeFactory;

/**
 * Guice Dependency Injection Module Configuration
 */
public class NodeModule extends AbstractModule {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configure() {
        bind(INodeFactory.class).to(NodeFactory.class);
    }

}
