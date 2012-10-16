package com.vaadin.tests.server.component.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

public class UIAddRemoveComponents {

    private static class TestUI extends UI {
        @Override
        protected void init(VaadinRequest request) {
        }
    }

    @Test
    public void addComponent() {
        UI ui = new TestUI();
        Component c = new Label("abc");

        ui.addComponent(c);

        assertSame(c, ui.iterator().next());
        assertSame(c, ui.getContent().iterator().next());
        assertEquals(1, ui.getComponentCount());
        assertEquals(1, ui.getContent().getComponentCount());
    }

    @Test
    public void removeComponent() {
        UI ui = new TestUI();
        Component c = new Label("abc");

        ui.addComponent(c);

        ui.removeComponent(c);

        assertFalse(ui.iterator().hasNext());
        assertFalse(ui.getContent().iterator().hasNext());
        assertEquals(0, ui.getComponentCount());
        assertEquals(0, ui.getContent().getComponentCount());
    }

    @Test
    public void replaceComponent() {
        UI ui = new TestUI();
        Component c = new Label("abc");
        Component d = new Label("def");

        ui.addComponent(c);

        ui.replaceComponent(c, d);

        assertSame(d, ui.iterator().next());
        assertSame(d, ui.getContent().iterator().next());
        assertEquals(1, ui.getComponentCount());
        assertEquals(1, ui.getContent().getComponentCount());
    }
}
