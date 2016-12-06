public class Sundae extends IceCream {
  private int costOfTopping;
  private int cost;

  Sundae(String iceCreamName, int costOfIceCream, String toppingName, int costOfTopping) {
    super(iceCreamName, costOfIceCream);
    setCost(costOfTopping);
  }

  public int getCost() {
    return this.cost;
  }

  public void setCost(int costOfTopping) {
    this.cost = super.getCost() + costOfTopping;
  }
}
