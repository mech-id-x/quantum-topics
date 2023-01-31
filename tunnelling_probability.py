import math

class QuantumTunnelling:
    """ Planck's constant """
    K_PLANK = 6.626e-34
    
    """ MASS OF ELECTRON (kg) """
    K_ELECTRON_MASS = 9.1e-31
    
    """ Electron volt """
    K_EV = 1.6e-19
    
    @staticmethod
    def EngelProbability(size, E, V):
        """
        Engel's Quantum Tunnelling Probability
        :param size: size of barrier in meters.
        :param E: kinetic energy in electron volt (eV)
        :param V: potential energy in eV.
        :return: Quantum Tunnelling Probability
        """ 
        if E > V:
            raise Exception("Potential energy (V) must be > Kinetic Energy (E)")
        delta = V - E
        p1 = ((-4 * size * math.pi) / QuantumTunnelling.K_PLANK)
        p2 = math.sqrt(2 * QuantumTunnelling.K_ELECTRON_MASS * delta * QuantumTunnelling.K_EV)
        return math.exp(p1 * p2)
    
def main():
    """ A simple test for current semiconductor processes """
    try:
        # Barrier sizes for current semiconductor processes (m)
        SIZES = [130e-9, 32e-9, 14e-9, 7e-9, 5e-9, 500e-12]
        # Dates for display purposes
        DATES = ["2001", "2010", "2014", "2019", "2021", "Beyond"]
        E = 4.5 # Kinetic energy of electron (eV)
        V = 5.0 # Potential Energy (eV)
        
        # Display them
        for i in range(len(DATES)): 
            p = QuantumTunnelling.EngelProbability(SIZES[i], E, V)
            print("{}\t{:.2e}\t{:.3e}".format(DATES[i], SIZES[i], p))
    
    except Exception as e:
        print(e)

if __name__ == "__main__":
    main()
