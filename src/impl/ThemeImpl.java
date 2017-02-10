package impl;

import api.Theme;

import java.util.Objects;

/**
 * Class description
 * @author Lobseer on 10.02.2017.
 */
public class ThemeImpl implements Theme {
    private String name;
    private String description;

    public ThemeImpl() {}

    public ThemeImpl(String name, String description) {
        this.name=name;
        this.description=description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThemeImpl theme = (ThemeImpl) o;
        return name.equalsIgnoreCase(theme.name) &&
                description.equalsIgnoreCase(theme.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return String.format("ThemeImpl{ name=%s; description=%s;}",
                name, description);
    }
}
