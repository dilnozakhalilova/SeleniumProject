package Class8;

public abstract class Car {
    String fuelType;

    public Car(String fuelType) {
        this.fuelType = fuelType;
    }

    abstract void fueltype();
}

class Toyota extends Car {

    public Toyota(String fuelType) {
        super(fuelType);
    }

    @Override
    void fueltype() {
        System.out.println("Toyota drives using " + fuelType);

    }
}

    class Honda extends Car {

        public Honda(String fuelType) {
            super(fuelType);
        }

        @Override
        void fueltype() {
            System.out.println("Honda drives using "+fuelType);
        }
    }

    class Tesla extends Car {


        public Tesla(String fuelType) {
            super(fuelType);
        }

        @Override
        void fueltype() {

            System.out.println("Tesla drives using " + fuelType);
        }
    }


