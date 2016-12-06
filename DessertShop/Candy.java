public class Candy extends DessertItem {
  private double weight;
  private int pricePerPound;

  private int cost;

  Candy(String candyName, double weight, int pricePerPound) {
    super(candyName);
    setWeight(weight);
    setPricePerPound(pricePerPound);
    setCost(weight, pricePerPound);
  }

  public int getCost() {
    return this.cost;
  }

  public double getWeight() {
    return this.weight;
  }

  public String toString() {
    String formattedCost = DessertShoppe.cents2dollarsAndCents(this.cost);
    String rowOne = this.getWeight() + " lbs. @ " + (double)(this.pricePerPound/100.0) + "/lb.\n";

    String rowTwo = String.format("%-" + DessertShoppe.MAX_ITEM_NAME_SIZE + "s %-" + DessertShoppe.COST_WIDTH + "s\n",
        this.getName(), formattedCost);

    return rowOne + rowTwo;
  }

  private void setCost(double weight, int pricePerPound) {
    this.cost = (int)Math.round(weight * pricePerPound);
  }

  private void setWeight(double weight) {
    this.weight = weight;
  }

  private void setPricePerPound(int pricePerPound) {
    this.pricePerPound = pricePerPound;
  }
}
