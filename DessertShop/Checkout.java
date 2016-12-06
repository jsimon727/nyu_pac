public class Checkout {
  public int numberOfItems;
  private DessertItem dessertItems[] = new DessertItem[100];

  Checkout() {
  }

  public void enterItem(DessertItem dessertItem) {
    dessertItems[numberOfItems] = dessertItem;
    numberOfItems++;
  }

  public int numberOfItems() {
    return this.numberOfItems;
  }

  public int totalCost() {
    int cost = 0;
    for(int i = 0; i < numberOfItems; i++) {
      cost = cost + dessertItems[i].getCost();
    }

    return cost;
  }

  public int totalTax() {
    double tax;
    tax = totalCost() * (DessertShoppe.TAX_RATE/100);
    return (int)Math.round(tax);
  }

  public String toString() {
    String header = DessertShoppe.STORE_NAME + "\n--------------------\n";
    String text = "";

    for(int i = 0; i < numberOfItems; i++) {
      text = text + dessertItems[i].toString() + "\n";
    }

    String formattedTax  = String.format("%-" + DessertShoppe.MAX_ITEM_NAME_SIZE + "s %-" + DessertShoppe.COST_WIDTH + "s\n", "Tax", DessertShoppe.cents2dollarsAndCents(totalTax()));
    String formattedCost = String.format("%-" + DessertShoppe.MAX_ITEM_NAME_SIZE + "s %-" + DessertShoppe.COST_WIDTH + "s\n", "Total Cost", DessertShoppe.cents2dollarsAndCents(totalCost()));

    return header + text + formattedTax + formattedCost;
  }

  public void clear() {
    numberOfItems = 0;
  }
}
