public class Cookie extends DessertItem {
  private int number;
  private int pricePerDozen;

  private int cost;

  Cookie(String cookieName, int number, int pricePerDozen) {
    super(cookieName);
    setNumber(number);
    setPricePerDozen(pricePerDozen);
    setCost(number, pricePerDozen);
  }

  public String toString() {
    String formattedCost = DessertShoppe.cents2dollarsAndCents(this.cost);
    String rowOne = this.number + " lbs. @ " + (double)(this.pricePerDozen/100.0) +
      "/lb.\n";

    String rowTwo = String.format("%-" + DessertShoppe.MAX_ITEM_NAME_SIZE + "s %-" + DessertShoppe.COST_WIDTH + "s\n",
        this.getName(), formattedCost);

    return rowOne + rowTwo;
  }

  public int getCost() {
    return this.cost;
  }

  private void setCost(int number, int pricePerDozen) {
    this.cost = (int)Math.round(number * (pricePerDozen/12.0));
  }

  private void setNumber(int number) {
    this.number = number;
  }

  private void setPricePerDozen(int pricePerDozen) {
    this.pricePerDozen = pricePerDozen;
  }
}
