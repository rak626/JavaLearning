package lld.creational.BuilderDesignPattern.example1;

public class House {
    private String foundation;
    private String structure;
    private String roof;
    private String interior;

    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.roof = builder.roof;
        this.interior = builder.interior;
    }

    public static HouseBuilder builder() {
        return new HouseBuilder();
    }

    public static class HouseBuilder {
        private String foundation;
        private String structure;
        private String roof;
        private String interior;

        HouseBuilder() {
        }

        public HouseBuilder foundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public HouseBuilder structure(String structure) {
            this.structure = structure;
            return this;
        }

        public HouseBuilder roof(String roof) {
            this.roof = roof;
            return this;
        }

        public HouseBuilder interior(String interior) {
            this.interior = interior;
            return this;
        }

        public House build() {
            return new House(this);
        }

        @Override
        public String toString() {
            return "House.HouseBuilder(foundation=" + this.foundation + ", structure=" + this.structure + ", roof=" + this.roof + ", interior=" + this.interior + ")";
        }
    }

    @Override
    public String toString() {
        return "House(foundation=" + this.getFoundation() + ", structure=" + this.getStructure() + ", roof=" + this.getRoof() + ", interior=" + this.getInterior() + ")";
    }

    public String getFoundation() {
        return this.foundation;
    }

    public String getStructure() {
        return this.structure;
    }

    public String getRoof() {
        return this.roof;
    }

    public String getInterior() {
        return this.interior;
    }
}
