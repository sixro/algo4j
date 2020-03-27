package algo4j.parameter;

import algo4j.Parameter;
import algo4j.Parameters;
import java.util.HashMap;
import java.util.Map;

public class MapParameters implements Parameters {

    private final Map<String, Parameter<? extends Comparable<?>>> paramsByName;

    public MapParameters() {
        this.paramsByName = new HashMap<>();
    }

    public <T extends Comparable<T>> void add(String name, Parameter<T> parameter) {
        paramsByName.put(name, parameter);
    }

    @Override
    public <T extends Comparable<T>> T value(String name, Class<T> type) {
        Parameter<? extends Comparable<?>> parameter = paramsByName.get(name);
        return type.cast(parameter.value());
    }

}
