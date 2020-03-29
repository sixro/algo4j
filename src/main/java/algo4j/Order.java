package algo4j;

import java.math.BigDecimal;

public interface Order {

    static Order newOrder(ISIN isin, int quantity, Direction direction, Type type) {
        return new Order() {
            @Override
            public ISIN isin() {
                return isin;
            }

            @Override
            public int quantity() {
                return quantity;
            }

            @Override
            public Status status() {
                return Status.PENDING;
            }

            @Override
            public Direction direction() {
                return direction;
            }

            @Override
            public Type type() {
                return type;
            }
        };
    }

    enum Status { PENDING, CONFIRMED, REFUSED };

    enum Direction { LONG, SHORT };

    /**
     * Returns the isin to which this order refers to.
     *
     * @return the isin
     */
    ISIN isin();

    /**
     * Returns the quantity
     *
     * @return a quantity
     */
    int quantity();

    /**
     * Returns the status of this order.
     *
     * @return status of this order
     */
    Status status();

    /**
     * Represents the order type.
     *
     * @return order type
     */
    Direction direction();

    Type type();

    interface Type {
        static Type atMarket() { return new Type() {
                @Override
                public String toString() {
                    return "at market";
                }
            };
        }
    }

    class Limit implements Type {

        private final BigDecimal price;

        private Limit(BigDecimal price) {
            this.price = price;
        }

        public static Limit of(BigDecimal price) {
            return new Limit(price);
        }

    }

}
