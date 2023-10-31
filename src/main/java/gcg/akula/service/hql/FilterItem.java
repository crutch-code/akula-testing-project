package gcg.akula.service.hql;

public class FilterItem {
    private final String name;

    private final String alias;

    private final String varName;

    private final Object value;

    public FilterItem(String name, String alias, String varName, Object value) {
        this.name = name;
        this.alias = alias;
        this.varName = varName;
        this.value = value;
    }

    public String getHqlFilter(){
        return value == null ? "" : alias + "." + name + "=:" + varName;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String getVarName() {
        return varName;
    }

    public Object getValue() {
        return value;
    }
}
