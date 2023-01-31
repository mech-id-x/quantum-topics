public class Quantum Tunnelling {
    /** Planck's constant */
    static final double K_PLANK = 6.626e-34;

    /** MASS OF ELECTRON (kg) */
    static final double K_ELECTRON_MASS = 9.1e-31;

    /** Electron volt */
    static final double K_EV = 1.6e-19;

    /**
    * Engel's Quantum Tunnelling Probability
    * @param size
    * size of barrier in meters.
    * @param E
    * kinetic energy in electron volt (eV)
    * @param V
    * potential energy in eV.
    * @return Quantum Tunnelling Probability
    */ 

    static double EngelProbability(double size, double E, double V) {
        if (E > V) {
            throw new IllegalArgumentException
            ("Potential energy (V) must be > Kinetic Energy (E)");
        }
        double delta = V - E;
        double p1 = ((-4 * size * Math.PI) / K_PLANK);
        double p2 = Math.sqrt(2 * K_ELECTRON_MASS * delta * K_EV);
        return Math.exp(p1 * p2);
    }

    /** A simple test for current semiconductor processes */
    public static void main(String[] args){
        try {
            //Barrier sizes for current semiconductor processes (m)
            final double[] SIZES = { 130-9, 32e-9, 14e-9, 7e-9, 5e-9, 500e-12 };
            //Dates for display purposes
            final String[] DATES = { "2001", "2010", "2014", "2019", "2021", "Beyond"};
            final double E = 4.5; //Kinetic energy of electron (eV)
            final double V = 5.0; //Potential Energy (eV)

            //dISPLAY THEM::
            for (int in = 0; i < DATES.length; i++) { 
                double p = Engel Probability(SIZES[i], E, V);
                System.out.println(String.format("%s\t%2.2e\t%2.3e",
                DATES[i], SIZES[i], p));
            }

        } catch (Expection e) {
            e.printStackTrace();
        }
    }
}
