public class PhysicalPerson extends Client {

        private double total;

        @Override
        public double getAmount() {
            return total;
        }

        public void put(double amountToPut) {
            total = amountToPut > 0? total + amountToPut : total;
        }

        public void take(double amountToTake) {
            total = amountToTake <= 0 || total - amountToTake < 0? total : total - amountToTake;
        }

        @Override
        public String toString() {
            return "Снятие и пополнение счета осуществляется без коммисии. PhysicalPerson Account. На вашем счете "
                    + total + " рублей.";
        }

}
