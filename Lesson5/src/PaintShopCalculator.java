/**
 * Computes the amount of paint needed to paint a room
 */

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

	// Area that can be painted with one gallon of paint (in square inches)
	public final double AREA_PER_GALLON = 25000.0;

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
        int area = 0, feetToInch = 144;


        if(heightFeet == 0 || widthFeet == 0 || lengthFeet == 0){
            lengthFeet = (lengthFeet == 0) ?  lengthFeet = lengthInches : lengthFeet * feetToInch;
            widthFeet = (widthFeet == 0) ?  widthFeet =  widthInches : widthFeet * feetToInch;
            heightFeet =(heightFeet == 0) ?  heightFeet =  heightInches : heightFeet * feetToInch;
        } 

		// find the area with the given dimensions
        area = (lengthFeet * widthFeet) + 2 * (widthFeet* heightFeet) + (lengthFeet * heightFeet) * 2;
        double customerGallon;
		// customer needed gallons
        customerGallon  = (area * feetToInch) / AREA_PER_GALLON;

        int totalGallon = (int) (customerGallon);
        double leftGallons;
        leftGallons = customerGallon - totalGallon;

        int halfGallons = (int) (leftGallons / 0.5);
        double halfGallonsAmount = halfGallons * 0.5;
        System.out.println("total half gallons "+ halfGallons);
        leftGallons = leftGallons - halfGallonsAmount; 


        int totalQuarts = (int) (leftGallons / 0.25);
        double quartsAmount = totalQuarts * 0.25;
        System.out.println("total quarts "+ totalQuarts);
        leftGallons = leftGallons - quartsAmount; 


        int totalPints = (int) (leftGallons / 0.125);
        double pintsAmount = totalPints * 0.125;
        System.out.println("total pints "+ totalPints);
        leftGallons = leftGallons - pintsAmount; 


        int totalHalfPints = (int) (leftGallons / 0.0625);
        double halfPintsAmount = totalHalfPints * 0.0625;
        System.out.println("total half pints "+ totalHalfPints);
        leftGallons = leftGallons - halfPintsAmount; 

        System.out.println("left gallons " + leftGallons);


		

    }

	/**
	 * Returns as a string the result of the computation. The string should list the
	 * exact amount of paint needed (with 3 digits after the decimal point), the
	 * number and type of paint containerthe output (no 0 one gallon container).
	 * 
	 * Here is an example with height=s needed, and the price (with 2 digits
	 * after the decimal point). Pay attention to the spelling (container versus
	 * containers) and the quality of 7'3'', length=20'4'' and width=18'7'':
	 * 
	 * <pre>
		For this job, you need 5.427 gallons of paint.
		You will need to purchase
			1 five-gallon container
			1 one-quart container
			1 one-pint container
			1 one-half-pint container
		
		Because the amount of cents (90c) in the cost
		is not odd and divisible by 5, no discount is
		applied.
	
			Your total is $136.90
			
			Thank you for your business!
	 * </pre>
	 */
	public String toString() {
		String s = "\tThank you for your business!"; // CHANGE THIS
        calculateFeet(heightFeet, heightInches, lengthFeet, lengthInches, widthFeet, widthInches);
		return s;
	}
}