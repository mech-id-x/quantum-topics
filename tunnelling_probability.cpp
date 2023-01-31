#include <iostream>
#include <cmath>

const double K_PLANK = 6.626e-34;
const double K_ELECTRON_MASS = 9.1e-31;
const double K_EV = 1.6e-19;

double EngelProbability(double size, double E, double V) {
    if (E > V) {
        std::cerr << "Potential energy (V) must be > Kinetic Energy (E)\n";
        return -1;
    }
    double delta = V - E;
    double p1 = ((-4 * size * M_PI) / K_PLANK);
    double p2 = sqrt(2 * K_ELECTRON_MASS * delta * K_EV);
    return exp(p1 * p2);
}

int main(int argc, char* argv[]) {
    double sizes[] = { 130e-9, 32e-9, 14e-9, 7e-9, 5e-9, 500e-12 };
    std::string dates[] = { "2001", "2010", "2014", "2019", "2021", "Beyond" };
    const int numDates = sizeof(dates) / sizeof(dates[0]);
    double E = 4.5;
    double V = 5.0;

    for (int i = 0; i < numDates; ++i) {
        double p = EngelProbability(sizes[i], E, V);
        std::cout << dates[i] << "\t" << sizes[i] << "\t" << p << std::endl;
    }

    return 0;
}
