/**
 * Computes the amount of paint needed to paint a room
 */

 import java.text.DecimalFormat;

 public class PaintShopCalculator {

    // variables
    private int heightFeet, heightInches, lengthFeet, lengthInches, widthFeet, widthInches;

	// Constants
	// Prices of the paint containers in dollars
	public final double FIVEGALLONS = 124.00;

	public final double ONEGALLON = 25.10;

	public final double HALFGALLON = 13.00;

	public final double QUART = 6.70;

	public final double PINT = 3.95;

	public final double HALFPINT = 2.25;

	public double totalCost = 0;

	// Area that can be painted with one gallon of paint (in square inches)
	public final double AREA_PER_GALLON = 25000.0;

	// global variables
	public int area, halfGallons, totalGallon, totalQuarts, totalPints, gallonsPacket, oneGallon = 0, totalHalfPints;
	public long cents;
	public double customerGallon, afterBonusCost = 0;

	/**
	 * Initializes this PaintShopCalculator with the room measurements. For example,
	 * if the height is 10'2'', heightFeet is 10 and heightInches is 2.
	 * 
	 * @param heightFeet   the number of feet of the height measurement
	 * @param heightInches the number of inches of the height measurement
	 * @param widthFeet    the number of feet of the width measurement
	 * @param widthInches  the number of inches of the width measurement
	 * @param lengthFeet   the number of feet of the length measurement
	 * @param lengthInches the number of inches of the length measurement
	 */
	public PaintShopCalculator(int heightFeet, int heightInches, int lengthFeet, int lengthInches, int widthFeet, int widthInches) {
            this.heightFeet = heightFeet;
            this.heightInches = heightInches;
            this.lengthFeet = lengthFeet;
            this.lengthInches = lengthInches;
            this.widthFeet = widthFeet;
            this.widthInches = widthInches;
	}

    // here is the calculateFeet function which calculates area and converts to the inches.
    private void calculateFeet(int heightFeet, int heightInches, int lengthFeet, int lengthInches, int widthFeet, int widthInches){
        int feetToInch = 12;


        heightFeet = heightFeet * feetToInch + heightInches;
		widthFeet = widthFeet * feetToInch + widthInches;
		lengthFeet = lengthFeet * feetToInch + lengthInches;

		// find the area with the given dimensions
        area = (lengthFeet * widthFeet) + 2 * (widthFeet* heightFeet) + (lengthFeet * heightFeet) * 2;


		// customer needed gallons
        customerGallon  = area  / AREA_PER_GALLON;
        totalGallon = (int) (customerGallon);
        double leftGallons;
        leftGallons = customerGallon - totalGallon;

		// if the total gallons are over than 5, the total cost should be 124$ for 5 gallons.
		if(totalGallon >= 5){
			gallonsPacket = totalGallon / 5;
			totalCost = totalCost + gallonsPacket * 124;
			// For example,  if the total gallon is 12, 10 would be 2 packs, so cost = 124 * 2. Then 12 - 10 = 2. 2 gallons would left. So, we need that left 2 gallons. 
			totalGallon -= gallonsPacket * 5;
			oneGallon = totalGallon;
		}
		totalCost = totalCost +  totalGallon * 25.10;
		

		// find half gallons and calculating.
        halfGallons = (int) (leftGallons / 0.5);
        double halfGallonsAmount = halfGallons * 0.5;
        leftGallons = leftGallons - halfGallonsAmount; 
		totalCost = totalCost + halfGallons * 13;

		// find quarts and calculating.
        totalQuarts = (int) (leftGallons / 0.25);
        double quartsAmount = totalQuarts * 0.25;
        leftGallons = leftGallons - quartsAmount; 
		totalCost = totalCost + totalQuarts * 6.70;

		// find pints and calculating.
        totalPints = (int) (leftGallons / 0.125);
        double pintsAmount = totalPints * 0.125;
        leftGallons = leftGallons - pintsAmount; 
		totalCost = totalCost + totalPints * 3.95;

		// find half pints and calculating.
		totalHalfPints = (int) (leftGallons / 0.0625);
        double halfPintsAmount = totalHalfPints * 0.0625;
        leftGallons = leftGallons - halfPintsAmount; 
		// if the left gallnons are lesser than 0.0625 (which means can't be an one half pints), the cost will be added by one half pints's price
		if (leftGallons < 0.0625){
			totalCost += 2.25;
			totalHalfPints = 1;
		} else {
			totalCost = totalCost + totalHalfPints * 2.25;
		}
		
		DecimalFormat df = new DecimalFormat("0.00");
		String roundedDouble = df.format(totalCost);
		totalCost = Double.valueOf(roundedDouble);

		cents = Math.round(totalCost * 100) % 100;
		int lastDigit;
		String roundedTotalCost;
		if(cents % 10 == 0){
			lastDigit = (int) (cents / 10);
		} else {
			lastDigit = (int) (cents % 10);
		}
		// if the total cost equals to 5 and odd, its declined by 124 from the total cost.
		if(lastDigit % 5 == 0 && lastDigit % 2 != 0 && customerGallon > 5){
			roundedTotalCost = df.format(totalCost - 124);
			afterBonusCost = Double.valueOf(roundedTotalCost);
		}
    }


	public String toString() {
        calculateFeet(heightFeet, heightInches, lengthFeet, lengthInches, widthFeet, widthInches);
		DecimalFormat df = new DecimalFormat("0.000");
		String roundedCustomerGallon = df.format(customerGallon);
		String s = ("For this job, you need "+ roundedCustomerGallon + " gallons of paint.\n"
		+ "You will need to purchase \n     ");
		if(gallonsPacket != 0){
			if(gallonsPacket == 1){
				s += String.format(gallonsPacket + " five-gallon container\n     ");
			} else {
				s += String.format(gallonsPacket + " five-gallon containers\n    ");	
			}
		}
		if(oneGallon != 0){
			if(oneGallon == 1){
				s+= String.format(oneGallon +" one-gallon container \n     ");
			} else {
				s+= String.format(oneGallon +" one-gallon containers \n     ");
			}
		}
		if(halfGallons != 0){
			if(halfGallons == 1){
				s += String.format(halfGallons + " half-gallon container \n     ");
			} else {
				s += String.format(halfGallons + " half-gallon containers \n     ");
			}
		}
		if(totalQuarts != 0){
			if(totalQuarts == 1){
				s += String.format(totalQuarts + " one-quart container \n     ");
			} else {
				s += String.format(totalQuarts + " one-quart containers \n     ");
			}
		}
		if(totalPints != 0){
			if(totalPints == 1){
				s += String.format(totalPints + " one-pints container \n     ");
			} else {
				s += String.format(totalPints + " one-pints containers \n     ");
			}
		 }
		 if(totalHalfPints != 0){
			if(totalHalfPints == 1){
				s += String.format(totalHalfPints + " one-half-pints containers \n");
			}
		 }
																		
		s += String.format("\nThe total cost is $" + totalCost + "\n");
		
		if(afterBonusCost != 0){
			s += String.format("However, because the amount of cents (" + cents + "c)\n"  
			+ "in the cost is odd and divisible by 5, \n"
			+ "you get 1 five-gallon container for free! \n\n     "
	
			+ "The total cost is $" + afterBonusCost + "\n\n     "
	
			+ "Thank you for your business!");
		}
		return s;
	}
}