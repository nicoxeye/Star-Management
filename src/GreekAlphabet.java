public enum GreekAlphabet {
    alpha,
    beta,
    gamma,
    delta,
    epsilon,
    zeta,
    eta,
    theta,
    iota,
    kappa,
    lambda,
    mu,
    nu,
    xi,
    omicron,
    pi,
    rho,
    sigma,
    tau,
    upsilon,
    phi,
    chi,
    psi,
    omega;

    //method to safely convert a string into the greek alphabet enum value
    public static GreekAlphabet fromString(String greekLetter) {
        for (GreekAlphabet letter : values()) {
            if (letter.name().equalsIgnoreCase(greekLetter)) {
                return letter;
            }
        }
        throw new GreekAlphabetException("Invalid Greek letter: " + greekLetter);
    }

    public static class GreekAlphabetException extends RuntimeException {
        public GreekAlphabetException(String message) {
            super(message);
        }
    }    
    
}


