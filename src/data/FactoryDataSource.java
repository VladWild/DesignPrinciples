package data;

public enum FactoryDataSource {
    PROPERTIES {
        @Override
        protected DataSource getSource() {
            return new PropertiesData();
        }
    }, XML {
        @Override
        protected DataSource getSource() {
            return new XmlData();
        }
    };

    protected abstract DataSource getSource();

    public static DataSource getDataSource(FactoryDataSource dataType){
        return dataType.getSource();
    }
}

