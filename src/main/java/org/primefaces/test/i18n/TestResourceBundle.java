package org.primefaces.test.i18n;

import org.omnifaces.util.Faces;

import java.util.*;

public class TestResourceBundle extends ResourceBundle
{
    private static final String MESSAGES_RESOURCE_BUNDLE = "org.primefaces.test.i18n.messages";

    public TestResourceBundle()
    {
        Locale locale = Faces.getViewRoot().getLocale();
        setParent(ResourceBundle.getBundle(MESSAGES_RESOURCE_BUNDLE, locale));

        System.out.println("TestResourceBundle initialized");
    }

    @Override
    protected Object handleGetObject(String key)
    {
        // -----------------------------------------------------------------------------
        //  From messages file
        // -----------------------------------------------------------------------------
        return parent.getObject(key);
    }

    @Override
    public Enumeration<String> getKeys()
    {
        // -----------------------------------------------------------------------------
        //  Read the default property keys, then add remaining ones from the database.
        // -----------------------------------------------------------------------------
        Vector<String> vector = new Vector<>();
        Enumeration<String> keys = parent.getKeys();
        while (keys.hasMoreElements())
            vector.add(keys.nextElement());

        return vector.elements();
    }

    /**
     * Determines whether the given {@code key} is contained in this {@code ResourceBundle} or its parent bundles.
     *
     * @param key the resource {@code key}
     * @return {@code true} if the given {@code key} is contained in this {@code ResourceBundle} or its parent bundles;
     * {@code false} otherwise.
     * @throws NullPointerException if {@code key} is {@code null}
     */
    @Override
    public boolean containsKey(String key)
    {
        Objects.requireNonNull(key);
        return parent.containsKey(key);
    }
}
