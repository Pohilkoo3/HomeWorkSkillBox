public class IndividualBusinessman extends PhysicalPerson {
    @Override
    public void put(double amountToPut) {
        double percentToPut = amountToPut < 1000 ? amountToPut * 0.01 : amountToPut * 0.005;
        super.put(amountToPut - percentToPut);
    }


    @Override
    public String toString() {
        return "Снятие осуществляется без коммисии. При пополнении счета на сумму менее 1000 рублей " +
                "взимается коммисия в размере 1% от вносимой суммы. При пополнении от 1000 рублей" +
                "коммисия составит 0,5% от вносимой суммы. IndividualBusinessman Account. На вашем счете "
                + getAmount() + " рублей.";
    }
}


