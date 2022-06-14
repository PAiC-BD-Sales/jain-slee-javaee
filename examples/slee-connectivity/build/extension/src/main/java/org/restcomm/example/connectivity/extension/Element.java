package org.restcomm.example.connectivity.extension;

import java.util.HashMap;
import java.util.Map;

enum Element {

    REMOTE_RMI_ADDRESS(SubsystemDefinition.REMOTE_RMI_ADDRESS.getXmlName()),
    REMOTE_RMI_PORT(SubsystemDefinition.REMOTE_RMI_PORT.getXmlName()),
    UNKNOWN(null);

    private final String name;

    Element(final String name) {
        this.name = name;
    }

    /**
     * Get the local name of this element.
     *
     * @return the local name
     */
    public String getLocalName() {
        return name;
    }

    private static final Map<String, Element> MAP;

    static {
        final Map<String, Element> map = new HashMap<String, Element>();
        for (Element element : values()) {
            final String name = element.getLocalName();
            if (name != null) map.put(name, element);
        }
        MAP = map;
    }

    public static Element forName(String localName) {
        final Element element = MAP.get(localName);
        return element == null ? UNKNOWN : element;
    }
}
