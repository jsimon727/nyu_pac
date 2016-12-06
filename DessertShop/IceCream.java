public class IceCream extends DessertItem {
  private int cost;

  IceCream(String iceCreamName, int cost) {
    super(iceCreamName);
    setCost(cost);
  }

  public String toString() {
    String formattedCost = DessertShoppe.cents2dollarsAndCents(this.cost);
    String rowTwo = String.format("%-" + DessertShoppe.MAX_ITEM_NAME_SIZE + "s %-" + DessertShoppe.COST_WIDTH + "s\n",
        this.getName(), formattedCost);

    return rowTwo;
  }

  public int getCost() {
    return this.cost;
  }

  private void setCost(int cost) {
    this.cost = cost;
  }
}
