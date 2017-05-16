package com.company.controller;

import org.reflections.Reflections;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by yulia on 16.05.17.
 */
public abstract class AbstractAction implements Action {

    public AbstractAction() {


        Reflections reflections = new Reflections(Error.class.getPackage().getName());
        Set<Class<? extends AbstractAction>> classes =
                reflections.getSubTypesOf(AbstractAction.class);

    }
}
